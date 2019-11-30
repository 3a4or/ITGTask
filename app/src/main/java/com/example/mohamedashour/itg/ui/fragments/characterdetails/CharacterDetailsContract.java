package com.example.mohamedashour.itg.ui.fragments.characterdetails;

import com.example.mohamedashour.itg.data.models.Result;

import java.util.List;

public interface CharacterDetailsContract {
    interface CharacterDetailsView {
        void receiveComics(List<Result> comics);
        void receiveSeries(List<Result> series);
        void receiveStories(List<Result> stores);
        void receiveEvents(List<Result> events);
    }
    interface CharacterDetailsPresenter {
        void getComics(long id);
        void getSeries(long id);
        void getStories(long id);
        void getEvents(long id);
        void unSubscribeFromObservable();
    }
}
