package com.zyj.tbools.presenter;

import java.util.Map;
import com.zyj.tbools.entity.User;
import com.zyj.tbools.model.IEntittyCallBack;
import com.zyj.tbools.model.UserModel;
import com.zyj.tbools.untils.GlobalConsts;
import com.zyj.tbools.view.ILoginView;
import com.zyj.tbools.view.ILoginWithoutPwdView;
import com.zyj.tbools.view.IRegisterView;

public class UserPersenter {
	UserModel model;
	public UserPersenter() {
		super();
		// TODO Auto-generated constructor stub
		model=new UserModel();
	}
	public void login(Map<String, String> maplogin,final ILoginView iLoginView){
		model.login(maplogin,GlobalConsts.URL_USER_LOGIN,new IEntittyCallBack() {
			@Override
			public void loadDataOk(Object obj) {
				// TODO Auto-generated method stub
				User user=(User) obj;
				iLoginView.loginOk(user);
			}
			@Override
			public void loadDataError(String boj) {
				// TODO Auto-generated method stub
				iLoginView.loginErr(boj);
			}
		});
	}
	public void register(Map<String , String> mapRegister,final IRegisterView register){
		model.register(GlobalConsts.URL_USER_REGIST, mapRegister, new IEntittyCallBack() {
			@Override
			public void loadDataOk(Object obj) {
				// TODO Auto-generated method stub
				String ok=(String) obj;
				register.registerOk(ok);
			}
			
			@Override
			public void loadDataError(String boj) {
				// TODO Auto-generated method stub
				register.registerErr(boj);
			}
		});
	}
	public void loginWithoutPwd(String token,final ILoginWithoutPwdView iLoginWithoutPwdView){
		
		model.loginWithoutPwd(token, new IEntittyCallBack() {
			@Override
			public void loadDataOk(Object obj) {
				// TODO Auto-generated method stub
				String ok=(String) obj;
				iLoginWithoutPwdView.loginWithoutPwdOk(ok);
				
			}
			
			@Override
			public void loadDataError(String boj) {
				// TODO Auto-generated method stub
				iLoginWithoutPwdView.loginWithoutPwdOk(boj);
			}
		});
	}
}
