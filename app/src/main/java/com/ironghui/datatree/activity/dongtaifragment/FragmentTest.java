package com.ironghui.datatree.activity.dongtaifragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ironghui.datatree.R;

public class FragmentTest extends Fragment {
    TextView mTxtNumber;

    int mPosition;
    String mTitle = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_tab, null);

        mPosition = getArguments().getInt("position");
        mTitle = getArguments().getString("title");

        mTxtNumber.setText("第" + mPosition + "个fragment==" + mTitle);
        return view;


    }
}
