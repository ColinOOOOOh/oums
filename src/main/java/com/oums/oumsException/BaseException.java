package com.oums.oumsException;

/**
 * 
 * @author 谭治
 *
 */
public class BaseException extends Exception {

	/**
    * 序列化ID
    */
    private static final long serialVersionUID = 1L;
	
    public BaseException() {
        super();
    }
    
    public BaseException(String msg) {
        super(msg);
    }
    
    public BaseException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public BaseException(Throwable cause) {
        super(cause);
    }
}
