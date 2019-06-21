package com.cheer.dao;

import com.cheer.domain.Examinee;

import java.util.List;

public interface ExamineeMapper {
    public Examinee findExaminee(int id);

    public void updateExaminee(Examinee examinee);

    public List<Examinee>  getExaminee();
}
