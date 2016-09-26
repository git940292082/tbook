package com.zyj.tbools.presenter;

import java.util.List;

import com.zyj.tbools.entity.Book;
import com.zyj.tbools.model.IEntittyCallBack;
import com.zyj.tbools.model.ShouYeModel;
import com.zyj.tbools.untils.GlobalConsts;
import com.zyj.tbools.view.ShouYeView;

public class ShouYePresenter {

	private ShouYeModel ShouYeModel;
	ShouYeView shouYeView;
	public ShouYePresenter(ShouYeView shouye) {
		ShouYeModel=new ShouYeModel();
		shouYeView=shouye;
	}

	public void loadBook(final String url){
		ShouYeModel.LoadBook(url,new IEntittyCallBack() {
			@Override
			public void loadDataOk(Object obj) {
				// TODO Auto-generated method stub
				List<Book> books=(List<Book>) obj;
				if(url.equals(GlobalConsts.URL_LOAD_RECOMMEND_BOOK_LIST)){
					shouYeView.ShowTuijian(books);
				}else if(url.equals(GlobalConsts.URL_LOAD_HOT_BOOK_LIST)){
					shouYeView.ShowReXiao(books);
				}else if(url.equals(GlobalConsts.URL_LOAD_NEW_BOOK_LIST)){
					shouYeView.ShowZuiXin(books);
				}
				
			}
			@Override
			public void loadDataError(String boj) {
				// TODO Auto-generated method stub
				
			}
		});

	}
}
