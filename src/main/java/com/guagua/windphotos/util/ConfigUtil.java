package com.guagua.windphotos.util;

import com.alibaba.fastjson2.JSONArray;
import com.guagua.windphotos.dto.PortfolioDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ConfigUtil {

    private static final String CONFIG_PATH = "config.json";

    private static List<PortfolioDTO> CACHE_PORTFOLIO;

    public static List<PortfolioDTO> getPortfolio() {
        if (CACHE_PORTFOLIO == null) {
            try {
                String str = Files.readString(Paths.get(CONFIG_PATH));
                CACHE_PORTFOLIO = JSONArray.parseArray(str, PortfolioDTO.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return CACHE_PORTFOLIO;
    }
}
