package com.thanggun99.baithi.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.thanggun99.baithi.App;
import com.thanggun99.baithi.R;
import com.thanggun99.baithi.interfaces.CommondActionForView;

public abstract class BaseFragment extends Fragment implements CommondActionForView {
    protected View view;
    private int layoutResource;
    private Animation zoomAnimation;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.clear();
    }

    public BaseFragment(int layoutResource) {
        this.layoutResource = layoutResource;
        zoomAnimation = AnimationUtils.loadAnimation(App.getContext(), R.anim.zoom);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
            view.startAnimation(zoomAnimation);
        } else {
            view.clearAnimation();
        }
        super.onHiddenChanged(hidden);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.view = inflater.inflate(layoutResource, container, false);
        findViews(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.startAnimation(zoomAnimation);
        super.onViewCreated(view, savedInstanceState);
        initComponents();
        setEvents();
    }

    @Override
    public abstract void findViews(View view);

    @Override
    public abstract void initComponents();

    @Override
    public abstract void setEvents();
}
