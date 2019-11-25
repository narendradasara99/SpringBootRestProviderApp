package com.nare.exception;

import org.springframework.stereotype.Component;

@Component
public class ErrorHanlingClass {
	private int id;
	private String msg;
	public ErrorHanlingClass(int id, String msg) {
		super();
		this.id = id;
		this.msg = msg;
	}
	public ErrorHanlingClass() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ErrorHanlingClass [id=" + id + ", msg=" + msg + "]";
	}
	

}
