package com.example.petlog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "logs")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Log {

    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long logId;

    @Column(name = "user_id")
    private @Getter @Setter Long userId;

    @Column(name = "created_at")
    private @Getter @Setter Timestamp createdAt;

    @Column(name = "updated_at")
    private @Getter @Setter Timestamp updatedAt;

    @Column(name = "title")
    private @Getter @Setter String title;

    @Column(name = "text")
    private @Getter @Setter String text;


}
