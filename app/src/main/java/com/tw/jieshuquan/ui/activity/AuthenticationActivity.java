package com.tw.jieshuquan.ui.activity;

import android.os.Bundle;

import com.tw.jieshuquan.R;
import com.tw.jieshuquan.ui.fragment.LoginFragment;

public class AuthenticationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, LoginFragment.getInstance())
                    .commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        setDisplayHomeAsUpEnabled(true);
    }
}
