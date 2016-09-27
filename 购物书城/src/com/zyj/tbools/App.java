package com.zyj.tbools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xutils.x;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.zyj.tbools.entity.Book;
import com.zyj.tbools.entity.Cart;

import android.app.Application;
import android.content.Context;

public class App extends Application {
	public static Context context;
	public static RequestQueue queue;
	public static List<Cart> carts;
	public static Book book;
	@Override
	public void onCreate() {
		super.onCreate();
		x.Ext.init(this);
		queue=Volley.newRequestQueue(this);
		carts=new ArrayList<Cart>();
		context=this;
	}
	public static void addcart(Book book){
		for (Cart cart : carts) {
			if(book.equals(cart.getBook())){
				cart.jia();
				return;
			}
		}
		carts.add(new Cart(book, 1));
	}
	
	public static void remove(Book book){
		for (Cart cart : carts) {
			if(book.equals(cart.getBook())){
				carts.remove(cart);
				break;
			}
		}
	}
	
}
