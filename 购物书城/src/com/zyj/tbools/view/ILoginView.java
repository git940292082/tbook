package com.zyj.tbools.view;

import com.zyj.tbools.entity.User;

public interface ILoginView {
	public void loginOk(User user);
	public void loginErr(String msg);
	
}
