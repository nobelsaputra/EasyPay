package com.mycompany.components.delete;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mycompany.MainMenu;

import java.io.*;
import java.text.NumberFormat;

public class Hapus extends javax.swing.JFrame {

    private DefaultTableModel model;

    public Hapus() {
        initComponents();
        loadTableData(); // Memuat data dari file ke tabel
        setTitle("EasyPay | Hapus Barang");
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        model = new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Nama", "Harga", "Jumlah", "Diskon", "Pajak", "Total Harga"
                });
        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getTableHeader().setPreferredSize(new java.awt.Dimension(100, 40));
        jTable1.setRowHeight(40);
        jTable1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));
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

        jButton1.setBackground(new java.awt.Color(115, 236, 139));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/image/image-delete/skeleton.png")));
        jButton1.setText("Hapus Semua");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(115, 236, 139));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Hapus");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("HAPUS BARANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 114,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(434, 434, 434)
                                .addComponent(jLabel1)
                                .addContainerGap(465, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)));

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
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenu MainMenu = new MainMenu();
        MainMenu.setVisible(true);
        dispose(); // Tutup jendela Hapus
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Menampilkan dialog konfirmasi
        int confirmation = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus semua barang?",
                "Konfirmasi Hapus Semua", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Menghapus semua baris di tabel
            saveData(); // Simpan data yang diperbarui ke file
            JOptionPane.showMessageDialog(this, "Semua barang berhasil dihapus!");
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            // Menampilkan dialog konfirmasi
            int confirmation = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus barang ini?",
                    "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                // Hapus baris yang dipilih
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(selectedRow);
                saveData(); // Simpan data yang diperbarui ke file
                JOptionPane.showMessageDialog(this, "Barang berhasil dihapus!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih barang yang ingin dihapus!");
        }
    }

    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Kosongkan tabel

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
                    price = parseCurrency(line.substring(14).trim()); // Menggunakan parseCurrency
                } else if (line.startsWith("Jumlah:")) {
                    quantity = parseIntSafely(line.substring(8).trim());
                } else if (line.startsWith("Pajak:")) {
                    tax = parseCurrency(line.substring(7, line.indexOf('%')).trim()); // Menggunakan parseCurrency
                } else if (line.startsWith("Diskon:")) {
                    discount = parseCurrency(line.substring(8, line.indexOf('%')).trim()); // Menggunakan parseCurrency
                }

                // Tambahkan item ke model jika baris kosong ditemukan
                if (line.isEmpty() && !name.isEmpty()) {
                    double total = (price * quantity) * (1 + tax / 100) * (1 - discount / 100);
                    model.addRow(new Object[] {
                            name,
                            formatCurrency(price), // Menampilkan harga dengan format yang benar
                            quantity,
                            (int) discount + "%", // Menampilkan diskon sebagai integer
                            (int) tax + "%", // Menampilkan pajak sebagai integer
                            formatCurrency(total) // Menampilkan total dengan format yang benar
                    });
                    // Reset variabel untuk item berikutnya
                    name = "";
                    price = 0;
                    quantity = 0;
                    tax = 0;
                    discount = 0;
                }
            }

            // Menangani item terakhir jika tidak diakhiri dengan baris kosong
            if (!name.isEmpty()) {
                double total = (price * quantity) * (1 + tax / 100) * (1 - discount / 100);
                model.addRow(new Object[] {
                        name,
                        formatCurrency(price),
                        quantity,
                        (int) discount + "%",
                        (int) tax + "%",
                        formatCurrency(total)
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
    }

    private String formatCurrency(double value) {
        // Format angka ke string dengan pemisah ribuan
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setGroupingUsed(true);
        formatter.setMinimumFractionDigits(0); // Tanpa desimal jika tidak ada
        return formatter.format(value).replace(",", "."); // Ganti pemisah ribuan dengan titik
    }

    private double parseCurrency(String currency) {
        // Menghilangkan titik pemisah ribuan jika ada, dan menggunakan titik desimal
        // Menggunakan regex untuk menghindari kesalahan parsing
        return Double.parseDouble(currency.replace(".", "").replace(",", ".")); // Mengubah sesuai format yang benar
    }

    private int parseIntSafely(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.err.println("Invalid integer value: " + value);
            return 0; // Atau lempar kembali exception
        }
    }

    private void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("barang.txt"))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                writer.println("Nama Barang: " + model.getValueAt(i, 0));
                writer.println("Harga Satuan: " + model.getValueAt(i, 1));
                writer.println("Jumlah: " + model.getValueAt(i, 2));
                writer.println("Pajak: " + model.getValueAt(i, 3));
                writer.println("Diskon: " + model.getValueAt(i, 4));
                writer.println("Total Harga: " + model.getValueAt(i, 5));
                writer.println(); // Baris kosong antara item
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Hapus().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
