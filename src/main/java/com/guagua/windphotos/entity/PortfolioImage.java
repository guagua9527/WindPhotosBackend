package com.guagua.windphotos.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作品集图片
 */
@Table(name = "portfolio_image")
@Entity
@Data
public class PortfolioImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 图片所属的作品集id
     */
    @Column(name = "portfolio_id")
    private Integer portfolioId;

    /**
     * 图片描述
     */
    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    /**
     * 相机参数
     */
    @Column(name = "camera_param")
    private String cameraParam;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    // 自动更新 createTime 字段
    @PrePersist
    public void prePersist() {
        this.createTime = LocalDateTime.now();
    }
}
