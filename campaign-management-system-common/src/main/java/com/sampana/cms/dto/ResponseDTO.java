/**
 * 
 */
package com.sampana.cms.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * Generic Response in all cases.
 * @author Sudhanshu Chaturvedi
 * @param <T>
 *
 */
public class ResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -212651961961257920L;

	private HttpStatus status;

	private int statusCode;

	private Object data;

	private String message = "";

	/**
	 * 
	 */
	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param status
	 * @param statusCode
	 * @param message
	 */
	public ResponseDTO(HttpStatus status, int statusCode, String message) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
	}



	/**
	 * @param status
	 * @param data
	 */
	public ResponseDTO(HttpStatus status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	/**
	 * @param status
	 * @param statusCode
	 * @param data
	 * @param message
	 */
	public ResponseDTO(HttpStatus status, int statusCode, Object data, String message) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.data = data;
		this.message = message;
	}
	
	/**
	 * @param status
	 * @param statusCode
	 * @param data
	 */
	public ResponseDTO(HttpStatus status, int statusCode, Object data) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.data = data;
	}

	/**
	 * @param status
	 * @param data
	 * @param message
	 */
	public ResponseDTO(HttpStatus status, Object data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public final HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public final void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * @return the data
	 */
	public final Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public final void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the statusCode
	 */
	public final int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public final void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
