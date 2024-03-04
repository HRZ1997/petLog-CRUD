package com.example.petlog.sevice.intefaces;

import com.example.petlog.entity.Tag;

import java.util.List;

public interface ITagService {

    Tag save(Tag theTag);

    List<Tag> findAll();

    Tag findById(int theId);

    void deleteById(int theId);
}
