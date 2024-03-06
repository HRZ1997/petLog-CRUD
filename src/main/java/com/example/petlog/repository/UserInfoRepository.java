package com.example.petlog.repository;

import com.example.petlog.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo getUserInfoByFirstName(String firstName);

}
