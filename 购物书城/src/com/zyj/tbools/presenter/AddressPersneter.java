package com.zyj.tbools.presenter;


import java.util.List;
import java.util.Map;

import com.zyj.tbools.entity.Addres;
import com.zyj.tbools.model.AddressModel;
import com.zyj.tbools.model.IEntittyCallBack;
import com.zyj.tbools.view.IAddressView;

public class AddressPersneter {
	AddressModel addressModel;
	IAddressView addressView;
	public AddressPersneter(IAddressView addressView) {
		// TODO Auto-generated constructor stub
		addressModel=new AddressModel();
		this.addressView=addressView;
	}
	public void ListAddress(){
		addressModel.listAddress(new IEntittyCallBack() {
			@Override
			public void loadDataOk(Object obj) {
				// TODO Auto-generated method stub
				List<Addres> addres=(List<Addres>) obj;
				addressView.ShowAddress(addres);
			}
			
			@Override
			public void loadDataError(String boj) {
				// TODO Auto-generated method stub
				addressView.addMsg(boj);
			}
		});
	}
	public void SaveAdderes(Map<String, String> mapAddress){
		addressModel.saveAddress(mapAddress	,new  IEntittyCallBack() {
			
			@Override
			public void loadDataOk(Object obj) {
				// TODO Auto-generated method stub
				addressView.addMsg("添加成功");
			}	
			
			@Override
			public void loadDataError(String boj) {
				// TODO Auto-generated method stub
				addressView.addMsg("添加失败");
			}
		});
	}
	public void setdefault(int id){
		addressModel.setAddDefault(id, new IEntittyCallBack() {
			@Override
			public void loadDataOk(Object obj) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void loadDataError(String boj) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
