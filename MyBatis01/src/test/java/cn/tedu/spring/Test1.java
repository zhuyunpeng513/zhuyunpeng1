package cn.tedu.spring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.mybatis.User;
import cn.tedu.mybatis.UserMapper;

public class Test1 {
	ClassPathXmlApplicationContext ac;
	UserMapper userMapper;
	@Test
	public void getConnection() throws SQLException {
		
		DataSource dataSource
			= ac.getBean("dataSource", DataSource.class);
		
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		
	}
	@Test
	public void  addnew() {
		User user = new User();
		user.setUsername("MyBatis");
		user.setPassword("888888");
		user.setAge(12);
		user.setEmail("112@qq.com");
		user.setTel("123123");
		Integer rows = userMapper.addnew(user);
		System.out.println("rows=" + rows);
		
	}
	@Before
	public void a(){
		 ac=new ClassPathXmlApplicationContext("spring.xml");
		 userMapper = ac.getBean("userMapper",UserMapper.class);
	}
	@After
	public void b(){
		ac.close();
	}
	@Test
	public void deleteById(){
		Integer id = 10;
		Integer rows = userMapper.deleteById(id);
		
	}
	@Test
	public void updateData(){
		String password = "666666";
		Integer rows = userMapper.updateData(password);
		System.out.println("rows:"+rows);
	}
	@Test
	public void findById(){
		User user = userMapper.findById(10);
		System.out.println(user);
	}
}
