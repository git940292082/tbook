package com.zyj.tbools.activity;


import java.util.HashMap;
import java.util.Map;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.zyj.tbools.R;
import com.zyj.tbools.entity.User;
import com.zyj.tbools.presenter.UserPersenter;
import com.zyj.tbools.view.ILoginView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements ILoginView{
	@ViewInject(R.id.etLoginname)
	EditText etLoginname;
	@ViewInject(R.id.etPwd)
	EditText etPwd;
	@ViewInject(R.id.btnLogin)
	Button btnLogin;
	@ViewInject(R.id.tvNewAccount)
	TextView tvNewAccount;
	private UserPersenter userPersenter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		x.view().inject(this);
		setListerner();
		setData();
	}

	public LoginActivity() {
		super();
		// TODO Auto-generated constructor stub
		userPersenter = new UserPersenter();
	}

	private void setListerner() {
		// TODO Auto-generated method stub
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				login();
			}
		});
		tvNewAccount.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),RegisterActivity.class) );
			}
		});
	}
	
	protected void login() {
		// TODO Auto-generated method stub
		Map<String , String> maplogin=new HashMap<String, String>();
		maplogin.put("email",etLoginname.getText().toString().trim());
		maplogin.put("password", etPwd.getText().toString().trim());
		userPersenter.login(maplogin, this);
	}

	private void setData() {
		// TODO Auto-generated method stub
	}
	@Override
	public void loginOk(User user) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "µÇÂ½³É¹¦", 0).show();
	}

	@Override
	public void loginErr(String msg) {
		// TODO Auto-generated method stub
		Toast.makeText(this, msg, 0).show();
	}
}
