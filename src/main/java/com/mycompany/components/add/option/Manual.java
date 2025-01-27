/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.components.add.option;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.mycompany.MainMenu;

/**
 *
 * @author USER
 */
public class Manual extends javax.swing.JFrame {

        /**
         * Creates new form TambahBarangManual
         */
        public Manual() {
                initComponents();

                setTitle("EasyPay | Tambah Barang Manual");
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */

        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jTextField1 = new javax.swing.JTextField();
                jTextField5 = new javax.swing.JTextField();
                jSpinner1 = new javax.swing.JSpinner();
                jSpinner2 = new javax.swing.JSpinner();
                jSpinner3 = new javax.swing.JSpinner();
                jButton5 = new javax.swing.JButton();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));

                jTextField1.setBackground(new java.awt.Color(255, 255, 255));
                jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18));
                jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                jTextField5.setBackground(new java.awt.Color(255, 255, 255));
                jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 18));
                jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                jSpinner1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

                jSpinner2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

                jSpinner3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

                jButton5.setBackground(new java.awt.Color(115, 236, 139));
                jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jButton5.setForeground(new java.awt.Color(51, 51, 51));
                jButton5.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/com/mycompany/image/image-add/add-button.png"))); // NOI18N
                jButton5.setText("Tambah");
                jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButton5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton5ActionPerformed(evt);
                        }
                });

                jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 0, 0));
                jLabel1.setText("Nama");

                jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(0, 0, 0));
                jLabel2.setText("Jumlah");

                jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(0, 0, 0));
                jLabel3.setText("Harga");

                jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(0, 0, 0));
                jLabel4.setText("Diskon %");

                jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel5.setForeground(new java.awt.Color(0, 0, 0));
                jLabel5.setText("Pajak %");

                jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
                jLabel6.setForeground(new java.awt.Color(0, 0, 0));
                jLabel6.setText("TAMBAH BARANG MANUAL");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(122, 122, 122)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel6)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jTextField1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                202,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel1))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jTextField5,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                202,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel3))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel2)
                                                                                                                .addComponent(jSpinner2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                105,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jSpinner3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                125,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel5))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel4)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jSpinner1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                125,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(53, 53, 53)
                                                                                                                                .addComponent(jButton5,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                141,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addContainerGap(356, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(110, 110, 110)
                                                                .addComponent(jLabel6)
                                                                .addGap(92, 92, 92)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jLabel3))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jTextField1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTextField5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jSpinner2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(76, 76, 76)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(jLabel5))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jSpinner3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jSpinner1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(128, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
                // Ambil input dari form
                String namaBarang = jTextField1.getText();
                String hargaInput = jTextField5.getText();
                String jumlahInput = String.valueOf((Integer) jSpinner2.getValue());
                int diskon = (Integer) jSpinner1.getValue();
                int pajak = (Integer) jSpinner3.getValue();

                double hargaBarang = 0;
                int jumlahBarang = 0;

                // Validasi nama barang
                if (namaBarang.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Nama barang tidak boleh kosong!", "Peringatan",
                                        JOptionPane.WARNING_MESSAGE);
                        return; // Menghentikan eksekusi jika nama barang tidak diisi
                }

                // Validasi input harga
                try {
                        hargaBarang = Double.parseDouble(hargaInput.replace(".00", "")); // Menghilangkan .00
                        if (hargaBarang <= 0) {
                                JOptionPane.showMessageDialog(this, "Harga tidak boleh 0 atau negatif!", "Peringatan",
                                                JOptionPane.WARNING_MESSAGE);
                                return; // Menghentikan eksekusi jika harga tidak valid
                        }
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Harga harus berupa angka!", "Peringatan",
                                        JOptionPane.WARNING_MESSAGE);
                        return; // Menghentikan eksekusi jika harga tidak valid
                }

                // Validasi input jumlah
                try {
                        jumlahBarang = Integer.parseInt(jumlahInput);
                        if (jumlahBarang <= 0) {
                                JOptionPane.showMessageDialog(this, "Jumlah tidak boleh 0 atau negatif!", "Peringatan",
                                                JOptionPane.WARNING_MESSAGE);
                                return; // Menghentikan eksekusi jika jumlah tidak valid
                        }
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Jumlah harus berupa angka!", "Peringatan",
                                        JOptionPane.WARNING_MESSAGE);
                        return; // Menghentikan eksekusi jika jumlah tidak valid
                }

                // Hitung total harga setelah diskon
                double hargaSetelahDiskon = hargaBarang * (1 - (diskon / 100.0)); // Hitung harga setelah diskon
                double totalHarga = hargaSetelahDiskon * jumlahBarang; // Total harga setelah diskon
                totalHarga += totalHarga * (pajak / 100.0); // Tambahkan pajak ke total harga

                // Simpan data ke dalam file barang.txt dengan format yang rapi
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("barang.txt", true))) {
                        writer.write(String.format("Nama Barang: %s", namaBarang));
                        writer.newLine();
                        writer.write(String.format("Harga Satuan: %.0f", hargaBarang)); // Menghilangkan .00
                        writer.newLine();
                        writer.write(String.format("Jumlah: %d", jumlahBarang));
                        writer.newLine();
                        writer.write(String.format("Pajak: %d%%", pajak)); // Menghilangkan angka desimal
                        writer.newLine();
                        writer.write(String.format("Diskon: %d%%", diskon)); // Menghilangkan angka desimal
                        writer.newLine();
                        writer.write(String.format("Total Harga: %.2f", totalHarga)); // Tampilkan total harga dengan 2
                                                                                      // angka di belakang koma
                        writer.newLine();
                        writer.newLine();
                        JOptionPane.showMessageDialog(this, "Barang berhasil ditambahkan!");

                        // Menanyakan apakah ingin menambahkan barang lagi
                        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda ingin menambahkan barang lagi?",
                                        "Konfirmasi", JOptionPane.YES_NO_OPTION);

                        if (response == JOptionPane.NO_OPTION) {
                                // Jika tidak, kembali ke MainMenu
                                this.dispose(); // Menutup form saat ini
                                new MainMenu().setVisible(true); // Membuka MainMenu
                        }

                } catch (IOException e) {
                        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data!", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                }
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(Manual.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Manual.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Manual.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Manual.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new Manual().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify
        private javax.swing.JButton jButton5;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JSpinner jSpinner1;
        private javax.swing.JSpinner jSpinner2;
        private javax.swing.JSpinner jSpinner3;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField5;
        // End of variables declaration
}
