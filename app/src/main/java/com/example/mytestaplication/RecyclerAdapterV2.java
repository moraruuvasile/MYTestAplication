package com.example.mytestaplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterV2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	List<String> movieList;


	public RecyclerAdapterV2(List<String> movieList) {
		this.movieList = movieList;

	}

	@Override
	public int getItemViewType(int position) {
		return movieList.get(position).toLowerCase().contains("avengers") ? 0 : 1;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

		if(viewType == 0)
			return new ViewHolderOne(layoutInflater.inflate(R.layout.row_item1,parent,false));
		else
			return new ViewHolderTwo(layoutInflater.inflate(R.layout.row_item2,parent,false));
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		if (holder.getItemViewType() == 0){
			ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
			viewHolderOne.sus.setText(movieList.get(position));
			viewHolderOne.jos.setText(String.valueOf(position));
		} else {
			ViewHolderTwo viewHolderTwo = (ViewHolderTwo) holder;
			viewHolderTwo.sus.setText("movieList.get(position)");
			viewHolderTwo.jos.setText("String.valueOf(position)");
		}

	}

	@Override
	public int getItemCount() {
		return movieList.size();
	}



	class ViewHolderOne extends RecyclerView.ViewHolder{
		TextView sus, jos;
		ImageView stanga;
		public ViewHolderOne(@NonNull View itemView) {
			super(itemView);
			sus = itemView.findViewById(R.id.row_item_textView);
			jos = itemView.findViewById(R.id.row_item_rowCountTextView);
			stanga = itemView.findViewById(R.id.row_item_imageView);
		}
	}

	class ViewHolderTwo extends RecyclerView.ViewHolder{
		TextView sus, jos;
		public ViewHolderTwo(@NonNull View itemView) {
			super(itemView);
			sus = itemView.findViewById(R.id.row_item2_textView);
			jos = itemView.findViewById(R.id.row_item2_rowCountTextView);
		}
	}
}
