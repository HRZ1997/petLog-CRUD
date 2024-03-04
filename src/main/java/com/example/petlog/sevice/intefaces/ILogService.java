package com.example.petlog.sevice.intefaces;

import com.example.petlog.entity.Log;

import java.util.List;

public interface ILogService {

    Log save(Log theLog);

    List<Log> findAll();

    Log findById(Long theId);

    void deleteById(Long theId);
}
