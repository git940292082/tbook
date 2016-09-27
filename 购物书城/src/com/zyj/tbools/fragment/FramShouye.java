package com.zyj.tbools.fragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

import com.zyj.tbools.App;
import com.zyj.tbools.R;
import com.zyj.tbools.activity.BookDeatail;
import com.zyj.tbools.adapter.BookAdaoter;
import com.zyj.tbools.entity.Book;
import com.zyj.tbools.presenter.ShouYePresenter;
import com.zyj.tbools.untils.GlobalConsts;
import com.zyj.tbools.view.ShouYeView;

public class FramShouye  extends Fragment implements ShouYeView,OnItemClickListener{
	
	@ViewInject(R.id.shouye_tuijian_gl)
	GridView Gvtuijian;
	@ViewInject(R.id.shouye_rexiao_gl)
	GridView Gvrexiao;
	@ViewInject(R.id.shouye_zuixin_gl)
	GridView Gvzuixin;
	private Map<GridView, List<Book>> mapBook;
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
			setListener();
			setData();
		
		}else{
			((ViewGroup) view.getParent()).removeView(view); 
		}
		return view;
	}
	private void setListener() {
		// TODO Auto-generated method stub
		Gvrexiao.setOnItemClickListener(this);
		Gvtuijian.setOnItemClickListener(this);
		Gvzuixin.setOnItemClickListener(this);
	}
	private void setData() {
		// TODO Auto-generated method stub
		mapBook=new HashMap<GridView, List<Book>>();
		//初始数据在这里写
		presenter.loadBook(GlobalConsts.URL_LOAD_RECOMMEND_BOOK_LIST);
		presenter.loadBook(GlobalConsts.URL_LOAD_HOT_BOOK_LIST);
		presenter.loadBook(GlobalConsts.URL_LOAD_NEW_BOOK_LIST);
	}
	@Override
	public void ShowTuijian(List<Book> books) {
		// TODO Auto-generated method stub
		BookAdaoter adapter = new BookAdaoter(getActivity(), books);
		mapBook.put(Gvtuijian, books);
		Gvtuijian.setAdapter(adapter);
	}
	@Override
	public void ShowReXiao(List<Book> books) {
		// TODO Auto-generated method stub
		BookAdaoter adapter = new BookAdaoter(getActivity(), books);
		mapBook.put(Gvrexiao, books);
		Gvrexiao.setAdapter(adapter);
	}
	@Override
	public void ShowZuiXin(List<Book> books) {
		// TODO Auto-generated method stub
		BookAdaoter adapter = new BookAdaoter(getActivity(), books);
		mapBook.put(Gvzuixin, books);
		Gvzuixin.setAdapter(adapter);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Book book=mapBook.get(arg0).get(arg2);
		App.book=book;
		startActivity(new Intent(getActivity(),BookDeatail.class));
	}
}
