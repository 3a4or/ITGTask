package com.example.mohamedashour.itg.ui.fragments.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mohamedashour.itg.R;
import com.example.mohamedashour.itg.data.models.Result;
import com.example.mohamedashour.itg.utils.interfaces.RecyclerViewClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    Context context;
    List<Result> list;
    RecyclerViewClickListener recyclerViewClickListener;

    public SearchAdapter(Context context, List<Result> list, RecyclerViewClickListener recyclerViewClickListener) {
        this.context = context;
        this.list = list;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_search_name)
        TextView titleTextView;
        @BindView(R.id.img_search_photo)
        ImageView photo;
        @BindView(R.id.rl_container)
        RelativeLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_search, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.titleTextView.setText(list.get(i).getName());
        if (list.get(i).getThumbnail() != null) {
            Glide.with(context).load(list.get(i).getThumbnail().getPath() + "." + list.get(i).getThumbnail().getExtension())
                    .placeholder(R.mipmap.ic_launcher).into(viewHolder.photo);
        } else {
            Glide.with(context).load(R.drawable.img_marvel_logo).into(viewHolder.photo);
        }
        viewHolder.container.setOnClickListener(view -> recyclerViewClickListener.OnItemClick(view, i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
