package com.spotsoont.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spotsoont.test.R;
import com.spotsoont.test.adapter.ListAdapter;
import com.spotsoont.test.model.VideoModel;
import com.spotsoont.test.util.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sharana.b on 7/17/2017.
 */

public class VideosFragment extends Fragment {

    private String TAG = VideosFragment.class.getCanonicalName();

    private static final String BASE_PATH = "android.resource://";


    @BindView(R.id.fragment_list_rv)
    public RecyclerView recyclerView;

    private ListAdapter mAdapter;

    private List<VideoModel> videoDataList = new ArrayList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        mAdapter = new ListAdapter(getDataList(), getActivity());
        recyclerView.setAdapter(mAdapter);
    }

    private List<VideoModel> getDataList() {
        List<VideoModel> detailsList = new ArrayList<>();


        //For Sample1
        VideoModel model = new VideoModel();
        model.setmPath(BASE_PATH + getActivity().getPackageName() + "/" + R.raw.sample_1);
        model.setSongName(Constants.VideoNames.TITLE_VIDEO_1);
        model.setPostedBefore(10);
        model.setImageId(R.drawable.smpale_one);
        detailsList.add(model);

        VideoModel model1 = new VideoModel();
        model1.setmPath(BASE_PATH + getActivity().getPackageName() + "/" + R.raw.sample_2);
        model1.setSongName(Constants.VideoNames.TITLE_VIDEO_2);
        model1.setPostedBefore(12);
        model1.setImageId(R.drawable.sample_two);
        detailsList.add(model1);

        VideoModel model2 = new VideoModel();
        model2.setmPath(BASE_PATH + getActivity().getPackageName() + "/" + R.raw.sample_3);
        model2.setSongName(Constants.VideoNames.TITLE_VIDEO_3);
        model2.setPostedBefore(8);
        model2.setImageId(R.drawable.smpale_three);
        detailsList.add(model2);

        VideoModel model3 = new VideoModel();
        model3.setmPath(BASE_PATH + getActivity().getPackageName() + "/" + R.raw.sample_4);
        model3.setSongName(Constants.VideoNames.TITLE_VIDEO_4);
        model3.setPostedBefore(48);
        model3.setImageId(R.drawable.smpale_four);
        detailsList.add(model3);

        VideoModel model4 = new VideoModel();
        model4.setmPath(BASE_PATH + getActivity().getPackageName() + "/" + R.raw.sample_5);
        model4.setSongName(Constants.VideoNames.TITLE_VIDEO_5);
        model4.setPostedBefore(1);
        model4.setImageId(R.drawable.smpale_five);
        detailsList.add(model4);

        return detailsList;
    }
}
