package com.guagua.windphotos.dto;

import lombok.Data;
import myenum.PortfolioType;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PortfolioDTO {

    private String name;

    private String description;

    private PortfolioType type;

    private List<String> images;

    private LocalDateTime createTime;

    public String toOssPath() {
        return type.getType() + "/" + name;
    }

}
