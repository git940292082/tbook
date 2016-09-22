package com.zyj.tbools.fragment;

import org.xutils.x;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyj.tbools.R;

public class FramShouye  extends Fragment{
	private View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(view==null){
			view=inflater.inflate(R.layout.fragment_shouye, null);
			Log.i("123", "FramFind");
			x.view().inject(this,view);
			//初始数据在这里写
			
		}else{
			((ViewGroup) view.getParent()).removeView(view); 
		}
		return view;
	}
}
