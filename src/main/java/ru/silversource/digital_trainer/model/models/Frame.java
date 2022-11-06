package ru.silversource.digital_trainer.model.models;

import org.springframework.stereotype.Component;
import ru.silversource.digital_trainer.model.dto.FrameDTO;

@Component
public class Frame {

    private Person person;

    public Frame() {
    }

    public Frame(FrameDTO frameDTO) {
        person = new Person(frameDTO.getPeople());
    }

    public Person getPerson() {
        return person;
    }

    public void setPeople(Person person) {
        this.person = person;
    }
}
