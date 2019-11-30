package com.example.mohamedashour.itg.ui.fragments.search;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mohamedashour.itg.R;
import com.example.mohamedashour.itg.data.models.Result;
import com.example.mohamedashour.itg.ui.fragments.characterdetails.CharacterDetailsFragment;
import com.example.mohamedashour.itg.utils.AppTools;
import com.example.mohamedashour.itg.utils.AppUtils;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements SearchContract.SearchView {

    View rootView;
    @BindView(R.id.et_search)
    EditText searchEditText;
    @BindView(R.id.rv_search_results)
    RecyclerView resultsRecyclerView;
    SearchAdapter adapter;

    SearchContract.SearchPresenter presenter;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, rootView);
        init();

        return rootView;
    }

    private void init() {
        presenter = new SearchPresenter(this);
        AppUtils.initHorizontalRV(resultsRecyclerView, getActivity(), 1);
        searchEditText.requestFocus();
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("")) {
                    resultsRecyclerView.setAdapter(null);
                    presenter.search(editable.toString());
                    Log.e("SSS", "here");
                }
            }
        });
    }

    @OnClick(R.id.tv_search_cancel)
    public void onCancelClick() {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void receiveResults(List<Result> list) {
        adapter = new SearchAdapter(getActivity(), list, (view, position) -> {
            Bundle bundle = new Bundle();
            bundle.putLong("id", list.get(position).getId());
            bundle.putString("name", list.get(position).getName());
            bundle.putString("desc", list.get(position).getDescription());
            bundle.putString("photo", list.get(position).getThumbnail().getPath() + "." + list.get(position).getThumbnail().getExtension());
            bundle.putSerializable("urls", (Serializable) list.get(position).getUrls());
            Fragment fragment = new CharacterDetailsFragment();
            fragment.setArguments(bundle);
            AppUtils.openFragmentFromFragment(SearchFragment.this, fragment, R.id.fl_container, AppTools.STACK_NAME);
        });
        resultsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.unSubscribeFromObservable();
    }
}
