package com.zyj.tbools.fragment;

import org.xutils.x;

import com.zyj.tbools.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FramCart extends Fragment {
	private View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(view==null){
			view=inflater.inflate(R.layout.fragment_cart, null);
			 x.view().inject(this, view);
			Log.i("123", "FramFind");
			x.view().inject(this,view);
			//��ʼ����������д
			
		}else{
			((ViewGroup) view.getParent()).removeView(view); 
		}
		return view;
	}
}
