package ru.silversource.digital_trainer.model.dto;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class FrameDTO {

    private Double version;
    private List<PeopleDTO> people;

    public FrameDTO() {
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public List<PeopleDTO> getPeople() {
        return people;
    }

    public void setPeople(List<PeopleDTO> people) {
        if(people.isEmpty()) {
            this.people = new ArrayList<>(Collections.singleton(new PeopleDTO()));
        }else {
            this.people = people;
        }
    }
}
