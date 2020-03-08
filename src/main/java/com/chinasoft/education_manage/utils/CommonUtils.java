package com.chinasoft.education_manage.utils;

import com.chinasoft.education_manage.domain.Yuangong;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Description TODO
 * @ClassName CommonUtils
 * @Author Jack.Shen
 * @Date 2020/2/27 10:49
 * @Version V1.0
 */
public class CommonUtils {

    public static Yuangong populate(Yuangong yuangong, Map<String, String[]> parameterMap) {
        try {
            BeanUtils.populate(yuangong, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return yuangong;
    }
}
