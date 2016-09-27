package com.zyj.tbools.model;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zyj.tbools.App;
import com.zyj.tbools.entity.Addres;
import com.zyj.tbools.untils.CommonRequest;
import com.zyj.tbools.untils.GlobalConsts;

public class AddressModel {
	public  void saveAddress(final Map<String, String> mapAddress,final IEntittyCallBack callBack){
		String url=GlobalConsts.URL_SAVE_ADDRESS;
		CommonRequest request=new CommonRequest(Method.POST,url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				try {
					JSONObject jsonObject=new JSONObject(response);
					int code=jsonObject.getInt("code");
					if(code==GlobalConsts.RESPONSE_CODE_SUCCESS){
						callBack.loadDataOk(null);
					}else{
						String msg=jsonObject.getString("error_msg");
						callBack.loadDataError(msg);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				callBack.loadDataError("ÃÌº”µÿ÷∑ ß∞‹");
			}
		}){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
				return mapAddress;
			}
		};
		App.queue.add(request);
	}
	public void listAddress(final IEntittyCallBack callBack){
		String url=GlobalConsts.URL_LOAD_USER_ADDRESS;
		CommonRequest request=new CommonRequest(url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				try {
					JSONObject jsonObject=new JSONObject(response);
					int code=jsonObject.getInt("code");
					if(code==GlobalConsts.RESPONSE_CODE_SUCCESS){
						JSONArray arr=jsonObject.getJSONArray("data");
						Gson gson=new Gson();
						List<Addres> address=gson.fromJson(arr.toString(),new TypeToken<List<Addres>>(){}.getType());
						callBack.loadDataOk(address);
					}else{
						String msg=jsonObject.getString("error_msg");
						callBack.loadDataError(msg);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, new Response.ErrorListener()  {
			
			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
			}
		});
		App.queue.add(request);
	}
	public void setAddDefault(int id,final IEntittyCallBack callBack){
		
		CommonRequest request=new CommonRequest(GlobalConsts.URL_SET_ADDRESS_DEFAULT,new Listener<String>() {

			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				JSONObject jsonObject;
				try {
					jsonObject = new JSONObject(response);
					int code=jsonObject.getInt("code");
					if(code==GlobalConsts.RESPONSE_CODE_SUCCESS){
						callBack.loadDataOk(true);
					}else{
						String msg=jsonObject.getString("error_msg");
						callBack.loadDataError(msg);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				
			}
		}){
			
		};
		App.queue.add(request);
	}
}
