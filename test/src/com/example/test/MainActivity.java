package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button mOne;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      mOne = (Button)findViewById(R.id.button1);  
      
        mOne.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*Intent i = new Intent(getApplicationContext(),SecondActivity.class);
				startActivity(i);*/
				MainActivity.this.finish();
				
			}
		});
       
      
    }

    
}
