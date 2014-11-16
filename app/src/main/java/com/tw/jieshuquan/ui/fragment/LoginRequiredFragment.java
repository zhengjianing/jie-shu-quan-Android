package com.tw.jieshuquan.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Toast;

import com.tw.jieshuquan.R;

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
            View unauthorizedView = ((ViewStub) rootView.findViewById(R.id.unauthorized_view)).inflate();
            unauthorizedView.findViewById(R.id.login_or_register).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Redirect to Login or Regsiter page", Toast.LENGTH_SHORT).show();
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
