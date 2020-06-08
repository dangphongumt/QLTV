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
public class nguoi_doc {
    private String tendocgia;
    private String madocgia;
    private String ngaysinh;
    private String nghenghiep;
    private String diachi;
    private String sdt;
    public nguoi_doc ()
    {
        super();
    }
    public nguoi_doc(String tendocgia , String madocgia, String ngaysinh,String ngenghiep, String diachi, String sdt )
    {
        super();
        this.tendocgia = tendocgia;
        this.madocgia = madocgia;
        this.ngaysinh = ngaysinh;
        this.nghenghiep = nghenghiep;
        this.diachi = diachi;
        this.sdt = sdt;
     
    }

    /*
     * @return the tendocgia
     */
    public String getTendocgia() {
        return tendocgia;
    }

    /**
     * @param tendocgia the tendocgia to set
     */
    public void setTendocgia(String tendocgia) {
        this.tendocgia = tendocgia;
    }

    /**
     * @return the madocgia
     */
    public String getMadocgia() {
        return madocgia;
    }

    /**
     * @param madocgia the madocgia to set
     */
    public void setMadocgia(String madocgia) {
        this.madocgia = madocgia;
    }

    /**
     * @return the ngaysinh
     */
    public String getNgaysinh() {
        return ngaysinh;
    }

    /**
     * @param ngaysinh the ngaysinh to set
     */
    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    /**
     * @return the nghenghiep
     */
    public String getNghenghiep() {
        return nghenghiep;
    }

    /**
     * @param nghenghiep the nghenghiep to set
     */
    public void setNghenghiep(String nghenghiep) {
        this.nghenghiep = nghenghiep;
    }

    /**
     * @return the diachi
     */
    public String getDiachi() {
        return diachi;
    }

    /**
     * @param diachi the diachi to set
     */
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

  
}