package com.example.petlog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "tags")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tag {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer tagId;

    @Column(name = "tag_content")
    private @Getter @Setter String tagContent;

    @ManyToMany(mappedBy = "tags")
    private @Getter @Setter Collection<Log> logs;
}
