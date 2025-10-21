package com.spring.jdbc;

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
    	int result = studentDao.update(student);
    	System.out.println(result+" rows updated...");
    }
}
