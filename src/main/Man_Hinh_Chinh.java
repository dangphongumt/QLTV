/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.rowset.internal.Row;
import database.dataMan_hinh_chinh;
import static database.dataMan_hinh_chinh.ps;
import database.dataNhan_Vien;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;
import javax.swing.table.DefaultTableModel;
import mo_hinh.Connec;
import static mo_hinh.Connec.getConnection;
import mo_hinh.muonTra;
import mo_hinh.nguoi_doc;
import mo_hinh.nhan_vien;
import mo_hinh.sach;

/**
 *
 * @author Dang Phong
 */
public class Man_Hinh_Chinh extends javax.swing.JFrame {

    /**
     * Creates new form Man_Hinh_Chinh
     */
    public static PreparedStatement ps;
    private static String userName;
    private static String passWord;
    public static ResultSet rs;
    DefaultTableModel MD;

    private ArrayList<sach> listSach;
    private ArrayList<muonTra> listMT;
    private ArrayList<nguoi_doc> listNguoidoc;
 

    public String showTinhTrangSach(boolean t) {
        if (t) {
            return "Có thể cho mượn";
        } else {
            return "Không thể cho mượn";
        }
    }

    public boolean kiemTraMa(ArrayList<sach> listSach, String masach) {
        for (int i = 0; i < listSach.size(); i++) {
            if (listSach.get(i).getMaSach().equals(masach)) {
                return true;
            }
        }
        return false;
    }
    int j = 0;

    public void loadData() {
        Vector Title = new Vector();
        Title.addElement("Mã sách");
        Title.addElement("Tên sách");
        Title.addElement("Loại sách");
        Title.addElement("Tác giả");
        Title.addElement("Nhà xuất bản");
        Title.addElement("Tinh trạng");
        //Load record from database to Jtable 
        DefaultTableModel defaut = new DefaultTableModel(Title, 0);
        jTable1.setModel(defaut);
        try {
            String sql = "SELECT * FROM Sach";
            Statement sttm = Connec.getConnection().createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            while (rs.next()) {
                Vector Row = new Vector();
                Row.addElement(rs.getString("Masach"));

                Row.addElement(rs.getString("Tensach"));
                Row.addElement(rs.getString("Loaisach"));
                Row.addElement(rs.getString("Tacgia"));
                Row.addElement(rs.getString("Nhaxuatban"));
                Row.addElement(showTinhTrangSach(rs.getBoolean("Tinhtrang")));
                defaut.addRow(Row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
            e.printStackTrace();
        }
    }
    public void loadDataDG() {
        Vector Title = new Vector();
        Title.addElement("Mã đọc giả");
        Title.addElement("Họ và tên");
        Title.addElement("Ngày sinh");
        Title.addElement("Địa chỉ");
        Title.addElement("Nghề nghiệp");
        Title.addElement("SĐT");
        DefaultTableModel defaut = new DefaultTableModel(Title, 0);
        jTable3.setModel(defaut);
        try {
            String sql = "SELECT * FROM docgia";
            Statement sttm = Connec.getConnection().createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            while (rs.next()) {
                Vector Row = new Vector();
                Row.addElement(rs.getString("Madocgia"));

                Row.addElement(rs.getString("Tendocgia"));
                Row.addElement(rs.getString("Ngaysinh"));
                Row.addElement(rs.getString("Diachi"));
                Row.addElement(rs.getString("Nghenghiep"));
                Row.addElement(rs.getString("SDT"));
                defaut.addRow(Row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
            e.printStackTrace();
        }

    }
    public void loadDataMT() {
        Vector Title = new Vector();
        Title.addElement("Mã phiếu mượn");
        Title.addElement("Mã người đọc");
        Title.addElement("Tên người đọc");
        Title.addElement("Mã sách");
        Title.addElement("Tên sách");
        Title.addElement("Ngày mượn");
        Title.addElement("Ngày trả");
        DefaultTableModel defaut = new DefaultTableModel(Title, 0);
        jTable2.setModel(defaut);
        try {
            String sql = "SELECT * FROM DSmuon";
            Statement sttm = Connec.getConnection().createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            while (rs.next()) {
                Vector Row = new Vector();
                Row.addElement(rs.getString("MaPhieu"));

                Row.addElement(rs.getString("MaNgdoc"));
                Row.addElement(rs.getString("TenNgdoc"));
                Row.addElement(rs.getString("Masach"));
                Row.addElement(rs.getString("TenSach"));
                Row.addElement(rs.getString("Ngaymuon"));
                Row.addElement(rs.getString("Ngaytra"));
                defaut.addRow(Row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
            e.printStackTrace();
        }

    }
    public Man_Hinh_Chinh() {
        initComponents();
        loadData();
        loadDataDG();
        loadDataMT();
        listSach = new dataMan_hinh_chinh().getListSach();
        listNguoidoc = new dataMan_hinh_chinh().getListNguoidoc();
        listMT=new dataMan_hinh_chinh().getListMuonTra();
        

    }

    public boolean Kiemtrama(ArrayList<nguoi_doc> listNguoidoc, String ma) {
        for (int i = 0; i < listNguoidoc.size(); i++) {
            if (listNguoidoc.get(i).getMadocgia().equals(ma)) {
                return true;
            }
        }
        return false;
    }
    private DefaultTableModel model1;
    int i = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        TAB = new javax.swing.JTabbedPane();
        pnTrangChu = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTextField14 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnDangXuatNV = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnQuayVeNV = new javax.swing.JButton();
        btnMuonSach = new javax.swing.JButton();
        btnTraSach = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtMaNgDocTC = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtMSachTC = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtMaPhieu = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtNgayMuon = new javax.swing.JTextField();
        btnThongKeQuaHan = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtNgayTra = new javax.swing.JTextField();
        pnSach = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoaSach = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLoaiSach = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNXB = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        btnDSSach = new javax.swing.JButton();
        pnNguoiDoc = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        themdocgia = new javax.swing.JButton();
        SuaDG = new javax.swing.JButton();
        XoaDG = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tendocgia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        madocgia = new javax.swing.JTextField();
        ngaysinh = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        diachi = new javax.swing.JTextField();
        nghenghiep = new javax.swing.JTextField();
        sdt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btnDSdocgia = new javax.swing.JButton();
        Timnguoi = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí thư viện");

        TAB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TAB.setName("mmmmm"); // NOI18N

        pnTrangChu.setBackground(new java.awt.Color(204, 255, 255));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        jTextField14.setBackground(new java.awt.Color(153, 204, 255));
        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("Tên Nhân Viên");

        jTextField15.setBackground(new java.awt.Color(153, 204, 255));
        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("Mã Nhân Viên");

        jTextField16.setBackground(new java.awt.Color(153, 204, 255));
        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("Ngày");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/nhanvien.png"))); // NOI18N
        jLabel23.setText("Thông tin nhân viên:");

        btnDangXuatNV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDangXuatNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ĐĂNG XUẤT.png"))); // NOI18N
        btnDangXuatNV.setText("ĐĂNG XUẤT");
        btnDangXuatNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatNVActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Đổi mật khẩu !");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        btnQuayVeNV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnQuayVeNV.setText(" Quản Lý Nhân Viên");
        btnQuayVeNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayVeNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(btnQuayVeNV)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addComponent(jLabel15)))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnDangXuatNV)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField16, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(24, 24, 24))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(btnQuayVeNV))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(24, 24, 24)
                .addComponent(btnDangXuatNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnMuonSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMuonSach.setForeground(new java.awt.Color(102, 0, 102));
        btnMuonSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MUON.png"))); // NOI18N
        btnMuonSach.setText("Mượn sách");
        btnMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonSachActionPerformed(evt);
            }
        });

        btnTraSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTraSach.setForeground(new java.awt.Color(102, 0, 102));
        btnTraSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MUON.png"))); // NOI18N
        btnTraSach.setText("Trả sách");
        btnTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraSachActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Mượn", "Mã Người Đọc", "Tên Người Đọc", "Mã Sách", "Tên Sách", "Ngày Mượn", "Ngày Trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Danh sách mượn:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Mã người đọc:");

        txtMaNgDocTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNgDocTCActionPerformed(evt);
            }
        });
        txtMaNgDocTC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaNgDocTCKeyPressed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Mã sách:");

        txtMSachTC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMSachTCKeyPressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Mã phiếu mượn:");

        txtMaPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhieuActionPerformed(evt);
            }
        });
        txtMaPhieu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaPhieuKeyPressed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Ngày mượn:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Hạn trả:");

        txtNgayMuon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNgayMuonKeyPressed(evt);
            }
        });

        btnThongKeQuaHan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThongKeQuaHan.setForeground(new java.awt.Color(102, 0, 102));
        btnThongKeQuaHan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thongke.png"))); // NOI18N
        btnThongKeQuaHan.setText("Thống kê ");
        btnThongKeQuaHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeQuaHanActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(102, 0, 102));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnTimKiem.setText("Tìm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTrangChuLayout = new javax.swing.GroupLayout(pnTrangChu);
        pnTrangChu.setLayout(pnTrangChuLayout);
        pnTrangChuLayout.setHorizontalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTrangChuLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTrangChuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)))
                .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaNgDocTC)
                        .addComponent(txtMSachTC)
                        .addComponent(txtMaPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                    .addComponent(txtNgayTra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMuonSach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTrangChuLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThongKeQuaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))
                    .addGroup(pnTrangChuLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnTrangChuLayout.setVerticalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTrangChuLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNgDocTC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMSachTC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnTrangChuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThongKeQuaHan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TAB.addTab("TRANG CHỦ", pnTrangChu);

        pnSach.setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(102, 0, 102));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(102, 0, 102));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fix-it-icon.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoaSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoaSach.setForeground(new java.awt.Color(102, 0, 102));
        btnXoaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
        btnXoaSach.setText("Xóa");
        btnXoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSachActionPerformed(evt);
            }
        });

        btnTim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTim.setForeground(new java.awt.Color(102, 0, 102));
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Tên Sách");

        txtTenSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSachActionPerformed(evt);
            }
        });
        txtTenSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenSachKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Mã Sách");

        txtMaSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMaSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaSachKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Loại Sách");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Tác giả");

        txtLoaiSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLoaiSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoaiSachKeyPressed(evt);
            }
        });

        txtTacGia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTacGiaActionPerformed(evt);
            }
        });
        txtTacGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTacGiaKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Nhà Xuất Bản");

        txtNXB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNXBActionPerformed(evt);
            }
        });
        txtNXB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNXBKeyPressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 153));
        jLabel19.setText("Tình trạng");

        jRadioButton1.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton1.setText("Không thể cho mượn");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton2.setText("Có thể cho mượn");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)))))
                .addGap(0, 93, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(23, 23, 23))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Quay lại");

        btnDSSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDSSach.setForeground(new java.awt.Color(102, 0, 102));
        btnDSSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/List.png"))); // NOI18N
        btnDSSach.setText("Danh sách");
        btnDSSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDSSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(416, 416, 416))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnXoaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(btnDSSach)
                .addContainerGap(112, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDSSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnSachLayout = new javax.swing.GroupLayout(pnSach);
        pnSach.setLayout(pnSachLayout);
        pnSachLayout.setHorizontalGroup(
            pnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnSachLayout.setVerticalGroup(
            pnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSachLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TAB.addTab("QUẢN LÝ SÁCH", pnSach);

        pnNguoiDoc.setBackground(new java.awt.Color(204, 204, 255));
        pnNguoiDoc.setPreferredSize(new java.awt.Dimension(1000, 715));

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 682));

        themdocgia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        themdocgia.setForeground(new java.awt.Color(102, 0, 102));
        themdocgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/themdocgia.png"))); // NOI18N
        themdocgia.setText("Thêm");
        themdocgia.setMaximumSize(new java.awt.Dimension(51, 23));
        themdocgia.setMinimumSize(new java.awt.Dimension(51, 23));
        themdocgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themdocgiaActionPerformed(evt);
            }
        });

        SuaDG.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SuaDG.setForeground(new java.awt.Color(102, 0, 102));
        SuaDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fix-it-icon.png"))); // NOI18N
        SuaDG.setText("Sửa");
        SuaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaDGActionPerformed(evt);
            }
        });

        XoaDG.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        XoaDG.setForeground(new java.awt.Color(102, 0, 102));
        XoaDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
        XoaDG.setText("Xóa");
        XoaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaDGActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("Tên Đọc Giả");

        tendocgia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tendocgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tendocgiaActionPerformed(evt);
            }
        });
        tendocgia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tendocgiaKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Mã Đọc Giả");

        madocgia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        madocgia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                madocgiaKeyPressed(evt);
            }
        });

        ngaysinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ngaysinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ngaysinhKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("Ngày sinh");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Địa chỉ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Nghề nghiệp");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 153));
        jLabel17.setText("SĐT");

        diachi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        diachi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                diachiKeyPressed(evt);
            }
        });

        nghenghiep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nghenghiep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nghenghiepActionPerformed(evt);
            }
        });
        nghenghiep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nghenghiepKeyPressed(evt);
            }
        });

        sdt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tendocgia, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(madocgia)
                    .addComponent(ngaysinh))
                .addGap(94, 94, 94)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nghenghiep, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tendocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(madocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nghenghiep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đọc giả", "Họ và tên", "Ngày sinh", "Địa chỉ", "Nghề nghiệp", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnDSdocgia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDSdocgia.setForeground(new java.awt.Color(102, 0, 102));
        btnDSdocgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/List.png"))); // NOI18N
        btnDSdocgia.setText("Danh sách");
        btnDSdocgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDSdocgiaActionPerformed(evt);
            }
        });

        Timnguoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Timnguoi.setForeground(new java.awt.Color(102, 0, 102));
        Timnguoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        Timnguoi.setText("Tìm");
        Timnguoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimnguoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(themdocgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(SuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(XoaDG)
                .addGap(101, 101, 101)
                .addComponent(Timnguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnDSdocgia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themdocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDSdocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Timnguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnNguoiDocLayout = new javax.swing.GroupLayout(pnNguoiDoc);
        pnNguoiDoc.setLayout(pnNguoiDocLayout);
        pnNguoiDocLayout.setHorizontalGroup(
            pnNguoiDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE)
        );
        pnNguoiDocLayout.setVerticalGroup(
            pnNguoiDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 654, Short.MAX_VALUE)
        );

        TAB.addTab("QUẢN LÝ ĐỌC GIẢ", pnNguoiDoc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TAB)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TAB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nghenghiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nghenghiepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nghenghiepActionPerformed

    private void SuaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaDGActionPerformed
        if (madocgia.getText().isEmpty() & tendocgia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chọn đọc giả cần sửa");
        } else {
            nguoi_doc d = new nguoi_doc();
            d.setMadocgia(madocgia.getText());
            d.setTendocgia(tendocgia.getText());
            d.setNgaysinh(ngaysinh.getText());
            d.setDiachi(diachi.getText());
            d.setNghenghiep(nghenghiep.getText());
            d.setSdt(sdt.getText());
            if (new dataMan_hinh_chinh().SuaNguoidoc(d)) {
                JOptionPane.showMessageDialog(null, "Sửa thành công!");
                listNguoidoc.remove(jTable3.getSelectedRow());//cập nhật lại bảng???? 
                MD.removeRow(jTable3.getSelectedRow());
                MD.addRow(new Object[]{
                    d.getMadocgia(), d.getTendocgia(), d.getNgaysinh(), d.getDiachi(), d.getNghenghiep(), d.getSdt()
                });

            } else {
                JOptionPane.showMessageDialog(null, "Sửa không thành công");
            }
        }
    }//GEN-LAST:event_SuaDGActionPerformed

    private void txtNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNXBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNXBActionPerformed

    private void txtTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTacGiaActionPerformed

    private void txtTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSachActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed

        DefaultTableModel model6 = (DefaultTableModel) jTable1.getModel();
        while (model6.getRowCount() > 0) {
        model6.removeRow(0);
        }
        if(txtMaSach.getText().isEmpty()&txtTenSach.getText().isEmpty()&&txtLoaiSach.getText().isEmpty()
           &&jRadioButton1.isSelected()==false&&jRadioButton2.isSelected()==false&&txtTacGia.getText().isEmpty()&&txtNXB.getText().isEmpty()
           )
           JOptionPane.showMessageDialog(rootPane, "Nhập thông tin cần tìm");
        else{
            int tam=1;
            while(tam==1){
                for(int j=0;j<listSach.size();j++)
                    if((txtMaSach.getText().equals(listSach.get(j).getMaSach()))||(txtTenSach.getText().equals(listSach.get(j).getTenSach()))||
                        (txtLoaiSach.getText().equals(listSach.get(j).getLoaiSach()))||(txtNXB.getText().equals(listSach.get(j).getNhaXuatBan()))||
                        (txtTacGia.getText().equals(listSach.get(j).getTacGia()))
                            ||(jRadioButton1.isSelected()==true&listSach.get(j).getTinhTrang()==false)||
                        (jRadioButton2.isSelected()==true&&listSach.get(j).getTinhTrang()==true)){
                            tam=0;
                            model6.addRow(new Object[]{
                            listSach.get(j).getMaSach(),listSach.get(j).getTenSach(),listSach.get(j).getLoaiSach(),listSach.get(j).getTacGia(),
                            listSach.get(j).getNhaXuatBan(),showTinhTrangSach(listSach.get(j).getTinhTrang())});
                        }
                if(tam==0)continue;
                else {JOptionPane.showMessageDialog(rootPane,"không tìm thấy sách");
                tam=0;
                }
        }
            txtMaSach.setText("");
            txtTenSach.setText("");
            txtLoaiSach.setText("");
            txtTacGia.setText("");
            txtNXB.setText("");
            buttonGroup1.clearSelection();
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);        
        }
    }//GEN-LAST:event_btnTimActionPerformed


    private void btnXoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSachActionPerformed
        if (txtMaSach.getText().isEmpty() & txtTenSach.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chọn sách cần xóa");
        } else {
            int tam = 1;
            while (tam == 1) {
                if (tam == 1) {
                    if (new dataMan_hinh_chinh().xoaSach(txtMaSach.getText(), txtTenSach.getText())) {
                        tam = 0;
                        JOptionPane.showMessageDialog(null, "Đã xóa");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sách không tồn tại");
                        tam = 0;
                    }
                }
            }
        }
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtLoaiSach.setText("");
        txtTacGia.setText("");
        txtNXB.setText("");
        buttonGroup1.clearSelection();
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
    }//GEN-LAST:event_btnXoaSachActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (txtMaSach.getText().isEmpty() & txtTenSach.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chọn sách cần sửa");
        } else {
            sach s = new sach();
            s.setMaSach(txtMaSach.getText());
            s.setTenSach(txtTenSach.getText());
            s.setTacGia(txtTacGia.getText());
            s.setLoaiSach(txtLoaiSach.getText());
            s.setNhaXuatBan(txtNXB.getText());
            if (jRadioButton1.isSelected() == true) {
                s.setTinhTrang(false);
            } else {
                s.setTinhTrang(true);
            }
            if (new dataMan_hinh_chinh().SuaSach(s)) {
                JOptionPane.showMessageDialog(null, "Sửa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Sửa không thành công!");
            }

        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThongKeQuaHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeQuaHanActionPerformed
        Thongkequahan TK = new Thongkequahan();
        //   dispose();//???
        TK.setLocationRelativeTo(null);
        TK.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeQuaHanActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        sach s = new sach();
        int t = 0;
        String tam;
        s.setMaSach(txtMaSach.getText());
        s.setTenSach(txtTenSach.getText());
        s.setTacGia(txtTacGia.getText());
        s.setNhaXuatBan(txtNXB.getText());
        s.setLoaiSach(txtLoaiSach.getText());
        if (jRadioButton2.isSelected()) {
            s.setTinhTrang(true);
        } else {
            s.setTinhTrang(false);
        }
        if (t == 0) {
            do {
                if (s.getTenSach().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Tên sách không được để trống!");
                    txtTenSach.requestFocus();
                    break;
                } else if (s.getMaSach().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Mã Sách không được để trống!");
                    txtMaSach.requestFocus();
                    break;
                } else if (s.getLoaiSach().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Loại sách không được để trống!");
                    txtLoaiSach.requestFocus();
                    break;
                } else if (s.getTacGia().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Tác giả không được để trống!");
                    txtTacGia.requestFocus();
                    break;
                } else if (s.getNhaXuatBan().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nhà xuất bản không được để trống!");
                    txtNXB.requestFocus();
                    break;
                } else if ((!jRadioButton1.isSelected() && !jRadioButton2.isSelected())) {
                    JOptionPane.showMessageDialog(this, "Chọn tình trạng sách");
                    jRadioButton1.requestFocus();
                    break;
                } else {
                    t = 1;
                }

            } while (t == 0);
        }
        if (t == 1) {
            if (kiemTraMa(listSach, s.getMaSach())) {
                JOptionPane.showMessageDialog(this, "Mã sách bị trùng");
            } else {
                if (new dataMan_hinh_chinh().addSach(s)) {
                    listSach.add(s);
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "khong thanh cong");
                }
                loadData();
                txtMaSach.setText("");
                txtTenSach.setText("");
                txtLoaiSach.setText("");
                txtTacGia.setText("");
                txtNXB.setText("");
                buttonGroup1.clearSelection();
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(false);
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void txtMaNgDocTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNgDocTCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNgDocTCActionPerformed

    private void themdocgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themdocgiaActionPerformed
//        nguoi_doc d=new nguoi_doc();
//        d.setMadocgia(madocgia.getText());
//        d.setTendocgia(tendocgia.getText());
//        d.setNgaysinh(ngaysinh.getText());
//        d.setDiachi(diachi.getText());
//        d.setNghenghiep(nghenghiep.getText());
//        d.setSdt(sdt.getText());
//       
//        if(Kiemtrama(listNguoidoc,d.getMadocgia()))
//           JOptionPane.showMessageDialog(this, "Mã ID bị trùng");
//        else {listNguoidoc.add(d);
//        model1=(DefaultTableModel) jTable1.getModel();
//            
//            model1.addRow(new Object[]{
//                j++,d.getMadocgia(),d.getTendocgia(),d.getNgaysinh(),d.getDiachi(),d.getNghenghiep(),d.getSdt()
//            });}
        nguoi_doc d = new nguoi_doc();

        int t = 0;
        String tam;

        d.setMadocgia(madocgia.getText());
        d.setTendocgia(tendocgia.getText());
        d.setNgaysinh(ngaysinh.getText());
        d.setDiachi(diachi.getText());
        d.setNghenghiep(nghenghiep.getText());
        d.setSdt(sdt.getText());
        if (t == 0) {
            do {
                if (d.getTendocgia().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Tên độc giả không được để trống!");
                    tendocgia.requestFocus();
                    break;
                } else if (d.getMadocgia().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Mã độc giả không được để trống!");
                    madocgia.requestFocus();
                    break;
                } else if (d.getNgaysinh().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống!");
                    ngaysinh.requestFocus();
                    break;
                } else if (d.getDiachi().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!");
                    diachi.requestFocus();
                    break;
                } else if (d.getNghenghiep().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nghề nghiệp không được để trống!");
                    nghenghiep.requestFocus();
                    break;
                } else if (d.getSdt().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "SDT không được để trống!");
                    sdt.requestFocus();
                    break;
                } else {
                    t = 1;
                }

            } while (t == 0);
        }
        if (t == 1) {
            if (Kiemtrama(listNguoidoc, d.getMadocgia())) {
                JOptionPane.showMessageDialog(this, "Mã độc giả bị trùng");
            } else {
                if (new dataMan_hinh_chinh().addDocgia(d)) {
                    listNguoidoc.add(d);
                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Không thành công!");
                }
                loadDataDG();
                madocgia.setText("");
                tendocgia.setText("");
                ngaysinh.setText("");
                diachi.setText("");
                nghenghiep.setText("");
                sdt.setText("");
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_themdocgiaActionPerformed

    private void tendocgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tendocgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tendocgiaActionPerformed

    private void btnDangXuatNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatNVActionPerformed
        DANG_NHAP DN = new DANG_NHAP();
        dispose();//???
        DN.setLocationRelativeTo(null);
        DN.setVisible(true);
    }//GEN-LAST:event_btnDangXuatNVActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void btnDSSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDSSachActionPerformed
        // TODO add your handling code here:
        buttonGroup1.clearSelection();
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtLoaiSach.setText("");
        txtTacGia.setText("");
        txtNXB.setText("");
        loadData();
//        DefaultTableModel model3;
//        model3=(DefaultTableModel) jTable1.getModel();
//        while (model3.getRowCount() > 0) {
//            model3.removeRow(0);
//            i=1;
//        }
//        for(int i=0;i<listSach.size();i++){if(true){
//            model3.addRow(new Object[]{
//                this.i++,listSach.get(i).getMaSach(),listSach.get(i).getTenSach(),listSach.get(i).getTacGia(),
//                showTinhTrangSach(listSach.get(i).getTinhTrang()),listSach.get(i).getLoaiSach(),listSach.get(i).getNhaXuatBan()
//            });
//        }}
    }//GEN-LAST:event_btnDSSachActionPerformed

    private void txtTenSachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenSachKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMaSach.requestFocus();
        }
    }//GEN-LAST:event_txtTenSachKeyPressed

    private void txtMaSachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSachKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtLoaiSach.requestFocus();
        }
    }//GEN-LAST:event_txtMaSachKeyPressed

    private void txtLoaiSachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoaiSachKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTacGia.requestFocus();
        }
    }//GEN-LAST:event_txtLoaiSachKeyPressed

    private void txtTacGiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTacGiaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNXB.requestFocus();
        }
    }//GEN-LAST:event_txtTacGiaKeyPressed

    private void txtNXBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNXBKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jRadioButton1.requestFocus();
        }
    }//GEN-LAST:event_txtNXBKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model4;
        model4 = (DefaultTableModel) jTable1.getModel();
        int index = jTable1.getSelectedRow();
        txtMaSach.setText((String) (model4.getValueAt(index, 0)));
        txtTenSach.setText((String) (model4.getValueAt(index, 1)));
        txtTacGia.setText((String) (model4.getValueAt(index, 3)));
        txtLoaiSach.setText((String) (model4.getValueAt(index, 2)));
        txtNXB.setText((String) (model4.getValueAt(index, 4)));
        if ((model4.getValueAt(index, 5)).equals("Có thể cho mượn")) {
            jRadioButton2.setSelected(true);
        } else {
            jRadioButton1.setSelected(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnDSdocgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDSdocgiaActionPerformed

        madocgia.setText("");
        tendocgia.setText("");
        ngaysinh.setText("");
        diachi.setText("");
        nghenghiep.setText("");
        sdt.setText("");
        loadDataDG();
    }//GEN-LAST:event_btnDSdocgiaActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        DefaultTableModel model4;
        model4 = (DefaultTableModel) jTable3.getModel();
        int index = jTable3.getSelectedRow();
        madocgia.setText((String) (model4.getValueAt(index, 0)));
        tendocgia.setText((String) (model4.getValueAt(index, 1)));
        ngaysinh.setText((String) (model4.getValueAt(index, 2)));
        diachi.setText((String) (model4.getValueAt(index, 3)));
        nghenghiep.setText((String) (model4.getValueAt(index, 4)));
        sdt.setText((String) (model4.getValueAt(index, 4)));
    }//GEN-LAST:event_jTable3MouseClicked

    private void XoaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaDGActionPerformed
        if (madocgia.getText().isEmpty() & tendocgia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chọn đọc giả cần xóa");
        } else {
            int tam = 1;
            while (tam == 1) {
                if (tam == 1) {
                    if (new dataMan_hinh_chinh().xoaNguoidoc(madocgia.getText())) {
                        tam = 0;
                        JOptionPane.showMessageDialog(null, "Đã xóa");
                    } else {
                        JOptionPane.showMessageDialog(null, "Đọc giả không tồn tại");
                        tam = 0;
                    }
                }
            }
        }

        madocgia.setText("");
        tendocgia.setText("");
        ngaysinh.setText("");
        diachi.setText("");
        nghenghiep.setText("");
        sdt.setText("");
    }//GEN-LAST:event_XoaDGActionPerformed

    private void tendocgiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tendocgiaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            madocgia.requestFocus();
        }
    }//GEN-LAST:event_tendocgiaKeyPressed

    private void madocgiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_madocgiaKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ngaysinh.requestFocus();
        }
    }//GEN-LAST:event_madocgiaKeyPressed

    private void ngaysinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ngaysinhKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            diachi.requestFocus();
        }
    }//GEN-LAST:event_ngaysinhKeyPressed

    private void diachiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diachiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            nghenghiep.requestFocus();
        }
    }//GEN-LAST:event_diachiKeyPressed

    private void nghenghiepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nghenghiepKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            sdt.requestFocus();
        }
    }//GEN-LAST:event_nghenghiepKeyPressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        matkhau mk = new matkhau();
        dispose();//???
        mk.setLocationRelativeTo(null);
        mk.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnQuayVeNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayVeNVActionPerformed
        Quanlynhanvien QLNV = new Quanlynhanvien();

        DANG_NHAP DN = new DANG_NHAP();
        // if(str1.isEmpty() || str2.isEmpty())

        //  System.out.println("tên: "+str1+ str2);
        nhan_vien nv= new dataNhan_Vien().dangNhap(userName, passWord);
        // JOptionPane.showMessageDialog(null, userName+"    "+passWord);
        if((userName.equals("ADMIN")|| userName.equals("admin")) && passWord.equals("1234")){

            QLNV.setLocationRelativeTo(null);
            QLNV.setVisible(true);
            dispose();

        }else{
            JOptionPane.showMessageDialog(null, "Bạn Phải là ADMIN");
        }
    }//GEN-LAST:event_btnQuayVeNVActionPerformed

    private void TimnguoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimnguoiActionPerformed
        DefaultTableModel model7 = (DefaultTableModel) jTable3.getModel();
        while (model7.getRowCount() > 0) {
            model7.removeRow(0);
        }
        if(tendocgia.getText().isEmpty()&&madocgia.getText().isEmpty()&&ngaysinh.getText().isEmpty()
            &&nghenghiep.getText().isEmpty()&&diachi.getText().isEmpty()&&sdt.getText().isEmpty()
        )
        JOptionPane.showMessageDialog(rootPane, "Nhập thông tin cần tìm");
        else{
            int tam=1;
            while(tam==1){
                for(int j=0;j<listNguoidoc.size();j++)
                if(madocgia.getText().equals(listNguoidoc.get(j).getMadocgia()) ||(tendocgia.getText().equals(listNguoidoc.get(j).getTendocgia()))||
                    (ngaysinh.getText().equals(listNguoidoc.get(j).getNgaysinh()))||(diachi.getText().equals(listNguoidoc.get(j).getDiachi()))||
                    (nghenghiep.getText().equals(listNguoidoc.get(j).getNghenghiep()))||(sdt.getText().equals(listNguoidoc.get(j).getSdt())))
                {
                    tam=0;
                    model7.addRow(new Object[]{
                        listNguoidoc.get(j).getMadocgia(),listNguoidoc.get(j).getTendocgia(),listNguoidoc.get(j).getNgaysinh(),
                        listNguoidoc.get(j).getDiachi(),listNguoidoc.get(j).getNghenghiep(),listNguoidoc.get(j).getSdt()});
            }
            if(tam==0)continue;
            else {JOptionPane.showMessageDialog(rootPane,"không tìm thấy");
                tam=0;
            }
        }

        madocgia.setText("");
        tendocgia.setText("");
        ngaysinh.setText("");
        diachi.setText("");
        nghenghiep.setText("");
        sdt.setText("");

        }

    }//GEN-LAST:event_TimnguoiActionPerformed

    private void txtMaPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuActionPerformed
        
    }//GEN-LAST:event_txtMaPhieuActionPerformed

    private void txtMaPhieuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaPhieuKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMaNgDocTC.requestFocus();
        }
    }//GEN-LAST:event_txtMaPhieuKeyPressed

    private void txtMaNgDocTCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaNgDocTCKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMSachTC.requestFocus();
        }
    }//GEN-LAST:event_txtMaNgDocTCKeyPressed

    private void txtNgayMuonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNgayMuonKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNgayTra.requestFocus();
        }
    }//GEN-LAST:event_txtNgayMuonKeyPressed

    private void btnMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuonSachActionPerformed
        muonTra m=new muonTra();
        m.setMaPheuMuon(txtMaPhieu.getText());
        m.setMaNguoiDoc(txtMaNgDocTC.getText());
        m.setMaSach(txtMSachTC.getText());
        m.setNgayMuon(txtNgayMuon.getText());
        m.setNgayTra(txtNgayTra.getText());
        m.setTenNguoiDoc("");
        m.setTenSach("");
        boolean tt = false;
        int n = 0;
        int tam=0;
        while(tam==0){ 
        for(int i=0;i<listNguoidoc.size();i++){
            if(m.getMaNguoiDoc().trim().equals(listNguoidoc.get(i).getMadocgia().trim())){
            m.setTenNguoiDoc(listNguoidoc.get(i).getTendocgia());
            }
        }
        
        for(int i=0;i<listSach.size();i++){
            if(m.getMaSach().equals(listSach.get(i).getMaSach())){
            m.setTenSach(listSach.get(i).getTenSach());
            tt=listSach.get(i).getTinhTrang();
            n=i;
            }
        }
        
        if(m.getTenNguoiDoc().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Mã người đọc không tồn tại");
            txtMaNgDocTC.requestFocus();
            break;
        }
        if(m.getTenSach().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Mã sách không tồn tại");
            txtMSachTC.requestFocus();
            break;
        }else
           if(tt==false){
               JOptionPane.showMessageDialog(rootPane, "Sách không thể cho mượn");
               break;
           }
        else 
        
        
        if(txtMaPhieu.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Nhập mã phiếu mượn");
            txtMaPhieu.requestFocus();
        }else
            if(txtMaNgDocTC.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane,"Nhập mã người đọc");
                txtMaNgDocTC.requestFocus();
            }else
                if(txtMSachTC.getText().isEmpty()){
                    JOptionPane.showMessageDialog(rootPane,"Nhập mã sách");
                    txtMSachTC.requestFocus();
                }else
                    if(txtNgayMuon.getText().isEmpty()){
                        JOptionPane.showMessageDialog(rootPane,"Nhập ngày mượn");
                        txtMSachTC.requestFocus();
                    }else
                        if(txtNgayTra.getText().isEmpty()){
                            JOptionPane.showMessageDialog(rootPane,"Nhập ngày trả");
                            txtNgayTra.requestFocus();  
                        }else tam=1;
        }
        
        if (new dataMan_hinh_chinh().addMuonTra(m)) {
            
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    listSach.get(n).setTinhTrang(false);
                    DefaultTableModel modell=(DefaultTableModel) jTable2.getModel();
                    modell.addRow(new Object[]{
                        m.getMaPheuMuon(),m.getMaNguoiDoc(),m.getTenNguoiDoc(),m.getMaSach(),m.getTenSach(),m.getNgayMuon(),m.getNgayTra()
                    });
                    txtMaPhieu.setText("");
                    txtMaNgDocTC.setText("");
                    txtMSachTC.setText("");
                    txtNgayMuon.setText("");
                    txtNgayTra.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Thêm không thành công");
                }
    }//GEN-LAST:event_btnMuonSachActionPerformed

    private void txtMSachTCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMSachTCKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNgayMuon.requestFocus();
        }
    }//GEN-LAST:event_txtMSachTCKeyPressed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
    DefaultTableModel model6 = (DefaultTableModel) jTable2.getModel();
        while (model6.getRowCount() > 0) {
        model6.removeRow(0);
        }
        if(txtMaPhieu.getText().isEmpty() )
           JOptionPane.showMessageDialog(rootPane, "Nhập thông tin cần tìm");
        else{
            int tam=1;
            while(tam==1){
                for(int j=0;j<listSach.size();j++)
                    if(txtMaPhieu.getText().equals(listMT.get(j).getMaPheuMuon())){
                            tam=0;
                            model6.addRow(new Object[]{
                                listMT.get(j).getMaPheuMuon(),listMT.get(j).getMaNguoiDoc(),listMT.get(j).getTenNguoiDoc(),listMT.get(j).getMaSach(),
                                listMT.get(j).getTenSach(),listMT.get(j).getNgayMuon(),listMT.get(j).getNgayTra(),
                            });
                        }
                if(tam==0)continue;
                else {JOptionPane.showMessageDialog(rootPane,"không tìm thấy thông tin");
                tam=0;
                }
        }
            txtMaSach.setText("");
            txtTenSach.setText("");
            txtLoaiSach.setText("");
            txtTacGia.setText("");
            txtNXB.setText("");
            buttonGroup1.clearSelection();
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);        
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        DefaultTableModel model4;
        model4 = (DefaultTableModel) jTable2.getModel();
        int index = jTable2.getSelectedRow();
        txtMaPhieu.setText((String) (model4.getValueAt(index, 0)));
        txtMaNgDocTC.setText((String) (model4.getValueAt(index, 1)));
        txtMSachTC.setText((String) (model4.getValueAt(index, 3)));
        txtNgayMuon.setText((String) (model4.getValueAt(index, 5)));
        txtNgayTra.setText((String) (model4.getValueAt(index, 6)));
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnTraSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraSachActionPerformed
        if (txtMaPhieu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nhập thông tin mượn trả");
        } else {
            int tam = 1;
            while (tam == 1) {
                if (tam == 1) {
                    if (new dataMan_hinh_chinh().xoaMT(txtMaPhieu.getText())) {
                        tam = 0;
                        JOptionPane.showMessageDialog(null, "Đã xóa");
                        loadDataMT();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sách không tồn tại");
                        tam = 0;
                    }
                }
            }
        }
    }//GEN-LAST:event_btnTraSachActionPerformed
    
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
            java.util.logging.Logger.getLogger(Man_Hinh_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Man_Hinh_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Man_Hinh_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Man_Hinh_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Man_Hinh_Chinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SuaDG;
    private javax.swing.JTabbedPane TAB;
    private javax.swing.JButton Timnguoi;
    private javax.swing.JButton XoaDG;
    private javax.swing.JButton btnDSSach;
    private javax.swing.JButton btnDSdocgia;
    private javax.swing.JButton btnDangXuatNV;
    private javax.swing.JButton btnMuonSach;
    private javax.swing.JButton btnQuayVeNV;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThongKeQuaHan;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTraSach;
    private javax.swing.JButton btnXoaSach;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JTextField diachi;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField madocgia;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JTextField ngaysinh;
    private javax.swing.JTextField nghenghiep;
    private javax.swing.JPanel pnNguoiDoc;
    private javax.swing.JPanel pnSach;
    private javax.swing.JPanel pnTrangChu;
    private javax.swing.JTextField sdt;
    private javax.swing.JTextField tendocgia;
    private javax.swing.JButton themdocgia;
    private javax.swing.JTextField txtLoaiSach;
    private javax.swing.JTextField txtMSachTC;
    private javax.swing.JTextField txtMaNgDocTC;
    private javax.swing.JTextField txtMaPhieu;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
