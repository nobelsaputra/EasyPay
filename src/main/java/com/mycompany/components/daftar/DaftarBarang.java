package com.mycompany.components.daftar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mycompany.MainMenu;

public class DaftarBarang extends javax.swing.JFrame {

    public DaftarBarang() {
        initComponents();
        setTitle("EasyPay | Daftar Barang");
        loadTableData(); // Load data saat form dibuka
    }

    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing rows

        try (BufferedReader br = new BufferedReader(new FileReader("barang.txt"))) {
            String line;
            String name = "";
            double price = 0;
            int quantity = 0;
            double tax = 0;
            double discount = 0;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("Nama Barang:")) {
                    name = line.substring(12).trim();
                } else if (line.startsWith("Harga Satuan:")) {
                    price = parseCurrency(line.substring(14).trim()); // Parsing harga dari format dengan pemisah ribuan
                } else if (line.startsWith("Jumlah:")) {
                    quantity = Integer.parseInt(line.substring(8).trim());
                } else if (line.startsWith("Pajak:")) {
                    tax = Double.parseDouble(line.substring(7, line.indexOf('%')).trim()); // Ambil pajak dalam format
                                                                                           // desimal
                } else if (line.startsWith("Diskon:")) {
                    discount = Double.parseDouble(line.substring(8, line.indexOf('%')).trim()); // Ambil diskon dalam
                                                                                                // format desimal
                }

                // Setelah membaca semua atribut, hitung total harga
                if (line.isEmpty() && !name.isEmpty()) { // Pastikan nama tidak kosong
                    double total = (price * quantity) * (1 + tax / 100) * (1 - discount / 100);
                    model.addRow(new Object[] {
                            name,
                            formatCurrency(price), // Menggunakan metode formatCurrency untuk menampilkan harga
                            quantity,
                            (int) discount + "%", // Menampilkan diskon sebagai integer dan menambah "%" di belakangnya
                            (int) tax + "%", // Menampilkan pajak sebagai integer
                            formatCurrency(total) // Menggunakan metode formatCurrency untuk total
                    });
                    // Reset variabel untuk item berikutnya
                    name = "";
                    price = 0;
                    quantity = 0;
                    tax = 0;
                    discount = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatCurrency(double value) {
        // Format angka ke string dengan pemisah ribuan
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setGroupingUsed(true);
        formatter.setMinimumFractionDigits(0); // Tanpa desimal jika tidak ada
        return formatter.format(value);
    }

    private double parseCurrency(String currency) {
        // Menghilangkan titik pemisah ribuan jika ada, dan menggunakan titik desimal
        return Double.parseDouble(currency.replace(".", "").replace(",", ".")); // Mengubah sesuai format yang benar
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        double grandTotal = 0.0;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            // Ambil nilai total harga dari tabel dan hapus koma
            String totalHargaStr = model.getValueAt(i, 5).toString().replace(".", "").replace(",", ""); // Kolom Total
                                                                                                        // Harga
            try {
                // Parsing ke double setelah membersihkan string
                grandTotal += Double.parseDouble(totalHargaStr);
            } catch (NumberFormatException e) {
                // Menangani kesalahan parsing jika format tidak valid
                JOptionPane.showMessageDialog(this, "Format total harga tidak valid di baris " + (i + 1), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        // Tampilkan total dengan dua desimal
        javax.swing.JOptionPane.showMessageDialog(this, "Total Harga: " + String.format("%.2f", grandTotal));
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenu MainMenu = new MainMenu();
        MainMenu.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DAFTAR BARANG");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Nama", "Harga", "Jumlah", "Diskon", "Pajak", "Total Harga"
                }));

        // Set font untuk teks di dalam tabel
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // Ukuran font 16

        // Mengatur tinggi baris
        jTable1.setRowHeight(30); // Mengatur tinggi setiap baris menjadi 30 piksel
        jTable1.getTableHeader().setPreferredSize(new java.awt.Dimension(100, 40)); // Tinggi header 40 piksel
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(115, 236, 139));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Total Harga");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Kembali");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(368, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addGap(348, 348, 348))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)))));

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel1)
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null); // Center the frame
    }

    // Variabel declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new DaftarBarang().setVisible(true));
    }
}