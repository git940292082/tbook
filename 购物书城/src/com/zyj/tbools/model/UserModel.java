package com.zyj.tbools.model;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.zyj.tbools.App;
import com.zyj.tbools.entity.User;
import com.zyj.tbools.untils.GlobalConsts;

public class UserModel {
	public void login(final Map<String, String> maplogin,String url,final IEntittyCallBack callBack){
		StringRequest request=new StringRequest(Request.Method.POST,url,new Listener<String>() {
			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				try {
					JSONObject jsonObject=new JSONObject(response);
					int code=jsonObject.getInt("code");
					if(code==GlobalConsts.RESPONSE_CODE_SUCCESS){
						JSONObject json=jsonObject.getJSONObject("user");
						Gson gson=new Gson();
						User user=gson.fromJson(json.toString(), User.class);
						callBack.loadDataOk(user);
					}else{
						String msg=jsonObject.getString("error_msg");
						callBack.loadDataError(msg);
					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					callBack.loadDataError("");
				}
			}
		},new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub

			}
		}){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
				return maplogin;
			}
		};
		App.queue.add(request);
	}
	public void register(String url,final Map<String , String> mapRegist,final IEntittyCallBack callBack){
		StringRequest request=new StringRequest(Request.Method.POST, url, 
				new Listener<String>() {
			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				JSONObject json;
				try {
					json = new JSONObject(response);
					int code=json.getInt("code");
					if(code==GlobalConsts.RESPONSE_CODE_SUCCESS){
						callBack.loadDataOk("ok");
					}else{
						String msg=json.getString("error_msg");
						callBack.loadDataError(msg);
					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		},null){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
				return mapRegist;
			}
		};
		App.queue.add(request);
	}
	public void loginWithoutPwd(String token,final IEntittyCallBack callBack){
		String url = GlobalConsts.URL_USER_LOGIN_WITHOUT_PWD + "?token=" + token;
		StringRequest request=new StringRequest(url,new Listener<String>() {
			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				try {
					JSONObject json=new JSONObject(response);
					int code=json.getInt("code");
					if(code==GlobalConsts.RESPONSE_CODE_SUCCESS){
						callBack.loadDataOk("ok");
					}else{
						callBack.loadDataError(json.getString("error_msg"));
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
				}
				
			}
		},null);
		App.queue.add(request);
	}
}
