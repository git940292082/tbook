package com.zyj.tbools.adapter;

import java.util.List;

import org.xutils.x;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyj.tbools.R;
import com.zyj.tbools.entity.Book;
import com.zyj.tbools.untils.GlobalConsts;

public class BookAdaoter extends MyAdapter<Book>{

	public BookAdaoter(Context context, List<Book> data) {
		super(context, data);
		// TODO Auto-generated constructor stub
	}
	@Override
	public View getView(int position, View layout, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder=null;
		Book book=getData().get(position);
		if(layout==null){
			layout=getInflater().inflate(R.layout.item_store_gv_book, null);
			holder=new ViewHolder(layout);
			layout.setTag(holder);
		}else{
			holder = (ViewHolder) layout.getTag();
		}
		x.image().bind(holder.imageView, GlobalConsts.BASEURL + "productImages/" + book.getProduct_pic());
		holder.textView.setText(book.getProductName());
		return layout;
	}
	
	class ViewHolder{
		ImageView imageView;
		TextView textView;
		public ViewHolder(View view) {
			// TODO Auto-generated constructor stub
			imageView=(ImageView) view.findViewById(R.id.imageView);
			textView=(TextView) view.findViewById(R.id.textView);
		}
		
	}
	
}
