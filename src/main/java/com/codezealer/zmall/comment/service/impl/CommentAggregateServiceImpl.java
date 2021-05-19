package com.codezealer.zmall.comment.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.codezealer.zmall.comment.constant.CommentTypeConstant;
import com.codezealer.zmall.comment.constant.ShowPicturesConstant;
import com.codezealer.zmall.comment.dao.CommentAggregateDAO;
import com.codezealer.zmall.comment.dto.CommentInfoDTO;
import com.codezealer.zmall.comment.entity.CommentAggregate;
import com.codezealer.zmall.comment.mapper.CommentAggregateMapper;
import com.codezealer.zmall.comment.service.CommentAggregateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 评论聚合汇总表 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-18
 */
@Service
public class CommentAggregateServiceImpl extends ServiceImpl<CommentAggregateMapper, CommentAggregate> implements CommentAggregateService {

    @Resource
    CommentAggregateDAO commentAggregateDAO;

    @Override
    public void update(CommentInfoDTO commentInfoDTO) {
        CommentAggregate commentAggregate = commentAggregateDAO.selectByGoodsId(commentInfoDTO.getGoodsId());
        if (commentAggregate == null) {
            commentAggregate = new CommentAggregate();
            commentAggregate.setTotalCommentCount(0L);
            commentAggregate.setGoodCommentCount(0L);
            commentAggregate.setBadCommentCount(0L);
            commentAggregate.setMediumCommentCount(0L);
            commentAggregate.setShowPicturesCommentCount(0L);
            commentAggregate.setGmtCreate(LocalDateTime.now());
            commentAggregate.setGoodsId(commentInfoDTO.getGoodsId());
        }

        commentAggregate.setTotalCommentCount(commentAggregate.getTotalCommentCount() + 1);
        if (commentInfoDTO.getCommentType() == CommentTypeConstant.GOOD) {
            commentAggregate.setGoodCommentCount(commentAggregate.getGoodCommentCount() + 1);
        } else if (commentInfoDTO.getCommentType() == CommentTypeConstant.MEDIAN) {
            commentAggregate.setMediumCommentCount(commentAggregate.getMediumCommentCount() + 1);
        } else if (commentInfoDTO.getCommentType() == CommentTypeConstant.BAD) {
            commentAggregate.setBadCommentCount(commentAggregate.getBadCommentCount() + 1);
        }
        commentAggregate.setGoodCommentRate(NumberUtil.round(commentAggregate.getGoodCommentCount() / commentAggregate.getTotalCommentCount(), 2));
        if (commentInfoDTO.getIsShowPictures() == ShowPicturesConstant.YES) {
            commentAggregate.setShowPicturesCommentCount(commentAggregate.getShowPicturesCommentCount() + 1);
        }
        commentAggregateDAO.saveOrUpdate(commentAggregate);
    }

}
