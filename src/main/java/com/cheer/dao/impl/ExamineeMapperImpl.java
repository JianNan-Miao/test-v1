package com.cheer.dao.impl;

import com.cheer.dao.ExamineeMapper;
import com.cheer.dao.QuestionMapper;
import com.cheer.domain.Examinee;
import com.cheer.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ExamineeMapperImpl {
    public static void main(String[] args) {
        /*Examinee examinee = new Examinee(123,"mjy","k3",0,66,1);*/
        List<Examinee> list = new ExamineeMapperImpl().getExaminee();
        System.out.println(list);


    }

    public Examinee findExaminee(int id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Examinee examinee = sqlSession.getMapper(ExamineeMapper.class).findExaminee(id);
        MybatisUtils.closeSqlSession(sqlSession);
        return examinee;
    }

    public void updateExaminee(Examinee examinee){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        sqlSession.getMapper(ExamineeMapper.class).updateExaminee(examinee);
        MybatisUtils.closeSqlSession(sqlSession);
    }

    public List<Examinee> getExaminee(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Examinee> list = sqlSession.getMapper(ExamineeMapper.class).getExaminee();
        MybatisUtils.closeSqlSession(sqlSession);
        return list;
    }
}
