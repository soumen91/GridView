package com.example.practice;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	private Button mBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.e("onCreate", "onCreate");

		mBtn = (Button) findViewById(R.id.button1);

		mBtn.setOnClickListener(new OnClickListener() {

			private int REQUEST_CODE;

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), SecondActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("A1", "A");
				bundle.putString("B1", "B");
				i.putExtras(bundle);
				startActivityForResult(i,REQUEST_CODE);
				
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Log.e("requestCode", "" + requestCode);
		Log.e("resultCode", "" + resultCode);
		if (getIntent().getExtras() != null) {
			String ss = data.getExtras().getString("b");
			String ss1 = data.getExtras().getString("c");

			Toast.makeText(getApplicationContext(), ss + "  " + ss1, 5000)
					.show();
		}

	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.e("onStart", "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e("onResume", "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.e("onPause", "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e("onStop", "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e("onDestroy", "onDestroy");
	}

}
