package com.example.mohamedashour.itg.ui.fragments.characterdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder>{

    Context context;
    List<Result> list;
    RecyclerViewClickListener recyclerViewClickListener;

    public FilmsAdapter(Context context, List<Result> list, RecyclerViewClickListener recyclerViewClickListener) {
        this.context = context;
        this.list = list;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_film_name)
        TextView nameTextView;
        @BindView(R.id.img_film)
        ImageView photo;
        @BindView(R.id.ll_container)
        LinearLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_film, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nameTextView.setText(list.get(i).getTitle());
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
