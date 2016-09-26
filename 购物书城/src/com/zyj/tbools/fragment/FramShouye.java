package com.zyj.tbools.fragment;

import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.zyj.tbools.R;
import com.zyj.tbools.adapter.BookAdaoter;
import com.zyj.tbools.entity.Book;
import com.zyj.tbools.presenter.ShouYePresenter;
import com.zyj.tbools.untils.GlobalConsts;
import com.zyj.tbools.view.ShouYeView;

public class FramShouye  extends Fragment implements ShouYeView{
	
	@ViewInject(R.id.shouye_tuijian_gl)
	GridView Gvtuijian;
	@ViewInject(R.id.shouye_rexiao_gl)
	GridView Gvrexiao;
	@ViewInject(R.id.shouye_zuixin_gl)
	GridView Gvzuixin;
	
	
	private View view;
	ShouYePresenter presenter;
	
	
	public FramShouye() {
		presenter=new ShouYePresenter(this);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(view==null){
			view=inflater.inflate(R.layout.fragment_shouye, null);
			Log.i("123", "FramFind");
			x.view().inject(this,view);
			//初始数据在这里写
			presenter.loadBook(GlobalConsts.URL_LOAD_RECOMMEND_BOOK_LIST);
			presenter.loadBook(GlobalConsts.URL_LOAD_HOT_BOOK_LIST);
			presenter.loadBook(GlobalConsts.URL_LOAD_NEW_BOOK_LIST);
		}else{
			((ViewGroup) view.getParent()).removeView(view); 
		}
		return view;
	}
	@Override
	public void ShowTuijian(List<Book> books) {
		// TODO Auto-generated method stub
		BookAdaoter adapter = new BookAdaoter(getActivity(), books);
		Gvtuijian.setAdapter(adapter);
	}
	@Override
	public void ShowReXiao(List<Book> books) {
		// TODO Auto-generated method stub
		BookAdaoter adapter = new BookAdaoter(getActivity(), books);
		Gvrexiao.setAdapter(adapter);
	}
	@Override
	public void ShowZuiXin(List<Book> books) {
		// TODO Auto-generated method stub
		BookAdaoter adapter = new BookAdaoter(getActivity(), books);
		Gvzuixin.setAdapter(adapter);
	}
}
