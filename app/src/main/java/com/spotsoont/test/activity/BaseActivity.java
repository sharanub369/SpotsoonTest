package com.spotsoont.test.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.spotsoont.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by sharana.b on 5/29/2017.
 */

public class BaseActivity extends AppCompatActivity {

    private String TAG = BaseActivity.class.getCanonicalName();

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        bindViews();
    }

    /**
     * Binding views to current context
     */
    protected void bindViews() {
        ButterKnife.bind(this);
        setupToolbar();
    }

    public void setContentViewWithoutInject(int layoutResId) {
        super.setContentView(layoutResId);
    }

    /**
     * Setting up toolbar
     */
    protected void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbar.setNavigationIcon(R.drawable.ic_menu);
        }
    }

    public Toolbar getToolbar() {
        return toolbar;
    }


}
