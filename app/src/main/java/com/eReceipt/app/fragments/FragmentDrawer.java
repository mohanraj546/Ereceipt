package com.eReceipt.app.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.RelativeLayout;
import android.widget.TextView;


import com.eReceipt.app.R;
import com.eReceipt.app.adapters.NavigationDrawerAdapter;
import com.eReceipt.app.datamodels.NavigationItem;

import java.util.ArrayList;
import java.util.List;


public class FragmentDrawer extends BaseFragment implements OnClickListener {

    private RecyclerView recyclerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationDrawerAdapter adapter;
    private View containerView;
    private FragmentDrawerListener drawerListener;
    private static ArrayList<NavigationItem> navigationItemsArrayList;

    public FragmentDrawer() {

    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    public static List<NavigationItem> getData() {
        return navigationItemsArrayList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCurrentNavigationItems();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflating view layout
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        adapter = new NavigationDrawerAdapter(getActivity(), getData(), getResources().getString(R.string.nav_drawer_customers));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);
                mDrawerLayout.closeDrawer(containerView);
            }
            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return layout;
    }
    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //update the navigation header data(points,username and image)
                getCurrentNavigationItems();
                adapter.data = getData();
                //update notification count
                adapter.notifyDataSetChanged();
                hideKeyBoard(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }


    }

    public interface FragmentDrawerListener {
        public void onDrawerItemSelected(View view, int position);
    }

    private void getCurrentNavigationItems() {
        navigationItemsArrayList = new ArrayList<>();
        //  preparing navigation drawer items
        NavigationItem nav_customers = new NavigationItem();
        nav_customers.setName(getResources().getString(R.string.nav_drawer_customers));
        navigationItemsArrayList.add(nav_customers);

        NavigationItem nav_vendors = new NavigationItem();
        nav_vendors.setName(getResources().getString(R.string.nav_drawer_vendors));
        navigationItemsArrayList.add(nav_vendors);

        NavigationItem nav_ven_entry_form = new NavigationItem();
        nav_ven_entry_form.setName(getResources().getString(R.string.nav_drawer_vendor_entry));
        navigationItemsArrayList.add(nav_ven_entry_form);

        NavigationItem nav_cus_entry_form = new NavigationItem();
        nav_cus_entry_form.setName(getResources().getString(R.string.nav_drawer_customer_entry));
        navigationItemsArrayList.add(nav_cus_entry_form);

        NavigationItem nav_pay_rcv = new NavigationItem();
        nav_pay_rcv.setName(getResources().getString(R.string.nav_drawer_pay_rcv));
        navigationItemsArrayList.add(nav_pay_rcv);

        NavigationItem nav_pay_gvn = new NavigationItem();
        nav_pay_gvn.setName(getResources().getString(R.string.nav_drawer_pay_gvn));
        navigationItemsArrayList.add(nav_pay_gvn);

        NavigationItem nav_my_acct = new NavigationItem();
        nav_my_acct.setName(getResources().getString(R.string.nav_drawer_my_acct));
        navigationItemsArrayList.add(nav_my_acct);

        NavigationItem nav_log_out = new NavigationItem();
        nav_log_out.setName(getResources().getString(R.string.nav_drawer_log_out));
        navigationItemsArrayList.add(nav_log_out);
    }
}
