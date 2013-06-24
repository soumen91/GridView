package com.example.practiceset1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	public Button mbttn;
	private static final int REQUEST_CODE = 100;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mbttn=(Button)findViewById(R.id.bttn1);
		mbttn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				/*Intent i = new Intent(getApplicationContext(), SecondActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("A1", "A");
				bundle.putString("B1", "B");
				i.putExtras(bundle);
				startActivity(i);*/
				registerForContextMenu(v);
				
			}
		});
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	inflater.inflate(R.menu.test, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.item11:
			Toast.makeText(getApplicationContext(), "A1", Toast.LENGTH_LONG)	.show();
			break;
		case R.id.item21:
			Toast.makeText(getApplicationContext(), "B1", Toast.LENGTH_LONG)	.show();
			break;
		case R.id.item31:
			Toast.makeText(getApplicationContext(), "C1", Toast.LENGTH_LONG)	.show();
			break;
		case R.id.item2:
			Toast.makeText(getApplicationContext(), "B", Toast.LENGTH_LONG)	.show();
			break;

		case R.id.item3:
			Toast.makeText(getApplicationContext(), "C", Toast.LENGTH_LONG)	.show();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.i1:
			Toast.makeText(getApplicationContext(), "I", Toast.LENGTH_LONG)	.show();
			break;
		case R.id.i2:
			Toast.makeText(getApplicationContext(), "J", Toast.LENGTH_LONG)	.show();
			break;
		case R.id.i3:
			Toast.makeText(getApplicationContext(), "K", Toast.LENGTH_LONG)	.show();
			break;

		default:
			break;
		}
		return super.onContextItemSelected(item);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("TITLE");
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.context, menu);
		
	}
	
}
