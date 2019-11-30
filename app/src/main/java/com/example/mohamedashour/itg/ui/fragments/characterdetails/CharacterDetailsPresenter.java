package com.example.mohamedashour.itg.ui.fragments.characterdetails;

import android.util.Log;

import com.example.mohamedashour.itg.data.network.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CharacterDetailsPresenter implements CharacterDetailsContract.CharacterDetailsPresenter {

    CharacterDetailsContract.CharacterDetailsView view;
    public CompositeDisposable compositeDisposable;

    public CharacterDetailsPresenter(CharacterDetailsContract.CharacterDetailsView view) {
        this.view = view;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getComics(long id) {
        compositeDisposable.add(RetrofitSingleton.webService()
                .getCharacterComics(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(characters -> view.receiveComics(characters.getData().getResults()), throwable -> {
                }));
    }

    @Override
    public void getSeries(long id) {
        compositeDisposable.add(RetrofitSingleton.webService()
                .getCharacterSeries(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(characters -> view.receiveSeries(characters.getData().getResults()), throwable -> {
                    Log.e("SERIES", throwable.getMessage());
                }));
    }

    @Override
    public void getStories(long id) {
        compositeDisposable.add(RetrofitSingleton.webService()
                .getCharacterStories(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(characters -> view.receiveStories(characters.getData().getResults()), throwable -> {
                    Log.e("STORIES", throwable.getMessage());
                }));
    }

    @Override
    public void getEvents(long id) {
        compositeDisposable.add(RetrofitSingleton.webService()
                .getCharacterEvents(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(characters -> view.receiveEvents(characters.getData().getResults()), throwable -> {
                    Log.e("EVENTS", throwable.getMessage());
                }));
    }

    @Override
    public void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
