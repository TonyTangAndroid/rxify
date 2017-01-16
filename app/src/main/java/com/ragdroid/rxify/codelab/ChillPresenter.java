package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class ChillPresenter extends BaseCLPresenter<Long> implements CodeLabContract.Presenter {

    @Inject
    public ChillPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return Observable.timer(1, TimeUnit.SECONDS)
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
