package ru.silversource.digital_trainer.model.models;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Point3D {
    private Long id;
    private Double x;
    private Double y;

    private Double z;
    private Double valid;

    public Point3D() {
        this(0.0,0.0,0.0,0.0);
    }

    public Point3D(Double x, Double y, Double z, Double valid) {
        this.x = x;
        this.y = y;
        this.valid = valid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getValid() {
        return valid;
    }

    public void setValid(Double valid) {
        this.valid = valid;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }
}
