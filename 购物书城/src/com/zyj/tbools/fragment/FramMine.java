package com.zyj.tbools.fragment;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.zyj.tbools.R;
import com.zyj.tbools.activity.LoginActivity;

public class FramMine extends Fragment implements OnClickListener {
	private View view;
	
	@ViewInject(R.id.ivPhoto)
	ImageView ivPhoto;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(view==null){
			view=inflater.inflate(R.layout.fragment_mine, null);
			Log.i("123", "FramFind");
			x.view().inject(this,view);
			//初始数据在这里写
			ivPhoto.setOnClickListener(this);
			
		}else{
			((ViewGroup) view.getParent()).removeView(view); 
		}
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(new Intent(getActivity(),LoginActivity.class));
	}
}
