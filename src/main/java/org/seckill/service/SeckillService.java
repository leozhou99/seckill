package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

/**
 * ҵ��ӿڣ�վ�ڡ�ʹ���ߡ��Ƕ���ƽӿ�
 * �������棺�����������ȣ��������������ͣ�return ����/�쳣��
 * 
 * @author Administrator
 *
 */
public interface SeckillService {
	
	/**
	 * ��ѯ������ɱ��¼
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * ��ѯ������ɱ��¼
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * ��ɱ����ʱ�����ɱ�ӿڵĵ�ַ��
	 * �������ϵͳʱ�����ɱʱ��
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * ִ����ɱ����
	 * @param seckill
	 * @param userphone
	 * @param md5
	 */
	SeckillExecution executeSeckill(long seckillId,long userPhone,String md5) 
			throws SeckillException,RepeatKillException,SeckillCloseException;
	
	/**
	 * ִ����ɱ���� by�洢����
	 * @param seckill
	 * @param userphone
	 * @param md5
	 */
	SeckillExecution executeSeckillProcedure(long seckillId,long userPhone,String md5);
}