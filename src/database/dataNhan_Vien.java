/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mo_hinh.Connec;
import mo_hinh.nhan_vien;

/**
 *
 * @author Dang Phong
 */
public class dataNhan_Vien {

    public static PreparedStatement ps;
    public static ResultSet rs;
   
     public nhan_vien dangNhap(String user, String pass) {
       nhan_vien nv=null;
       
         try{
         ps = Connec.getConnection().prepareStatement("SELECT * FROM qlNV where TenDN = ? and Pass = ?");
         ps.setString(1, user);
         ps.setString(2, pass);
         rs = ps.executeQuery();
        
        while(rs.next()){
           
          nv = new nhan_vien();
          nv.setTenDangNhap(user);
          nv.setPass(pass);
         
    
         }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Oh no!!!Fail_Ahihi "+e);
             return nv=null;
         }
        return nv;
    }

//    /**public boolean addNV(nhan_vien nv){
//        String sql = "INSERT INTO tbnhan_vienSQL(TenNV, MaNV, DiaChi, NgSinh, SDT, TenDN) "
//                + "VALUES(?,?,?,?,?,?)";
//        try {
//           ps = Connection.getConnection().prepareStatement(sql);
//             ps.setString(1, nv.getTenNhanVien());
//            ps.setString(2, nv.getMaNhanVien());
//            ps.setString(3, nv.getDiaChi());
//            ps.set
//     *
//     * @param nv
//     * @return
//     */
    public boolean addNV(nhan_vien nv) {
        String sql = "INSERT INTO qlNV(MaNV,TenNV, NgSinh,DiaChi, SDT, TenDN, Pass) "
                + "VALUES(?,?,?,?,?,?,?)";
        try {
              ps = Connec.getConnection().prepareStatement(sql);
            //rs = ps.executeQuery(sql);

            ps.setString(1, nv.getMaNhanVien());
            ps.setString(2, nv.getTenNhanVien()); 
            ps.setString(3, nv.getNgaySinh());
            ps.setString(4, nv.getDiaChi());
            ps.setString(5, nv.getSoDienThoai());
            ps.setString(6, nv.getTenDangNhap());
            ps.setString(7, "123456");
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.printf("không thể them");
        }
        return false;
    }
//    public ArrayList<nhan_vien> getlistNV(){
//       // nhan_vien nvien = null;
//        ArrayList<nhan_vien> listNV =   new ArrayList<>();
//        String sql = "SELECT * FROM tbnhan_vienSQL";
//        try {
//         //   PreparedStatement ps = nvien.prepareStatement(sql);
//            ps = Connection.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                nhan_vien nv = new nhan_vien();
//                nv.setTenNhanVien(rs.getString("TenNV"));
//                nv.setMaNhanVien(rs.getString("MaNV"));
//                nv.setDiaChi(rs.getString("DiaChi"));
//                nv.setNgaySinh(rs.getString("NgSinh"));
//                nv.setSoDienThoai(rs.getString("SDT"));
//                nv.setTenDangNhap(rs.getString("TenDN"));
//                listNV.add(nv);
//            }
//            }catch(Exception e){
//                    e.printStackTrace();
//                    }
//        //return listNV;
//    }

    public static ArrayList<nhan_vien> getnvien() {
        ArrayList<nhan_vien> listNV = new ArrayList<>();
        String sql = "SELECT * FROM qlNV";
        try {
            ps = Connec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                nhan_vien nv = new nhan_vien();
                nv.setMaNhanVien(rs.getString("MaNV"));
                nv.setTenNhanVien(rs.getString("TenNV"));
                nv.setNgaySinh(rs.getString("NgSinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSoDienThoai(rs.getString("SDT"));
                nv.setTenDangNhap(rs.getString("TenDN"));
                listNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }
    public boolean deleteNV(String maNV){
        try{
            ps = Connec.getConnection().prepareStatement("DELETE FROM qlNV WHERE MaNV = ?");
            ps.setString(1, maNV);
            return ps.executeUpdate()>0;
        }catch(Exception e){
            return false;
        }
    }
    public boolean UpdateNV(nhan_vien nv){
        try{
            ps =Connec.getConnection().prepareStatement("UPDATE qlNV SET  TenNV =?, NgSinh = ?,DiaChi = ?,"
                    + "SDT = ?, TenDN = ? WHERE MaNV= ?");
            ps.setString(6, nv.getMaNhanVien());
            ps.setString(1, nv.getTenNhanVien());
            ps.setString(2, nv.getNgaySinh());
            ps.setString(3, nv.getDiaChi());
            ps.setString(4, nv.getSoDienThoai());
            ps.setString(5, nv.getTenDangNhap());

            return ps.executeUpdate()>0;
        }catch(SQLException e){
            return false;
        }
    }
    public static void main(String[] args) {
        new dataNhan_Vien();
    }
}
