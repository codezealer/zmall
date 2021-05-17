package com.codezealer.zmall.auth.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.codezealer.zmall.common.util.BeanCopierUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Data
@Slf4j
public class PriorityDTO {

    /**
     * id
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
