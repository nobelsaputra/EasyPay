package com.mycompany.components.transaction;

import com.mycompany.MainMenu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Transaksi extends javax.swing.JFrame {

    private DefaultTableModel tableModel;

    public Transaksi() {
        initComponents();
        initTable();
        loadBarangFromFile("barang.txt"); // Memuat data barang dari file
        setTitle("EasyPay | Transaksi");
    }

    private void initTable() {
        // Menginisialisasi model tabel
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nama", "Harga", "Jumlah", "Diskon", "Pajak", "Total Harga" });
        jTable1.setModel(tableModel);
    }

    private void loadBarangFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String nama = "";
            String harga = "";
            String jumlah = "";
            String pajak = "";
            String diskon = "";
            String totalHarga = "";

            while ((line = br.readLine()) != null) {
                if (line.startsWith("Nama Barang:")) {
                    nama = line.split(":")[1].trim();
                } else if (line.startsWith("Harga Satuan:")) {
                    harga = line.split(":")[1].trim();
                } else if (line.startsWith("Jumlah:")) {
                    jumlah = line.split(":")[1].trim();
                } else if (line.startsWith("Pajak:")) {
                    pajak = line.split(":")[1].trim();
                } else if (line.startsWith("Diskon:")) {
                    diskon = line.split(":")[1].trim();
                } else if (line.startsWith("Total Harga:")) {
                    totalHarga = line.split(":")[1].trim();

                    // Menambahkan data ke model tabel setelah semua informasi dibaca
                    tableModel.addRow(new Object[] { nama, harga, jumlah, diskon, pajak, totalHarga });
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal membaca file: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Kembali ke menu utama atau tampilan sebelumnya
        this.dispose();
        new MainMenu().setVisible(true); // Asumsikan MainMenu adalah JFrame yang valid
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Beli semua barang di tabel
        List<String> itemsToBuy = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            StringBuilder item = new StringBuilder();
            item.append("Nama Barang: ").append(tableModel.getValueAt(i, 0)).append("\n");
            item.append("Harga Satuan: ").append(tableModel.getValueAt(i, 1)).append("\n");
            item.append("Jumlah: ").append(tableModel.getValueAt(i, 2)).append("\n");
            item.append("Diskon: ").append(tableModel.getValueAt(i, 3)).append("\n");
            item.append("Pajak: ").append(tableModel.getValueAt(i, 4)).append("\n");
            item.append("Total Harga: ").append(tableModel.getValueAt(i, 5)).append("\n");
            itemsToBuy.add(item.toString());
        }
        proceedToPayment(itemsToBuy);
    }

   
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Beli barang yang dipilih
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            StringBuilder item = new StringBuilder();
            item.append("Nama Barang: ").append(tableModel.getValueAt(selectedRow, 0)).append("\n");
            item.append("Harga Satuan: ").append(tableModel.getValueAt(selectedRow, 1)).append("\n");
            item.append("Jumlah: ").append(tableModel.getValueAt(selectedRow, 2)).append("\n");
            item.append("Diskon: ").append(tableModel.getValueAt(selectedRow, 3)).append("\n");
            item.append("Pajak: ").append(tableModel.getValueAt(selectedRow, 4)).append("\n");
            item.append("Total Harga: ").append(tableModel.getValueAt(selectedRow, 5)).append("\n");

            List<String> itemsToBuy = new ArrayList<>();
            itemsToBuy.add(item.toString());
            proceedToPayment(itemsToBuy);
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih barang terlebih dahulu!", "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void proceedToPayment(List<String> items) {
        // Mengalihkan ke Bayar.java dengan daftar barang yang dipilih
        this.dispose(); // Menutup jendela Transaksi
        new Bayar(items).setVisible(true); // Mengalihkan ke jendela Bayar
    }

 
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Nama", "Harga", "Jumlah", "Diskon", "Pajak", "Total Harga" }));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("TRANSAKSI");

// Set font untuk teks di dalam tabel
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // Ukuran font 16

        // Mengatur tinggi baris
        jTable1.setRowHeight(30); // Mengatur tinggi setiap baris menjadi 30 piksel
        jTable1.getTableHeader().setPreferredSize(new java.awt.Dimension(100, 40)); // Tinggi header 40 piksel

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Kembali");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(115, 236, 139));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Beli Semua");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(115, 236, 139));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Beli");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(424, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jButton2)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(26, 26, 26))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addGap(386, 386, 386)))));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(132, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(33, 33, 33)))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variabel deklarasi
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
