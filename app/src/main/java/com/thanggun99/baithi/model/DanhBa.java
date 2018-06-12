package com.thanggun99.baithi.model;

import android.graphics.Bitmap;

public class DanhBa {
    private Bitmap hinhAnh;
    private String hoTen;
    private String soDienThoai;


    public DanhBa(Bitmap hinhAnh, String hoTen, String soDienThoai) {
        this.hinhAnh = hinhAnh;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
    }

    public Bitmap getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(Bitmap hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
