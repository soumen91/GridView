package com.example.practiceset1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {
	public Button mbttn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mbttn=(Button)findViewById(R.id.bttn1);
		Bundle bundle = getIntent().getExtras();
		String st = bundle.getString("A1");
		String st1 = bundle.getString("B1");
		
		Toast.makeText(getApplicationContext(), st+st1, Toast.LENGTH_LONG).show();
		
		mbttn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
			}
		});
		
	}

	

}
