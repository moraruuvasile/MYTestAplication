package com.example.mytestaplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapterV2.RecyclerViewClickInterface{

	RecyclerView recyclerView;
	RecyclerAdapterV2 recyclerAdapter;

	List<String> moviesList;

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

		recyclerView = findViewById(R.id.act_main_recycler);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerAdapter = new RecyclerAdapterV2(moviesList, this);

		recyclerView.setAdapter(recyclerAdapter);
		recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


//		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//		recyclerView.addItemDecoration(dividerItemDecoration);

	}

	@Override
	public void onItemLongClick(int position) {
		moviesList.remove(position);
		recyclerAdapter.notifyDataSetChanged();
//		recyclerAdapter.notifyItemRemoved(position);
	}
}