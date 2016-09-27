package com.zyj.tbools.adapter;

import org.xutils.x;

import com.zyj.tbools.App;
import com.zyj.tbools.R;
import com.zyj.tbools.entity.Cart;
import com.zyj.tbools.untils.GlobalConsts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CartAdapter extends BaseAdapter{
IUpdatePicCallBack callBack;
	
	public CartAdapter(IUpdatePicCallBack callbakc) {
		super();
		// TODO Auto-generated constructor stub
		callBack=callbakc;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return App.carts.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return App.carts.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Cart item = App.carts.get(position);
		HolderView holder=null;
		if(convertView==null){
			convertView=LayoutInflater.from(App.context).inflate(R.layout.item_cart_lv_cartitem, null);
			holder=new HolderView(convertView);
			convertView.setTag(holder);
		}else{
			holder=(HolderView) convertView.getTag();
		}
		String picPath = GlobalConsts.BASEURL + "productImages/" + item.getBook().getProduct_pic();
		x.image().bind(holder.ivBookPic, picPath);
		holder.tvBookName.setText(item.getBook().getProductName());
		holder.tvPrice.setText(item.getBook().getDangPrice() + "гд");
		holder.tvCount.setText("x" + item.getCount());
		holder.tvCount.setTag("tvCount" + position);
		holder.tvNum.setText(item.getCount() + "");
		holder.tvNum.setTag("tvNum" + position);
		holder.ivDel.setTag("ivDel" + position);
		return convertView;
	}
	class HolderView{
		ImageView ivBookPic;
		TextView tvBookName;
		TextView tvPrice;
		TextView tvCount;
		ImageView ivm;
		ImageView ivp;
		TextView tvNum;
		ImageView ivDel;
		public HolderView(View view) {
			// TODO Auto-generated constructor stub
			ivBookPic = (ImageView) view.findViewById(R.id.ivBookPic);
			ivm = (ImageView) view.findViewById(R.id.ivm);
			ivp = (ImageView) view.findViewById(R.id.ivp);
			ivDel = (ImageView) view.findViewById(R.id.ivDel);
			tvBookName = (TextView) view.findViewById(R.id.tvBookName);
			tvPrice = (TextView) view.findViewById(R.id.tvPrice);
			tvCount = (TextView) view.findViewById(R.id.tvCount);
			tvNum = (TextView) view.findViewById(R.id.tvNum);
		}

	}
}
