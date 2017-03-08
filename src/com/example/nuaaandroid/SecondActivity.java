package com.example.nuaaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
			
		this.setContentView(R.layout.second);
	 	
	    Intent intent = this.getIntent();
		
		String userName = intent.getStringExtra("userName");
	
		TextView tv = (TextView)this.findViewById(R.id.tvContent);
		
		tv.setText(userName);
		
		
	}
}
