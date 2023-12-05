package views;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.MauSac;
import repositories.MauSacRepository;

public class QuanLyMauSac extends javax.swing.JFrame {
    
    private MauSacRepository msRepo;
    private int limit = 5;
    private int page = 1;
    private int totalPage = 0;
    private int searchTrangThai = 1;
    private String searchKeyword = "";

    public QuanLyMauSac() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.msRepo = new MauSacRepository();
        ArrayList<MauSac> ds = this.msRepo.searchAndPaging(page, limit, searchKeyword, searchTrangThai);
        this.loadTable(ds);
        this.lblPage.setText(this.page + "");
    }
    
    public void loadTable(ArrayList<MauSac> ds)
    {
        DefaultTableModel dtm = (DefaultTableModel) this.tblMauSac.getModel();
        dtm.setRowCount(0);
        for (MauSac ms: ds) {
            Object[] row = {
                ms.getId(),
                ms.getMa(),
                ms.getTen(),
                ms.getTrangThai() == 1 ? "Hoạt động" : "Dừng hoạt động"
            };
            
            dtm.addRow(row);
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrStt = new javax.swing.ButtonGroup();
        btnGrSttSearch = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdoActive = new javax.swing.JRadioButton();
        rdoInactive = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lblPage = new javax.swing.JLabel();
        txtTenSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        rdoActiveSearch = new javax.swing.JRadioButton();
        btnClearSearch = new javax.swing.JButton();
        rdoInactiveSearch = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ID");

        jLabel2.setText("Tên");

        txtID.setEditable(false);
        txtID.setEnabled(false);

        jLabel3.setText("Trạng thái");

        btnGrStt.add(rdoActive);
        rdoActive.setSelected(true);
        rdoActive.setText("Hoạt động");

        btnGrStt.add(rdoInactive);
        rdoInactive.setText("Dừng hoạt động");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnClear.setText("Làm mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel5.setText("Mã");

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(rdoActive)
                        .addGap(18, 18, 18)
                        .addComponent(rdoInactive))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTen)
                            .addComponent(txtID)
                            .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rdoActive)
                    .addComponent(rdoInactive))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Tên", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMauSac);
        if (tblMauSac.getColumnModel().getColumnCount() > 0) {
            tblMauSac.getColumnModel().getColumn(0).setResizable(false);
            tblMauSac.getColumnModel().getColumn(1).setResizable(false);
            tblMauSac.getColumnModel().getColumn(2).setResizable(false);
            tblMauSac.getColumnModel().getColumn(3).setResizable(false);
        }

        btnBack.setText("<");
        btnBack.setEnabled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPage.setText("0");

        txtTenSearch.setToolTipText("Nhập tên hoặc mã");
        txtTenSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSearchActionPerformed(evt);
            }
        });
        txtTenSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenSearchKeyTyped(evt);
            }
        });

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnGrSttSearch.add(rdoActiveSearch);
        rdoActiveSearch.setSelected(true);
        rdoActiveSearch.setText("Hoạt động");
        rdoActiveSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoActiveSearchItemStateChanged(evt);
            }
        });

        btnClearSearch.setText("Làm mới");
        btnClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSearchActionPerformed(evt);
            }
        });

        btnGrSttSearch.add(rdoInactiveSearch);
        rdoInactiveSearch.setText("Dừng hoạt động");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoActiveSearch)
                                .addGap(18, 18, 18)
                                .addComponent(rdoInactiveSearch)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClearSearch)
                            .addComponent(btnSearch))
                        .addGap(11, 11, 11))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearSearch)
                    .addComponent(rdoActiveSearch)
                    .addComponent(rdoInactiveSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnBack)
                    .addComponent(lblPage))
                .addGap(326, 326, 326))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        //
    }//GEN-LAST:event_txtMaActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.totalPage = this.msRepo.countPage(limit, searchKeyword, searchTrangThai);
        
        if (this.page + 1 <= totalPage) {
            this.page++;
            this.lblPage.setText(this.page + "");
            ArrayList<MauSac> ds = this.msRepo.searchAndPaging(page, limit, searchKeyword, searchTrangThai);
            this.loadTable(ds);
        }
        
        if (this.page == totalPage) {
            this.btnNext.setEnabled(false);
        } else if (this.page  + 1 < totalPage) {
            this.btnNext.setEnabled(true);
        }
        
        if (this.page < 1) {
            this.btnBack.setEnabled(false);
        } else {
            this.btnBack.setEnabled(true);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.totalPage = this.msRepo.countPage(limit, searchKeyword, searchTrangThai);
        
        if (this.page - 1 >= 1) {
            this.page--;
            this.lblPage.setText(this.page + "");
            ArrayList<MauSac> ds = this.msRepo.searchAndPaging(page, limit, searchKeyword, searchTrangThai);
            this.loadTable(ds);
        }
        
        if (this.page == totalPage) {
            this.btnNext.setEnabled(false);
        } else if (this.page + 1 <= totalPage) {
            this.btnNext.setEnabled(true);
        }
        
        if (this.page <= 1) {
            this.btnBack.setEnabled(false);
        } else {
            this.btnBack.setEnabled(true);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        MauSac ms = this.getFormData();
        if (ms == null) return ;
        
        try {
            this.msRepo.create(ms);
            JOptionPane.showMessageDialog(this, "Thêm mới thành công");
            this.loadTable(this.msRepo.paging(page, limit));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        MauSac ms = this.getFormData();
        if (ms == null) return ;
        
        try {
            this.msRepo.update(ms);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            this.loadTable(this.msRepo.paging(page, limit));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        int row = this.tblMauSac.getSelectedRow();
        if (row == -1) {
            return ;
        }
        
        this.txtID.setText(this.tblMauSac.getValueAt(row, 0).toString());
        this.txtMa.setText(this.tblMauSac.getValueAt(row, 1).toString());
        this.txtTen.setText(this.tblMauSac.getValueAt(row, 2).toString());
        
        if (this.tblMauSac.getValueAt(row, 3).toString().equals("Hoạt động")) {
            this.rdoActive.setSelected(true);
        } else {
            this.rdoInactive.setSelected(true);
        }
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.page = 1;
        this.lblPage.setText(this.page + "");
        ArrayList<MauSac> ds = this.msRepo.searchAndPaging(page, limit, searchKeyword, searchTrangThai);
        this.loadTable(ds);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtTenSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSearchActionPerformed
        //
    }//GEN-LAST:event_txtTenSearchActionPerformed

    private void txtTenSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenSearchKeyTyped
        // 
    }//GEN-LAST:event_txtTenSearchKeyTyped

    private void txtTenSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenSearchKeyReleased
        this.searchKeyword = this.txtTenSearch.getText().trim();
    }//GEN-LAST:event_txtTenSearchKeyReleased

    private void rdoActiveSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoActiveSearchItemStateChanged
        this.searchTrangThai = this.rdoActiveSearch.isSelected() ? 1 : 0;
    }//GEN-LAST:event_rdoActiveSearchItemStateChanged

    private void btnClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSearchActionPerformed
        this.txtTenSearch.setText("");
        this.rdoActiveSearch.setSelected(true);
        this.searchTrangThai = -1;
        this.searchKeyword = "";
        
        this.lblPage.setText(this.page + "");
        
        this.loadTable(this.msRepo.searchAndPaging(page, limit, searchKeyword, searchTrangThai));
    }//GEN-LAST:event_btnClearSearchActionPerformed

    private MauSac getFormData()
    {
        int id = this.txtID.getText().equals("") ? 0 : Integer.parseInt(this.txtID.getText());
        String ten = this.txtTen.getText().trim();
        String ma = this.txtMa.getText().trim();
        
        if (ten.equals("") || ma.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
            return null;
        }
        int trangThai = this.rdoActive.isSelected() == true ? 1 : 0;
        MauSac ms = new  MauSac(id, ma, ten, trangThai);
        
        return ms;
    }
    
    private void clearForm()
    {
        this.txtID.setText("");
        this.txtMa.setText("");
        this.txtTen.setText("");
        this.rdoActive.setSelected(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearSearch;
    private javax.swing.ButtonGroup btnGrStt;
    private javax.swing.ButtonGroup btnGrSttSearch;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPage;
    private javax.swing.JRadioButton rdoActive;
    private javax.swing.JRadioButton rdoActiveSearch;
    private javax.swing.JRadioButton rdoInactive;
    private javax.swing.JRadioButton rdoInactiveSearch;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenSearch;
    // End of variables declaration//GEN-END:variables
}
