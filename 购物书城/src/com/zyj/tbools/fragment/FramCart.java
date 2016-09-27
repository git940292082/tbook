package com.zyj.tbools.fragment;


import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.zyj.tbools.App;
import com.zyj.tbools.R;
import com.zyj.tbools.adapter.CartAdapter;
import com.zyj.tbools.adapter.IUpdatePicCallBack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


public class FramCart extends Fragment implements IUpdatePicCallBack {
	
	@ViewInject(R.id.lvCart)
	ListView lvCart;
	@ViewInject(R.id.tvTotalPrice)
	TextView tvTotalPrice;
	private View view;
	private CartAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(view==null){
			view=inflater.inflate(R.layout.fragment_cart, null);
			 x.view().inject(this, view);
			Log.i("123", "FramFind");
			x.view().inject(this,view);
			//初始数据在这里写
			setData();
		}else{
			((ViewGroup) view.getParent()).removeView(view); 
		}
		return view;
	}
	private void setData() {
		// TODO Auto-generated method stub
		adapter = new CartAdapter(this);
		lvCart.setAdapter(adapter);
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		update();
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		double pic=0;
		adapter.notifyDataSetChanged();
		for(int i=0;i<App.carts.size();i++){
			pic=pic+App.carts.get(i).getQian();
		}
		tvTotalPrice.setText(pic+"");
	}
	
	
}
