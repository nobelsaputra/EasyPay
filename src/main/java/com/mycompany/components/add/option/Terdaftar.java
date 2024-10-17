package com.mycompany.components.add.option;

import javax.swing.*;

import com.mycompany.MainMenu;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Terdaftar extends javax.swing.JFrame {

        private List<String> daftarBarang = new ArrayList<>();
        private List<Double> daftarHarga = new ArrayList<>();

        public Terdaftar() {
                initComponents();
                loadBarang();
                setupComboBox();
                setupListeners();
                setTitle("EasyPay | Tambah Barang Terdaftar");
        }

        private void loadBarang() {
                try (BufferedReader br = new BufferedReader(new FileReader("BT-tersedia.txt"))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                                String[] data = line.split(",");
                                daftarBarang.add(data[0].trim());
                                daftarHarga.add(Double.parseDouble(data[1].trim()));
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        private void setupComboBox() {
                for (String barang : daftarBarang) {
                        jComboBox1.addItem(barang);
                }
        }

        private void setupListeners() {
                jComboBox1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                updateHarga();
                        }
                });

                jTextField1.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                                updateComboBox();
                        }
                });
        }

        private void updateHarga() {
                int index = jComboBox1.getSelectedIndex();
                if (index != -1) {
                        jSpinner1.setValue(daftarHarga.get(index)); // Update harga di JSpinner
                }
        }

        private void updateComboBox() {
                String text = jTextField1.getText().toLowerCase();
                jComboBox1.removeAllItems();
                for (int i = 0; i < daftarBarang.size(); i++) {
                        if (daftarBarang.get(i).toLowerCase().contains(text)) {
                                jComboBox1.addItem(daftarBarang.get(i));
                        }
                }
                if (jComboBox1.getItemCount() > 0) {
                        jComboBox1.setSelectedIndex(0);
                        updateHarga();
                }
        }

        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jComboBox1 = new javax.swing.JComboBox<>();
                jTextField1 = new javax.swing.JTextField();
                jSpinner1 = new javax.swing.JSpinner();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jSpinner2 = new javax.swing.JSpinner();
                jLabel3 = new javax.swing.JLabel();
                jSpinner3 = new javax.swing.JSpinner();
                jSpinner4 = new javax.swing.JSpinner();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jButton5 = new javax.swing.JButton();
                jButton6 = new javax.swing.JButton();
                jLabel6 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));

                jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

                jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

                jSpinner1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

                jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel1.setText("Jumlah");

                jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel2.setText("Nama");

                jSpinner2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

                jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel3.setText("Harga");

                jSpinner3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

                jSpinner4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

                jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel4.setText("Diskon");

                jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel5.setText("Pajak");

                jButton5.setBackground(new java.awt.Color(236, 114, 144));
                jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jButton5.setText("Kembali");
                jButton5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton5ActionPerformed(evt);
                        }
                });

                jButton6.setBackground(new java.awt.Color(115, 236, 139));
                jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jButton6.setText("Tambah");
                jButton6.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton6ActionPerformed(evt);
                        }
                });

                jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
                jLabel6.setText("TAMBAH BARANG TERDAFTAR");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(90, 90, 90)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel6)
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                                                .addComponent(jButton6,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                179,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGap(26, 26, 26)
                                                                                                                                                .addComponent(jButton5,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                179,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                false)
                                                                                                                                                                                .addComponent(jComboBox1,
                                                                                                                                                                                                0,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                .addComponent(jTextField1,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                244,
                                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                                .addComponent(jLabel2))
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                72,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                false)
                                                                                                                                                                .addComponent(jLabel3)
                                                                                                                                                                .addComponent(jLabel5)
                                                                                                                                                                .addComponent(jSpinner1)
                                                                                                                                                                .addComponent(jSpinner2,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                180,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addGap(68, 68, 68)
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                false)
                                                                                                                                                                .addComponent(jLabel1)
                                                                                                                                                                .addComponent(jSpinner3)
                                                                                                                                                                .addComponent(jLabel4)
                                                                                                                                                                .addComponent(jSpinner4,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                179,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                                                .addGap(173, 173,
                                                                                                                                173)))));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(82, 82, 82)
                                                                .addComponent(jLabel6)
                                                                .addGap(81, 81, 81)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel2)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                43,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jComboBox1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                42,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel3)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jSpinner1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                42,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel1)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jSpinner3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                42,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(39, 39, 39)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel4)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jSpinner4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                42,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel5)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jSpinner2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                42,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(36, 36, 36)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jButton5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                45,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton6,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                45,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(67, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));

                pack();
        }

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
                MainMenu MainMenu = new MainMenu();
                MainMenu.setVisible(true);
                this.dispose(); // Menutup jendela ini
        }

        private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
                // Ambil item yang dipilih dari JComboBox
                String selectedBarang = (String) jComboBox1.getSelectedItem();

                // Validasi pemilihan barang
                if (selectedBarang == null || selectedBarang.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Silakan pilih barang!", "Peringatan",
                                        JOptionPane.WARNING_MESSAGE);
                        return; // Menghentikan eksekusi jika barang tidak dipilih
                }

                // Pastikan semua komponen diambil dengan tipe yang benar
                int jumlah = (Integer) jSpinner3.getValue(); // Ambil jumlah dari JSpinner
                if (jumlah <= 0) {
                        JOptionPane.showMessageDialog(this, "Jumlah barang tidak boleh 0 atau negatif!", "Peringatan",
                                        JOptionPane.WARNING_MESSAGE);
                        return; // Menghentikan eksekusi jika jumlah tidak valid
                }

                double harga = ((Number) jSpinner1.getValue()).doubleValue(); // Cast dari Number ke double
                if (harga <= 0) {
                        JOptionPane.showMessageDialog(this, "Harga barang tidak boleh 0 atau negatif!", "Peringatan",
                                        JOptionPane.WARNING_MESSAGE);
                        return; // Menghentikan eksekusi jika harga tidak valid
                }

                double diskon = ((Number) jSpinner4.getValue()).doubleValue(); // Cast dari Number ke double
                double pajak = ((Number) jSpinner2.getValue()).doubleValue(); // Cast dari Number ke double

                // Hitung total harga
                double totalHarga = harga * jumlah * (1 - (diskon / 100)) * (1 + (pajak / 100));

                // Format untuk menampilkan angka dengan pemisah ribuan
                

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("barang.txt", true))) {
                        bw.write("Nama Barang: " + selectedBarang + "\n");
                        bw.write("Harga Satuan: " + String.format("%.0f", harga) + "\n"); // Menggunakan harga tanpa
                                                                                          // format ribuan
                        bw.write("Jumlah: " + jumlah + "\n");
                        bw.write("Pajak: " + String.format("%.0f%%", pajak) + "\n"); // Format pajak sebagai persentase
                        bw.write("Diskon: " + String.format("%.0f%%", diskon) + "\n"); // Format diskon sebagai
                                                                                       // persentase
                        bw.write("Total Harga: " + String.format("%.2f", totalHarga) + "\n"); // Total harga tanpa
                                                                                              // pemisah ribuan
                        bw.write("\n"); // Tambahkan pemisah untuk entri yang lebih baik
                        JOptionPane.showMessageDialog(this, "Barang berhasil ditambahkan!");

                        // Tanyakan kepada pengguna apakah ingin menambahkan barang lagi
                        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda ingin menambahkan barang lagi?",
                                        "Konfirmasi",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.NO_OPTION) {
                                // Kembali ke MainMenu
                                this.dispose(); // Menutup form saat ini
                                new MainMenu().setVisible(true); // Ganti dengan cara Anda menampilkan MainMenu
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error saat menambahkan barang.");
                }

        }

        

        public static void main(String args[]) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                        
                        public void run() {
                                Terdaftar frame = new Terdaftar(); // Membuat instance dari
                                                                   // Terdaftar
                                frame.pack(); // Memanggil pack untuk menyesuaikan ukuran
                                frame.setLocationRelativeTo(null); // Memusatkan JFrame
                                frame.setVisible(true); // Menampilkan JFrame
                        }
                });
        }

        // Variabel deklarasi
        private javax.swing.JButton jButton5;
        private javax.swing.JButton jButton6;
        private javax.swing.JComboBox<String> jComboBox1;
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
        private javax.swing.JSpinner jSpinner4;
        private javax.swing.JTextField jTextField1;

}
