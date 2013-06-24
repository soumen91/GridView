package com.example.testforcustomdiaogue;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn = (Button)findViewById(R.id.bttnSubmit);
		final Dialog dialog = new Dialog(this);
		
		btn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				final Dialog dialog = new Dialog(MainActivity.this);
				dialog.setContentView(R.layout.custom);
				TextView tv1=(TextView)dialog.findViewById(R.id.textView1);
				EditText ed1 = (EditText) dialog.findViewById(R.id.editText1);
				EditText ed2 = (EditText) dialog.findViewById(R.id.editText2);
				Button bttn = (Button) dialog.findViewById(R.id.button1);
				bttn.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

						dialog.dismiss();
					}
				});

				dialog.show();

			}
		});

	}

}
