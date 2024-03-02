package com.example.petlog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Image {

    @Id
    @Column(name = "image_id")
    private @Getter @Setter String imageId;

    @Column(name = "log_id")
    private @Getter @Setter String logId;

    @Column(name = "image_url")
    private @Getter @Setter String imageUrl;

}
