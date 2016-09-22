package com.zyj.tbools.activity;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.zyj.tbools.R;
import com.zyj.tbools.adapter.MyPageAdapter;
import com.zyj.tbools.fragment.FramCart;
import com.zyj.tbools.fragment.FramMine;
import com.zyj.tbools.fragment.FramShouye;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
public class TbookActivity extends FragmentActivity {

	@ViewInject(R.id.main_viewpage)
	private ViewPager vPager;
	@ViewInject(R.id.main_groaup)
	private RadioGroup radioGroup;
	@ViewInject(R.id.radio1)
	private RadioButton rb1;
	@ViewInject(R.id.radio2)
	private RadioButton rb2;
	@ViewInject(R.id.radio3)
	private RadioButton rb3;

	private ArrayList<Fragment> fragments;
	private MyPageAdapter myPageAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tbook);
		x.view().inject(this);
		setListner();
		setAdapter();

	}

	private void setAdapter() {
		// TODO Auto-generated method stub
		fragments=new ArrayList<Fragment>();
		fragments.add(new FramShouye());
		fragments.add(new FramCart());
		fragments.add(new FramMine());
		myPageAdapter=new MyPageAdapter(getSupportFragmentManager(), fragments);
		vPager.setAdapter(myPageAdapter);
	}
	private void setListner() {
		// TODO Auto-generated method stub
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.radio1:
					vPager.setCurrentItem(0);
					break;
				case R.id.radio2:
					vPager.setCurrentItem(1);
					break;
				case R.id.radio3:
					vPager.setCurrentItem(2);
					break;
				}
			}
		});
		vPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				switch (arg0){
				case 0:
					radioGroup.check(R.id.radio1);
					break;
				case 1:
					radioGroup.check(R.id.radio2);
					break;
				case 2:
					radioGroup.check(R.id.radio3);
					break;
			}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
