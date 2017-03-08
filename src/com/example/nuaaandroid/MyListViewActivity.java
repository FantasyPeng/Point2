package com.example.nuaaandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MyListViewActivity extends Activity {
	ListView lvUsers;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.userslistview);
		
		lvUsers = (ListView)this.findViewById(R.id.lvUsers);
		
		List users  = new ArrayList();
		users.add("A");
		users.add("B");
		users.add("C");
		users.add("D");
		
		
		MyAdapter adapter = new MyAdapter(this,users);
		
		lvUsers.setAdapter(adapter);
		
		
		
		
		
	}
}

