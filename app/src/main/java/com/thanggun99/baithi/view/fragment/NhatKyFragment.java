package com.thanggun99.baithi.view.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.thanggun99.baithi.CallActivity;
import com.thanggun99.baithi.Demo;
import com.thanggun99.baithi.R;
import com.thanggun99.baithi.adapter.NhatKyAdapter;
import com.thanggun99.baithi.model.NhatKy;

import java.util.ArrayList;
import java.util.Date;


@SuppressLint("ValidFragment")
public class NhatKyFragment extends BaseFragment {

    Button button;
    View v;
    private RecyclerView nhatKyRecyclerView;
    private NhatKyAdapter nhatKyAdapter;
    private ArrayList<NhatKy> nhatKyList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_nhat_ky,container,false);
        initControl();
        initUI();

        return v;
    }

    private void initUI() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call();
            }
        });
    }
    private void initControl() {
        button= (Button) v.findViewById(R.id.btncall);
        nhatKyRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview_nhat_ky);
    }

//    public void onClick(View v){
//        switch (v.getId()){
//            case R.id.btncall:
//                call();
//                break;
//        }
//    }

    private void call() {
        Intent i= new Intent(getActivity(), CallActivity.class);
        NhatKyFragment.this.startActivity(i);

    }



    public NhatKyFragment() {
        super(R.layout.fragment_nhat_ky);
    }


    @Override
    public void findViews(View view) {
        nhatKyRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_nhat_ky);

    }

    @Override
    public void initComponents() {
        getCallDetails();
        //nhatKyList = new ArrayList<>();
//        nhatKyList.add(new NhatKy("+0915194096", "[0:15] 22:18:30 26-03-2017"));
//        nhatKyList.add(new NhatKy("+5454878784", "[0:15] 22:18:30 26-03-2017"));
//        nhatKyList.add(new NhatKy("+012355799", "[0:15] 11:18:30 26-03-2017"));
//        nhatKyList.add(new NhatKy("+012344578", "[0:15] 22:18:30 26-03-2017"));
//        nhatKyList.add(new NhatKy("+0123225546", "[0:15] 05:18:30 12-01-2017"));
//        nhatKyList.add(new NhatKy("+012344557", "[0:15] 22:18:30 26-03-2017"));
//        nhatKyList.add(new NhatKy("+012355468", "[0:15] 06:18:30 26-03-2017"));
//        nhatKyList.add(new NhatKy("+0915457741", "[0:15] 22:18:30 26-03-2017"));
//        nhatKyList.add(new NhatKy("+012354789", "[0:15] 22:18:30 22-02-2017"));


        nhatKyAdapter = new NhatKyAdapter(nhatKyList);
    }

    @Override
    public void setEvents() {
        //doan nay de lam gi. xem lai no xem. bi die cho nay
        nhatKyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        nhatKyRecyclerView.setAdapter(nhatKyAdapter);

    }

    private void getCallDetails() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        Cursor cursor = getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);

        if (cursor == null) {
            return;
        } else if (cursor.getCount() == 0) {
            return;
        } else {
            int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
            int date = cursor.getColumnIndex(CallLog.Calls.DATE);
            int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);

            nhatKyList = new ArrayList<>();
            while (cursor.moveToNext()) {

                String phoneNumber = cursor.getString(number);
                String callDate = cursor.getString(date);
                Date callDayTime = new Date(Long.valueOf(callDate));
                int callDuration = cursor.getInt(duration);


                String durationTime = "";
                if (callDuration < 60) {

                    durationTime = "[ 00:" + callDuration + "] ";
                } else {
                    durationTime = "[" + (callDuration / 60) + "] ";
                }


                String thoiGian = durationTime + " " + formatDate(callDayTime);

                nhatKyList.add(new NhatKy(phoneNumber, thoiGian));
            }
        }


    }

    public String formatDate(Date d) {

        return new java.text.SimpleDateFormat("hh:mm:ss  dd-MM-yyyy").format(d);
    }
}