package com.guagua.windphotos.service.impl;

import com.guagua.windphotos.dto.PortfolioDTO;
import com.guagua.windphotos.dto.ResponseDTO;
import com.guagua.windphotos.service.ImageService;
import com.guagua.windphotos.util.OssUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {


    @Override
    public ResponseDTO<List<String>> getImages(String portfolio) {
        List<String> objectsUrl = OssUtil.getObjectsUrl(portfolio);
        return ResponseDTO.buildSuccess(objectsUrl);
    }

    @Override
    public ResponseDTO<List<PortfolioDTO>> getPortfolio(String types) {
        return null;
    }
}
