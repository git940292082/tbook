package com.zyj.tbools.adapter;

import com.zyj.tbools.App;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CartAdapter extends BaseAdapter {

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return App.carts.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return App.carts.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			
		}
		return null;
	}
	
}
