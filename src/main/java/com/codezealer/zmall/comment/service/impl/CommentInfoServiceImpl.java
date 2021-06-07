package com.codezealer.zmall.comment.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.BeanCopier;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codezealer.zmall.comment.constant.*;
import com.codezealer.zmall.comment.dao.CommentInfoDAO;
import com.codezealer.zmall.comment.dto.CommentInfoDTO;
import com.codezealer.zmall.comment.entity.CommentInfo;
import com.codezealer.zmall.comment.mapper.CommentInfoMapper;
import com.codezealer.zmall.comment.query.CommentInfoQuery;
import com.codezealer.zmall.comment.service.CommentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codezealer.zmall.common.page.PageRequest;
import com.codezealer.zmall.common.page.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public PageResult<CommentInfoDTO> selectPage(PageRequest<CommentInfoQuery> pageRequest) {
        Page<CommentInfo> commentInfoPage = commentInfoDAO.listPage(pageRequest);
        PageResult<CommentInfoDTO> pageResult = new PageResult<>();
        pageResult.setPageNum(commentInfoPage.getCurrent());
        pageResult.setPageSize(commentInfoPage.getSize());
        pageResult.setTotalPages(commentInfoPage.getPages());
        pageResult.setTotalSize(commentInfoPage.getTotal());
        List<CommentInfo> records = commentInfoPage.getRecords();
        List<CommentInfoDTO> comentInfoDTOs = BeanUtil.copyToList(records, CommentInfoDTO.class, null);
        pageResult.setPageList(comentInfoDTOs);
        return pageResult;
    }
}
