package ru.silversource.digital_trainer.model.models;

import org.springframework.stereotype.Component;
import ru.silversource.digital_trainer.model.dto.PeopleDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Component
public class Person {
    //private Long person_id;
    private List<Point2D> pose_keypoints_2d;
    private List<Point2D> face_keypoints_2d;
    private List<Point2D> hand_left_keypoints_2d;
    private List<Point2D> hand_right_keypoints_2d;
    private List<Point3D> pose_keypoints_3d;
    private List<Point3D> face_keypoints_3d;
    private List<Point3D> hand_left_keypoints_3d;
    private List<Point3D> hand_right_keypoints_3d;

    public Person() {
    }

    public Person(List<PeopleDTO> people) {
        pose_keypoints_2d = getPoints2D(people.get(0).getPose_keypoints_2d());
        face_keypoints_2d = getPoints2D(people.get(0).getFace_keypoints_2d());
        hand_left_keypoints_2d = getPoints2D(people.get(0).getHand_left_keypoints_2d());
        hand_right_keypoints_2d = getPoints2D(people.get(0).getHand_right_keypoints_2d());
        pose_keypoints_3d = getPoints3D(people.get(0).getPose_keypoints_3d());
        face_keypoints_3d = getPoints3D(people.get(0).getFace_keypoints_3d());
        hand_left_keypoints_3d = getPoints3D(people.get(0).getHand_left_keypoints_3d());
        hand_right_keypoints_3d = getPoints3D(people.get(0).getHand_right_keypoints_3d());
    }

    private List<Point2D> getPoints2D(List<Double> pointsDTO) {
        List<Point2D> points = new ArrayList<>();
        ListIterator<Double> iterator = pointsDTO.listIterator();

        while (iterator.hasNext()) {
            Point2D point2D = createPoint2D(iterator.next(), iterator.next(), iterator.next());
            point2D.setId(Long.valueOf(points.size()));
            points.add(point2D);
        }
        return points;
    }

    private List<Point3D> getPoints3D(List<Double> pointsDTO) {
        List<Point3D> points = new ArrayList<>();
        ListIterator<Double> iterator = pointsDTO.listIterator();

        while (iterator.hasNext()) {
            Point3D point3D = createPoint3D(iterator.next(), iterator.next(), iterator.next(), iterator.next());
            point3D.setId(Long.valueOf(points.size()));
            points.add(point3D);
        }
        return points;
    }
    private Point2D createPoint2D(Double x, Double y, Double valid) {
        return  new Point2D(x,y,valid);
    }

    private Point3D createPoint3D(Double x, Double y, Double z, Double valid) {
        return  new Point3D(x,y, z, valid);
    }

    public List<Point2D> getPose_keypoints_2d() {
        return pose_keypoints_2d;
    }

    public List<Point2D> getFace_keypoints_2d() {
        return face_keypoints_2d;
    }

    public List<Point2D> getHand_left_keypoints_2d() {
        return hand_left_keypoints_2d;
    }

    public List<Point2D> getHand_right_keypoints_2d() {
        return hand_right_keypoints_2d;
    }

    public List<Point3D> getPose_keypoints_3d() {
        return pose_keypoints_3d;
    }

    public List<Point3D> getFace_keypoints_3d() {
        return face_keypoints_3d;
    }

    public List<Point3D> getHand_left_keypoints_3d() {
        return hand_left_keypoints_3d;
    }

    public List<Point3D> getHand_right_keypoints_3d() {
        return hand_right_keypoints_3d;
    }
}
