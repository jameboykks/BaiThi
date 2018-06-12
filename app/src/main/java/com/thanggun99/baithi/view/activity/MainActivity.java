package com.thanggun99.baithi.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.thanggun99.baithi.R;
import com.thanggun99.baithi.adapter.TabsAdapter;
import com.thanggun99.baithi.view.fragment.DanhBaFragment;
import com.thanggun99.baithi.view.fragment.NhatKyFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabsAdapter tabsAdapter;
    private DanhBaFragment danhBaFragment;
    private NhatKyFragment nhatKyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initComponents();
        setEvents();
    }

    public void findViews() {
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.view_pg);
    }

    public void initComponents() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(danhBaFragment = new DanhBaFragment());
        fragments.add(nhatKyFragment = new NhatKyFragment());
        tabsAdapter = new TabsAdapter(getSupportFragmentManager(), fragments);

    }

    public void setEvents() {
        viewPager.setAdapter(tabsAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
