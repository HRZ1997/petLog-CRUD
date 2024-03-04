package com.example.petlog.sevice.intefaces;

import com.example.petlog.entity.Image;

import java.util.List;

public interface IImageService {

    Image save(Image theImage);

    List<Image> findAll();

    Image findById(Long theId);

    void deleteById(Long theId);
}
