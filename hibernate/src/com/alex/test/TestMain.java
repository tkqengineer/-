package com.alex.test;

import com.alex.bean.Course;
import com.alex.bean.Student;
import com.alex.utils.HibernateUtils;
import org.hibernate.*;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.type.*;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 2016/12/24.
 */
public class TestMain extends HibernateUtils {
	
	
	/*
	* 保存学生的同时保存班级
	*
	* */
	
	@Test
	public void one(){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student("张三", 4);
		session.save(student);
		transaction.commit();
		session.close();
	}
	
	
	/*
	* 添加课程
	*
	* */
	@Test
	public void two(){
		
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, 1);
		
		Course course = new Course("java程序设计2");
		
		student.getCourses().add(course);
		
		session.flush();
		
		transaction.commit();
		
		session.close();
		
	}
	
	
	/*
	*
	* 拿到当前学生的所有课程
	*
	* */
	
	@Test
	public  void three(){
		
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, 1);
		
		Set<Course> courses = student.getCourses();
		for (Course course : courses) {
			
			System.out.println(course);
			
		}
		
		
	}
	
	
	@Test
	public  void four(){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		
		Course course  = (Course) session.get(Course.class, 1);
		
		Set<Student> students = course.getStudents();
		
		for (Student student : students) {
			System.out.println(student);
			
		}
		
		
		
		
		
	}
	
	
	@Test
	public  void hql1(){
		
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Course course = (Course) session.createQuery("from Course course where  course.id=1").uniqueResult();
		System.out.println(course);
		
		
	}
	
	@Test
	public  void hql2(){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		
		List list = session.createQuery("select student.sname,student.age from Student student").list();
		
		for (Object o : list) {
			
			System.out.println(((Object[])o)[0]);
			System.out.println(((Object[])o)[1]);
			
		}
		
		
		
	}
	
	
	@Test
	public void hql3(){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		
		List<Student> list = session.createQuery("select new Student(student.sname,student.age) from Student student").list();
		
		for (Student o : list) {
			System.out.println(o);
		}
		
	}
	
	
	@Test
	public void hql4(){
		
		
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Student studnet where studnet.sid=?");
		Student o = (Student) query.setInteger(0, 1).uniqueResult();
		
		System.out.println(o);
		
		
	}
	
	@Test
	public void hql5(){
		
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Student studnet where studnet.sid=:sid");
		Student sid = (Student) query.setInteger("sid", 1).uniqueResult();
		System.out.println(sid);
		
	}
	
	@Test
	public void hql6(){
		
		/*
		*
		* QBC查询
		*
		* */
		
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Student.class);
		
		//Expression
		
		Student o = (Student) criteria.add( Restrictions.like("sname", "%四")).uniqueResult();
		System.out.println(o);
		
		
	}
	
	
	
	@Test
	public  void hql7(){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Student student where student.age=:age and student.id=:id");
		
		String[] namedParameters = query.getNamedParameters();
		
		for (String namedParameter : namedParameters) {
			query.setParameter(namedParameter,1);
			
		}
		
		Student student = (Student) query.uniqueResult();
		
		System.out.println(student);
		
	}
	
	
	@Test
	public void hql8(){
		
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Student student where student.sid=?");
		String[] namedParameters = query.getNamedParameters();
		System.out.println(namedParameters.length);
		
	}
	
	@Test
	public  void  hqlq(){
		
	
		
		
	}
	
	

	
	
}
