package com.eureka.micro.image.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image {
    private Long id;
    private String title;
    private String url;
}
