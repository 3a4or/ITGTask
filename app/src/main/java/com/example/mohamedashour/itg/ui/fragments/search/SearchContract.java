package com.example.mohamedashour.itg.ui.fragments.search;

import com.example.mohamedashour.itg.data.models.Result;

import java.util.List;

public interface SearchContract {
    interface SearchView {
        void receiveResults(List<Result> list);
    }
    interface SearchPresenter {
        void search(String name);
        void unSubscribeFromObservable();
    }
}
