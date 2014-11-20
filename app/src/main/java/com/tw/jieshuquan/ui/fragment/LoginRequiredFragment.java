package com.tw.jieshuquan.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.tw.jieshuquan.R;
import com.tw.jieshuquan.ui.activity.AuthenticationActivity;

public class LoginRequiredFragment extends Fragment {


    public static Fragment newInstance() {
        LoginRequiredFragment fragment = new LoginRequiredFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dummy, container, false);

        if (!isLoggedIn()) {
            final View unauthorizedView = ((ViewStub) rootView.findViewById(R.id.unauthorized_view)).inflate();
            final View loginOrRegister = unauthorizedView.findViewById(R.id.login_or_register);
            loginOrRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), AuthenticationActivity.class));
                }
            });

        }

        return rootView;
    }

    private boolean isLoggedIn() {
        //FIXME will implement it after integrate with server side
        return false;
    }
}
