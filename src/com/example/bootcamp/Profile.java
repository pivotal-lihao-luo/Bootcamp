package com.example.bootcamp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends Activity implements UpdatableActivity {

	private ImageView posteriv;
	private TextView ratingtv;
	private TextView synopsistv;
	private TextView directortv;
	private TextView genretv;
	private ListData data;
	private MovieData movie;
	private ImageView tomatoiv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		ratingtv = (TextView) findViewById(R.id.ratingtv);
		synopsistv = (TextView) findViewById(R.id.synopsistv);
		directortv = (TextView) findViewById(R.id.directortv);
		genretv = (TextView) findViewById(R.id.genretv);
		posteriv = (ImageView) findViewById(R.id.profilePosteriv);
		tomatoiv = (ImageView) findViewById(R.id.tomatoiv);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		Intent intent = getIntent();
		data = (ListData) intent.getSerializableExtra(ListData.NAME);
		getActionBar().setTitle(
				(CharSequence) data.getTitle() + " (" + data.getYear() + ")");

		// gets the rest of the movie data
		String id = data.getId();
		GetMovieTask task = new GetMovieTask(this);
		task.execute(id);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void setMovie(MovieData result) {
		this.movie = result;
		if (data.getRating() == -1) {
			ratingtv.setText("N/A");
			tomatoiv.setImageResource(R.drawable.ic_menu_notifications);
		} else {
			ratingtv.setText(data.getRating() + "%");
			if (result.getTomato())
				tomatoiv.setImageResource(R.drawable.fresh);
			else
				tomatoiv.setImageResource(R.drawable.rotten);
		}
		if (result != null) {
			directortv.setText(result.getDirector());
			genretv.setText(result.getGenre());
			synopsistv.setText("Synopsis: \n" + result.getSynopsis());
			updateImage();
		}
		
	}

	@Override
	public void updateImage() {
		Drawable poster = GetImageTask.getInstance().getImage(movie.getUrl(),
				this);
		if (poster != null)
			posteriv.setImageDrawable(poster);

	}

}
