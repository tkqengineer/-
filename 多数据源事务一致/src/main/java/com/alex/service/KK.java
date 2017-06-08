package com.alex.service;


import com.alex.bean.Student;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class KK {
    @Resource(name = "sessionTemplate1")
    private SqlSessionTemplate sqlSessionTemplate1;

    @Resource(name = "sessionTemplate2")
    private SqlSessionTemplate sqlSessionTemplate2;

    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    public  void save(){
        this.sqlSessionTemplate1.insert("a","aaaa");

        this.sqlSessionTemplate2.insert("b","aaaa");
        Student student = new Student();
        student.setName("aaaa");
        /*int a=1/0;*/
        hibernateTemplate.save(student);

    }

}
