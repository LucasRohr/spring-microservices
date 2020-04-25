package com.eureka.micro.image.service;

import com.eureka.micro.image.domain.Image;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GetImageService {

    public List<Image> getImages() {
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
