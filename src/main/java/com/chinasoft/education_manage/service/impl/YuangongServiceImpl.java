package com.chinasoft.education_manage.service.impl;

import com.chinasoft.education_manage.dao.YuangongDao;
import com.chinasoft.education_manage.dao.impl.YuangongDaoImpl;
import com.chinasoft.education_manage.domain.Yuangong;
import com.chinasoft.education_manage.service.YuangongService;

/**
 * @Description TODO
 * @ClassName YuangongServiceImpl
 * @Author Lenovo
 * @Date 2020/3/6 13:41
 * @Version V1.0
 */
public class YuangongServiceImpl implements YuangongService {
    private YuangongDao yuangongDao = new YuangongDaoImpl();

    @Override
    public Yuangong findYuangongByNameAndPassword(Yuangong yuangong) {
        return yuangongDao.findYuangong(yuangong);
    }

    @Override
    public void updatePasswordBySname(Yuangong yuangong,String newPassword) {
        yuangongDao.updatePasswordBySname(yuangong,newPassword);
    }

}
