package com.example.petlog.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Image {

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long imageId;

    @Column(name = "image_url")
    private @Getter @Setter String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "log_id")
    private Log log;
}
