package com.example.testpractice;

import com.example.testpractice.R.string;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	public Button bmttn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bmttn = (Button) findViewById(R.id.bttn);
		bmttn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				startActivityForResult(new Intent(getApplicationContext(),
						secondActivity.class).putExtra("gg", "soumen"), 100);

			}
		});
	}


	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		if (getIntent().getExtras() != null) {

			String ss = getIntent().getExtras().getString("n");
			String ss1 = getIntent().getExtras().getString("m");
			Toast.makeText(getApplicationContext(), ss1 + " " + ss, 5000).show();
		}
	}

}