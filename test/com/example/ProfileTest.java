package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import android.content.Intent;
import android.widget.TextView;

import com.example.bootcamp.ListData;
import com.example.bootcamp.MainActivity;
import com.example.bootcamp.MovieData;
import com.example.bootcamp.Profile;
import com.example.bootcamp.R;

@RunWith(RobolectricTestRunner.class)
public class ProfileTest {
	
	Profile activity;
	ListData data;
	MovieData movie;
	
	@Before
	public void setup() {
		Intent intent = new Intent(new MainActivity(), Profile.class);
		Robolectric.getFakeHttpLayer().interceptHttpRequests(false);
		data =  new ListData("771246543", 2013,
				"Frozen",
				"http://content6.flixster.com/movie/11/17/35/11173584_tmb.jpg",
				89, 102);
		intent.putExtra(ListData.NAME, data);
		this.activity = Robolectric.buildActivity(Profile.class).withIntent(intent).create().get();
		

	}

	@Test
	public void checkDirector() throws Exception{
		TextView director = (TextView) activity.findViewById(R.id.directortv);
		assertTrue(director.getText().equals("Chris Buck, Jennifer Lee (XXX)"));
	}
	
	@Test
	public void checkActionBar() throws Exception{
		assertTrue(activity.getActionBar().getTitle().equals("Frozen"));
	}
	
	
}
