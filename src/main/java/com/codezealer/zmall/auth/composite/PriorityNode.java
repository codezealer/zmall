package com.codezealer.zmall.auth.composite;

import com.codezealer.zmall.auth.visitor.PriorityNodeVisitor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PriorityNode {

    /**
     * 主键，自增长
     */
    private Long id;

    /**
     * 权限编号
     */
    private String code;

    /**
     * 权限对应的请求URL
     */
    private String url;

    /**
     * 权限的说明备注
     */
    private String priorityComment;

    /**
     * 权限类型，1：菜单，2：其他
     */
    private Integer priorityType;

    /**
     * 父权限的主键
     */
    private Long parentId;

    /**
     * 权限的创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 权限的修改时间
     */
    private LocalDateTime gmtModified;

    private List<PriorityNode> children = new ArrayList<>();

    public void accept(PriorityNodeVisitor visitor) {
        visitor.visit(this);
    }


}
