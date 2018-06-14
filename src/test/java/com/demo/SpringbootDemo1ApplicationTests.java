package com.demo;

import com.demo.modules.sys.dao.RoleDao;
import com.demo.modules.sys.entity.Role;
import com.demo.modules.sys.entity.User;
import com.demo.modules.sys.service.RoleService;
import com.demo.modules.sys.service.UserService;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo1ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private RoleService roleService;

	@Test
	public void test() {

		User user = new User();

		user.setUsername("admin");
		user.setPassword("admin");

		boolean flag = userService.verifyUserByLoginName(user);

		if (flag) {
			System.out.println("校验成功");
		} else {
			System.out.println("校验失败");
		}

		System.out.println("完成");

	}

	@Test
	public void test2() {
		User u = new User();
		u.setId("1");
		u.setPassword("admin");
		userService.updatePassword(u);

	}
}
