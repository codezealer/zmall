package com.codezealer.zmall.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.codezealer.zmall.common.util.BeanCopierUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 权限表，每个权限代表了系统中的一个菜单、按钮、URL请求
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class PriorityDO implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
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

    /**
     * 克隆
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T clone(Class<T> clazz) {
        T target = null;
        try {
            target = clazz.newInstance();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        BeanCopierUtil.copyProperties(this, target);
        return target;
    }

}
