package ru.silversource.digital_trainer.service;

import org.junit.jupiter.api.Test;
import ru.silversource.digital_trainer.model.models.Frame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XLSServiceTest {

    @Test
    void framesToXLS() throws IOException {
        String path = "C:/json_test";
        List<Frame> frames = JsonServise.getFrames(path);
        //List<Files> files = JsonServise.findFiles(path, "xls");
        //assertEquals(files.size(),0);
        XLSService.framesToXLS(path, frames);
        //files = JsonServise.findFiles(path, "xls");
        //assertEquals(files.size(),1);
    }
}