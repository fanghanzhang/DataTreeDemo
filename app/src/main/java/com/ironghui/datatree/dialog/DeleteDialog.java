package com.ironghui.datatree.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ironghui.datatree.R;

/**
 * Created by ZhangFangHan on 2018/3/6.
 */

public class DeleteDialog extends Dialog implements View.OnClickListener{
    private  static final int DEFAULTCHEM = R.style.DialogTheme;
    private Context context;
    private TextView tvMsg;
    private TextView tvTitle;
    private Button btnOK;
    private Button btnCancel;

    public DeleteDialog(Context context, int style) {
        super(context, style);
        this.context = context;
        this.setCanceledOnTouchOutside(false);
    }
    private DialogOnClickListener onclickListener;
    public DeleteDialog(Context context, DialogOnClickListener listener) {
        this(context, DEFAULTCHEM);//添加静态即可被引用
        this.onclickListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_del);
        findViews();
    }
    private void findViews() {
        tvTitle = (TextView) findViewById(R.id.tv_dialog_title);
        tvMsg = (TextView) findViewById(R.id.tv_dialog_msg);
        btnOK = (Button) findViewById(R.id.btn_ok);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnOK.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    public void setMsg(String message){
        tvMsg.setText(message);
    }
    public void setTitle(String title){
        tvTitle.setText(title);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok:
                if(onclickListener != null){
                    onclickListener.deleteStatus(true);
                }
                close();
                break;

            case R.id.btn_cancel:
                if(onclickListener != null){
                    onclickListener.deleteStatus(false);
                }
                close();
                break;

            default:
                break;
        }
    }

    private void close() {
        if (this!=null&&this.isShowing()){
            dismiss();
        }
    }

    public interface DialogOnClickListener {
        public void deleteStatus(boolean delStatus);
    }
}
