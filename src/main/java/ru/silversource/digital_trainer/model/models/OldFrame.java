package ru.silversource.digital_trainer.model.models;

import org.springframework.stereotype.Component;
import ru.silversource.digital_trainer.model.dto.FrameDTO;

@Component
public class OldFrame {

    private Frame person;

    public OldFrame() {
    }

    public OldFrame(FrameDTO frameDTO) {
        person = new Frame(frameDTO.getPeople());
    }

    public Frame getPerson() {
        return person;
    }

    public void setPeople(Frame person) {
        this.person = person;
    }
}
