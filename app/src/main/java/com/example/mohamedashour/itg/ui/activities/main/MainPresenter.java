package com.example.mohamedashour.itg.ui.activities.main;

import com.example.mohamedashour.itg.data.network.RetrofitSingleton;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.MainPresenter{

    MainContract.MainView view;
    public CompositeDisposable compositeDisposable;

    public MainPresenter(MainContract.MainView view) {
        this.view = view;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getCharacters(int limit, int offset, String type) {
        compositeDisposable.add(RetrofitSingleton.webService()
                        .getCharacters(limit, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(characters -> view.receiveCharacters(characters.getData().getResults(), type), throwable -> {

                }));
    }

    public void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
