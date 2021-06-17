package com.codezealer.zmall.file.controller;

import com.codezealer.zmall.common.http.HttpResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    /**
     * 文件上传接口
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public HttpResult<String> upload(MultipartFile file) {

        return HttpResult.ok();
    }

}
