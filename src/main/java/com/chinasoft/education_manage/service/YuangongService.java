package com.chinasoft.education_manage.service;

import com.chinasoft.education_manage.domain.Yuangong;

public interface YuangongService {
    Yuangong findYuangongByNameAndPassword(Yuangong yuangong);

    Yuangong findPasswordBysno(String sno);

    void updatePasswordById(Yuangong yuangong);

}
