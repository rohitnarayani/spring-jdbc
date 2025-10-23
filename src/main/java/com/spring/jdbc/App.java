package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
    	
    	StudentDao studentDao = context.getBean("studentDao",StudentDaoImpl.class);
    	
    	Student student = new Student();
    	student.setId(4);
    	student.setName("Ronnie	");
    	student.setCity("Anand");
    	
//    	int result = studentDao.insert(student);
//    	int result = studentDao.update(student);
//    	int result = studentDao.delete(2);
//    	
//    	Student student2 = studentDao.getStudent(3);
//    	System.out.println(student2);
//    	System.out.println(result+" row deleted...");
    	
    	List<Student> students = studentDao.getAllStudents();
    	
    	for(Student s:students) {
    		System.out.println(s);
    	}
    }
}