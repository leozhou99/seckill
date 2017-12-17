package org.seckill.exception;
/**
 * √Î…±“µŒÒ“Ï≥£
 * @author Administrator
 *
 */
public class SeckillException extends RuntimeException{

	public SeckillException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillException(String message) {
		super(message);
	}

}
