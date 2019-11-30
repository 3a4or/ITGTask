package com.example.mohamedashour.itg.ui.activities.main;

import com.example.mohamedashour.itg.data.models.Result;

import java.util.List;

public interface MainContract {

    interface MainView {
        void receiveCharacters(List<Result> list, String type);
    }
    interface MainPresenter {
        void getCharacters(int limit, int offset, String type);
    }
}
