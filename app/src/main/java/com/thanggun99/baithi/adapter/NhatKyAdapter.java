package com.thanggun99.baithi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thanggun99.baithi.R;
import com.thanggun99.baithi.model.NhatKy;

import java.util.ArrayList;


public class NhatKyAdapter extends RecyclerView.Adapter<NhatKyAdapter.ViewHolder> {
    private ArrayList<NhatKy> nhatKyList;

    public NhatKyAdapter(ArrayList<NhatKy> nhatKyList) {

        this.nhatKyList = nhatKyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nhat_ky, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NhatKy nhatKy = nhatKyList.get(position);

        holder.tvThoiGian.setText(nhatKy.getThoiGian());
        holder.tvSoDienThoai.setText(nhatKy.getSoDienThoai());
    }

    @Override
    public int getItemCount() {
        return (nhatKyList != null) ? nhatKyList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSoDienThoai;
        TextView tvThoiGian;

        public ViewHolder(View itemView) {
            super(itemView);

            tvThoiGian = (TextView) itemView.findViewById(R.id.tv_thoi_gian);
            tvSoDienThoai = (TextView) itemView.findViewById(R.id.tv_so_dien_thoai);
        }
    }
}
