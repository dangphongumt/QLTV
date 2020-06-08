/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.dataNhan_Vien;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mo_hinh.Connec;
import mo_hinh.nhan_vien;

/**
 *
 * @author Thảo Vy
 */
public class Quanlynhanvien extends javax.swing.JFrame {

    //nhan_vien NVIEN = new nhan_vien();
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    //Connection cnn=null;
   private ArrayList<nhan_vien> listNV;
    DefaultTableModel MD;
    public Quanlynhanvien() {
        Connec cnn=null;
        dataNhan_Vien nv;
        //listNV = new ArrayList<>();
        initComponents();
        listNV = dataNhan_Vien.getnvien();
        MD = (DefaultTableModel) tbNhanVien.getModel();
        MD.setColumnIdentifiers(new Object[]{
            "MaNV","TenNV", "NgSinh","DiaChi","SDT","TenDN"
        });
        showNvien();//hien thi thong tin nhan vien tu SQL
    }
   
    public void showNvien(){//khi mở jFrame thì show
        
        for(nhan_vien nv : listNV){
            MD.addRow(new Object[]{
                nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getNgaySinh(),nv.getDiaChi(),nv.getSoDienThoai(),
                nv.getTenDangNhap()
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDiaChiNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgSinhNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenDN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        btnTimNV = new javax.swing.JButton();
        btnDiChuyenTrangChu = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên:");

        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });
        txtMaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaNVKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaNVKeyReleased(evt);
            }
        });

        txtTenNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenNVKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tên nhân viên:");

        txtDiaChiNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiNVActionPerformed(evt);
            }
        });
        txtDiaChiNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDiaChiNVKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Địa chỉ:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ngày sinh:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("SĐT:");

        txtNgSinhNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNgSinhNVKeyPressed(evt);
            }
        });

        txtSDTNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSDTNVKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tên đăng nhập:");

        txtTenDN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenDNKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(txtMaNV)
                    .addComponent(txtNgSinhNV))
                .addGap(105, 105, 105)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtSDTNV, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                        .addComponent(txtTenDN))
                    .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addComponent(txtTenDN, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNgSinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Quản lý nhân viên:");

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/CỘNG.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSuaNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSuaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fix-it-icon.png"))); // NOI18N
        btnSuaNV.setText("Sửa");
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnXoaNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
        btnXoaNV.setText("Xóa");
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        btnTimNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnTimNV.setText("Tìm");
        btnTimNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimNVActionPerformed(evt);
            }
        });

        btnDiChuyenTrangChu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDiChuyenTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/page-next-icon.png"))); // NOI18N
        btnDiChuyenTrangChu.setText("Di chuyển qua trang chủ");
        btnDiChuyenTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiChuyenTrangChuActionPerformed(evt);
            }
        });

        btnDangXuat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ĐĂNG XUẤT.png"))); // NOI18N
        btnDangXuat.setText("ĐĂNG XUẤT");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Địa chỉ", "SĐT", "Tên đăng nhập"
            }
        ));
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhanVien);
        if (tbNhanVien.getColumnModel().getColumnCount() > 0) {
            tbNhanVien.getColumnModel().getColumn(4).setResizable(false);
            tbNhanVien.getColumnModel().getColumn(5).setResizable(false);
        }

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnXoaNV)
                .addGap(58, 58, 58)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnSuaNV)
                .addGap(52, 52, 52)
                .addComponent(btnTimNV, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDangXuat)
                .addGap(66, 66, 66)
                .addComponent(btnDiChuyenTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDiChuyenTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimNV, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int i=1;
    public void showThongTin(){
        nhan_vien S= listNV.get(listNV.size()-1);
        MD.addRow(new Object[]{
         S.getMaNhanVien(),S.getTenNhanVien(), S.getNgaySinh(), S.getDiaChi(), S.getSoDienThoai(),S.getTenDangNhap()
        });
    }
    private void btnDiChuyenTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiChuyenTrangChuActionPerformed
          Man_Hinh_Chinh man_hinh = new Man_Hinh_Chinh();
        dispose();//???
        man_hinh.setLocationRelativeTo(null);
        man_hinh.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDiChuyenTrangChuActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        DANG_NHAP DN = new DANG_NHAP();
        dispose();//???
        DN.setLocationRelativeTo(null);
        DN.setVisible(true);
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       nhan_vien nv = new nhan_vien();
       nv.setMaNhanVien(txtMaNV.getText());
       nv.setTenNhanVien(txtTenNV.getText());
       nv.setNgaySinh(txtNgSinhNV.getText());
       nv.setDiaChi(txtDiaChiNV.getText());
       nv.setSoDienThoai(txtSDTNV.getText());
       nv.setTenDangNhap(txtTenDN.getText());
       
       if(new dataNhan_Vien().addNV(nv)){
           JOptionPane.showMessageDialog(null, "Thêm Nhân Viên thành công!");
           listNV.add(nv);
           txtMaNV.setText("");//xóa dữliệu trong textfeil
           txtTenNV.setText("");
           txtNgSinhNV.setText("");
           txtDiaChiNV.setText("");
           txtSDTNV.setText("");
           txtTenDN.setText("");
       }else {
           JOptionPane.showMessageDialog(null, "Thêm KHÔNG  thành công");
       }
     
       showThongTin();//show khi thêm()
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTenNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenNVKeyPressed
           if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    txtMaNV.requestFocus();
                }
    }//GEN-LAST:event_txtTenNVKeyPressed

    private void txtMaNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaNVKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVKeyReleased

    private void txtMaNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaNVKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    txtNgSinhNV.requestFocus();
                }
    }//GEN-LAST:event_txtMaNVKeyPressed

    private void txtNgSinhNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNgSinhNVKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                   txtDiaChiNV.requestFocus();
                }
    }//GEN-LAST:event_txtNgSinhNVKeyPressed

    private void txtDiaChiNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaChiNVKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                   txtSDTNV.requestFocus();
                }
    }//GEN-LAST:event_txtDiaChiNVKeyPressed

    private void txtSDTNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTNVKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                   txtTenDN.requestFocus();
                }
    }//GEN-LAST:event_txtSDTNVKeyPressed

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void txtTenDNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenDNKeyPressed
        
                
    }//GEN-LAST:event_txtTenDNKeyPressed

    private void txtDiaChiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiNVActionPerformed

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        if(new dataNhan_Vien().deleteNV(txtMaNV.getText())){
                System.out.println("Xóa Nhân Viên thành công! ");
                listNV.remove(tbNhanVien.getSelectedRow());//cập nhật lại bảng
                MD.removeRow(tbNhanVien.getSelectedRow());
                txtMaNV.setText("");//xóa dữliệu trong textfeil
                 txtTenNV.setText("");
                 txtNgSinhNV.setText("");
                txtDiaChiNV.setText("");
                txtSDTNV.setText("");
                txtTenDN.setText("");
                
            }else 
                System.err.println("Xóa KHÔNG thành công");
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtMaNV.setText("");//xóa dữliệu trong textfeil
        txtTenNV.setText("");
        txtNgSinhNV.setText("");
        txtDiaChiNV.setText("");
        txtSDTNV.setText("");
        txtTenDN.setText("");
        while(MD.getRowCount()>0){
            MD.removeRow(0);
        }
        showNvien();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
      txtMaNV.setText(MD.getValueAt(tbNhanVien.getSelectedRow(),0).toString());
                txtTenNV.setText(MD.getValueAt(tbNhanVien.getSelectedRow(),1).toString());
                txtNgSinhNV.setText(MD.getValueAt(tbNhanVien.getSelectedRow(), 2).toString());
                txtDiaChiNV.setText(MD.getValueAt(tbNhanVien.getSelectedRow(), 3).toString());
                txtSDTNV.setText(MD.getValueAt(tbNhanVien.getSelectedRow(),4 ).toString());
                txtTenDN.setText(MD.getValueAt(tbNhanVien.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        nhan_vien nv =new nhan_vien();
        nv.setTenNhanVien(txtTenNV.getText());
        nv.setMaNhanVien(txtMaNV.getText());
        nv.setNgaySinh(txtNgSinhNV.getText());
        nv.setDiaChi(txtDiaChiNV.getText());
        nv.setSoDienThoai(txtSDTNV.getText());
        nv.setTenDangNhap(txtTenDN.getText());
        if(new dataNhan_Vien().UpdateNV(nv)){
            JOptionPane.showMessageDialog(null, "Sửa thành công!");
             listNV.remove(tbNhanVien.getSelectedRow());//cập nhật lại bảng???? 
               MD.removeRow(tbNhanVien.getSelectedRow());
                MD.addRow(new Object[]{
                    nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(),nv.getDiaChi(),nv.getSoDienThoai(),nv.getTenDangNhap()
                });
                
        }else {
            JOptionPane.showMessageDialog(null, "Sửa KHÔNG thành công");
        }
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnTimNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimNVActionPerformed
         while(MD.getRowCount()>0){
              MD.removeRow(0);
         }
        nhan_vien nv =new nhan_vien();
            nv.setTenNhanVien(txtTenNV.getText());
            nv.setMaNhanVien(txtMaNV.getText());
            nv.setNgaySinh(txtNgSinhNV.getText());
            nv.setDiaChi(txtDiaChiNV.getText());
            nv.setSoDienThoai(txtSDTNV.getText());
            nv.setTenDangNhap(txtTenDN.getText());
            if(txtMaNV.getText().isEmpty()&& txtTenNV.getText().isEmpty()&&txtNgSinhNV.getText().isEmpty()
                    &&txtDiaChiNV.getText().isEmpty()&& txtSDTNV.getText().isEmpty()&&txtTenDN.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Nhập Thông Tin Cần Tìm!!");
            }else{
                int index2=0;
             
                    for(int i=0;i<listNV.size();i++){
                        if(txtMaNV.getText().equals(listNV.get(i).getMaNhanVien())|| txtTenNV.getText().equals(listNV.get(i).getTenNhanVien())||
                            txtNgSinhNV.getText().equals(listNV.get(i).getNgaySinh())|| txtDiaChiNV.getText().equals(listNV.get(i).getDiaChi())||
                            txtSDTNV.getText().equals(listNV.get(i).getSoDienThoai())|| txtTenDN.getText().equals(listNV.get(i).getTenDangNhap()))
                        {
                           // index=0;
                          index2++;
                              MD.addRow(new Object[]{
                          listNV.get(i).getMaNhanVien(),listNV.get(i).getTenNhanVien(),listNV.get(i).getNgaySinh(),listNV.get(i).getDiaChi()
                                    ,listNV.get(i).getSoDienThoai(),listNV.get(i).getTenDangNhap()
                         });
                              
                        }
                            
                    }
                    if(index2==0)
                       JOptionPane.showMessageDialog(null, "Không Có Kết Quả Tìm Thấy");
                
            }
    }//GEN-LAST:event_btnTimNVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quanlynhanvien().setVisible(true);
            }
        });
    }

 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDiChuyenTrangChu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimNV;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgSinhNV;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtTenDN;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
