package com.guagua.windphotos.controller;

import com.guagua.windphotos.dto.PortfolioDTO;
import com.guagua.windphotos.dto.ResponseDTO;
import com.guagua.windphotos.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("api")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/images")
    public ResponseDTO<List<String>> getImages(@RequestParam String portfolio) {
        return imageService.getImages(portfolio);
    }

    @GetMapping("/portfolio")
    public ResponseDTO<List<PortfolioDTO>> getPortfolio(@RequestParam String type) {
        return imageService.getPortfolio(type);
    }
}
