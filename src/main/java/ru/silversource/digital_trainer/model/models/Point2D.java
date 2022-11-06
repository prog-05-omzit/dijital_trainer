package ru.silversource.digital_trainer.model.models;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Point2D {
    private Long id;
    private Double x;
    private Double y;
    private Double valid;

    public Point2D() {
        this(0.0,0.0,0.0);
    }

    public Point2D(Double x, Double y, Double valid) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2D)) return false;
        Point2D point = (Point2D) o;
        return Objects.equals(getId(), point.getId()) && Objects.equals(getX(), point.getX()) && Objects.equals(getY(), point.getY()) && Objects.equals(getValid(), point.getValid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getX(), getY(), getValid());
    }
}
