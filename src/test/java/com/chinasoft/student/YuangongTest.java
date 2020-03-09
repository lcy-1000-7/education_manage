package com.chinasoft.student;

import com.chinasoft.education_manage.domain.Yuangong;
import com.chinasoft.education_manage.service.YuangongService;
import com.chinasoft.education_manage.service.impl.YuangongServiceImpl;
import org.junit.Test;

public class YuangongTest {
    YuangongService yuangongService = new YuangongServiceImpl();
    @Test
    public void yuangong(){
        Yuangong yuangong = new Yuangong();
        yuangong.setSname("刘备");
        yuangong.setPassword("002222");
        yuangongService.updatePasswordBySname(yuangong,"111111");
    }
}
