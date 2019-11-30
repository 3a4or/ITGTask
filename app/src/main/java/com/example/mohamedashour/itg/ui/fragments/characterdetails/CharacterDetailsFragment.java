package com.example.mohamedashour.itg.ui.fragments.characterdetails;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mohamedashour.itg.R;
import com.example.mohamedashour.itg.data.models.Result;
import com.example.mohamedashour.itg.data.models.Thumbnail;
import com.example.mohamedashour.itg.data.models.URL;
import com.example.mohamedashour.itg.utils.AppUtils;
import com.example.mohamedashour.itg.utils.interfaces.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.List;

import at.technikum.mti.fancycoverflow.FancyCoverFlow;
import at.technikum.mti.fancycoverflow.FancyCoverFlowAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterDetailsFragment extends Fragment implements CharacterDetailsContract.CharacterDetailsView {

    View rootView;
    @BindView(R.id.tv_character_details_name)
    TextView nameTextView;
    @BindView(R.id.tv_character_details_desc)
    TextView descTextView;
    @BindView(R.id.img_character_details_photo)
    ImageView photo;
    @BindView(R.id.rv_character_details_comics)
    RecyclerView comicsRecyclerView;
    @BindView(R.id.rv_character_details_series)
    RecyclerView seriesRecyclerView;
    @BindView(R.id.rv_character_details_stories)
    RecyclerView storiesRecyclerView;
    @BindView(R.id.rv_character_details_events)
    RecyclerView eventsRecyclerView;
    @BindView(R.id.rv_character_details_links)
    RecyclerView linksRecyclerView;

    FilmsAdapter adapter;
    LinksAdapter linksAdapter;

    Dialog loadingBar;
    FancyCoverFlow fancyCoverFlow;
    ImageView closeImageView;

    CharacterDetailsContract.CharacterDetailsPresenter presenter;

    public CharacterDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_character_details, container, false);
        ButterKnife.bind(this, rootView);
        init();

        return rootView;
    }

    private void init() {
        presenter = new CharacterDetailsPresenter(this);
        AppUtils.initHorizontalRV(comicsRecyclerView, getActivity(), 1);
        AppUtils.initHorizontalRV(seriesRecyclerView, getActivity(), 1);
        AppUtils.initHorizontalRV(storiesRecyclerView, getActivity(), 1);
        AppUtils.initHorizontalRV(eventsRecyclerView, getActivity(), 1);
        AppUtils.initVerticalRV(linksRecyclerView, getActivity(), 1);
        updateUi();
        initSliderView();
    }

    private void updateUi() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            nameTextView.setText(bundle.getString("name", "No Name"));
            descTextView.setText(bundle.getString("desc", "No Desc"));
            Glide.with(this).load(bundle.getString("photo"))
                    .placeholder(R.drawable.img_marvel_logo).into(photo);
            presenter.getComics(bundle.getLong("id"));
            presenter.getSeries(bundle.getLong("id"));
            presenter.getStories(bundle.getLong("id"));
            presenter.getEvents(bundle.getLong("id"));
            ArrayList<URL> urls = (ArrayList<URL>) bundle.getSerializable("urls");
            if (urls != null && urls.size() > 0) {
                linksAdapter = new LinksAdapter(getActivity(), urls, (view, position) -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urls.get(position).getUrl()))));
                linksRecyclerView.setAdapter(linksAdapter);
            }
        }
    }

    private void initSliderView() {
        loadingBar = new Dialog(getActivity(), android.R.style.Theme_Black_NoTitleBar);
        loadingBar.requestWindowFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View loadingView = inflater.inflate(R.layout.view_slider, null);
        loadingBar.setContentView(loadingView);
        loadingBar.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#90000000")));
        loadingBar.setCancelable(false);
        loadingBar.setCanceledOnTouchOutside(false);
        fancyCoverFlow = loadingView.findViewById(R.id.fancyCoverFlow);
        fancyCoverFlow.setUnselectedAlpha(.0f);
        fancyCoverFlow.setUnselectedSaturation(0.0f);
        fancyCoverFlow.setUnselectedScale(0.5f);
        fancyCoverFlow.setSpacing(-100);
        fancyCoverFlow.setMaxRotation(0);
        fancyCoverFlow.setScaleDownGravity(0.2f);
        closeImageView = loadingView.findViewById(R.id.img_close);
        closeImageView.setOnClickListener(v -> loadingBar.dismiss());
    }

    @OnClick(R.id.img_back)
    public void onBackClick() {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.unSubscribeFromObservable();
    }

    @Override
    public void receiveComics(List<Result> comics) {
        adapter = new FilmsAdapter(getActivity(), comics, (view, position) -> {
            if (comics.get(position).getImages() != null) {
                if (comics.get(position).getImages().size() > 0) {
                    openSlider(comics.get(position).getImages());
                } else {
                    Toast.makeText(getActivity(), "No Images for this comic", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "No Images for this comic", Toast.LENGTH_SHORT).show();
            }
        });
        comicsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void receiveSeries(List<Result> series) {
        adapter = new FilmsAdapter(getActivity(), series, (view, position) -> {
            if (series.get(position).getImages() != null) {
                if (series.get(position).getImages().size() > 0) {
                    openSlider(series.get(position).getImages());
                } else {
                    Toast.makeText(getActivity(), "No Images for this series", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "No Images for this series", Toast.LENGTH_SHORT).show();
            }
        });
        seriesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void receiveStories(List<Result> stores) {
        adapter = new FilmsAdapter(getActivity(), stores, (view, position) -> {
            if (stores.get(position).getImages() != null) {
                if (stores.get(position).getImages().size() > 0) {
                    openSlider(stores.get(position).getImages());
                } else {
                    Toast.makeText(getActivity(), "No Images for this story", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "No Images for this story", Toast.LENGTH_SHORT).show();
            }
        });
        storiesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void receiveEvents(List<Result> events) {
        adapter = new FilmsAdapter(getActivity(), events, (view, position) -> {
            if (events.get(position).getImages() != null) {
                if (events.get(position).getImages().size() > 0) {
                    openSlider(events.get(position).getImages());
                } else {
                    Toast.makeText(getActivity(), "No Images for this event", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "No Images for this event", Toast.LENGTH_SHORT).show();
            }
        });
        eventsRecyclerView.setAdapter(adapter);
    }

    private void openSlider(List<Thumbnail> images) {
        fancyCoverFlow.setAdapter(new FancyCoverFlowSampleAdapter(getActivity(), images));
        loadingBar.show();
    }

    private class FancyCoverFlowSampleAdapter extends FancyCoverFlowAdapter {

        List<Thumbnail> images;
        Context context;
        LayoutInflater inflater;

        public FancyCoverFlowSampleAdapter(Context context, List<Thumbnail> images) {
            this.context = context;
            this.images = images;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public Object getItem(int i) {
            return images.get(i).getPath()+ "." + images.get(i).getExtension();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getCoverFlowItem(final int i, View reuseableView, ViewGroup viewGroup) {
            ImageView imageView = null;
            if (reuseableView != null) {
                imageView = (ImageView) reuseableView;
            } else {
                imageView = new ImageView(viewGroup.getContext());
                imageView.setLayoutParams(new FancyCoverFlow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }
            Glide.with(context).load(images.get(i).getPath()+ "." + images.get(i).getExtension())
                    .placeholder(R.drawable.img_marvel_logo).into(imageView);
            return imageView;
        }
    }
}
