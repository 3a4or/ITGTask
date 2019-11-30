package com.example.mohamedashour.itg.ui.fragments.search;


import com.example.mohamedashour.itg.data.network.RetrofitSingleton;
import java.util.concurrent.TimeUnit;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenter implements SearchContract.SearchPresenter {

    SearchContract.SearchView view;
    public CompositeDisposable compositeDisposable;

    public SearchPresenter(SearchContract.SearchView view) {
        this.view = view;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void search(String name) {
        compositeDisposable.add(RetrofitSingleton.webService()
                .search(name)
                .delay(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(characters -> view.receiveResults(characters.getData().getResults()), throwable -> {

                }));
    }

    public void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
