package com.example.petlog.repository;

import com.example.petlog.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, String> {

}
