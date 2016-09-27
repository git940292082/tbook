package com.zyj.tbools.activity;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.zyj.tbools.App;
import com.zyj.tbools.R;
import com.zyj.tbools.entity.Book;
import com.zyj.tbools.untils.GlobalConsts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class BookDeatail extends Activity{
	@ViewInject(R.id.tvAuthor)
	TextView tvAuthor;
	@ViewInject(R.id.tvCategory)
	TextView tvCategory;
	@ViewInject(R.id.tvDate)
	TextView tvDate;
	@ViewInject(R.id.textView8)
	TextView tv;
	@ViewInject(R.id.tvPublish)
	TextView tvPublish;
	@ViewInject(R.id.tvTotalDesc)
	TextView tvTotalDesc;
	@ViewInject(R.id.tvDescription)
	TextView tvDescription;
	@ViewInject(R.id.btnAddToCart)
	Button btnAddToCart;
	@ViewInject(R.id.tvPrice)
	TextView tvPrice;
	@ViewInject(R.id.ivBookPic)
	ImageView ivBookPic;
	private Book book;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_detail);
		x.view().inject(this);
		setListener();
		setData();
	}

	private void setListener() {
		// TODO Auto-generated method stub
		btnAddToCart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btnAddToCart.setEnabled(false);
				btnAddToCart.setText("已添加购物车");
				App.addcart(book);
				Toast.makeText(getApplicationContext(), "添加购物车成功"+book.toString(), 0).show();
			}
		});
	}
	
	private void setData() {
		// TODO Auto-generated method stub
		book=App.book;
		Log.i("", book.toString());
		tvAuthor.setText(book.getAuthor());
		tvCategory.setText(book.getCatalogue());
		tvDate.setText(book.getPublishedTime());
		tvPublish.setText(book.getPublishing());
		tvPrice.setText(book.getFixedPrice()+"￥");
		tvDescription.setText(book.getDescription());
		x.image().bind(ivBookPic, GlobalConsts.BASEURL + "productImages/" + book.getProduct_pic());
	}
}
