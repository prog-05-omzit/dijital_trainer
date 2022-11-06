package ru.silversource.digital_trainer.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;
import ru.silversource.digital_trainer.model.models.Frame;
import ru.silversource.digital_trainer.model.models.Point2D;
import ru.silversource.digital_trainer.model.models.Point3D;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class XLSService {

    public static void framesToXLS(String path, List<Frame> frames) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        //pose_keypoints_2d;
        //face_keypoints_2d;
        //hand_left_keypoints_2d;
        //hand_right_keypoints_2d;
        //pose_keypoints_3d;
        //face_keypoints_3d;
        //hand_left_keypoints_3d;
        //hand_right_keypoints_3d;
        AtomicInteger counter = new AtomicInteger();

        Sheet pose_keypoints_2d = workbook.createSheet("pose_keypoints_2d");
        fillHead2D(pose_keypoints_2d.createRow(counter.get()), frames.get(0).getPose_keypoints_2d().size());
        Sheet face_keypoints_2d = workbook.createSheet("face_keypoints_2d");
        fillHead2D(face_keypoints_2d.createRow(counter.get()), frames.get(0).getFace_keypoints_2d().size());
        Sheet hand_left_keypoints_2d = workbook.createSheet("hand_left_keypoints_2d");
        fillHead2D(hand_left_keypoints_2d.createRow(counter.get()), frames.get(0).getHand_left_keypoints_2d().size());
        Sheet hand_right_keypoints_2d = workbook.createSheet("hand_right_keypoints_2d");
        fillHead2D(hand_right_keypoints_2d.createRow(counter.get()), frames.get(0).getHand_right_keypoints_2d().size());

        Sheet pose_keypoints_3d = workbook.createSheet("pose_keypoints_3d");
        fillHead3D(pose_keypoints_3d.createRow(counter.get()), frames.get(0).getPose_keypoints_3d().size());
        Sheet face_keypoints_3d = workbook.createSheet("face_keypoints_3d");
        fillHead3D(face_keypoints_3d.createRow(counter.get()), frames.get(0).getFace_keypoints_3d().size());
        Sheet hand_left_keypoints_3d = workbook.createSheet("hand_left_keypoints_3d");
        fillHead3D(hand_left_keypoints_3d.createRow(counter.get()), frames.get(0).getHand_left_keypoints_3d().size());
        Sheet hand_right_keypoints_3d = workbook.createSheet("hand_right_keypoints_3d");
        fillHead3D(hand_right_keypoints_3d.createRow(counter.getAndIncrement()), frames.get(0).getHand_right_keypoints_3d().size());


        frames.forEach(f -> {
            Row row = pose_keypoints_2d.createRow(counter.get());
            fillRow2D(f.getPose_keypoints_2d(), row, (long) counter.get());
            row = face_keypoints_2d.createRow(counter.get());
            fillRow2D(f.getFace_keypoints_2d(), row, (long) counter.get());
            row = hand_left_keypoints_2d.createRow(counter.get());
            fillRow2D(f.getHand_left_keypoints_2d(), row, (long) counter.get());
            row = hand_right_keypoints_2d.createRow(counter.get());
            fillRow2D(f.getHand_right_keypoints_2d(), row, (long) counter.get());

            row = pose_keypoints_3d.createRow(counter.get());
            fillRow3D(f.getPose_keypoints_3d(), row, (long) counter.get());
            row = face_keypoints_3d.createRow(counter.get());
            fillRow3D(f.getFace_keypoints_3d(), row, (long) counter.get());
            row = hand_left_keypoints_3d.createRow(counter.get());
            fillRow3D(f.getHand_left_keypoints_3d(), row, (long) counter.get());
            row = hand_right_keypoints_3d.createRow(counter.get());
            fillRow3D(f.getHand_right_keypoints_3d(), row, (long) counter.getAndIncrement());

        });

        try {
            workbook.write(new FileOutputStream(new File(path + "/out.xls")));
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fillHead2D(Row row, Integer count) {
        AtomicInteger counter = new AtomicInteger();
        row.createCell(counter.getAndIncrement()).setCellValue("№");
        for(int i = 0; i < count; i++) {
            row.createCell(counter.getAndIncrement()).setCellValue("X" + i);
            row.createCell(counter.getAndIncrement()).setCellValue("Y" + i);
            row.createCell(counter.getAndIncrement()).setCellValue("valid" + i);
        }
    }

    private static void fillHead3D(Row row, Integer count) {
        AtomicInteger counter = new AtomicInteger();
        row.createCell(counter.getAndIncrement()).setCellValue("№");
        for(int i = 0; i < count; i++) {
            row.createCell(counter.getAndIncrement()).setCellValue("X" + i);
            row.createCell(counter.getAndIncrement()).setCellValue("Y" + i);
            row.createCell(counter.getAndIncrement()).setCellValue("Z" + i);
            row.createCell(counter.getAndIncrement()).setCellValue("valid" + i);
        }
    }

    private static void fillRow2D(List<Point2D> points, Row row, Long line) {
        AtomicInteger counter = new AtomicInteger();
        row.createCell(counter.getAndIncrement()).setCellValue(line);
        points.forEach(p -> {
            row.createCell(counter.getAndIncrement()).setCellValue(p.getX());
            row.createCell(counter.getAndIncrement()).setCellValue(p.getY());
            row.createCell(counter.getAndIncrement()).setCellValue(p.getValid());
        });
    }

    private static void fillRow3D(List<Point3D> points, Row row, Long line) {
        AtomicInteger counter = new AtomicInteger();
        row.createCell(counter.getAndIncrement()).setCellValue(line);
        points.forEach(p -> {
            row.createCell(counter.getAndIncrement()).setCellValue(p.getX());
            row.createCell(counter.getAndIncrement()).setCellValue(p.getY());
            row.createCell(counter.getAndIncrement()).setCellValue(p.getZ());
            row.createCell(counter.getAndIncrement()).setCellValue(p.getValid());
        });
    }
}
