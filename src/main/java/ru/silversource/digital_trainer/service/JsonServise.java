package ru.silversource.digital_trainer.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.silversource.digital_trainer.model.dto.FrameDTO;
import ru.silversource.digital_trainer.model.models.Frame;
import ru.silversource.digital_trainer.model.models.OldFrame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JsonServise {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonServise.class);

    private List<OldFrame> frames;

    public JsonServise() {
    }

    public static FrameDTO createFrameDTO(String path) {
        //LOGGER.debug("Start method {}, with path {}", "createFrameDTO()", path);
        StringBuilder jsonBuilder = new StringBuilder();
        try (Stream<String> jsonStream = Files.lines(Path.of(path))) {
            jsonStream.forEach(s -> jsonBuilder.append(s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String json = String.valueOf(jsonBuilder);
        FrameDTO frameDTO = new Gson().fromJson(json, FrameDTO.class);
        return frameDTO ;
    };

    public static Frame getFrame(String path) {
        FrameDTO frameDTO = createFrameDTO(path);
        return frameDTO.getPeople().isEmpty()? null: new Frame(frameDTO);
    }

    public static List<Files> findFiles(String path, String extension) throws IOException {
        LOGGER.debug("Start method {}, with path {}", "createListFrames()", path);

        if (!Files.isDirectory(Paths.get(path))) {
            throw new IllegalArgumentException("Path must be directory!");
        }

        List files;
        try (Stream<Path> walk = Files.walk(Path.of(path), 1)) {
            files = walk
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith(extension))
                    .collect(Collectors.toList());
        }
        return files;
    }

    public static List<Frame> getFrames(String path) {
        LOGGER.debug("Start method {}, with path {}", "getFrames()", path);

        List<Frame> frames = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Path.of(path),1)) {
            walk
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith("json"))
                    .collect(Collectors.toList()).forEach(f -> {
                        Frame frame = getFrame(f.toAbsolutePath().toString());
                        if(frame != null) {
                            frame.setId(Long.valueOf(frames.size()));
                            frames.add(frame);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return frames;
    }
}
