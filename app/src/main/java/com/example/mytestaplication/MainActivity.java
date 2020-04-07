package com.example.mytestaplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	RecyclerAdapterV2 recyclerAdapter;

	List<String> moviesList, moviesList2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		moviesList = new ArrayList<>();
		moviesList.add("Iron Man");
		moviesList.add("The Incredible Hulk");
		moviesList.add("Iron Man 2");
		moviesList.add("Thor");
		moviesList.add("Captain America: The First Avenger");
		moviesList.add("The Avengers");
		moviesList.add("Iron Man 3");
		moviesList.add("Thor: The Dark World");
		moviesList.add("Captain America: The Winter Soldier");
		moviesList.add("Guardians of the Galaxy");
		moviesList.add("Avengers: Age of Ultron");
		moviesList.add("Ant-Man");
		moviesList.add("Captain America: Civil War");
		moviesList.add("Doctor Strange");
		moviesList.add("Guardians of the Galaxy Vol. 2");
		moviesList.add("Spider-Man: Homecoming");
		moviesList.add("Thor: Ragnarok");
		moviesList.add("Black Panther");
		moviesList.add("Avengers: Infinity War");
		moviesList.add("Ant-Man and the Wasp");
		moviesList.add("Captain Marvel");
		moviesList.add("Avengers: Endgame");
		moviesList.add("Spider-Man: Far From Home");

		moviesList2 = new ArrayList<>();
		moviesList2.add("AAAAAAAAAAAAAAAA");
		moviesList2.add("AAAAAAAAAAAAAAAA");
		moviesList2.add("AAAAAAAAAAAAAAAA");
		moviesList2.add("AAAAAAAAAAAAAAAA");
		moviesList2.add("AAAAAAAAAAAAAAAA");
		moviesList2.add("AAAAAAAAAAAAAAAA");
		moviesList2.add("AAAAAAAAAAAAAAAA");
		moviesList2.add("AAAAAAAAAAAAAAAA");
		moviesList2.add("AAAAAAAAAAAAAAAA");


		recyclerView = findViewById(R.id.act_main_recycler);
		recyclerAdapter = new RecyclerAdapterV2();
//		recyclerView.setLayoutManager(new GridLayoutManager());

		recyclerView.setAdapter(recyclerAdapter);
		recyclerAdapter.setMovieList(moviesList);
		Vasea vasea = new Vasea(recyclerAdapter, moviesList2);
		vasea.execute();

//		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//		recyclerView.addItemDecoration(dividerItemDecoration);

	}


	private class Vasea extends AsyncTask<String, Void, String>	{
		RecyclerAdapterV2 recyclerAdapter;

		List<String> moviesList;

		public Vasea(RecyclerAdapterV2 recyclerAdapter, List<String> moviesList) {
			this.recyclerAdapter = recyclerAdapter;
			this.moviesList = moviesList;
		}

		@Override
		protected String doInBackground(String... strings) throws IllegalStateException {
			System.out.println("AAAAA");
			try {
				Thread.sleep(99);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("BBBBBBB");

			recyclerAdapter.setMovieList(moviesList);
			recyclerAdapter.notifyDataSetChanged();
			return null;
		}
	}
}