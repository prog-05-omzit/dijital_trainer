package ru.silversource.digital_trainer.service;

import org.junit.jupiter.api.Test;
import ru.silversource.digital_trainer.model.dto.FrameDTO;
import ru.silversource.digital_trainer.model.models.Frame;

class JsonServiseTestDTO {

    @Test
    void getFrameDTO() {
        FrameDTO frameDTO = JsonServise.createFrameDTO("C:/json_test/h4_000000000002_keypoints.json");
        System.out.println(frameDTO.getPeople());
    }

    @Test
    void getFrame() {
        Frame frame = JsonServise.getFrame("C:/json_test/h4_000000000002_keypoints.json");
        System.out.println(frame.getPerson());
    }
}