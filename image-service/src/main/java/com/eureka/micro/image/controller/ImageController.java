package com.eureka.micro.image.controller;

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

    @GetMapping("")
    public List<Image> getImages() throws Exception {
        // === Use throw bellow to simulate error and test Hydrix ===
//        throw new Exception("Images can't be fetched");

        List<Image> images = Arrays.asList(
                new Image(1L, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
                new Image(2L, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
                new Image(3L, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112")
        );
        return images;
    }

}
