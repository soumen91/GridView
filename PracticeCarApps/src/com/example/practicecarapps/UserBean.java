package com.example.practicecarapps;

public class UserBean {
	public String mName;
	public String mBttn;

	public UserBean(String mName, String mBttn) {
		this.mName = mName;
		this.mBttn = mBttn;
	}

	public String getName() {
		return mName;

	}

	public String getBttn() {
		return mBttn;

	}

	public void setName(String mName) {
		this.mName = mName;

	}

	public void setBttn(String mBttn) {

		this.mBttn = mBttn;
	}

}
