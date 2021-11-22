/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlquannet.dao;

import com.qlquannet.models.DichVu;
import com.qlquannet.helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nana
 */
public class DichVuDAO {
    private DichVu readFromResultSet(ResultSet rs) throws SQLException{
	DichVu model=new DichVu();
        model.setMaDV(rs.getString("MaDV"));
        model.setTenDV(rs.getString("TenDV"));
        model.setGiaDV(rs.getDouble("GiaDV"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setHinh(rs.getString("Hinh"));
        return model;
    }

    private List<DichVu> select(String sql, Object...args){
        List<DichVu> list=new ArrayList<>();
        try {
            ResultSet rs=null;
            try{
                rs=jdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    list.add(readFromResultSet(rs));
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }
    /**
     * Thêm mới thực thể vào CSDL
     * @param entity là thực thể chứa thông tin bản ghi mới
     */
    public void insert(DichVu entity) {
        String sql="INSERT INTO DichVu (MaDV, TenDV, Gia, SoLuong, Hinh) VALUES (?, ?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMaDV(),
                entity.getTenDV(),
                entity.getGiaDV(),
                entity.getSoLuong(),
                entity.getHinh());
    }

    /**
     * Cập nhật thực thể vào CSDL
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    public void update(DichVu entity) {
        String sql="UPDATE DichVu SET TenDV=?, GiaDV=?, SoLuong=?, Hinh=? WHERE MaDV=?";
        jdbcHelper.executeUpdate(sql,
                entity.getTenDV(),
                entity.getGiaDV(),
                entity.getSoLuong(),
                entity.getHinh(),
                entity.getMaDV());
    }

    /**
     * Xóa bản ghi khỏi CSDL
     * @param id là mã của bản ghi cần xóa
     */
    public void delete(String id) {
        String sql="DELETE FROM DichVu WHERE MaDV=?";
        jdbcHelper.executeUpdate(sql, id);
    }

    /**
     * Truy vấn tất cả các các thực thể
     * @return list danh sách các thực thể
     */
    public List<DichVu> select() {
        String sql="SELECT * FROM DichVu";
        return select(sql);
    }

    /**
     * Truy vấn thực thể theo mã id
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public DichVu findById(String id) {
        String sql="SELECT * FROM DichVu WHERE MaDV=?";
        List<DichVu> list=select(sql,id);
        return list.size()>0?list.get(0):null;
    }    
}
