package com.codezealer.zmall.comment.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import com.codezealer.zmall.comment.dto.CommentInfoDTO;
import com.codezealer.zmall.comment.service.CommentAggregateService;
import com.codezealer.zmall.comment.service.CommentInfoService;
import com.codezealer.zmall.comment.service.CommentPictureService;
import com.codezealer.zmall.common.http.HttpResult;
import com.codezealer.zmall.common.util.WebContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * <p>
 *  评论controller
 * </p>
 *
 * @author codezealer
 * @since 2021-05-18
 */
@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    CommentInfoService commentInfoService;
    @Resource
    CommentPictureService commentPictureService;
    @Resource
    CommentAggregateService commentAggregateService;

    @RequestMapping("/uploadPicture")
    public HttpResult<String> uploadPicture(HttpServletRequest request, @RequestParam(name = "file") MultipartFile file) {
        try {
            String staticDir = WebContextUtil.getStaticFileDir();
            String originalFileName = file.getOriginalFilename();
            String fileName = RandomUtil.randomString(10) + originalFileName;
            FileUtil.writeBytes(file.getBytes(), new File(staticDir + fileName));
            return HttpResult.ok(fileName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return HttpResult.ok();
    }

    @PostMapping("/publish")
    public Boolean publishComment(@RequestBody CommentInfoDTO commentInfoDTO) {

        commentInfoService.saveCommentInfo(commentInfoDTO);

        return false;
    }
}

