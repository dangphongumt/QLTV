/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static database.dataNhan_Vien.ps;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTextField;
import mo_hinh.Connec;
import static mo_hinh.Connec.getConnection;
import mo_hinh.muonTra;
import mo_hinh.nguoi_doc;

import mo_hinh.sach;

/**
 *
 * @author Thảo Vy
 */
public class dataMan_hinh_chinh {
    public static PreparedStatement ps;
    public static ResultSet rs;
    private static ArrayList<sach> listSach;
    private static ArrayList<nguoi_doc> listNguoidoc;
    public boolean addSach(sach s){
        String sql = "INSERT INTO Sach(Masach,TenSach, Loaisach,Tacgia,Nhaxuatban,Tinhtrang)" 
                + "VALUES(?,?,?,?,?,?)";
        try {
            ps= Connec.getConnection().prepareStatement(sql);
            ps.setString(1,s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3,s.getLoaiSach());
            ps.setString(4, s.getTacGia());
            ps.setString(5, s.getNhaXuatBan());
            ps.setBoolean(6, s.getTinhTrang());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
   
    public boolean xoaSach(String maSach,String tenSach){
        try{String sql="SELECT * FROM Sach"; 
            Connection conn=getConnection();
            ResultSet rs=conn.createStatement().executeQuery(sql);
            while(rs.next())if(maSach.equals(rs.getString("Masach"))||tenSach.equals(rs.getString("Tensach"))){
            ps = Connec.getConnection().prepareStatement("DELETE FROM Sach WHERE maSach = ? or tenSach=?");
            ps.setString(1, maSach);
            ps.setString(2, tenSach);
            return ps.executeUpdate()>0;}
        }catch(Exception e){
            return false;
        }return false;
    }
    
   
    
    public boolean SuaSach(sach s){
        try{
            
            ps =Connec.getConnection().prepareStatement("UPDATE Sach SET  TenSach=?,Loaisach=?,"
                    + "Tacgia=?,Nhaxuatban=?,Tinhtrang=? where Masach = ?");
            ps.setString(6, s.getMaSach());
            ps.setString(1, s.getTenSach());
            ps.setString(2, s.getTacGia());
            ps.setString(3, s.getLoaiSach());
            ps.setString(4, s.getNhaXuatBan());
            ps.setBoolean(5, s.getTinhTrang());
            ps.executeUpdate();
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean addDocgia(nguoi_doc d){
        String sql ="INSERT INTO docgia(Madocgia, Tendocgia,Ngaysinh,Diachi,Nghenghiep, SDT)" + "VALUES(?,?,?,?,?,?)";
        try {
            ps = Connec.getConnection().prepareStatement(sql);
            ps.setString(1, d.getMadocgia());
            ps.setString(2, d.getTendocgia());
            ps.setString(3, d.getNgaysinh());
            ps.setString(4, d.getDiachi());
            ps.setString(5, d.getNghenghiep());
            ps.setString(6, d.getSdt());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false; 
    }
    public boolean addMuonTra(muonTra d){
        String sql ="INSERT INTO DSmuon(Maphieu, MaNgdoc,TenNgdoc,Masach,Tensach, Ngaymuon,Ngaytra)" + "VALUES(?,?,?,?,?,?,?)";
        try {
            ps = Connec.getConnection().prepareStatement(sql);
            ps.setString(1, d.getMaPheuMuon());
            ps.setString(2, d.getMaNguoiDoc());
            ps.setString(3, d.getTenNguoiDoc());
            ps.setString(4, d.getMaSach());
            ps.setString(5, d.getTenSach());
            ps.setString(6, d.getNgayMuon());
            ps.setString(7, d.getNgayTra());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false; 
    }
    public boolean xoaNguoidoc(String maNguoidoc){
         try{
            ps = Connec.getConnection().prepareStatement("DELETE FROM docgia WHERE Madocgia = ?");
            ps.setString(1, maNguoidoc);
            return ps.executeUpdate()>0;
        }catch(Exception e){
            return false;
        }
    }
    public boolean xoaMT(String m){
         try{
            ps = Connec.getConnection().prepareStatement("DELETE FROM DSmuon WHERE MaPhieu = ?");
            ps.setString(1, m);
            return ps.executeUpdate()>0;
        }catch(Exception e){
            return false;
        }
    }
    public boolean SuaNguoidoc(nguoi_doc d){
//      
          try{
            ps =Connec.getConnection().prepareStatement("UPDATE docgia SET  Tendocgia=?,Ngaysinh=?," +    
                     "Diachi=?,Nghenghiep=?,SDT=? where Madocgia = ?");
            ps.setString(6, d.getMadocgia());
            ps.setString(1, d.getTendocgia());
            ps.setString(2, d.getNgaysinh());
            ps.setString(3, d.getDiachi());
            ps.setString(4, d.getNghenghiep());
            ps.setString(5, d.getSdt());
            ps.executeUpdate();
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            return false;
        }
    }
   

    
    
//    public boolean addMuon(nguoi_doc d , sach s ){
//        String sql = "INSERT INTO DSmuon(MaPhieu, MaNgdoc,TenNgdoc,Masach,Tensach,Ngaymuon,Ngaytra)"+"VALUES(?,?,?,?,?,?,?)";
//        try {
//            ps.setString(1, s.getmaPhieu());
//            ps.setString(2, d.getMadocgia());
//            ps.setString(3, d.getTendocgia());
//            ps.setString(4, s.getMaSach());
//            ps.setString(5, s.getTenSach());
//            ps.setString(6, s.getNgmuon());
//            ps.setString(7, s.getNgtra());
//        } catch (Exception e) {
//        }
//    
//        return false;
//    }
    public static ArrayList<sach> getListSach() {
        ArrayList<sach> listSach = new ArrayList<>();
        String sql = "SELECT * FROM Sach";
        try {
            ps = Connec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sach s = new sach();
                s.setMaSach(rs.getString("Masach"));
                s.setTenSach(rs.getString("Tensach"));
                s.setLoaiSach(rs.getString("Loaisach"));
                s.setTacGia(rs.getString("Tacgia"));
                s.setNhaXuatBan(rs.getString("Nhaxuatban"));
                s.setTinhTrang(rs.getBoolean("Tinhtrang"));
                listSach.add(s);
            }
            return listSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSach;
    }
    public static ArrayList<nguoi_doc> getListNguoidoc(){
        ArrayList<nguoi_doc> listNguoidoc;
        listNguoidoc = new ArrayList<>();
        String sql = "SELECT * FROM docgia";
        try {
            ps = Connec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                nguoi_doc d = new nguoi_doc();
                d.setMadocgia(rs.getString("Madocgia"));
                d.setTendocgia(rs.getString("Tendocgia"));
                d.setNgaysinh(rs.getString("Ngaysinh"));
                d.setDiachi(rs.getString("Diachi"));
                d.setNghenghiep(rs.getString("Nghenghiep"));
                d.setSdt(rs.getString("SDT"));
                listNguoidoc.add(d);
            }
            return listNguoidoc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoidoc;
    }
    public static ArrayList<muonTra> getListMuonTra(){
        ArrayList<muonTra> listMT;
        listMT = new ArrayList<>();
        String sql = "SELECT * FROM DSmuon";
        try {
            ps = Connec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                muonTra d = new muonTra();
                d.setMaPheuMuon(rs.getString("MaPhieu"));
                d.setMaNguoiDoc(rs.getString("MaNgdoc"));
                d.setTenNguoiDoc(rs.getString("TenNgdoc"));
                d.setMaSach(rs.getString("Masach"));
                d.setTenSach(rs.getString("Tensach"));
                d.setNgayMuon(rs.getString("Ngaymuon"));
                d.setNgayTra(rs.getString("Ngaytra"));
                listMT.add(d);
            }
            return listMT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMT;
    }
    public static void main(String[] args) {
        new dataMan_hinh_chinh();
        getListNguoidoc();
    }

    
}
   
    
    
    






 