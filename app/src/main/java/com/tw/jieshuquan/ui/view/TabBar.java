package com.tw.jieshuquan.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.tw.jieshuquan.R;

public class TabBar extends RelativeLayout {

    private ViewGroup tabGroup;
    private OnTabClickListener listener;

    public TabBar(Context context) {
        super(context);
        init(null, 0);
    }

    public TabBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public TabBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        inflate(getContext(), R.layout.view_tab_bar, this);
        tabGroup = (ViewGroup) findViewById(R.id.tab_group);

        int tabCount = tabGroup.getChildCount();
        for (int i = 0; i < tabCount; i++) {
            final int position = i;
            View tab = tabGroup.getChildAt(i);
            tab.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    unselectAll();
                    v.setSelected(true);
                    if (listener != null) {
                        listener.onTabClick(v, position);
                    }
                }
            });
        }
    }

    public void setCurrentItem(final int position) {
        if (position >= 0 && position < tabGroup.getChildCount()) {
            unselectAll();
            tabGroup.getChildAt(position).setSelected(true);
        }
    }

    private void unselectAll() {
        int tabCount = tabGroup.getChildCount();
        for (int i = 0; i < tabCount; i++) {
            View tab = tabGroup.getChildAt(i);
            tab.setSelected(false);
        }
    }

    public void setOnTabClickListener(OnTabClickListener listener) {
        this.listener = listener;
    }

    public interface OnTabClickListener {
        void onTabClick(View tabView, int position);
    }
}
