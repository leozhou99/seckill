package org.seckill.service;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
						"classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	@Test
	public void testGetSeckillList() {
		List<Seckill> list=seckillService.getSeckillList();
		logger.info("list={}",list);
	}

	@Test
	public void testGetById() {
		long id=1000;
		Seckill seckill=seckillService.getById(id);
		logger.info("seckill={}",seckill);
	}
	//���ɲ��Դ��������߼���ע���ظ�ִ��
	@Test
	public void testSeckillLogic() {
		long id=1001L;
		Exposer exposer=seckillService.exportSeckillUrl(id);
		if(exposer.isExposed()) {
			logger.info("exposer={}",exposer);
			long phone=18861640347L;
			String md5=exposer.getMd5();
			try {
				SeckillExecution execution=seckillService.executeSeckill(id, phone, md5);
				logger.info("result={}",execution);
			} catch (RepeatKillException e) {
				logger.error(e.getMessage());
			} catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			}
		}else {
			//��ɱδ����
			logger.warn("exposer={}",exposer);
		}

	}
	
	@Test
	public void executeSeckillProcedure() {
		long seckillId=1000;
		long phone= 18861640444L;
		Exposer exposer=seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()) {
			String md5=exposer.getMd5();
			SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
			logger.info(execution.getStateInfo());
		}
		String md5=null;
	}

}
