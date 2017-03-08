package com.example.nuaaandroid;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	Context ctx;
	List users;
	
	public MyAdapter (Context ctx, List users){
		
		this.ctx = ctx;
		this.users = users;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return users.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return users.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		
		View view = LayoutInflater.from(ctx).inflate(R.layout.userslistviewsub, null);
		
		TextView tv1 = (TextView) view.findViewById(R.id.textView1);
		
		tv1.setText(users.get(position).toString());
		
		
		return view;
	}

}
