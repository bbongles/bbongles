package com.online.shop.domain;

public class ImageVO {

	// 멤버 변수
	private int i_no;
	private String i_img;
	private String i_cont;
	private String p_name;
	private String s_id;
	
	// 생성자
	public ImageVO() {}

	// getter/setter 메소드
	public int getI_no() {
		return i_no;
	}

	public void setI_no(int i_no) {
		this.i_no = i_no;
	}

	public String getI_img() {
		return i_img;
	}

	public void setI_img(String i_img) {
		this.i_img = i_img;
	}

	public String getI_cont() {
		return i_cont;
	}

	public void setI_cont(String i_cont) {
		this.i_cont = i_cont;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	
} // end class ImageVO
