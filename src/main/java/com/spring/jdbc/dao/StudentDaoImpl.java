package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
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

	public StudentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}