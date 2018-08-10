package com.ironghui.datatree.activity.mvp;

/**
 * Created by ZhangFangHan on 2018/5/24.
 */

public class LoginPresenter implements ILoginInterface.IPresenter {
    ILoginInterface.IView iView;

    public LoginPresenter(ILoginInterface.IView iView) {
        this.iView = iView;
    }

    @Override
    public void loadData() {
        LoginModel loginModel = new LoginModel();
        String str = loginModel.getData();
        iView.setData(str);
    }
}
