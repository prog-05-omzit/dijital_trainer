package ru.silversource.digital_trainer.model.dto;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PeopleDTO {
    //private Long person_id;
    private List<Double> pose_keypoints_2d;
    private List<Double> face_keypoints_2d;
    private List<Double> hand_left_keypoints_2d;
    private List<Double> hand_right_keypoints_2d;
    private List<Double> pose_keypoints_3d;
    private List<Double> face_keypoints_3d;
    private List<Double> hand_left_keypoints_3d;
    private List<Double> hand_right_keypoints_3d;

    public PeopleDTO() {
    }

    public List<Double> getPose_keypoints_2d() {
        return pose_keypoints_2d;
    }

    public void setPose_keypoints_2d(List<Double> pose_keypoints_2d) {
        this.pose_keypoints_2d = pose_keypoints_2d;
    }

    public List<Double> getFace_keypoints_2d() {
        return face_keypoints_2d;
    }

    public void setFace_keypoints_2d(List<Double> face_keypoints_2d) {
        this.face_keypoints_2d = face_keypoints_2d;
    }

    public List<Double> getHand_left_keypoints_2d() {
        return hand_left_keypoints_2d;
    }

    public void setHand_left_keypoints_2d(List<Double> hand_left_keypoints_2d) {
        this.hand_left_keypoints_2d = hand_left_keypoints_2d;
    }

    public List<Double> getHand_right_keypoints_2d() {
        return hand_right_keypoints_2d;
    }

    public void setHand_right_keypoints_2d(List<Double> hand_right_keypoints_2d) {
        this.hand_right_keypoints_2d = hand_right_keypoints_2d;
    }

    public List<Double> getPose_keypoints_3d() {
        return pose_keypoints_3d;
    }

    public void setPose_keypoints_3d(List<Double> pose_keypoints_3d) {
        this.pose_keypoints_3d = pose_keypoints_3d;
    }

    public List<Double> getFace_keypoints_3d() {
        return face_keypoints_3d;
    }

    public void setFace_keypoints_3d(List<Double> face_keypoints_3d) {
        this.face_keypoints_3d = face_keypoints_3d;
    }

    public List<Double> getHand_left_keypoints_3d() {
        return hand_left_keypoints_3d;
    }

    public void setHand_left_keypoints_3d(List<Double> hand_left_keypoints_3d) {
        this.hand_left_keypoints_3d = hand_left_keypoints_3d;
    }

    public List<Double> getHand_right_keypoints_3d() {
        return hand_right_keypoints_3d;
    }

    public void setHand_right_keypoints_3d(List<Double> hand_right_keypoints_3d) {
        this.hand_right_keypoints_3d = hand_right_keypoints_3d;
    }

}
