package ru.silversource.digital_trainer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/upload")
public class WebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @GetMapping(value = "/form")
    public String getUploadPage() {
        LOGGER.debug("request page upload/page.html");
        return "upload/page.html";
    }

}
