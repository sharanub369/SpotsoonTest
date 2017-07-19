package com.spotsoont.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spotsoont.test.R;

/**
 * Created by sharana.b on 7/17/2017.
 */

public class ImagesFragment extends Fragment {

    private String TAG = ImagesFragment.class.getCanonicalName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_images, container, false);
        return view;
    }
}
