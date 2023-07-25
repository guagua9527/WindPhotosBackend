package com.guagua.windphotos.controller;

import com.guagua.windphotos.dto.ResponseDTO;
import com.guagua.windphotos.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/manage")
public class ManageController {

    @Autowired
    private ManageService manageService;

    // TODO: 上传文件夹，图片，文字说明等
    // 搞一个 zip 包，里面包含图片、说明文件，自动解压上传到 OSS 然后删除文件

    @PostMapping("/upload")
    public ResponseDTO<?> upload() {
        return null;
    }
}
