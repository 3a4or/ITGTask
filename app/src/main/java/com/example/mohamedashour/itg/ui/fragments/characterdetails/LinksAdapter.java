package com.example.mohamedashour.itg.ui.fragments.characterdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mohamedashour.itg.R;
import com.example.mohamedashour.itg.data.models.URL;
import com.example.mohamedashour.itg.utils.interfaces.RecyclerViewClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LinksAdapter extends RecyclerView.Adapter<LinksAdapter.ViewHolder>{

    Context context;
    List<URL> list;
    RecyclerViewClickListener recyclerViewClickListener;

    public LinksAdapter(Context context, List<URL> list, RecyclerViewClickListener recyclerViewClickListener) {
        this.context = context;
        this.list = list;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_film_link)
        TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_link, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nameTextView.setText(list.get(i).getType());
        viewHolder.nameTextView.setOnClickListener(view -> recyclerViewClickListener.OnItemClick(view, i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
