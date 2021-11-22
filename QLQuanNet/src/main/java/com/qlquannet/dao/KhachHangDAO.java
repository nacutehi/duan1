/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlquannet.dao;

import com.qlquannet.helper.jdbcHelper;
import com.qlquannet.models.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nana
 */
public class KhachHangDAO {
    private KhachHang readFromResultSet(ResultSet rs) throws SQLException{
	KhachHang entity=new KhachHang();
         entity.setMaKH(rs.getString("MaKH"));
         entity.setHoTen(rs.getString("HoTen"));     
         entity.setSoDT(rs.getString("DienThoai"));
         entity.setEmail(rs.getString("Email"));
         return entity;
    }

    private List<KhachHang> select(String sql, Object...args){
        List<KhachHang> list=new ArrayList<>();
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
    public void insert(KhachHang entity) {
        String sql="INSERT INTO KhachHang (MaKH, HoTen, DienThoai, Email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
         jdbcHelper.executeUpdate(sql,
             entity.getMaKH(),
             entity.getHoTen(),
             entity.getSoDT(),
             entity.getEmail());
    }

    /**
     * Cập nhật thực thể vào CSDL
     * @param model là thực thể chứa thông tin bản ghi cần cập nhật
     */
    public void update(KhachHang model) {
        String sql="UPDATE KhachHang SET HoTen=?, DienThoai=?, Email=?, WHERE MaKH=?";
        jdbcHelper.executeUpdate(sql,            
                 model.getHoTen(),
                 model.getSoDT(),
                 model.getEmail(),
                 model.getMaKH());
    }

    /**
     * Xóa bản ghi khỏi CSDL
     * @param id là mã của bản ghi cần xóa
     */
    public void delete(String id) {
        String sql="DELETE FROM KhachHang WHERE MaKH=?";
        jdbcHelper.executeUpdate(sql, id);
    }

    /**
     * Truy vấn tất cả các các thực thể
     * @return list danh sách các thực thể
     */
    public List<KhachHang> select() {
        String sql="SELECT * FROM KhachHang";
        return select(sql);
    }

    /**
     * Truy vấn người học theo keyword
     */
    public List<KhachHang> selectByKeyword(String keyword) {
        String sql="SELECT * FROM KhachHang WHERE HoTen LIKE ?";
        return select(sql, "%"+keyword+"%");
    }
    
     
     //truy xuất người học theo maKH
     public KhachHang findById(String maKh){
     String sql="SELECT * FROM KhachHang WHERE MaKH=?";
     List<KhachHang> list = select(sql, maKh);
     return list.size() > 0 ? list.get(0) : null;
     }
}
