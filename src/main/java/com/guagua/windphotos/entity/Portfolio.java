package com.guagua.windphotos.entity;

import jakarta.persistence.*;
import lombok.Data;
import myenum.PortfolioType;

import java.time.LocalDateTime;

/**
 * 作品集
 */
@Table(name = "portfolio")
@Entity
@Data
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(columnDefinition = "description")
    private String description;

    @Column(name = "cover_image")
    private String coverImage;

    @Column(name = "type")
    private PortfolioType type;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    // 自动更新 createTime 字段
    @PrePersist
    public void prePersist() {
        this.createTime = LocalDateTime.now();
    }

    // 自动更新 updateTime 字段
    @PreUpdate
    public void preUpdate() {
        this.updateTime = LocalDateTime.now();
    }
}
