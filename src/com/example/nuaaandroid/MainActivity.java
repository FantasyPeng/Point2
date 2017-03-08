package com.example.nuaaandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.List;

import com.example.nuaaandroid.entity.User;
import com.example.nuaaandroid.util.DatabaseHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	
	
	EditText etUserName;
	CheckBox cbSave;
	EditText userName;
	EditText passwd;
	
	TextView tvResult;
	RadioGroup rg1;

	
	Handler handler = new Handler(){
		
		@Override
		public void handleMessage(Message msg) {
			
			super.handleMessage(msg);
			
			List list = (List) msg.obj;
			
			String strUserName = "";
			for(int i = 0;i<list.size();i++){
				
				User user = (User) list.get(i);
				
				strUserName = strUserName+user.getUserName();
				
				
				tvResult.setText(strUserName);
			}
			
			
			
		}
		
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		cbSave = (CheckBox) this.findViewById(R.id.cbSave);
		userName = (EditText) this.findViewById(R.id.etUserName);

		passwd = (EditText) this.findViewById(R.id.etPasswd);

		tvResult = (TextView)this.findViewById(R.id.tvResult);
		
		
		// rg1 = (RadioGroup)this.findViewById(R.id.radioGroup1);

		// Button btnLogin = (Button) this.findViewById(R.id.btnLogin);

		// etUserName = (EditText) this.findViewById(R.id.etUserName);

		// btnLogin.setOnClickListener(this);

	}

	public void view(View view) {

		Uri uri = Uri.parse("http://www.cctv.com");
		Intent it = new Intent(Intent.ACTION_VIEW, uri);
		this.startActivity(it);

	}

	public void call(View view) {

		Uri uri = Uri.parse("tel:13492348998");
		Intent it = new Intent(Intent.ACTION_CALL, uri);
		this.startActivity(it);

	}

	public void login(View view) {

		
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				
				try {
					
				
					
					URL url = new URL("http://192.168.3.17:8080/Nuaa_JavaEE/loginServlet?userName=rod&passwd=123");
					
					URLConnection conn = url.openConnection();
					
					InputStream stream = conn.getInputStream();
					
					InputStreamReader reader = new InputStreamReader(stream);
					
					BufferedReader br = new BufferedReader(reader);
					
					String str = br.readLine();
					
					System.out.println(str);
										
					Gson gson = new Gson();
					
					List<User> userList = gson.fromJson(str, new TypeToken<List<User>>() {
					}.getType());
					for (User user : userList) {
						System.out.println(user.getUserName());
					}
					
					
					Message msg = new Message();
					
					msg.obj = userList;
					
					
					handler.sendMessage(msg);
					
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}});
		
		t.start();
		
		
	/*	 * System.out.println("in the login method......0..");
		 * 
		 * 
		 * if(cbSave.isChecked()==true){
		 * 
		 * System.out.println("in the login method......1..");
		 * 
		 * SharedPreferences sp = this.getSharedPreferences("userInfo",
		 * Context.MODE_WORLD_READABLE);
		 * 
		 * Editor editor = sp.edit();
		 * 
		 * 
		 * editor.putString("username",userName.getText().toString() );
		 * editor.putString("passwd", passwd.getText().toString());
		 * System.out.println("in the login method.......2."); editor.commit();
		 * 
		 * System.out.println("in the login method......3..");
		 * 
		 * }
		 */

		/*
		 * Intent intent = new Intent(); intent.setAction(Intent.ACTION_MAIN);
		 * intent.addCategory(Intent.CATEGORY_HOME); startActivity(intent);
		 */

		/*
		 * int btnId = rg1.getCheckedRadioButtonId();
		 * 
		 * if(btnId==R.id.radioButton1){
		 * 
		 * //
		 * 
		 * }
		 */

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {

		String strUserName = etUserName.getText().toString();

		if (strUserName.equals("rod")) {

			Intent intent = new Intent();

			intent.putExtra("userName", strUserName);

			intent.setClass(MainActivity.this, SecondActivity.class);

			this.startActivity(intent);

		}

	}

	public void add(View view) {

		DatabaseHandler db = new DatabaseHandler(this);
		SQLiteDatabase sqlite = db.getWritableDatabase();

		sqlite.execSQL("insert into t_user values(1,'Rod')");

	}

	public void modify(View view) {
		DatabaseHandler db = new DatabaseHandler(this);
		SQLiteDatabase sqlite = db.getWritableDatabase();
		sqlite.execSQL("update t_user set username='' where userid = 1");
	}

}
