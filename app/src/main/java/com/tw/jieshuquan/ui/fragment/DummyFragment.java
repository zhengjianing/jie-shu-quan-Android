package com.tw.jieshuquan.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tw.jieshuquan.R;

public class DummyFragment extends Fragment {

    public static Fragment newInstance() {
        DummyFragment fragment = new DummyFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public DummyFragment
            () {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dummy, container, false);
        return rootView;
    }
}
