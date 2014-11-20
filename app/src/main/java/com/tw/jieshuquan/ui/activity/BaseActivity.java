package com.tw.jieshuquan.ui.activity;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.tw.jieshuquan.R;

public class BaseActivity extends ActionBarActivity {

    @Override
    protected void onStart() {
        super.onStart();
        setupActionBar();
    }

    protected void setupActionBar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }
}
