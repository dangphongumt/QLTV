/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo_hinh;

/**
 *
 * @author Dang Phong
 */
public class sach  {
    private String tenSach;
    private String maSach;
    private String nhaXuatBan;
    private String loaiSach;
    private boolean tinhTrang;
    private String tacGia;
    private String maPhieu;
    private String Ngmuon;
    private String Ngtra;
    
    public sach()
    {
        super();
    }
    public sach( String tenSach,String maSach,String nhaXuatBan,String loaiSach, boolean tinhTrang, String maPhieu, String Ngmuon,String Ngtra)
    {
     super();
     this.tenSach= tenSach;
     this.loaiSach = loaiSach;
     this.maSach = maSach;
     this.nhaXuatBan = nhaXuatBan;
     this.tinhTrang = tinhTrang;
     this.tacGia=tacGia;
     this.Ngmuon=Ngmuon;
     this.Ngtra= Ngtra;
     this.maPhieu = maPhieu;
    }

    /**
     * @return the tenSach
     */
    public String getTenSach() {
        return tenSach;
    }

    /**
     * @param tenSach the tenSach to set
     */
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    /**
     * @return the maSach
     */
    public String getMaSach() {
        return maSach;
    }

    /**
     * @param maSach the maSach to set
     */
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    /**
     * @return the nhaXuatBan
     */
    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    /**
     * @param nhaXuatBan the nhaXuatBan to set
     */
    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    /**
     * @return the loaiSach
     */
    public String getLoaiSach() {
        return loaiSach;
    }

    /**
     * @param loaiSach the loaiSach to set
     */
    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    /**
     * @return the soLuong
     */
    public boolean getTinhTrang() {
        return tinhTrang;
    }

    /**
     * @param tinhTrang
     */
    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    /**
     * @return the tacGia
     */
    public String getTacGia() {
        return tacGia;
    }

    /**
     * @param tacGia the tacGia to set
     */
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    public String getmaPhieu() {
        return maPhieu;
    }

    /**
     * @param maPhieu
     */
    public void setmaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }
    public String getNgmuon() {
        return Ngmuon;
    }

    /**
     * @param Ngmuon
     */
    public void setNgmuon(String Ngmuon) {
        this.Ngmuon = Ngmuon;
    }  
    public String getNgtra() {
        return Ngtra;
    }

    /**
     * @param Ngtra
     */
    public void setNgtra(String Ngtra) {
        this.Ngtra = Ngtra;
    }

    public void getMaSach(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getTenSach(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getTinhTrang(boolean aBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getNhaXuatBan(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getLoaiSach(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getTacGia(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
