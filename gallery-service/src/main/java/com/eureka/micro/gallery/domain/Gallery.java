package com.eureka.micro.gallery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {
    private Long id;
    private List images;

    public Gallery(Long id) {
        this.id = id;
    }
}
