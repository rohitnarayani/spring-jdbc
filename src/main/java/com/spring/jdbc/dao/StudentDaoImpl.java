package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("Setter called...");
		this.jdbcTemplate = jdbcTemplate;
	}

	public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
		System.out.println("Constructor called....");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		
		String query = "insert into student values(?,?,?)";
		
		int result = jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		
		return result;
	}
	
	@Override
	public int update(Student student) {
		String query = "update student set name=?,city=? where id=?";
		
		int result = jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		
		return result;
	}

	@Override
	public int delete(int studentId) {
		
		String query = "delete from student where id=?";
		
		int result = jdbcTemplate.update(query,studentId);
		
		
		return result;
	}
	
	@Override
	public Student getStudent(int studentId) {
		
		String query = "select * from student where id=?";
		
		RowMapper<Student> rowMapper = new RowMapperImpl();
		
		Student student = jdbcTemplate.queryForObject(query,rowMapper,studentId);
		
//		Object student = jdbcTemplate.queryForObject(query, new RowMapper() {

//			@Override
//			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student student = new Student();
//				student.setId(rs.getInt(1));
//				student.setName(rs.getString(2));
//				student.setCity(rs.getString(3));
//				
//				return student;
//			}
//				
//			
//			
//		} ,studentId);
		
		return   student;
	}

	public List<Student> getAllStudents() {
		
		String query = "select *  from student";
		
		List<Student> students = jdbcTemplate.query(query,new RowMapperImpl());
		
		return students;
	}
	
	public StudentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
}