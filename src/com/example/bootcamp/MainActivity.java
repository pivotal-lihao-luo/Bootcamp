package com.example.bootcamp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView movieList;
	SearchTask search;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		movieList = (ListView) findViewById(R.id.listView1);
		search = new SearchTask(this);
		search.execute("Frozen", 1);
		
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void setList(ArrayList<ListData> newList) {
		ListArrayAdapter adapter = new ListArrayAdapter(this, newList);
		movieList.setAdapter(adapter);
	}
	
	public void setTotal(int total) {
	}

}
