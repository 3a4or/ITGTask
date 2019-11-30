package com.example.mohamedashour.itg.ui.activities.main;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.mohamedashour.itg.R;
import com.example.mohamedashour.itg.data.models.Result;
import com.example.mohamedashour.itg.utils.interfaces.RecyclerViewClickListener;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder>{

    Context context;
    List<Result> list;
    RecyclerViewClickListener recyclerViewClickListener;

    public CharactersAdapter(Context context, List<Result> list, RecyclerViewClickListener recyclerViewClickListener) {
        this.context = context;
        this.list = list;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_main_title)
        TextView titleTextView;
        @BindView(R.id.img_item_main_photo)
        ImageView photo;
        @BindView(R.id.rl_container)
        RelativeLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void addData(List<Result> listItems) {
        int size = this.list.size();
        this.list.addAll(listItems);
        int sizeNew = this.list.size();
        notifyItemRangeChanged(size, sizeNew);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main_character, viewGroup, false);
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
