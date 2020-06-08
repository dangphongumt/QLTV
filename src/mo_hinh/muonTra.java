/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo_hinh;


/**
 *
 * @author LE THANH NHAN
 */
public class muonTra {
    private String maPheuMuon;
    private String maNguoiDoc;
    private String tenNguoiDoc;
    private String maSach;
    private String tenSach;
    private String ngayMuon;
    private String ngayTra;
    public muonTra()
    {
        super();
    }
    public muonTra(String maPheuMuon,String maNguoiDoc,String tenNguoiDoc,String maSach,String tenSach,String ngayMuon,String ngayTra){
        super();
        this.maNguoiDoc=maNguoiDoc;
        this.tenNguoiDoc=tenNguoiDoc;
        this.maPheuMuon=maPheuMuon;
        this.maSach=maSach;
        this.tenSach=tenSach;
        this.ngayMuon=ngayMuon;
        this.ngayTra=ngayTra;
    }

    /**
     * @return the maPheuMuon
     */
    public String getMaPheuMuon() {
        return maPheuMuon;
    }

    /**
     * @param maPheuMuon the maPheuMuon to set
     */
    public void setMaPheuMuon(String maPheuMuon) {
        this.maPheuMuon = maPheuMuon;
    }

    /**
     * @return the maNguoiDoc
     */
    public String getMaNguoiDoc() {
        return maNguoiDoc;
    }

    /**
     * @param maNguoiDoc the maNguoiDoc to set
     */
    public void setMaNguoiDoc(String maNguoiDoc) {
        this.maNguoiDoc = maNguoiDoc;
    }

    /**
     * @return the tenNguoiDoc
     */
    public String getTenNguoiDoc() {
        return tenNguoiDoc;
    }

    /**
     * @param tenNguoiDoc the tenNguoiDoc to set
     */
    public void setTenNguoiDoc(String tenNguoiDoc) {
        this.tenNguoiDoc = tenNguoiDoc;
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
     * @return the ngayMuon
     */
    public String getNgayMuon() {
        return ngayMuon;
    }

    /**
     * @param ngayMuon the ngayMuon to set
     */
    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    /**
     * @return the ngayTra
     */
    public String getNgayTra() {
        return ngayTra;
    }

    /**
     * @param ngayTra the ngayTra to set
     */
    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }
    
}
