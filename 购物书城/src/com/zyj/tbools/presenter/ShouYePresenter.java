package com.zyj.tbools.presenter;

import java.util.List;

import com.zyj.tbools.entity.Book;
import com.zyj.tbools.model.IEntittyCallBack;
import com.zyj.tbools.model.ShouYeModel;
import com.zyj.tbools.view.ShouYeView;

public class ShouYePresenter {

	private ShouYeModel ShouYeModel;
	ShouYeView shouYeView;
	public ShouYePresenter(ShouYeView shouye) {
		ShouYeModel=new ShouYeModel();
		shouYeView=shouye;
	}

	public void loadTuijian(){
		ShouYeModel.LoadTuiJian(new IEntittyCallBack() {
			@Override
			public void loadData(Object obj) {
				// TODO Auto-generated method stub
				List<Book> books=(List<Book>) obj;
				shouYeView.ShowTuijian(books);
			}
		});

	}
	public void loadReXiao(){
		ShouYeModel.LoadReXiao(new IEntittyCallBack() {
			@Override
			public void loadData(Object obj) {
				// TODO Auto-generated method stub
				List<Book> books=(List<Book>) obj;
				shouYeView.ShowReXiao(books);
			}
		});
	}
	public void loadZuixin(){
		ShouYeModel.LoadZuiXin(new IEntittyCallBack() {
			@Override
			public void loadData(Object obj) {
				// TODO Auto-generated method stub
				List<Book> books=(List<Book>) obj;
				shouYeView.ShowZuiXin(books);
			}
		});
	}
}
