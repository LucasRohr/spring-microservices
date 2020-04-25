package com.eureka.micro.image.controller;

import com.eureka.micro.image.service.GetImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import com.eureka.micro.image.domain.Image;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private Environment env;

    @Autowired
    private GetImageService getImageService;

    @GetMapping("")
    public List<Image> getImages() throws Exception {
        return getImageService.getImages();
    }

}
