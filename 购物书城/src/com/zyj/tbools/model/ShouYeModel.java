package com.zyj.tbools.model;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zyj.tbools.App;
import com.zyj.tbools.entity.Book;
import com.zyj.tbools.untils.GlobalConsts;

public class ShouYeModel {

	public void LoadBook(String url, final IEntittyCallBack iEntittyCallBack) {
		// TODO Auto-generated method stub
		StringRequest request=new  StringRequest(url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				Log.i("213", response);
				try {
					JSONObject jsonObject=new JSONObject(response);
					int code=jsonObject.getInt("code");
					if(code==GlobalConsts.RESPONSE_CODE_SUCCESS){
						JSONArray arr=jsonObject.getJSONArray("data");
						Log.i("213", arr.toString());
						Gson gson=new Gson();
						List<Book> books=gson.fromJson(arr.toString(),new TypeToken<List<Book>>(){}.getType());
						iEntittyCallBack.loadDataOk(books);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					iEntittyCallBack.loadDataError("");
				}
				
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				iEntittyCallBack.loadDataError("");
			}
		});
		App.queue.add(request);
	}
}
