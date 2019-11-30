package com.example.mohamedashour.itg.ui.activities.main;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mohamedashour.itg.R;
import com.example.mohamedashour.itg.data.models.Result;
import com.example.mohamedashour.itg.ui.fragments.characterdetails.CharacterDetailsFragment;
import com.example.mohamedashour.itg.ui.fragments.search.SearchFragment;
import com.example.mohamedashour.itg.utils.AppTools;
import com.example.mohamedashour.itg.utils.AppUtils;
import com.example.mohamedashour.itg.utils.PaginationScrollListener;

import java.io.Serializable;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    @BindView(R.id.rv_main_characters)
    RecyclerView charactersRecyclerView;
    GridLayoutManager gridLayoutManager;
    CharactersAdapter adapter;
    boolean isLoading = false, isLastPage = false;
    int offset = 0;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        presenter = new MainPresenter(this);
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 1, LinearLayoutManager.VERTICAL, false);
        charactersRecyclerView.setLayoutManager(gridLayoutManager);
        presenter.getCharacters(20, offset, "first");
        charactersRecyclerView.addOnScrollListener(new PaginationScrollListener(gridLayoutManager) {
            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }

            @Override
            public void loadMoreItems() {
                isLoading = true;
                offset += 20;
                presenter.getCharacters(20, offset, "load");
            }
        });
    }

    @Override
    public void receiveCharacters(List<Result> list, String type) {
        if (type.equals("first")) {
            adapter = new CharactersAdapter(this, list, (view, position) -> {
                Bundle bundle = new Bundle();
                bundle.putLong("id", list.get(position).getId());
                bundle.putString("name", list.get(position).getName());
                bundle.putString("desc", list.get(position).getDescription());
                bundle.putString("photo", list.get(position).getThumbnail().getPath() + "." + list.get(position).getThumbnail().getExtension());
                bundle.putSerializable("urls", (Serializable) list.get(position).getUrls());
                Fragment fragment = new CharacterDetailsFragment();
                fragment.setArguments(bundle);
                AppUtils.openFragmentFromActivity(MainActivity.this, fragment, R.id.fl_container, AppTools.STACK_NAME);
            });
            charactersRecyclerView.setAdapter(adapter);
        } else {
            isLoading = false;
            adapter.addData(list);
        }
    }

    @OnClick(R.id.img_search)
    public void onSearchClick() {
        AppUtils.openFragmentFromActivity(MainActivity.this, new SearchFragment(), R.id.fl_container, AppTools.STACK_NAME);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unSubscribeFromObservable();
    }
}
