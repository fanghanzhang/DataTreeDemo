package com.ironghui.datatree.activity.mvpdemo;

public class MyDemoPresenter implements ContactInterface.IPresenetr {
    ContactInterface.IView mView;

    public MyDemoPresenter(ContactInterface.IView view) {
        mView = view;
    }

    @Override
    public void getDate() {
        //用请求数据的网络框架获取数据

        mView.setView("你看看拿到MVP数据了吧");
    }
}
