package com.spotsoont.test.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.spotsoont.test.R;

import butterknife.BindDimen;
import butterknife.BindView;


/**
 * Created by sharana.b on 5/29/2017.
 */

public class BaseDrawerActivity extends BaseActivity {

    protected static final int NAV_DRAWER_ITEM_INVALID = -1;

    private String TAG = BaseDrawerActivity.class.getCanonicalName();

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.vNavigation)
    NavigationView vNavigation;

    /**
     * Setting content view for current context
     *
     * @param layoutResID
     */
    @Override
    public void setContentView(int layoutResID) {
        super.setContentViewWithoutInject(R.layout.activity_drawer);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.flContentRoot);
        LayoutInflater.from(this).inflate(layoutResID, viewGroup, true);
        bindViews();
        setupNavDrawer();
    }

    /**
     * Sets up the navigation drawer.
     */
    private void setupNavDrawer() {
        if (vNavigation != null) {
            vNavigation.setItemIconTintList(null);
        }

        setupDrawerSelectListener(vNavigation);
        setSelectedItem(vNavigation);
    }

    /**
     * Updated the checked item in the navigation drawer
     *
     * @param navigationView the navigation view
     */
    private void setSelectedItem(NavigationView navigationView) {
        // Which navigation item should be selected?
        int selectedItem = getSelfNavDrawerItem(); // subclass has to override this method
        navigationView.setCheckedItem(selectedItem);
    }

    /**
     * Creates the item click listener.
     *
     * @param navigationView the navigation view
     */
    private void setupDrawerSelectListener(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        drawerLayout.closeDrawers();
                        int menuId = 0;
                        menuId = menuItem.getItemId();
                        onNavigationItemClicked(menuId);
                        return true;
                    }
                });
    }

    /**
     * Handles the navigation item click.
     *
     * @param itemId the clicked item
     */
    private void onNavigationItemClicked(final int itemId) {
        if (itemId == getSelfNavDrawerItem()) {
            // Already selected
            closeDrawer();
            return;
        }

        goToNavDrawerItem(itemId);
    }

    /**
     * Handles the navigation item click and starts the corresponding activity.
     *
     * @param item the selected navigation item
     */
    private void goToNavDrawerItem(int item) {
        switch (item) {

        }
    }

    /**
     * Returns the navigation drawer item that corresponds to this Activity. Subclasses
     * have to override this method.
     */
    protected int getSelfNavDrawerItem() {
        return NAV_DRAWER_ITEM_INVALID;
    }

    /**
     * Handles navigation drawer open.
     */
    protected void openDrawer() {
        if (drawerLayout == null)
            return;

        drawerLayout.openDrawer(GravityCompat.START);
    }


    /**
     * Handles navigation drawer close.
     */
    protected void closeDrawer() {
        if (drawerLayout == null)
            return;

        drawerLayout.closeDrawer(GravityCompat.START);
    }


    /**
     * Create option menu.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    /**
     * Handles navigation drawer icon click on the toolbar.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                openDrawer();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
