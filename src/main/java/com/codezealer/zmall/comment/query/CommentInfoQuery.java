package com.codezealer.zmall.comment.query;

import lombok.Data;

@Data
public class CommentInfoQuery {

    /**
     * 起始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 总评分
     */
    private Integer totalScore;
    /**
     * 评论状态
     */
    private Integer commentStatus;
    /**
     * 评论类型
     */
    private Integer commentType;
    /**
     * 是否晒图
     */
    private Integer showPictures;
    /**
     * 是否为默认评论
     */
    private Integer defaultComment;

}
