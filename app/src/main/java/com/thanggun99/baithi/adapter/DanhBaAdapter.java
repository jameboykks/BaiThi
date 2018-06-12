package com.thanggun99.baithi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thanggun99.baithi.R;
import com.thanggun99.baithi.model.DanhBa;

import java.util.ArrayList;


public class DanhBaAdapter extends RecyclerView.Adapter<DanhBaAdapter.ViewHolder> {
    private ArrayList<DanhBa> danhBaList;

    public DanhBaAdapter(ArrayList<DanhBa> danhBaList) {

        this.danhBaList = danhBaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danh_ba, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DanhBa danhBa = danhBaList.get(position);

        holder.ivHinhAnh.setImageBitmap(danhBa.getHinhAnh());
        holder.tvName.setText(danhBa.getHoTen());
        holder.tvSoDienThoai.setText(danhBa.getSoDienThoai());
    }

    @Override
    public int getItemCount() {
        return (danhBaList != null) ? danhBaList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHinhAnh;
        TextView tvName;
        TextView tvSoDienThoai;

        public ViewHolder(View itemView) {
            super(itemView);

            ivHinhAnh = (ImageView) itemView.findViewById(R.id.iv_hinh_anh);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvSoDienThoai = (TextView) itemView.findViewById(R.id.tv_so_dien_thoai);
        }
    }
}
