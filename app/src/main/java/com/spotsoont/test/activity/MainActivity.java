package com.spotsoont.test.activity;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.spotsoont.test.R;
import com.spotsoont.test.adapter.ViewPagerAdapter;
import com.spotsoont.test.fragment.AboutUsFragment;
import com.spotsoont.test.fragment.ImagesFragment;
import com.spotsoont.test.fragment.MilestoneFragment;
import com.spotsoont.test.fragment.VideosFragment;
import com.spotsoont.test.util.Constants;

import butterknife.BindView;

/**
 * Created by sharan.b on 7/18/2017.
 */

public class MainActivity extends BaseDrawerActivity implements View.OnClickListener {

    private String TAG = MainActivity.class.getCanonicalName();

    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.viewPager)
    public ViewPager viewPager;
    @BindView(R.id.tabsLyt)
    public TabLayout tabsLyt;
    //    @BindView(R.id.tabIndicator)
//    public InkPageIndicator tabIndicator;
    @BindView(R.id.tabInd1Img)
    public ImageView tabInd1Img;
    @BindView(R.id.tabInd2Img)
    public ImageView tabInd2Img;
    @BindView(R.id.tabInd3Img)
    public ImageView tabInd3Img;
    @BindView(R.id.tabInd4Img)
    public ImageView tabInd4Img;
    @BindView(R.id.playIcon)
    public ImageView playIcon;
    @BindView(R.id.videoView)
    public VideoView videoView;
    @BindView(R.id.imageViewImg)
    public ImageView imageViewImg;
    @BindView(R.id.viewID)
    public View viewID;

    private String videoPath = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbarTitle();
        setupViewPager();
        setOnclickListener();
        setInitialValues();
    }

    /**
     * Setting Default video path
     */
    private void setInitialValues() {
        videoPath = "android.resource://" + getPackageName() + "/" + R.raw.sample_1;
    }


    /**
     * Onclick listeners
     */
    private void setOnclickListener() {
        playIcon.setOnClickListener(this);
    }

    /**
     * Page toolbar title
     */
    private void setupToolbarTitle() {
        getToolbar().setTitle(getString(R.string.page_title_home));
    }


    /**
     * setting viewpager to the toolbar for tabs view
     */
    private void setupViewPager() {
        setupWithViewPager();
        tabsLyt.setupWithViewPager(viewPager, true);
        createTabIcons();
        tabsLyt.getChildAt(0).setSelected(true);

        /**
         * Tabs select listener
         */
        tabsLyt.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ImageView tabIcon = null;
                if (tab.getPosition() == 0) {
                    tabIcon = (ImageView) tab.getCustomView().findViewById(R.id.tabIcon);
                    tabIcon.setImageResource(R.drawable.ic_select_video);
                    tabSelectedIndicator(tab.getPosition());
                    imageViewImg.setVisibility(View.GONE);
                    viewID.setVisibility(View.VISIBLE);
                } else if (tab.getPosition() == 1) {
                    tabIcon = (ImageView) tab.getCustomView().findViewById(R.id.tabIcon);
                    tabIcon.setImageResource(R.drawable.ic_select_image);
                    tabSelectedIndicator(tab.getPosition());
                    imageViewImg.setVisibility(View.VISIBLE);
                    imageViewImg.setImageResource(R.drawable.ic_select_image);
                    viewID.setVisibility(View.GONE);
                } else if (tab.getPosition() == 2) {
                    tabIcon = (ImageView) tab.getCustomView().findViewById(R.id.tabIcon);
                    tabIcon.setImageResource(R.drawable.ic_select_milestone);
                    tabSelectedIndicator(tab.getPosition());
                    imageViewImg.setVisibility(View.VISIBLE);
                    imageViewImg.setImageResource(R.drawable.ic_select_milestone);
                    viewID.setVisibility(View.GONE);
                } else if (tab.getPosition() == 3) {
                    tabIcon = (ImageView) tab.getCustomView().findViewById(R.id.tabIcon);
                    tabIcon.setImageResource(R.drawable.ic_select_about_us);
                    tabSelectedIndicator(tab.getPosition());
                    imageViewImg.setVisibility(View.VISIBLE);
                    imageViewImg.setImageResource(R.drawable.ic_select_about_us);
                    viewID.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ImageView tabIcon = null;
                if (tab.getPosition() == 0) {
                    tabIcon = (ImageView) tab.getCustomView().findViewById(R.id.tabIcon);
                    tabIcon.setImageResource(R.drawable.ic_video);
                } else if (tab.getPosition() == 1) {
                    tabIcon = (ImageView) tab.getCustomView().findViewById(R.id.tabIcon);
                    tabIcon.setImageResource(R.drawable.ic_image);
                } else if (tab.getPosition() == 2) {
                    tabIcon = (ImageView) tab.getCustomView().findViewById(R.id.tabIcon);
                    tabIcon.setImageResource(R.drawable.ic_milestone);
                } else if (tab.getPosition() == 3) {
                    tabIcon = (ImageView) tab.getCustomView().findViewById(R.id.tabIcon);
                    tabIcon.setImageResource(R.drawable.ic_about_us);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * Tabs dots selected view setting
     *
     * @param position
     */
    private void tabSelectedIndicator(int position) {
        switch (position) {
            case 0:
                tabInd1Img.setImageResource(R.drawable.fill_circle);
                tabInd2Img.setImageResource(R.drawable.holo_circle);
                tabInd3Img.setImageResource(R.drawable.holo_circle);
                tabInd4Img.setImageResource(R.drawable.holo_circle);
                break;
            case 1:
                tabInd2Img.setImageResource(R.drawable.fill_circle);
                tabInd1Img.setImageResource(R.drawable.holo_circle);
                tabInd3Img.setImageResource(R.drawable.holo_circle);
                tabInd4Img.setImageResource(R.drawable.holo_circle);
                break;
            case 2:
                tabInd3Img.setImageResource(R.drawable.fill_circle);
                tabInd2Img.setImageResource(R.drawable.holo_circle);
                tabInd1Img.setImageResource(R.drawable.holo_circle);
                tabInd4Img.setImageResource(R.drawable.holo_circle);
                break;
            case 3:
                tabInd4Img.setImageResource(R.drawable.fill_circle);
                tabInd2Img.setImageResource(R.drawable.holo_circle);
                tabInd3Img.setImageResource(R.drawable.holo_circle);
                tabInd1Img.setImageResource(R.drawable.holo_circle);
                break;
        }
    }

    /**
     * Creating custom tabs items view
     */
    private void createTabIcons() {
        LinearLayout tab1 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab_item_view, null);
        ImageView tabImg1 = (ImageView) tab1.findViewById(R.id.tabIcon);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            tabImg1.setImageResource(R.drawable.ic_select_video);
        } else {
            tabImg1.setImageResource(R.drawable.ic_select_video);
        }
        TextView tabText1 = (TextView) tab1.findViewById(R.id.tabText);
        tabText1.setText(Constants.ToolbarTitles.TITLE_VIDEOS);
        tabsLyt.getTabAt(0).setCustomView(tab1);

        LinearLayout tab2 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab_item_view, null);
        ImageView tabImg2 = (ImageView) tab2.findViewById(R.id.tabIcon);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            tabImg2.setImageResource(R.drawable.ic_image);
        } else {
            tabImg2.setImageResource(R.drawable.ic_image);
        }
        TextView tabText2 = (TextView) tab2.findViewById(R.id.tabText);
        tabText2.setText(Constants.ToolbarTitles.TITLE_IMAGES);
        tabsLyt.getTabAt(1).setCustomView(tab2);

        LinearLayout tab3 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab_item_view, null);
        ImageView tabImg3 = (ImageView) tab3.findViewById(R.id.tabIcon);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            tabImg3.setImageResource(R.drawable.ic_milestone);
        } else {
            tabImg3.setImageResource(R.drawable.ic_milestone);
        }
        TextView tabText3 = (TextView) tab3.findViewById(R.id.tabText);
        tabText3.setText(Constants.ToolbarTitles.TITLE_MILESTONE);
        tabsLyt.getTabAt(2).setCustomView(tab3);

        LinearLayout tab4 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab_item_view, null);
        ImageView tabImg4 = (ImageView) tab3.findViewById(R.id.tabIcon);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            tabImg4.setImageResource(R.drawable.ic_about_us);
        } else {
            tabImg4.setImageResource(R.drawable.ic_about_us);
        }
        TextView tabText4 = (TextView) tab4.findViewById(R.id.tabText);
        tabText4.setText(Constants.ToolbarTitles.TITLE_ABOUT_US);
        tabsLyt.getTabAt(3).setCustomView(tab4);
    }

    /**
     * adding fragments for the specific tab
     */
    private void setupWithViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new VideosFragment(), null);
        adapter.addFrag(new ImagesFragment(), null);
        adapter.addFrag(new MilestoneFragment(), null);
        adapter.addFrag(new AboutUsFragment(), null);
        viewPager.setAdapter(adapter);
//        tabIndicator.setViewPager(viewPager);
    }

    /**
     * creating video player and playing the songs
     *
     * @param path1
     */
    public void playVideo(String path1) {
        if (path1 != null) {
            if (videoView.isPlaying()) videoView.stopPlayback();
            videoView.setVideoURI(Uri.parse(path1));
            videoView.start();
        }


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            // Do something for lollipop and above versions
        } else {
            // do something for phones running an SDK before lollipop
        }
    }

    /**
     * Override method for onclick of OnClickListenerInterface
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.playIcon:
                playVideo(videoPath);
                break;
        }
    }

}
