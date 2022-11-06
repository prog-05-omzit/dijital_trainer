package ru.silversource.digital_trainer.service;

import org.junit.jupiter.api.Test;
import ru.silversource.digital_trainer.model.models.Frame;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonServiseTest {

    @Test
    void findFiles() throws IOException {
        List<Files> files = JsonServise.findFiles("C:/json_test/outjson/output");
        assertEquals(files.size(),2125);
    }

    @Test
    void getFrames() {
        List<Frame> frames = JsonServise.getFrames("C:/json_test/outjson/output");
        assertEquals(frames.size(),2059);
    }

    @Test
    void getCoords() {
        List<Frame> frames = JsonServise.getFrames("C:/json_test");
        assertEquals(frames.size(),18);
        assertEquals(frames.get(3).getPerson().getPose_keypoints_2d().get(5).getId(),5);
        assertEquals(frames.get(3).getPerson().getPose_keypoints_2d().get(5).getX(),848.209);
        assertEquals(frames.get(3).getPerson().getPose_keypoints_2d().get(5).getY(),627.471);
        assertEquals(frames.get(3).getPerson().getPose_keypoints_2d().get(5).getValid(),0.578552);
    }
}