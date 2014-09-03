package com.example.bootcamp;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListArrayAdapter extends ArrayAdapter<ListData> implements UpdatableActivity {
	private final Context context;
	private final ArrayList<ListData> movieList;
	
	
	public ListArrayAdapter(Context context, ArrayList<ListData> movieList) {
		super(context, R.layout.move_list_item, movieList);
		this.context = context;
		this.movieList = movieList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		//LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.move_list_item, parent, false);
		TextView title = (TextView) convertView.findViewById(R.id.titletv);
		TextView year = (TextView) convertView.findViewById(R.id.yeartv);
		TextView runtime = (TextView) convertView.findViewById(R.id.runtimetv);
		TextView rating = (TextView) convertView.findViewById(R.id.ratingtv);
		ImageView poster = (ImageView) convertView.findViewById(R.id.posteriv);
		
		ListData curMovie = movieList.get(position);
		title.setText(curMovie.getTitle());
		year.setText("(" + curMovie.getYear() + ")");
		runtime.setText(curMovie.getRuntime() + " minutes");
		if (curMovie.getRating() == -1)
			rating.setText("N/A");
		else
			rating.setText(curMovie.getRating() + "%");
		poster.setImageDrawable(GetImageTask.getInstance().getImage(curMovie.getUrl(), this));
		return convertView;
	}
	
	public void updateImage() {
		this.notifyDataSetChanged();
	}
}
