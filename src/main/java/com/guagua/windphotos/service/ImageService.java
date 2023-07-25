package com.guagua.windphotos.service;

import com.guagua.windphotos.dto.PortfolioDTO;
import com.guagua.windphotos.dto.ResponseDTO;

import java.util.List;

public interface ImageService {
    ResponseDTO<List<String>> getImages(String portfolio);

    ResponseDTO<List<PortfolioDTO>> getPortfolio(String types);
}
