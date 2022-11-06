package ru.silversource.digital_trainer.service;

import org.junit.jupiter.api.Test;
import ru.silversource.digital_trainer.model.dto.FrameDTO;
import ru.silversource.digital_trainer.model.models.Frame;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonServiseTestDTO {

    @Test
    void getFrameDTO() {
        FrameDTO frameDTO = JsonServise.createFrameDTO("C:/json_test/h4_000000000002_keypoints.json");
        System.out.println(frameDTO.getPeople());
    }

    @Test
    void getFrame() {
        Frame frame = JsonServise.getFrame("C:/json_test/h4_000000000002_keypoints.json");
        assertEquals(frame.getPose_keypoints_2d().get(0).getId(),0);
        assertEquals(frame.getPose_keypoints_2d().get(0).getX(),839.321);
        assertEquals(frame.getPose_keypoints_2d().get(0).getY(),550.82);
        assertEquals(frame.getPose_keypoints_2d().get(0).getValid(),0.685167);
    }
}