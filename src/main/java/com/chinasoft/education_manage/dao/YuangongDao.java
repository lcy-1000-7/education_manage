package com.chinasoft.education_manage.dao;

import com.chinasoft.education_manage.domain.Yuangong;

public interface YuangongDao {
    Yuangong findYuangong(Yuangong yuangong);

    void updatePasswordById(Yuangong yuangong);

    Yuangong findPasswordBysno(int sno);
}
