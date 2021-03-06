package com.zyj.tbools.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zyj.tbools.R;
import com.zyj.tbools.entity.Addres;
import com.zyj.tbools.presenter.AddressPersneter;

import java.util.List;

/**
 * Created by hanamingming on 16/3/7.
 */
public class AddressAdapter extends BaseAdapter {
	private List<Addres> addresses;
	private Context context;
	private AddressPersneter presenter;

	public AddressAdapter(List<Addres> addresses, Context context) {
		this.addresses = addresses;
		this.context = context;
	}

	@Override
	public int getCount() {
		return addresses.size();
	}

	@Override
	public Addres getItem(int i) {
		return addresses.get(i);
	}

	@Override
	public long getItemId(int i) {
		return addresses.get(i).getId();
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		ViewHolder holder = null;
		if(view == null){
			view = View.inflate(context, R.layout.item_lv_address, null);
			holder = new ViewHolder();
			holder.tvReceiveName = (TextView) view.findViewById(R.id.tvReceiveName);
			holder.tvNumber = (TextView) view.findViewById(R.id.tvPhone);
			holder.tvReceiveAddress = (TextView) view.findViewById(R.id.tvReceiveAddress);
			holder.radioDefault = (RadioButton) view.findViewById(R.id.radioDefault);
			holder.radioEdit = (RadioButton) view.findViewById(R.id.radioEdit);
			holder.radioDelete = (RadioButton) view.findViewById(R.id.radioDelete);
			view.setTag(holder);
		}
		holder = (ViewHolder) view.getTag();
		Addres address = getItem(i);
		holder.tvReceiveName.setText(address.getReceiveName());
		holder.tvNumber.setText(address.getPhone());
		holder.tvReceiveAddress.setText(address.getFull_address());
		holder.radioDefault.setChecked(address.getIs_default()==1);
		holder.radioDefault.setOnCheckedChangeListener(new AddressAdapterListener(i));
		return view;
	}

	class AddressAdapterListener implements CompoundButton.OnCheckedChangeListener {
		private int position;

		AddressAdapterListener(int position) {
			this.position = position;
		}

		public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
			if(b){
				Addres address = addresses.get(position);
				int id = address.getId();
//				presenter.setdefault(id);
			}
		}
	}

	class ViewHolder{
		TextView tvReceiveName;
		TextView tvNumber;
		TextView tvReceiveAddress;
		RadioButton radioDefault;
		RadioButton radioEdit;
		RadioButton radioDelete;
	}

	public void setPresenter(AddressPersneter presenter) {
		this.presenter = presenter;
	}
}
