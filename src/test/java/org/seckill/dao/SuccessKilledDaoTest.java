package org.seckill.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled() {
		/*
		 * 第一次：insertCount=1
		 * 第二次：insertCount=0
		 */
		long id=1001L;
		long phone=18861640348L;
		int insertCount=successKilledDao.insertSuccessKilled(id, phone);
		System.out.println("insertCount="+insertCount);
	}

	@Test
	public void testQueryByIdWithSeckill() {
		long id=1001L;
		long phone=18861640348L;
		SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckill());
		
		/*
		 * SuccessKilled [
		 * seckillId=1001, 
		 * userPhone=18861640348, 
		 * state=0, 
		 * createTime=Wed Dec 06 20:10:50 CST 2017]
		 */
		

	}

}
