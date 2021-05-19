package com.codezealer.zmall.comment.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import com.codezealer.zmall.comment.dto.CommentInfoDTO;
import com.codezealer.zmall.comment.entity.CommentPicture;
import com.codezealer.zmall.comment.service.CommentAggregateService;
import com.codezealer.zmall.comment.service.CommentInfoService;
import com.codezealer.zmall.comment.service.CommentPictureService;
import com.codezealer.zmall.common.http.HttpResult;
import com.codezealer.zmall.common.util.WebContextUtil;
import com.codezealer.zmall.order.service.OrderFacadeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

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

    @Resource
    OrderFacadeService orderFacadeService;


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
        CommentInfoDTO returnCommentInfo = commentInfoService.saveCommentInfo(commentInfoDTO);
        if (CollectionUtil.isNotEmpty(commentInfoDTO.getPictureUrlList())) {
            commentInfoDTO.getPictureUrlList().forEach(s -> {
                CommentPicture commentPicture = new CommentPicture();
                commentPicture.setCommentInfoId(returnCommentInfo.getId());
                commentPicture.setCommentPictureUrl(s);
                commentPicture.setGmtCreate(LocalDateTime.now());
                commentPicture.setGmtModified(LocalDateTime.now());
                commentPictureService.save(commentPicture);
            });
        }
        commentAggregateService.update(commentInfoDTO);

        orderFacadeService.informCommentPublishedEvent(commentInfoDTO.getOrderId());

        return false;
    }
}

