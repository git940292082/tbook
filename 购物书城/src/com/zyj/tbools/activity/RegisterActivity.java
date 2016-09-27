package com.zyj.tbools.activity;

import java.util.HashMap;
import java.util.Map;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.zyj.tbools.R;
import com.zyj.tbools.presenter.UserPersenter;
import com.zyj.tbools.view.IRegisterView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity  extends Activity implements IRegisterView,OnClickListener{
	@ViewInject(R.id.ivCode)
	ImageView ivCode;
	@ViewInject(R.id.etLoginname)
	EditText etLoginname;
	@ViewInject(R.id.etPwd)
	EditText etPwd;
	@ViewInject(R.id.etRealname)
	EditText etRealname;
	@ViewInject(R.id.etCode)
	EditText etCode;
	@ViewInject(R.id.btnLogin)
	Button btnLogin;
	
	UserPersenter persenter;
	public RegisterActivity() {
		// TODO Auto-generated constructor stub
		persenter=new UserPersenter();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		x.view().inject(this);
		setListener();
		persenter.loadImageCode(this);
	}
	private void setListener() {
		ivCode.setOnClickListener(this);
		btnLogin.setOnClickListener(this);
	}
	@Override
	public void registerOk(String ok) {
		// TODO Auto-generated method stub
	Toast.makeText(this, "×¢²á³É¹¦", 0).show();
	}

	@Override
	public void registerErr(String msg) {
		// TODO Auto-generated method stub
		Toast.makeText(this, msg, 0).show();
		persenter.loadImageCode(this);
	}
	@Override
	public void ImageCode(Bitmap bitmap) {
		// TODO Auto-generated method stub
		ivCode.setImageBitmap(bitmap);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ivCode:
			persenter.loadImageCode(this);
			break;
		case R.id.btnLogin:
			regist();
			break;
		}
	}
	private void regist() {
		// TODO Auto-generated method stub
		Map<String, String> mapRegist=new HashMap<String, String>();
		mapRegist.put("user.email",etLoginname.getText().toString().trim());
		mapRegist.put("user.nickname", etRealname.getText().toString().trim());
		mapRegist.put("user.password", etPwd.getText().toString().trim());
		mapRegist.put("number", etCode.getText().toString().trim());
		persenter.register(mapRegist, this);
	}

}
