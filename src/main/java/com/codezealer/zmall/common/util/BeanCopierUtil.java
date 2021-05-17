package com.codezealer.zmall.common.util;

import net.sf.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

public class BeanCopierUtil {
    private static Map<String, BeanCopier> beanCopierMap = new HashMap<>();


    /**
     * 用于拷贝属性
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        String beanKey = source.toString() + target.toString();
        BeanCopier beanCopier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            synchronized (BeanCopierUtil.class) {
                if (!beanCopierMap.containsKey(beanKey)) {
                    beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                    beanCopierMap.put(beanKey, beanCopier);
                }
            }
        } else {
            beanCopier = beanCopierMap.get(beanKey);
        }
        beanCopier.copy(source, target, null);
    }
}
