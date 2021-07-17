package view;

import controller.IOFile;
import entities.KhachHang;
import entities.NganHang;
import entities.SoTietKiem;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    private DefaultTableModel tmKH, tmNH, tmSTK;
    private String fileKH, fileNH, fileSTK;
    private int maKH, maNH;
    private boolean themKH, themNH, themSTK;

    public Main() {
        initComponents();
        initTable();
        fileName();
        loadKH();
        loadNH();
        loadSTK();
        themKH = false;
        themNH = false;
        themSTK = false;
    }

    private void fileName() {
        fileKH = "src/controller/KH.DAT";
        fileNH = "src/controller/NH.DAT";
        fileSTK = "src/controller/STK.DAT";
    }

    private void initTable() {
        String[] cols1 = {"Ma", "Ho ten", "Dia chi",
            "Loai KH"};
        tmKH = new DefaultTableModel(cols1, 0);
        jTable1.setModel(tmKH);

        String[] cols2 = {"Ma", "Ten NH", "Lai suat theo nam"};
        tmNH = new DefaultTableModel(cols2, 0);
        jTable2.setModel(tmNH);

        String[] cols3 = {"Ma KH", "Ten KH", "Ma NH",
            "Ten NH", "So thang gui", "Ngay gui"};
        tmSTK = new DefaultTableModel(cols3, 0);
        jTable3.setModel(tmSTK);
    }

    private void loadKH() {
        File f = new File(fileKH);
        if (f.exists()) {
            List<KhachHang> a = new ArrayList<>();
            IOFile.readFile(a, fileKH);
            tmKH.setRowCount(0);
            for (KhachHang i : a) {
                tmKH.addRow(i.toObject());
            }
        }
    }

    private void loadNH() {
        File f = new File(fileNH);
        if (f.exists()) {
            List<NganHang> a = new ArrayList<>();
            IOFile.readFile(a, fileNH);
            tmNH.setRowCount(0);
            for (NganHang i : a) {
                tmNH.addRow(i.toObject());
            }
        }
    }

    private void loadSTK() {
        File f = new File(fileSTK);
        if (f.exists()) {
            List<SoTietKiem> a = new ArrayList<>();
            IOFile.readFile(a, fileSTK);
            tmSTK.setRowCount(0);
            for (SoTietKiem i : a) {
                int maKH = i.getMaKhachHang();
                String tenKH = getKHByMa(maKH).getHoTen();
                int maNH = i.getMaNganHang();
                String tenNH = getNganHangByMa(maNH).getTenNH();
                int soThangGui = i.getSoThangGui();
                String ngayGui = i.getNgayGui();
                tmSTK.addRow(new Object[]{maKH, tenKH, maNH,
                    tenNH, soThangGui, ngayGui});
            }
        }
    }

    private int getMaKH() {
        return 10000 + tmKH.getRowCount();
    }

    private int getMaNH() {
        return 100 + tmNH.getRowCount();
    }

    private NganHang getNganHangByMa(int ma) {
        for (int i = 0; i < tmNH.getRowCount(); i++) {
            if (Integer.parseInt(tmNH.getValueAt(i, 0).toString()) == ma) {
                return new NganHang(ma,
                        tmNH.getValueAt(i, 1).toString(),
                        Float.parseFloat(tmNH.getValueAt(i, 2).toString()));
            }
        }
        return null;
    }

    private KhachHang getKHByMa(int ma) {
        for (int i = 0; i < tmKH.getRowCount(); i++) {
            if (Integer.parseInt(tmKH.getValueAt(i, 0).toString()) == ma) {
                return new KhachHang(ma,
                        tmKH.getValueAt(i, 1).toString(),
                        tmKH.getValueAt(i, 2).toString(),
                        tmKH.getValueAt(i, 3).toString());
            }
        }
        return null;
    }

    private boolean toitaiMuon(int maKH, int maNH) {
        for (int i = 0; i < tmSTK.getRowCount(); i++) {
            if ((Integer.parseInt(tmKH.getValueAt(i, 0).toString()) == maKH)
                    && (Integer.parseInt(tmSTK.getValueAt(i, 2).toString()) == maNH)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1_themmoi = new javax.swing.JButton();
        jButton2_thembang = new javax.swing.JButton();
        jButton4_sua = new javax.swing.JButton();
        jButton5_luuvaofile = new javax.swing.JButton();
        jTextField1_maKH = new javax.swing.JTextField();
        jTextField2_hoten = new javax.swing.JTextField();
        jTextField3_diachi = new javax.swing.JTextField();
        jComboBox1_loaiKH = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton7_themmoi = new javax.swing.JButton();
        jButton8_themvaobang = new javax.swing.JButton();
        jButton9_xoa = new javax.swing.JButton();
        jButton11_luuvaofile = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField6_maNH = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7_tenNH = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField8_laiSuattheoNam = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton13_themmoi = new javax.swing.JButton();
        jButton17_luuvaofile = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2_maKH = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox3_maNH = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField11_ngaygui = new javax.swing.JTextField();
        jTextField1_sothang = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1_themmoi.setText("Them moi");
        jButton1_themmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_themmoiActionPerformed(evt);
            }
        });

        jButton2_thembang.setText("Them vao bang");
        jButton2_thembang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_thembangActionPerformed(evt);
            }
        });

        jButton4_sua.setText("Sua");
        jButton4_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_suaActionPerformed(evt);
            }
        });

        jButton5_luuvaofile.setText("Luu vao file");
        jButton5_luuvaofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5_luuvaofileActionPerformed(evt);
            }
        });

        jTextField1_maKH.setEditable(false);

        jTextField2_hoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2_hotenActionPerformed(evt);
            }
        });

        jTextField3_diachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3_diachiActionPerformed(evt);
            }
        });

        jComboBox1_loaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca nhan", "Tap the", "Doanh nghiep" }));

        jLabel1.setText("Ma:");

        jLabel2.setText("Ho ten:");

        jLabel3.setText("Dia chi");

        jLabel4.setText("Loai KH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1_themmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2_thembang)
                                .addGap(47, 47, 47)
                                .addComponent(jButton4_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButton5_luuvaofile, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(167, 167, 167)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1_maKH)
                            .addComponent(jTextField2_hoten)
                            .addComponent(jTextField3_diachi)
                            .addComponent(jComboBox1_loaiKH, 0, 256, Short.MAX_VALUE))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jButton1_themmoi)
                                                    .addComponent(jButton2_thembang)
                                                    .addComponent(jButton4_sua)
                                                    .addComponent(jButton5_luuvaofile))
                                                .addGap(32, 32, 32)
                                                .addComponent(jTextField1_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField2_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1_loaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khach hang", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton7_themmoi.setText("Them moi");
        jButton7_themmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7_themmoiActionPerformed(evt);
            }
        });

        jButton8_themvaobang.setText("Them vao bang");
        jButton8_themvaobang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8_themvaobangActionPerformed(evt);
            }
        });

        jButton9_xoa.setText("Xoa");
        jButton9_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9_xoaActionPerformed(evt);
            }
        });

        jButton11_luuvaofile.setText("Luu vao file");
        jButton11_luuvaofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11_luuvaofileActionPerformed(evt);
            }
        });

        jLabel7.setText("Ma NH:");

        jTextField6_maNH.setEditable(false);

        jLabel8.setText("Ten NH:");

        jLabel9.setText("Lai suat theo nam");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7_themmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8_themvaobang)
                        .addGap(29, 29, 29)
                        .addComponent(jButton9_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton11_luuvaofile, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField6_maNH)
                            .addComponent(jTextField7_tenNH, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(jTextField8_laiSuattheoNam))
                        .addGap(369, 369, 369)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7_themmoi)
                    .addComponent(jButton8_themvaobang)
                    .addComponent(jButton9_xoa)
                    .addComponent(jButton11_luuvaofile))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6_maNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7_tenNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jTextField8_laiSuattheoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ngan hang", jPanel2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jButton13_themmoi.setText("Them moi");
        jButton13_themmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13_themmoiActionPerformed(evt);
            }
        });

        jButton17_luuvaofile.setText("Luu vao file");
        jButton17_luuvaofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17_luuvaofileActionPerformed(evt);
            }
        });

        jLabel11.setText("Ma Khach hang");

        jComboBox2_maKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2_maKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2_maKHActionPerformed(evt);
            }
        });

        jLabel12.setText("Ma Ngan Hang");

        jComboBox3_maNH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3_maNH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3_maNHActionPerformed(evt);
            }
        });

        jLabel13.setText("So thang gui");

        jLabel14.setText("Ngay gui");

        jButton1.setText("Them vao bang");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton13_themmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jButton1)
                                .addGap(43, 43, 43)
                                .addComponent(jButton17_luuvaofile, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2_maKH, 0, 224, Short.MAX_VALUE)
                            .addComponent(jComboBox3_maNH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField11_ngaygui)
                            .addComponent(jTextField1_sothang))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13_themmoi)
                    .addComponent(jButton17_luuvaofile)
                    .addComponent(jButton1))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox2_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox3_maNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField1_sothang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField11_ngaygui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("So tiet kiem", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3_maNHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3_maNHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3_maNHActionPerformed

    private void jComboBox2_maKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2_maKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2_maKHActionPerformed

    private void jButton17_luuvaofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17_luuvaofileActionPerformed
        List<SoTietKiem> a = new ArrayList<>();
        for (int i = 0; i < tmSTK.getRowCount(); i++) {
            SoTietKiem stk = new SoTietKiem(Integer.parseInt(tmSTK.getValueAt(i, 0).toString()),
                Integer.parseInt(tmSTK.getValueAt(i, 2).toString()),
                Integer.parseInt(tmSTK.getValueAt(i, 4).toString()),
                tmSTK.getValueAt(i, 5).toString());
            a.add(stk);
        }
        IOFile.writeFile(a, fileSTK);
    }//GEN-LAST:event_jButton17_luuvaofileActionPerformed

    private void jButton13_themmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13_themmoiActionPerformed
        loadComboBoxKH();
        loadComboBoxNganHang();
        themSTK = true;
    }//GEN-LAST:event_jButton13_themmoiActionPerformed

    private void jButton11_luuvaofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11_luuvaofileActionPerformed
        List<NganHang> a = new ArrayList<>();
        for (int i = 0; i < tmNH.getRowCount(); i++) {
            NganHang nh = new NganHang(Integer.parseInt(tmNH.getValueAt(i, 0).toString()),
                tmNH.getValueAt(i, 1).toString(),
                Float.parseFloat(tmNH.getValueAt(i, 2).toString()));
            a.add(nh);
        }
        IOFile.writeFile(a, fileNH);
    }//GEN-LAST:event_jButton11_luuvaofileActionPerformed

    private void jButton9_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9_xoaActionPerformed
        int row = jTable2.getSelectedRow();
        if ((row < 0) || (row >= tmNH.getRowCount())) {
            JOptionPane.showMessageDialog(null, "chon dong de xoa");
            return;
        } else {
            tmNH.removeRow(row);
        }
    }//GEN-LAST:event_jButton9_xoaActionPerformed

    private void jButton8_themvaobangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8_themvaobangActionPerformed
        int ma = Integer.parseInt(jTextField6_maNH.getText());
        String tenNH = jTextField7_tenNH.getText();
        float laiSuat = Float.parseFloat(jTextField8_laiSuattheoNam.getText());
        NganHang nh = new NganHang(ma, tenNH, laiSuat);
        if (themNH) {
            tmNH.addRow(nh.toObject());
            themNH = false;
        }
    }//GEN-LAST:event_jButton8_themvaobangActionPerformed

    private void jButton7_themmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7_themmoiActionPerformed
        int ma = getMaNH();
        while (true) {
            if (getNganHangByMa(ma) == null) {
                jTextField6_maNH.setText(ma + "");
                break;
            }
            ma++;
        }
        themNH = true;
    }//GEN-LAST:event_jButton7_themmoiActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.getSelectedRow();
        jTextField6_maNH.setText(tmNH.getValueAt(row, 0).toString());
        jTextField7_tenNH.setText(tmNH.getValueAt(row, 1).toString());
        jTextField8_laiSuattheoNam.setText(tmNH.getValueAt(row, 2).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField3_diachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3_diachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3_diachiActionPerformed

    private void jTextField2_hotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2_hotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2_hotenActionPerformed

    private void jButton5_luuvaofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5_luuvaofileActionPerformed
        List<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < tmKH.getRowCount(); i++) {
            KhachHang kh = new KhachHang(Integer.parseInt(tmKH.getValueAt(i, 0).toString()),
                tmKH.getValueAt(i, 1).toString(),
                tmKH.getValueAt(i, 2).toString(),
                tmKH.getValueAt(i, 3).toString());
            a.add(kh);
        }
        IOFile.writeFile(a, fileKH);
    }//GEN-LAST:event_jButton5_luuvaofileActionPerformed

    private void jButton4_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_suaActionPerformed
        int row = jTable1.getSelectedRow();
        if ((row < 0) || (row >= jTable1.getRowCount())) {
            JOptionPane.showMessageDialog(null, "chon dong de sua");
        } else {
            tmKH.setValueAt(jTextField1_maKH.getText(), row, 0);
            tmKH.setValueAt(jTextField2_hoten.getText(), row, 1);
            tmKH.setValueAt(jTextField3_diachi.getText(), row, 2);
            tmKH.setValueAt(jComboBox1_loaiKH.getSelectedItem(), row, 3);
        }
    }//GEN-LAST:event_jButton4_suaActionPerformed

    private void jButton2_thembangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_thembangActionPerformed
        int ma = Integer.parseInt(jTextField1_maKH.getText());
        String ten = jTextField2_hoten.getText();
        String diachi = jTextField3_diachi.getText();
        String loaiKH = jComboBox1_loaiKH.getSelectedItem().toString();
        KhachHang kh = new KhachHang(ma, ten, diachi, loaiKH);
        if (themKH) {
            tmKH.addRow(kh.toObject());
            themKH = false;
        }

    }//GEN-LAST:event_jButton2_thembangActionPerformed

    private void jButton1_themmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_themmoiActionPerformed
        int ma = getMaKH();
        while (true) {
            if (getKHByMa(ma) == null) {
                jTextField1_maKH.setText(ma + "");
                break;
            }
            ma++;
        }
        themKH = true;
    }//GEN-LAST:event_jButton1_themmoiActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        jTextField1_maKH.setText(tmKH.getValueAt(row, 0).toString());
        jTextField2_hoten.setText(tmKH.getValueAt(row, 1).toString());
        jTextField3_diachi.setText(tmKH.getValueAt(row, 2).toString());
        String cn = tmKH.getValueAt(row, 3).toString();
        for (int i = 0; i < jComboBox1_loaiKH.getItemCount(); i++) {
            if (jComboBox1_loaiKH.getItemAt(i).toString().equals(cn)) {
                jComboBox1_loaiKH.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (themSTK) {

            int maKH = Integer.parseInt(jComboBox2_maKH.getSelectedItem().toString());
            int maNH = Integer.parseInt(jComboBox3_maNH.getSelectedItem().toString());
            if (!toitaiMuon(maKH, maNH)) {
                    String tenKH = getKHByMa(maKH).getHoTen();
                    String tenNH = getNganHangByMa(maNH).getTenNH();
                    int soThang = Integer.parseInt(jTextField1_sothang.getText().toString());
                    String ngayGui = jTextField11_ngaygui.getText().toString();
                    tmSTK.addRow(new Object[]{maKH, tenKH, maNH,
                        tenNH, soThang, ngayGui});
              
            } else {
                JOptionPane.showMessageDialog(null, "Ban nay da muon cuon nay roi");
                jComboBox2_maKH.requestFocus();
                return;
            }
        }
        themSTK = false;
    }//GEN-LAST:event_jButton1ActionPerformed
    private void loadComboBoxNganHang() {
        jComboBox3_maNH.removeAllItems();
        for (int i = 0; i < tmNH.getRowCount(); i++) {
            jComboBox3_maNH.addItem(tmNH.getValueAt(i, 0).toString());
        }
    }

    private void loadComboBoxKH() {
        jComboBox2_maKH.removeAllItems();
        for (int i = 0; i < tmKH.getRowCount(); i++) {
            jComboBox2_maKH.addItem(tmKH.getValueAt(i, 0).toString());
        }
    }////    private int getDauSach(int maBD) {
   

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11_luuvaofile;
    private javax.swing.JButton jButton13_themmoi;
    private javax.swing.JButton jButton17_luuvaofile;
    private javax.swing.JButton jButton1_themmoi;
    private javax.swing.JButton jButton2_thembang;
    private javax.swing.JButton jButton4_sua;
    private javax.swing.JButton jButton5_luuvaofile;
    private javax.swing.JButton jButton7_themmoi;
    private javax.swing.JButton jButton8_themvaobang;
    private javax.swing.JButton jButton9_xoa;
    private javax.swing.JComboBox<String> jComboBox1_loaiKH;
    private javax.swing.JComboBox<String> jComboBox2_maKH;
    private javax.swing.JComboBox<String> jComboBox3_maNH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField11_ngaygui;
    private javax.swing.JTextField jTextField1_maKH;
    private javax.swing.JTextField jTextField1_sothang;
    private javax.swing.JTextField jTextField2_hoten;
    private javax.swing.JTextField jTextField3_diachi;
    private javax.swing.JTextField jTextField6_maNH;
    private javax.swing.JTextField jTextField7_tenNH;
    private javax.swing.JTextField jTextField8_laiSuattheoNam;
    // End of variables declaration//GEN-END:variables
}
