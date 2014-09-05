package com.example;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Intent;
import android.widget.ListView;

import com.example.bootcamp.ListData;
import com.example.bootcamp.MainActivity;
import com.example.bootcamp.Profile;
import com.example.bootcamp.R;
import com.example.bootcamp.SearchTask;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

	MainActivity activity;

	@Before
	public void setup() {
		this.activity = Robolectric.buildActivity(MainActivity.class).create()
				.get();
		Robolectric.getFakeHttpLayer().interceptHttpRequests(false);
	}

	@Test
	public void shouldHaveHappySmiles() throws Exception {
		String hello = this.activity.getString(R.string.hello_world);
		assertThat(hello, equalTo("Hello world!"));
	}

	@Test
	public void checkPageEmptyAtStart() throws Exception {
		ListView ourList = (ListView) activity.findViewById(R.id.listView1);
		assertThat(ourList.getCount(), equalTo(0));
	}

	@Test
	public void checkPageEmptyAfterNext() throws Exception {
		/*
		 * Button next = (Button) activity.findViewById(R.id.nextbtn);
		 * assertTrue(next.performClick());
		 */
		SearchTask task = new SearchTask(activity);
		task.execute("Frozen", 2);

		Robolectric.runBackgroundTasks();
		// HttpRequest request = Robolectric.getNextSentHttpRequest();
		// Robolectric.setDefaultHttpResponse(200,
		// "{\"total\":18,\"movies\":[{\"id\":\"770948128\",\"title\":\"Allergies: A Natural Approach With Gary Null\",\"year\":2001,\"mpaa_rating\":\"Unrated\",\"runtime\":86,\"release_dates\":{\"dvd\":\"2002-01-15\"},\"ratings\":{\"critics_score\":-1,\"audience_score\":0},\"synopsis\":\"\",\"posters\":{\"thumbnail\":\"http://content9.flixster.com/movie/10/99/66/10996667_tmb.jpg\",\"profile\":\"http://content9.flixster.com/movie/10/99/66/10996667_tmb.jpg\",\"detailed\":\"http://content9.flixster.com/movie/10/99/66/10996667_tmb.jpg\",\"original\":\"http://content9.flixster.com/movie/10/99/66/10996667_tmb.jpg\"},\"abridged_cast\":[{\"name\":\"Gary Null\",\"id\":\"770680429\"}],\"links\":{\"self\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770948128.json\",\"alternate\":\"http://www.rottentomatoes.com/m/allergies_a_natural_approach_with_gary_null/\",\"cast\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770948128/cast.json\",\"reviews\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770948128/reviews.json\",\"similar\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770948128/similar.json\"}},{\"id\":\"770951400\",\"title\":\"Get Healthy Now! with Gary Null\",\"year\":2002,\"mpaa_rating\":\"Unrated\",\"runtime\":120,\"release_dates\":{\"dvd\":\"2002-08-20\"},\"ratings\":{\"critics_score\":-1,\"audience_score\":0},\"synopsis\":\"\",\"posters\":{\"thumbnail\":\"http://content7.flixster.com/movie/10/99/97/10999793_tmb.jpg\",\"profile\":\"http://content7.flixster.com/movie/10/99/97/10999793_tmb.jpg\",\"detailed\":\"http://content7.flixster.com/movie/10/99/97/10999793_tmb.jpg\",\"original\":\"http://content7.flixster.com/movie/10/99/97/10999793_tmb.jpg\"},\"abridged_cast\":[{\"name\":\"Gary Null\",\"id\":\"770680429\"}],\"links\":{\"self\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770951400.json\",\"alternate\":\"http://www.rottentomatoes.com/m/get_healthy_now_with_gary_null/\",\"cast\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770951400/cast.json\",\"reviews\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770951400/reviews.json\",\"similar\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770951400/similar.json\"}},{\"id\":\"770951407\",\"title\":\"For Women Only! with Gary Null\",\"year\":2002,\"mpaa_rating\":\"Unrated\",\"runtime\":60,\"release_dates\":{\"dvd\":\"2002-08-20\"},\"ratings\":{\"critics_score\":-1,\"audience_score\":0},\"synopsis\":\"\",\"posters\":{\"thumbnail\":\"http://content6.flixster.com/movie/10/99/98/10999800_tmb.jpg\",\"profile\":\"http://content6.flixster.com/movie/10/99/98/10999800_tmb.jpg\",\"detailed\":\"http://content6.flixster.com/movie/10/99/98/10999800_tmb.jpg\",\"original\":\"http://content6.flixster.com/movie/10/99/98/10999800_tmb.jpg\"},\"abridged_cast\":[{\"name\":\"Gary Null\",\"id\":\"770680429\"}],\"links\":{\"self\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770951407.json\",\"alternate\":\"http://www.rottentomatoes.com/m/for_women_only_with_gary_null/\",\"cast\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770951407/cast.json\",\"reviews\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770951407/reviews.json\",\"similar\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770951407/similar.json\"}},{\"id\":\"345740122\",\"title\":\"Breitengrad Null\",\"year\":2000,\"mpaa_rating\":\"Unrated\",\"runtime\":85,\"release_dates\":{},\"ratings\":{\"critics_score\":-1,\"audience_score\":100},\"synopsis\":\"\",\"posters\":{\"thumbnail\":\"http://content8.flixster.com/movie/28/88/93/2888930_tmb.jpg\",\"profile\":\"http://content8.flixster.com/movie/28/88/93/2888930_tmb.jpg\",\"detailed\":\"http://content8.flixster.com/movie/28/88/93/2888930_tmb.jpg\",\"original\":\"http://content8.flixster.com/movie/28/88/93/2888930_tmb.jpg\"},\"abridged_cast\":[{\"name\":\"Debora Duboc\",\"id\":\"364619379\"}],\"links\":{\"self\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/345740122.json\",\"alternate\":\"http://www.rottentomatoes.com/m/breitengrad-null/\",\"cast\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/345740122/cast.json\",\"reviews\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/345740122/reviews.json\",\"similar\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/345740122/similar.json\"}},{\"id\":\"771236329\",\"title\":\"Stunde Null (Zero Hour)\",\"year\":1977,\"mpaa_rating\":\"Unrated\",\"runtime\":108,\"release_dates\":{\"theater\":\"1977-03-08\"},\"ratings\":{\"critics_score\":-1,\"audience_rating\":\"Spilled\",\"audience_score\":0},\"synopsis\":\"\",\"posters\":{\"thumbnail\":\"http://d3biamo577v4eu.cloudfront.net/static/images/redesign/poster_default_thumb.gif\",\"profile\":\"http://d3biamo577v4eu.cloudfront.net/static/images/redesign/poster_default_thumb.gif\",\"detailed\":\"http://d3biamo577v4eu.cloudfront.net/static/images/redesign/poster_default_thumb.gif\",\"original\":\"http://d3biamo577v4eu.cloudfront.net/static/images/redesign/poster_default_thumb.gif\"},\"abridged_cast\":[{\"name\":\"Kai Taschner\",\"id\":\"770994671\"},{\"name\":\"Erika Wackernagel\",\"id\":\"770757680\"},{\"name\":\"Torsten Hentes\",\"id\":\"770935219\"},{\"name\":\"Erich Kleiber\",\"id\":\"770926506\"},{\"name\":\"Herbert Weissbach\",\"id\":\"770947000\"}],\"alternate_ids\":{\"imdb\":\"0075279\"},\"links\":{\"self\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/771236329.json\",\"alternate\":\"http://www.rottentomatoes.com/m/stunde_null_1976/\",\"cast\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/771236329/cast.json\",\"reviews\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/771236329/reviews.json\",\"similar\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/771236329/similar.json\"}},{\"id\":\"770806769\",\"title\":\"Nulle part terre promise (Nowhere Promised Land)\",\"year\":2008,\"mpaa_rating\":\"Unrated\",\"runtime\":94,\"release_dates\":{\"theater\":\"2008-08-08\"},\"ratings\":{\"critics_score\":-1,\"audience_rating\":\"Spilled\",\"audience_score\":50},\"synopsis\":\"\",\"posters\":{\"thumbnail\":\"http://d3biamo577v4eu.cloudfront.net/static/images/redesign/poster_default_thumb.gif\",\"profile\":\"http://d3biamo577v4eu.cloudfront.net/static/images/redesign/poster_default_thumb.gif\",\"detailed\":\"http://d3biamo577v4eu.cloudfront.net/static/images/redesign/poster_default_thumb.gif\",\"original\":\"http://d3biamo577v4eu.cloudfront.net/static/images/redesign/poster_default_thumb.gif\"},\"abridged_cast\":[{\"name\":\"Elsa Amiel\",\"id\":\"770836897\"},{\"name\":\"Nicolas Wanczycki\",\"id\":\"770836899\"},{\"name\":\"Haci Yusuf Aslan\",\"id\":\"771070783\"}],\"links\":{\"self\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770806769.json\",\"alternate\":\"http://www.rottentomatoes.com/m/nulle-part-terre-promise/\",\"cast\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770806769/cast.json\",\"reviews\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770806769/reviews.json\",\"similar\":\"http://api.rottentomatoes.com/api/public/v1.0/movies/770806769/similar.json\"}}],\"links\":{\"self\":\"http://api.rottentomatoes.com/api/public/v1.0/movies.json?q=null&page_limit=6&page=2\",\"next\":\"http://api.rottentomatoes.com/api/public/v1.0/movies.json?q=null&page_limit=6&page=3\",\"prev\":\"http://api.rottentomatoes.com/api/public/v1.0/movies.json?q=null&page_limit=6&page=1\"},\"link_template\":\"http://api.rottentomatoes.com/api/public/v1.0/movies.json?q={search-term}&page_limit={results-per-page}&page={page-number}\"}");
		Robolectric.runUiThreadTasks();
		checkPageEmptyAtStart();
	}

	@Test
	public void searchForFrozen() throws Exception {
		ListView ourList = (ListView) activity.findViewById(R.id.listView1);

		SearchTask task = new SearchTask(activity);
		task.execute("Frozen", 1);
		Intent expectedIntent = new Intent(activity, Profile.class);
		expectedIntent.putExtra(ListData.NAME, new ListData("771246543", 2013,
				"Frozen",
				"http://content6.flixster.com/movie/11/17/35/11173584_tmb.jpg",
				89, 102));
		Robolectric.runBackgroundTasks();
		Robolectric.runUiThreadTasks();

		ourList.performItemClick(ourList.getAdapter().getView(2, null, null),
				2, ourList.getAdapter().getItemId(2));
		Intent actual = Robolectric.shadowOf(activity).getNextStartedActivity();
		assertThat(actual.getComponent().getClassName(),
				equalTo("com.example.bootcamp.Profile"));

		assertTrue(actual.equals(expectedIntent));
	}
}