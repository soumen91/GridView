package com.example.carapps;

import java.util.ArrayList;

import android.R.array;
import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ArrayList<UserBean> arr = new ArrayList<UserBean>();
	private MyAdapter myadp;
	private ListView list;
	private LinearLayout mLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list = (ListView) findViewById(R.id.listView1);
		mLayout=(LinearLayout)findViewById(R.id.main);

		UserBean b1 = new UserBean("A", "a1");
		UserBean c1 = new UserBean("B", "b1");
		UserBean d1 = new UserBean("c", "C1");
		UserBean e1 = new UserBean("D", "d1");
		UserBean f1 = new UserBean("E", "e1");
		arr.add(b1);
		arr.add(c1);
		arr.add(d1);
		arr.add(e1);
		arr.add(f1);
		myadp = new MyAdapter(getApplicationContext(), R.layout.row, arr);
		list.setAdapter(myadp);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				Log.e("Reach here", "Reach here");
				
				Toast.makeText(getApplicationContext(), "Here is "+arr.get(position).getName(), Toast.LENGTH_SHORT).show();
			}
		});
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				Toast.makeText(getApplicationContext(), "Here is "+arr.get(position).getName(), Toast.LENGTH_SHORT).show();	
				arr.get(position).setName("soumen");
			}
		});

	}
	

}
