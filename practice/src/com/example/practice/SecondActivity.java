package com.example.practice;

import android.R.string;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class SecondActivity extends Activity {
	private Button mBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
		Log.i("onCreate", "onCreate");

		mBtn = (Button) findViewById(R.id.button2);
		String abc = getIntent().getExtras().getString("a");
		Toast.makeText(getApplicationContext(), abc, 4000).show();
		mBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// startActivity(new Intent(getApplicationContext(),
				// MainActivity.class));
				//
				Bundle bundle = new Bundle();
				Intent i = getIntent();
				bundle.putString("b", "yaju");
				bundle.putString("C", "yaju11");
				i.putExtras(bundle);
				setResult(101, i);
				SecondActivity.this.finish();
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i("onStart", "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i("onResume", "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i("onPause", "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i("onStop", "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("onDestroy", "onDestroy");
	}

}
