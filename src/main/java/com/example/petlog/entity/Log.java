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
public class Log {

    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long logId;

    @Column(name = "created_at")
    private @Getter @Setter Timestamp createdAt;

    @Column(name = "updated_at")
    private @Getter @Setter Timestamp updatedAt;

    @Column(name = "title")
    private @Getter @Setter String title;

    @Column(name = "text")
    private @Getter @Setter String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    @OneToMany(mappedBy = "log", cascade = CascadeType.ALL)
    private Collection<Image> images;

    @ManyToMany
    @JoinTable(
            name = "petInLogs",
            joinColumns = @JoinColumn(name = "log_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private Collection<Pet> pets;

    @ManyToMany
    @JoinTable(
            name = "tagInLogs",
            joinColumns = @JoinColumn(name = "log_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Collection<Tag> tags;

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
