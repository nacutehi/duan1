/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlquannet.models;

import com.qlquannet.helper.dateHelper;
import java.util.Date;

/**
 *
 * @author nana
 */
public class HoaDon {
    private String maHD;
    private int maKH;
    private Date ngayTao = dateHelper.now();  
    private double tongTien;
    private String trangthai;

    public String getMaCD() {
        return maHD;
    }

    public void setMaCD(String maCD) {
        this.maHD = maCD;
    }

    public int getMaKhach() {
        return maKH;
    }

    public void setMaKhach(int maKhach) {
        this.maKH = maKhach;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
}
