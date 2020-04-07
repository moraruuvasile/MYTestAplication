package com.example.mytestaplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterV2 extends RecyclerView.Adapter<RecyclerAdapterV2.ViewHolder> {
	List<String> movieList;

	public void setMovieList(List<String> movieList) {
		this.movieList = movieList;
	}
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item1, parent, false);
		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.sus.setText(movieList.get(position));
		holder.jos.setText(String.valueOf(position));


	}

	@Override
	public int getItemCount() {
		return movieList.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder{
		TextView sus, jos;
		ImageView stanga;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			sus = itemView.findViewById(R.id.row_item_textView);
			jos = itemView.findViewById(R.id.row_item_rowCountTextView);
			stanga = itemView.findViewById(R.id.row_item_imageView);
		}
	}
}
