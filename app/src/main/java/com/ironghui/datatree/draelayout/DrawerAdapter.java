package com.ironghui.datatree.draelayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ironghui.datatree.R;

import java.util.ArrayList;
import java.util.List;



public class DrawerAdapter extends BaseAdapter {
    class TuiCoolMenuItem {
        String menuTitle;
        int menuIcon;

        //构造方法
        public TuiCoolMenuItem(String menuTitle, int menuIcon) {
            this.menuTitle = menuTitle;
            this.menuIcon = menuIcon;
        }

    }

    //存储侧滑菜单中的各项的数据
    List<TuiCoolMenuItem> menuItems = new ArrayList<TuiCoolMenuItem>();
    //构造方法中传过来的activity
    Context context;

    //构造方法
    public DrawerAdapter(Context context) {

        this.context = context;

        menuItems.add(new TuiCoolMenuItem("", R.drawable.canhuirenyuan1x));
        menuItems.add(new TuiCoolMenuItem("推荐", R.drawable.canhuirenyuan1x));
        menuItems.add(new TuiCoolMenuItem("发现", R.drawable.canhuirenyuan1x));
        menuItems.add(new TuiCoolMenuItem("主题", R.drawable.canhuirenyuan1x));
        menuItems.add(new TuiCoolMenuItem("站点", R.drawable.canhuirenyuan1x));
        menuItems.add(new TuiCoolMenuItem("搜索", R.drawable.canhuirenyuan1x));
        menuItems.add(new TuiCoolMenuItem("离线", R.drawable.canhuirenyuan1x));
        menuItems.add(new TuiCoolMenuItem("设置", R.drawable.canhuirenyuan1x));
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.menudrawer_item, parent, false);
            ((TextView) view).setText("测试");
            ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.drawable.canhuirenyuan1x, 0, 0, 0);

        }
        return view;
    }

}
