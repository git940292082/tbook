package com.zyj.tbools.activity;

import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.zyj.tbools.R;
import com.zyj.tbools.adapter.AddressAdapter;
import com.zyj.tbools.entity.Addres;
import com.zyj.tbools.presenter.AddressPersneter;
import com.zyj.tbools.view.IAddressView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class AddressActivity extends Activity implements IAddressView{
	@ViewInject(R.id.lvAddress)
	ListView lvAddress;
	AddressPersneter persneter;
	public AddressActivity() {
		// TODO Auto-generated constructor stub
		persneter=new AddressPersneter(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address);
		x.view().inject(this);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		persneter.ListAddress();
	}

	@Override
	public void ShowAddress(List<Addres> address) {
		// TODO Auto-generated method stub
		AddressAdapter adapter = new AddressAdapter(address,getApplicationContext());
		lvAddress.setAdapter(adapter);
	}

	@Override
	public void addMsg(String msg) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), msg, 0).show();
	}
}
