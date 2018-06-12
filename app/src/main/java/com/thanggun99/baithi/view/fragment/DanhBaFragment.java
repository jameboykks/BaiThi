package com.thanggun99.baithi.view.fragment;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.thanggun99.baithi.R;
import com.thanggun99.baithi.adapter.DanhBaAdapter;
import com.thanggun99.baithi.model.DanhBa;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;


@SuppressLint("ValidFragment")
public class DanhBaFragment extends BaseFragment {

    private RecyclerView danhBaRecyclerView;
    private DanhBaAdapter danhBaAdapter;
    private ArrayList<DanhBa> danhBaList;

    public DanhBaFragment() {
        super(R.layout.fragment_danh_ba);
    }


    @Override
    public void findViews(View view) {
        danhBaRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_danh_ba);

    }

    @Override
    public void initComponents() {
        getContact();
/*        danhBaList.add(new DanhBa(R.drawable.iv_person_4, "Trần Văn Thắng", "+0915194096"));
        danhBaList.add(new DanhBa(R.drawable.iv_person_3, "Trấn Thành", "+4589999887"));
        danhBaList.add(new DanhBa(R.drawable.iv_person_2, "Bằng Kiều", "+478755642"));
        danhBaList.add(new DanhBa(R.drawable.iv_person_1, "Lê Công Vinh", "+0123556478"));
        danhBaList.add(new DanhBa(R.drawable.iv_person_5, "Phạm Văn Mách", "+019988753"));
        danhBaList.add(new DanhBa(R.drawable.iv_person_2, "Hoàng Xuân Vinh", "+012365478"));
        danhBaList.add(new DanhBa(R.drawable.iv_person_3, "Võ Hoài Linh", "+01235579"));
        danhBaList.add(new DanhBa(R.drawable.iv_person_1, "Hariwon", "+0914558796"));
        danhBaList.add(new DanhBa(R.drawable.iv_person_5, "Sơn Tùng MTP", "+0124457898"));*/

        danhBaAdapter = new DanhBaAdapter(danhBaList);
    }

    @Override
    public void setEvents() {
        danhBaRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        danhBaRecyclerView.setAdapter(danhBaAdapter);

    }

    public void getContact() {
        Cursor cursor = null;
        try {
            cursor = getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

            if (cursor == null) {

                return;
            } else if (cursor.getCount() == 0) {

                return;
            } else {
                int contactIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID);
                int nameIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                int phoneNumberIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

                danhBaList = new ArrayList<>();
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(contactIdx);

                    Uri my_contact_Uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(id));
                    InputStream photo_stream = ContactsContract.Contacts.openContactPhotoInputStream(getContext().getContentResolver(), my_contact_Uri);
                    BufferedInputStream buf = new BufferedInputStream(photo_stream);
                    Bitmap my_btmp = BitmapFactory.decodeStream(buf);

                    String name = cursor.getString(nameIdx);
                    String phoneNumber = cursor.getString(phoneNumberIdx);
                    danhBaList.add(new DanhBa(my_btmp, name, phoneNumber));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

}
