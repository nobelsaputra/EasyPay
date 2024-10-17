package com.mycompany.components.transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.MainMenu;

import java.util.List;
import java.io.*;

public class Bayar extends javax.swing.JFrame {

    private DefaultTableModel tableModel;

    /**
     * Creates new form Bayar
     */
    public Bayar(List<String> items) {
        initComponents();
        initTable();
        loadItems(items);
        setTitle("EasyPay | Pembayaran");
    }

    private void initTable() {
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nama", "Harga", "Jumlah", "Diskon", "Pajak", "Total Harga" });
        jTable1.setModel(tableModel);
    }

    private void loadItems(List<String> items) {
        for (String item : items) {
            String[] lines = item.split("\n");
            if (lines.length >= 6) {
                String namaBarang = lines[0].substring("Nama Barang: ".length()).trim();
                String harga = lines[1].substring("Harga Satuan: ".length()).trim();
                String jumlah = lines[2].substring("Jumlah: ".length()).trim();
                String diskon = lines[3].substring("Diskon: ".length()).trim();
                String pajak = lines[4].substring("Pajak: ".length()).trim();
                String totalHarga = lines[5].substring("Total Harga: ".length()).trim();

                tableModel.addRow(new Object[] { namaBarang, harga, jumlah, diskon, pajak, totalHarga });
            }
        }
    }

    private void calculateChange() {
        try {
            double amountReceived = Double.parseDouble(jTextField1.getText());
            double totalToPay = calculateTotal();

            if (amountReceived < totalToPay) {
                JOptionPane.showMessageDialog(this, "Jumlah uang yang diterima kurang!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                jTextField2.setText(""); // Kosongkan kembalian jika pembayaran batal
                return; // Batalkan pembayaran
            }

            double change = amountReceived - totalToPay;
            jTextField2.setText(String.valueOf(change));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double calculateTotal() {
        double total = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            total += Double.parseDouble(tableModel.getValueAt(i, 5).toString());
        }
        return total;
    }

    private void saveToCSV() {
        try (PrintWriter writer = new PrintWriter(new File("data_transaksi.csv"))) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                sb.append(tableModel.getColumnName(i)).append(",");
            }
            sb.append("\n");
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    sb.append(tableModel.getValueAt(i, j)).append(",");
                }
                sb.append("\n");
            }
            writer.write(sb.toString());
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke CSV!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error menyimpan ke CSV!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToPDF() {
        try {
            // Membuat objek dokumen PDF
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            PdfWriter.getInstance(document, new FileOutputStream("struk_pembayaran.pdf"));
            document.open();

            // Format untuk tanggal dan waktu
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
            String currentDateTime = dateFormat.format(new java.util.Date());

            // Header
            com.itextpdf.text.Font titleFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA,
                    18, com.itextpdf.text.Font.BOLD);
            document.add(new com.itextpdf.text.Paragraph("Struk Pembayaran", titleFont));
            document.add(new com.itextpdf.text.Paragraph("Tanggal dan Waktu: " + currentDateTime + "\n\n"));

            // Detail Transaksi
            document.add(new com.itextpdf.text.Paragraph("Detail Transaksi:\n\n"));

            // Loop untuk menambahkan item yang dipilih ke dalam PDF
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String namaBarang = tableModel.getValueAt(i, 0).toString();
                String harga = tableModel.getValueAt(i, 1).toString();
                String jumlah = tableModel.getValueAt(i, 2).toString();
                String diskon = tableModel.getValueAt(i, 3).toString();
                String pajak = tableModel.getValueAt(i, 4).toString();
                String totalHarga = tableModel.getValueAt(i, 5).toString();

                document.add(new com.itextpdf.text.Paragraph("Nama Barang: " + namaBarang));
                document.add(new com.itextpdf.text.Paragraph("Harga: " + harga));
                document.add(new com.itextpdf.text.Paragraph("Jumlah: " + jumlah));
                document.add(new com.itextpdf.text.Paragraph("Diskon: " + diskon));
                document.add(new com.itextpdf.text.Paragraph("Pajak: " + pajak));
                document.add(new com.itextpdf.text.Paragraph("Total Harga: " + totalHarga));
                document.add(new com.itextpdf.text.Paragraph("\n------------------------\n"));
            }

            // Total Harga
            double totalHarga = calculateTotal();
            document.add(new com.itextpdf.text.Paragraph(String.format("Total Harga: %.2f\n", totalHarga)));

            // Jumlah Diterima dan Kembalian
            try {
                double jumlahDiterima = Double
                        .parseDouble(jTextField1.getText().trim().replace(".", "").replace(",", "."));
                double kembalian = jumlahDiterima - totalHarga;

                document.add(new com.itextpdf.text.Paragraph(String.format("Jumlah Diterima: %.2f", jumlahDiterima)));
                document.add(new com.itextpdf.text.Paragraph(String.format("Kembalian: %.2f", kembalian)));
            } catch (NumberFormatException e) {
                document.add(new com.itextpdf.text.Paragraph("Jumlah Diterima: Error"));
            }

            // Menutup dokumen
            document.close();

            JOptionPane.showMessageDialog(this, "Struk berhasil disimpan sebagai PDF!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error menyimpan ke PDF: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        double totalToPay = calculateTotal();
        double amountReceived = 0;

        try {
            amountReceived = Double.parseDouble(jTextField1.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Batalkan jika input tidak valid
        }

        if (amountReceived < totalToPay) {
            JOptionPane.showMessageDialog(this, "Jumlah uang yang diterima kurang, pembayaran dibatalkan!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return; // Batalkan pembayaran jika jumlah kurang
        }

        saveToCSV();
        saveToPDF();
        JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");
        MainMenu mainMenu = new MainMenu(); // Gantilah MainMenu dengan nama kelas menu utama Anda
        mainMenu.setVisible(true); // Tampilkan menu utama
        this.dispose(); // Menutup jendela ini (Bayar)
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        calculateChange();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0); // Keluar aplikasi
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */

    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
                new java.awt.Dimension(0, 32767));
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Set font untuk teks di dalam tabel
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // Ukuran font 16

        // Mengatur tinggi baris
        jTable1.setRowHeight(30); // Mengatur tinggi setiap baris menjadi 30 piksel
        jTable1.getTableHeader().setPreferredSize(new java.awt.Dimension(100, 40)); // Tinggi header 40 piksel

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Nama", "Harga", "Jumlah", "Diskon", "Pajak", "Total Harga"
                }));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(115, 236, 139));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Selesai");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Jumlah yang diterima");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTextField2.setEditable(false); // Kembalian hanya untuk baca

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Kembalian");

        jButton2.setBackground(new java.awt.Color(115, 236, 139));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Hitung");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Keluar");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("PEMBAYARAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
                                .addGap(11, 11, 11))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 248,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 248,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(92, 92, 92)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(392, 392, 392)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(66, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Menjalankan form dengan daftar barang yang diambil dari Barang.txt
        java.awt.EventQueue.invokeLater(() -> {
            List<String> items = loadItemsFromFile("Barang.txt");
            new Bayar(items).setVisible(true);
        });
    }

    private static List<String> loadItemsFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            List<String> items = new java.util.ArrayList<>();
            StringBuilder item = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    items.add(item.toString());
                    item = new StringBuilder();
                } else {
                    item.append(line).append("\n");
                }
            }
            if (item.length() > 0) {
                items.add(item.toString()); // Add the last item if not empty
            }
            reader.close();
            return items;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error membaca file: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            return java.util.Collections.emptyList();
        }
    }

    // Variabel deklarasi - jangan modifikasi
    @SuppressWarnings("unused")
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
}