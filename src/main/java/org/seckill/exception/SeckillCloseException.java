package org.seckill.exception;
/**
 * ��ɱ�ر��쳣
 * @author Administrator
 *
 */
public class SeckillCloseException extends RuntimeException{

	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillCloseException(String message) {
		super(message);
	}

}
