package com.zyj.tbools.entity;

import java.io.Serializable;
public class Cart implements Serializable{
	private Book book;
	private int count;
	private double qian;
	
	public Book getBook() {
		return book;
	}
	public int getCount() {
		
		return count;
	}
	
	public double getQian() {
		qian=book.getDangPrice()*count;
		return qian;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(Book book, int count) {
		super();
		this.book = book;
		this.count = count;
	}
	
	public void jia(){
		count++;
	}
	
	public void jian(){
		count--;
		if(count<1){
			count=1;
		}
	}
	
}
