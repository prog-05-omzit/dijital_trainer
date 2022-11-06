package ru.silversource.digital_trainer.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.silversource.digital_trainer.model.dto.FrameDTO;
import ru.silversource.digital_trainer.model.models.Frame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public class JsonServise {
    public JsonServise() {
    }

    public static FrameDTO createFrameDTO(String path) {
        StringBuilder jsonBuilder = new StringBuilder();
        try (Stream<String> jsonStream = Files.lines(Path.of(path))) {
            jsonStream.forEach(s -> jsonBuilder.append(s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String json = String.valueOf(jsonBuilder);
        return new Gson().fromJson(json, FrameDTO.class);
    }

    public static Frame getFrame(String path) {
        return new Frame(createFrameDTO(path));
    }
}
