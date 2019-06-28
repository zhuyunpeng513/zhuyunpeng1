package cn.tedu.mybatis;

import org.mybatis.spring.mapper.MapperScannerConfigurer;

public interface UserMapper {
	/**
	 * 该方法用于insert新的数据
	 * 
	 * @param user
	 * @return
	 */
	Integer addnew (User user);
	/**
	 * 用于根据id删除数据, 名字建议取有关的
	 */
	Integer deleteById(Integer id);
	/**
	 * 该方法用于更改数据库数据
	 */
	Integer updateData(String password);
	/**
	 * 该方法用于查询
	 */
	User findById(Integer id);
}
