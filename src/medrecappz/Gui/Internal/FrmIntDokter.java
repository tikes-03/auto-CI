/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmIntDokter.java
 *
 * Created on Dec 19, 2013, 7:59:59 PM
 */
package medrecappz.Gui.Internal;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import medrecappz.Dao.DokterDao;
import medrecappz.Dao.SpesialisDao;
import medrecappz.Entity.Dokter;
import medrecappz.Services.DokterService;
import medrecappz.Services.SpesialisService;
import medrecappz.TabelModel.TabelModelDokter;
import medrecappz.TabelModel.TabelModelSpesialis;

/**
 *
 * @author Fachrul Pralienka BM
 */
public class FrmIntDokter extends javax.swing.JInternalFrame {

    DokterService ds = new DokterService();
    TabelModelDokter tabelModelDokter = new TabelModelDokter();
    SpesialisService ss = new SpesialisService();
    TabelModelSpesialis tabelModelSpesialis = new TabelModelSpesialis();
    Connection connection;

    /** Creates new form FrmIntDokter */
    public FrmIntDokter() {
        initComponents();
        tabelDokter.setModel(tabelModelDokter);
        tabelModelDokter.setData(ds.serviceGetAllDokter());
        if (!DokterDao.hasilGetAll.equals("ok")) {
            JOptionPane.showMessageDialog(null, DokterDao.hasilGetAll, "Get All Dokter Gagal!", JOptionPane.ERROR_MESSAGE);
        }
        sesuaikan();

        tabelModelSpesialis.setData(ss.serviceGetAllSpesialis());
        int a = tabelModelSpesialis.getRowCount();
        pilihSpesialis.setModel(new javax.swing.DefaultComboBoxModel(ss.serviceGetAllNamaSpesialis(a)));

        tabelDokter.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tabelDokter.getSelectedRow();
                if (row != -1) {

                    String nama = tabelDokter.getValueAt(row, 1).toString();
                    String spesialis = tabelDokter.getValueAt(row, 2).toString();
                    String tglKerja = tabelDokter.getValueAt(row, 3).toString();
                    String alamat = tabelDokter.getValueAt(row, 4).toString();
                    txtNmDokter.setText(nama);
                    pilihSpesialis.setSelectedItem(ss.serviceGetNmSpesialis(spesialis));
                    txtTglKerja.setText(tglKerja);
                    txtAlamat.setText(alamat);

                    btnInsert.setEnabled(false);
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                }
            }
        });

        txtAlamat.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    txtAlamat.transferFocus();
                    e.consume();
                }
            }
        });

        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        txtNmDokter.requestFocus();
        txtNmDokter.setText("");
        pilihSpesialis.setSelectedIndex(0);
        txtTglKerja.setText("");
        txtAlamat.setText("");
        txtCariDokter.setText("");

    }

    public void clear() {
        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        txtNmDokter.requestFocus();
        txtNmDokter.setText("");
        pilihSpesialis.setSelectedIndex(0);
        txtTglKerja.setText("");
        txtAlamat.setText("");
        tabelModelDokter.setData(ds.serviceGetAllDokter());
        txtCariDokter.setText("");

        sesuaikan();
    }

    public final void sesuaikan() {
        TableColumnModel tcm = tabelDokter.getColumnModel();
        for (int kolom = 0; kolom < tcm.getColumnCount(); kolom++) {
            int lebarKolomMax = 0;
            for (int baris = 0; baris < tabelDokter.getRowCount(); baris++) {
                TableCellRenderer tcr = tabelDokter.getCellRenderer(baris, kolom);
                Object nilaiTable = tabelDokter.getValueAt(baris, kolom);
                Component comp = tcr.getTableCellRendererComponent(tabelDokter, nilaiTable,
                        false, false, baris, kolom);
                lebarKolomMax = Math.max(comp.getPreferredSize().width, lebarKolomMax);
            }
            TableColumn tc = tcm.getColumn(kolom);
            tc.setPreferredWidth(lebarKolomMax);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNmDokter = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTglKerja = new javax.swing.JTextField();
        pilihSpesialis = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelDokter = new javax.swing.JTable();
        txtCariDokter = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dokter"));

        txtNmDokter.setName("txtNamaDokter"); // NOI18N

        jLabel3.setText("Spesialis");

        jLabel2.setText("Nama Dokter");

        txtTglKerja.setName("txtTglKerja"); // NOI18N

        pilihSpesialis.setName("pilihSpesialis"); // NOI18N

        jLabel8.setText(":");

        jLabel7.setText(":");

        jLabel10.setText(":");

        jLabel9.setText(":");

        jLabel4.setText("Tanggal Kerja");

        jLabel5.setText("Alamat");

        txtAlamat.setColumns(20);
        txtAlamat.setFont(new java.awt.Font("Tahoma", 0, 11));
        txtAlamat.setLineWrap(true);
        txtAlamat.setRows(5);
        txtAlamat.setName("txtAlamat"); // NOI18N
        jScrollPane1.setViewportView(txtAlamat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNmDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pilihSpesialis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTglKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(392, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(txtNmDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(pilihSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txtTglKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel10))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnInsert.setText("Insert");
        btnInsert.setName("btnInsert"); // NOI18N
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setName("btnUpdate"); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.setName("btnRefresh"); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tabelDokter.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelDokter.setName("tabelDokter"); // NOI18N
        jScrollPane2.setViewportView(tabelDokter);

        txtCariDokter.setName("txtCari"); // NOI18N
        txtCariDokter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariDokterKeyReleased(evt);
            }
        });

        jLabel1.setText("Masukkan No. Dokter / Nama Dokter");

        jLabel6.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(txtCariDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCariDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String nmDokter = txtNmDokter.getText();
        String tglKerja = txtTglKerja.getText();
        String alamat = txtAlamat.getText();
        int spesialis = pilihSpesialis.getSelectedIndex();

        if ((nmDokter.equals("")) || (spesialis == -1) || (tglKerja.equals("")) || (alamat.equals(""))) {
            JOptionPane.showMessageDialog(rootPane, "Data tidak boleh kosong!", "Insert Dokter Gagal!", JOptionPane.ERROR_MESSAGE);
        } else {
            String id = ss.serviceGetIDSpesialis(pilihSpesialis.getSelectedItem().toString());
//            if (!SpesialisDao.hasilGetIDSpesialis.equals("ok")) {
//                JOptionPane.showMessageDialog(null, SpesialisDao.hasilGetIDSpesialis, "Error - Get ID Spesialis", JOptionPane.ERROR_MESSAGE);
//            }
            Dokter d = new Dokter();
            d.setNoDokter("DOK." + ds.serviceGetMaxNoDokter());
            d.setNmDokter(nmDokter.toUpperCase());
            d.setIdSpesialis(id);
            d.setTglKerjaDok(tglKerja);
            d.setAlamatDok(alamat);
            ds.serviceInsertDokter(d);
            if (DokterDao.hasilInsert.equals("ok")) {
                JOptionPane.showMessageDialog(null, "Data dokter berhasil ditambah!", "Insert Dokter", JOptionPane.INFORMATION_MESSAGE);
                clear();
            } else {
                JOptionPane.showMessageDialog(null, DokterDao.hasilInsert, "Insert Dokter Gagal!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String nmDokter = txtNmDokter.getText();
        String tglKerja = txtTglKerja.getText();
        String alamat = txtAlamat.getText();
        int spesialis = pilihSpesialis.getSelectedIndex();

        if ((nmDokter.equals("")) || (spesialis == -1) || (tglKerja.equals("")) || (alamat.equals(""))) {
            JOptionPane.showMessageDialog(rootPane, "Data tidak boleh kosong!", "Update Dokter Gagal!", JOptionPane.ERROR_MESSAGE);
        } else {
            String id = ss.serviceGetIDSpesialis(pilihSpesialis.getSelectedItem().toString());
            Dokter d = new Dokter();
            d.setNmDokter(txtNmDokter.getText().toUpperCase());
            d.setIdSpesialis(id);
            d.setTglKerjaDok(txtTglKerja.getText());
            d.setAlamatDok(txtAlamat.getText());

            int row = tabelDokter.getSelectedRow();
            if (row != -1) {
                ds.serviceUpdateDokter(d, tabelDokter.getValueAt(row, 0).toString());
                if (DokterDao.hasilUpdate.equals("ok")) {
                    JOptionPane.showMessageDialog(null, "Data dokter berhasil diubah!", "Update Dokter", JOptionPane.INFORMATION_MESSAGE);
                    clear();
                } else {
                    JOptionPane.showMessageDialog(null, DokterDao.hasilUpdate, "Update Dokter Gagal!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tabelDokter.getSelectedRow();
        if (row == -1) {
            return;
        }

        int pilih = JOptionPane.showConfirmDialog(rootPane,
                "Yakin ingin mengahapus data yang dipilih?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pilih == JOptionPane.OK_OPTION) {
            ds.serviceDeleteDokter(tabelDokter.getValueAt(row, 0).toString());
            if (DokterDao.hasilDelete.equals("ok")) {
                JOptionPane.showMessageDialog(null, "Data dokter berhasil dihapus!", "Delete Dokter", JOptionPane.INFORMATION_MESSAGE);
                clear();
            } else {
                JOptionPane.showMessageDialog(null, DokterDao.hasilDelete, "Delete Dokter Gagal!", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtCariDokterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariDokterKeyReleased
        // TODO add your handling code here:
        tabelModelDokter.setData(ds.serviceGetAllDokterByNo(txtCariDokter.getText()));
        if (tabelModelDokter.getRowCount() == 0) {
            tabelModelDokter.setData(ds.serviceGetAllDokterByNm(txtCariDokter.getText()));
        }
        txtNmDokter.setText("");
        pilihSpesialis.setSelectedIndex(0);
        txtTglKerja.setText("");
        txtAlamat.setText("");

        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_txtCariDokterKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox pilihSpesialis;
    private javax.swing.JTable tabelDokter;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtCariDokter;
    private javax.swing.JTextField txtNmDokter;
    private javax.swing.JTextField txtTglKerja;
    // End of variables declaration//GEN-END:variables
}
