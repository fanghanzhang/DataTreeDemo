package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.ironghui.datatree.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * Created by ZhangFangHan on 2018/5/2.
 */

public class RxjavaTest extends AppCompatActivity {
    private String TAG = "TAG";
    public TextView mRxOperatorsText;
    private Disposable mDisposable;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        mRxOperatorsText = findViewById(R.id.tvtv);
//        testRxjavaBuffer();
//        testRxjavaInterval();  //interval间隔固定时间进行轮询
//        testRxDoonNext();
//        testRxjavaConcat();//连接数据
//        testRxjavaZip();//合并、配对
//        testRxjavaDistinc();//去重复数据  1 2 3   1 4  那就得去掉重复的1 得到1234
        testRxjavaInterval();//轮询，1秒打印一次
    }

    private void testRxjavaInterval() {
        //interval间隔固定时间进行轮询
        mDisposable = Flowable.interval(1, TimeUnit.SECONDS)
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.e(TAG, "accept: doOnNext : " + aLong);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//AndroidSchedulers.mainThread 属于rxandroid中的导包
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.e(TAG, "accept: 设置文本 ：" + aLong);
                        mRxOperatorsText.append("accept: 设置文本 ：" + aLong + "\n");
                    }
                });
    }
    private void testRxjavatake() {

        Flowable.fromArray(1, 2, 3, 4, 5)
                .take(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        mRxOperatorsText.append("take : " + integer + "\n");
                        Log.e(TAG, "accept: take : " + integer + "\n");
                    }
                });

    }
    private void testRxjavaDistinc() {
        Observable.just(1, 5, 6, 7, 2, 5, 2, 9)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        mRxOperatorsText.append("distinct : " + integer + "\n");
                        Log.e("TAG", "distinct : " + integer + "\n");
                    }
                });

    }
    private void testRxjavaConcat() {
        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        mRxOperatorsText.append("concat : " + integer + "\n");

                    }
                });


    }
    private void testRxjavaBuffer() {
        Observable.just(0,1, 2, 3, 4,5,6,7,8,9)
                .buffer(5, 2)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(@NonNull List<Integer> integers) throws Exception {
                        mRxOperatorsText.append("buffer size : " + integers.size() + "\n");
                        Log.e("TAG", "buffer size : " + integers.size() + "\n");
                        mRxOperatorsText.append("buffer value : ");
                        Log.e(TAG, "buffer value : ");
                        for (Integer i : integers) {
                            mRxOperatorsText.append(i + "");
                            Log.e(TAG, i + "");
                        }
                        mRxOperatorsText.append("\n");
                        Log.e(TAG, "\n");
                    }
                });

    }
    private void testRxDoonNext() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        mRxOperatorsText.append("doOnNext 保存 " + integer + "成功" + "\n");
                        Log.e(TAG, "doOnNext 保存 " + integer + "成功" + "\n");
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                mRxOperatorsText.append("doOnNext :" + integer + "\n");
                Log.e(TAG, "doOnNext :" + integer + "\n");
            }
        });


    }
    private void testRxjavaZip() {
        Observable.zip(getStringObservable(), getIntegerObservable(), new BiFunction<String, Integer, String>() {
            @Override
            public String apply(@NonNull String s, @NonNull Integer integer) throws Exception {
                return s + "配对" + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                mRxOperatorsText.append("zip : accept : " + s + "\n");
            }
        });

    }
    private Observable<String> getStringObservable() {
        return Observable.create( new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext("A");
                    mRxOperatorsText.append("String emit : A \n");

                    e.onNext("B");
                    mRxOperatorsText.append("String emit : B \n");

                    e.onNext("C");
                    mRxOperatorsText.append("String emit : C \n");
                    e.onNext("D");
                    mRxOperatorsText.append("String emit : C \n");


                }
            }
        });
    }
    private Observable<Integer> getIntegerObservable() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(1);
                    mRxOperatorsText.append("Integer emit : 1 \n");
                    e.onNext(2);
                    mRxOperatorsText.append("Integer emit : 2 \n");
                    e.onNext(3);
                    mRxOperatorsText.append("Integer emit : 3 \n");
                    e.onNext(4);
                    mRxOperatorsText.append("Integer emit : 4 \n");

                }
            }
        });
    }
    /**
     * 销毁时停止心跳
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}
