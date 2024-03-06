package com.example.petlog.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long imageId;

    @Column(name = "image_url")
    private @Getter @Setter String imageUrl;

    @ManyToOne
    @JoinColumn(name = "log_id")
    private Log log;

    public Image(Long imageId, String imageUrl) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
