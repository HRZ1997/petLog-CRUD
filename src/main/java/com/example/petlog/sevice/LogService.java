package com.example.petlog.sevice;

import com.example.petlog.entity.Log;
import com.example.petlog.sevice.intefaces.ILogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService implements ILogService {
    @Override
    public Log save(Log theLog) {
        return null;
    }

    @Override
    public List<Log> findAll() {
        return null;
    }

    @Override
    public Log findById(Long theId) {
        return null;
    }

    @Override
    public void deleteById(Long theId) {

    }
}
