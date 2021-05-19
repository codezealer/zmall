package com.codezealer.zmall.comment.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import com.codezealer.zmall.comment.constant.*;
import com.codezealer.zmall.comment.dao.CommentInfoDAO;
import com.codezealer.zmall.comment.dto.CommentInfoDTO;
import com.codezealer.zmall.comment.entity.CommentInfo;
import com.codezealer.zmall.comment.mapper.CommentInfoMapper;
import com.codezealer.zmall.comment.service.CommentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    public CommentInfoDTO saveCommentInfo(CommentInfoDTO commentInfoDTO) {
        if (CollectionUtil.isNotEmpty(commentInfoDTO.getPictureUrlList())) {
            commentInfoDTO.setIsShowPictures(ShowPicturesConstant.YES);
        }
        commentInfoDTO.setIsDefaultComment(DefaultCommentConstant.NO);
        commentInfoDTO.setCommentStatus(CommentStatusConstant.APPROVING);

        int totalScore = Math.round((commentInfoDTO.getGoodsScore()
                                        + commentInfoDTO.getLogisticsScore()
                                        + commentInfoDTO.getCustomerServiceScore()) / 3);
        commentInfoDTO.setTotalScore(totalScore);
        if (ArrayUtil.contains(CommentScoreConstant.GOOD_COMMENT_SOCRES, totalScore)) {
            commentInfoDTO.setCommentType(CommentTypeConstant.GOOD);
        } else if (ArrayUtil.contains(CommentScoreConstant.MEDIAN_COMMENT_SCORES, totalScore)) {
            commentInfoDTO.setCommentType(CommentTypeConstant.MEDIAN);
        } else if (ArrayUtil.contains(CommentScoreConstant.BAD_COMMENT_SCORES, totalScore)) {
            commentInfoDTO.setCommentType(CommentTypeConstant.BAD);
        }

        CommentInfo commentInfo = commentInfoDTO.clone(CommentInfo.class);
        commentInfoDAO.saveCommentInfo(commentInfo);
        commentInfoDTO.setId(commentInfo.getId());
        return commentInfoDTO;
    }
}
