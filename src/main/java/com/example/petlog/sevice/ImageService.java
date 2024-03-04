package com.example.petlog.sevice;

import com.example.petlog.entity.Image;
import com.example.petlog.sevice.intefaces.IImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService {
    @Override
    public Image save(Image theImage) {
        return null;
    }

    @Override
    public List<Image> findAll() {
        return null;
    }

    @Override
    public Image findById(Long theId) {
        return null;
    }

    @Override
    public void deleteById(Long theId) {

    }
}
