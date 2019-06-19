package com.cheer.dao.impl;

import com.cheer.dao.ExamineeMapper;
import com.cheer.dao.QuestionMapper;
import com.cheer.domain.Examinee;
import com.cheer.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class ExamineeMapperImpl {
    public static void main(String[] args) {
        Examinee examinee = new ExamineeMapperImpl().findExaminee(3204001);
        System.out.println(examinee);
    }

    public Examinee findExaminee(int id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Examinee examinee = sqlSession.getMapper(ExamineeMapper.class).findExaminee(id);
        MybatisUtils.closeSqlSession(sqlSession);
        return examinee;
    }
}
