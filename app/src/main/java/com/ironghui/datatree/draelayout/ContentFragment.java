package com.ironghui.datatree.draelayout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ironghui.datatree.R;

public class ContentFragment extends Fragment {
    public static final String SELECTED_ITEM = "selected_item";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         Bundle bd = getArguments();

         View view = inflater.inflate(R.layout.fragment_content, null);
         ((TextView) view).setText(bd.getString(SELECTED_ITEM));
         return view;

    }
}
