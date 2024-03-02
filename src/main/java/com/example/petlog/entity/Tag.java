package com.example.petlog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tags")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tag {

    @Id
    @Column(name = "tag_id")
    private @Getter
    @Setter String tagId;

    @Column(name = "log_id")
    private @Getter @Setter String logId;
}
