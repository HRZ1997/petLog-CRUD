package com.example.petlog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "tags")
@NoArgsConstructor
@ToString
public class Tag {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer tagId;

    @Column(name = "tag_content")
    private @Getter @Setter String tagContent;

    public Tag(String tagContent) {
        this.tagContent = tagContent;
    }
}
