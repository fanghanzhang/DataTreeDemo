package com.ironghui.datatree.activity.mvp;

/**
 * Created by ZhangFangHan on 2018/5/24.
 */

public interface ILoginInterface {
    interface IModel {
        String getData();
    }

    interface IPresenter {
        void loadData();
    }

    interface IView {
        void setData(String str );
    }
}
