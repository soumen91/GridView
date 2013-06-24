package com.example.testforscrollview;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private String listview_array[] = { "ONE", "TWO", "THREE", "FOUR", "FIVE",
			"SIX", "SEVEN", "EIGHT", "NINE", "TEN" };
	ListView myList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myList = (ListView) findViewById(R.id.listView);
		myList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listview_array));
		Helper.getListViewSize(myList);

	}

}
