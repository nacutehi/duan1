/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlquannet.models;

/**
 *
 * @author nana
 */
public class MayTram {
    private String maMay;
    private String tenMay;
    private double giaGio;
    private boolean trangThai=false;

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public double getGiaGio() {
        return giaGio;
    }

    public void setGiaGio(double giaGio) {
        this.giaGio = giaGio;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
