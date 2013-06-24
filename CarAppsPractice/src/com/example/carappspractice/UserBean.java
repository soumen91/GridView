package com.example.carappspractice;

public class UserBean {
	private String mBtn;
	private String mName;
	public UserBean(String mName,String mBtn)
	{
		this.mBtn=mBtn;
		this.mName=mName;
	}
	public String getName(){
		return mName;
	}
	public String getButton(){
		return mBtn;
	}
	public void setName(String mName){
		this.mName=mName;
	}
	public void setButton(String mBtn){
		this.mBtn=mBtn;
	}

}
