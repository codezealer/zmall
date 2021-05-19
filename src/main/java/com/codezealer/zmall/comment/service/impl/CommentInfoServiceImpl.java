package com.codezealer.zmall.comment.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.codezealer.zmall.comment.constant.CommentStatusConstant;
import com.codezealer.zmall.comment.constant.DefaultCommentConstant;
import com.codezealer.zmall.comment.constant.ShowPicturesConstant;
import com.codezealer.zmall.comment.dao.CommentInfoDAO;
import com.codezealer.zmall.comment.dto.CommentInfoDTO;
import com.codezealer.zmall.comment.entity.CommentInfo;
import com.codezealer.zmall.comment.mapper.CommentInfoMapper;
import com.codezealer.zmall.comment.service.CommentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 评论信息表 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-18
 */
@Service
public class CommentInfoServiceImpl extends ServiceImpl<CommentInfoMapper, CommentInfo> implements CommentInfoService {

    @Resource
    CommentInfoDAO commentInfoDAO;

    @Override
    public void saveCommentInfo(CommentInfoDTO commentInfoDTO) {
        if (CollectionUtil.isNotEmpty(commentInfoDTO.getPictureUrlList())) {
            commentInfoDTO.setIsShowPictures(ShowPicturesConstant.YES);
        }
        commentInfoDTO.setIsDefaultComment(DefaultCommentConstant.NO);
        commentInfoDTO.setCommentStatus(CommentStatusConstant.APPROVING);


    }
}
