package com.example.petlog.sevice;

import com.example.petlog.entity.Tag;
import com.example.petlog.sevice.intefaces.ITagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements ITagService {
    @Override
    public Tag save(Tag theTag) {
        return null;
    }

    @Override
    public List<Tag> findAll() {
        return null;
    }

    @Override
    public Tag findById(int theId) {
        return null;
    }

    @Override
    public void deleteById(int theId) {

    }
}
