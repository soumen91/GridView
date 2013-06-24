package com.hello.andoirdProject;

import com.hello.hellomain.client.HelloWorldPresenter;
import com.hello.hellomain.client.HelloWorldViewInterface;
import com.hello.hellomain.client.Listener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Hello extends Activity implements HelloWorldViewInterface {
    /** Called when the activity is first created. */
	Button button;
	TextView textView;
	Listener myListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button) findViewById(R.id.button_id);
        textView  = (TextView) findViewById(R.id.LabelView);
        new HelloWorldPresenter(this);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				myListener.onAction();
			}
		});
        Log.d("HelloAndroid", "End");
    }
	@Override
	public void setClickListener(Listener inListener) {
		myListener = inListener;
		
	}
	@Override
	public void setClickText(String clickText) {
		button.setText(clickText);
		
	}
	@Override
	public void setHelloText(String labelText) {
		textView.setText(labelText);
		
	}

}