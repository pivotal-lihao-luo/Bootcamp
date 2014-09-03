package com.example.bootcamp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView movieList;
	SearchTask search;
	String query;
	int pageCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pageCount = 1;
		movieList = (ListView) findViewById(R.id.listView1);
		Button prevBtn = (Button) findViewById(R.id.prevbtn);
		prevBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (pageCount > 1) {
					pageCount--;
					search.execute(query, pageCount);
				}
			}

		});
		Button nextBtn = (Button) findViewById(R.id.nextbtn);
		nextBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				pageCount++;
				search.execute(query, pageCount);
			}

		});
		movieList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				// TODO Auto-generated method stub
				Intent movieViewIntent = new Intent(getBaseContext(),
						Profile.class);
				ListData data = (ListData) movieList.getItemAtPosition(pos);
				movieViewIntent.putExtra(ListData.NAME, data);
				startActivity(movieViewIntent);
			}

		});

		search = new SearchTask(this);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
		switch (item.getItemId()) {
		case R.id.action_search:
			final View searchView = inflater.inflate(R.layout.searchdialog,
					null);
			AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
					.setTitle("Search Movies")
					.setView(searchView)
					.setPositiveButton("Search",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									EditText queryET = (EditText) searchView
											.findViewById(R.id.dialoget);
									pageCount = 1;
									query = queryET.getText().toString();
									search.execute(query, pageCount);
								}
							}).setNegativeButton("Cancel", null).create();

			dialog.getWindow().setSoftInputMode(
					WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
			dialog.show();
			break;
		}
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

}
