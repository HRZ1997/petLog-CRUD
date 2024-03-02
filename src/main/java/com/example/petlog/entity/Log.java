package com.example.petlog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "logs")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Log {

    @Id
    @Column(name = "log_id")
    private @Getter @Setter String logId;

    @Column(name = "user_id")
    private @Getter @Setter String userId;

    @Column(name = "timestamp")
    private @Getter @Setter Timestamp timestamp;

    @Column(name = "title")
    private @Getter @Setter String title;

    @Column(name = "text")
    private @Getter @Setter String text;

}
