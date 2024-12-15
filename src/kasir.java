import java.awt.print.PrinterException;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlCursor.TokenType;

import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.compress.archivers.zip.ZipFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.DriverManager;

import java.text.SimpleDateFormat;

import java.awt.event.KeyEvent;




/**
 *
 * @author paulj
 */
    public class kasir extends javax.swing.JFrame {
        Connection con;
        Statement stat;
        ResultSet rs;
    
    


    /**
     * Creates new form kasir
     */
    public kasir() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setLocationRelativeTo(this);
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        clock();
        jLabel3.setText(new SimpleDateFormat("dd / MMMM / YYYY").format(new java.util.Date()));
        
        // Set model untuk JTable
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Item");
        model.addColumn("Quantity");
        model.addColumn("Amount");
        jTable1.setModel(model);
        tampildata(); // Tampilkan data awal
     jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int selectedRow = jTable1.getSelectedRow();

            String item = jTable1.getValueAt(selectedRow, 0).toString();
            String quantity = jTable1.getValueAt(selectedRow, 1).toString();
            String amount = jTable1.getValueAt(selectedRow, 2).toString();

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            model.addRow(new Object[]{item, quantity, amount});
            
            txtitem.setText(item);
            txtquantity.setText(quantity);
            txtamount.setText(amount);
            
        }
    });
}
        
    void insert() {
    String sql = "INSERT INTO kasir (item, quantity, amount,) VALUES (?, ?, ?, ?, ?, ?, ?, ?. ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,)";
    try {
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        // Mengatur nilai parameter
        pstmt.setString(1, jButtonLego.getText());
        pstmt.setString(2, jButtonRubik.getText());
        pstmt.setString(3, jButtonRemoteCar.getText());
        pstmt.setString(4, jButtonTeddybear.getText());
        pstmt.setString(5, jButtonWaterGun.getText());
        pstmt.setString(6, jButtonSwordToys.getText());
        pstmt.setString(7, jButtonspidermanmask.getText());
        pstmt.setString(8, jButtonspinner.getText());
        pstmt.setString(9, jButtonNintendo.getText());
        pstmt.setString(10,jButtonmotor.getText());
        pstmt.setString(11,jButtondrone.getText());
        pstmt.setString(12,jButtonSlime.getText());
        pstmt.setString(13,jButtonhotwheel.getText());
        pstmt.setString(14,jButtongundam.getText());
        pstmt.setString(15,jButtonUno.getText());
        pstmt.setString(16,jButtonMonopoly.getText());
        pstmt.setString(17,jButtonPancingan.getText());
        pstmt.setString(18,jButtonBonekaBarbie.getText());
        pstmt.setString(19,jButtonironman.getText());
        pstmt.setString(20,jButtonNaruto.getText());
        pstmt.setString(21,jButtonPokemon.getText());
        pstmt.setString(22,jButtonBola.getText());
        pstmt.setString(23,jButtonroblox.getText());
        // Eksekusi query untuk menyimpan data
        pstmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        clearFields(); // Bersihkan input setelah simpan
        tampildata(); // Tampilkan data terbaru setelah simpan
    } catch (SQLException e) {
        // Menangani kesalahan SQL
        JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        // Menangani kesalahan umum
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
      private void clearFields() {
    jTextDisplay.setText("");
    jTextChange.setText("");
    jTextDiscount.setText("");
    jTextTotal.setText("");
    jTextSubtotal.setText("");
}

    

        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextDisplay = new javax.swing.JTextField();
        jTextChange = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboPayment = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextTotal = new javax.swing.JTextField();
        jTextSubtotal = new javax.swing.JTextField();
        jTextDiscount = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButtonExit = new javax.swing.JButton();
        jButtonPay = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonexportexcel = new javax.swing.JButton();
        jButtonupdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton07 = new javax.swing.JButton();
        jButton09 = new javax.swing.JButton();
        jButton08 = new javax.swing.JButton();
        jButton04 = new javax.swing.JButton();
        jButton05 = new javax.swing.JButton();
        jButton06 = new javax.swing.JButton();
        jButton01 = new javax.swing.JButton();
        jButton02 = new javax.swing.JButton();
        jButton03 = new javax.swing.JButton();
        jButton00 = new javax.swing.JButton();
        jButtonPeriod = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButtonLego = new javax.swing.JButton();
        jButtonRubik = new javax.swing.JButton();
        jButtonRemoteCar = new javax.swing.JButton();
        jButtonNintendo = new javax.swing.JButton();
        jButtonspinner = new javax.swing.JButton();
        jButtonspidermanmask = new javax.swing.JButton();
        jButtonhotwheel = new javax.swing.JButton();
        jButtonUno = new javax.swing.JButton();
        jButtongundam = new javax.swing.JButton();
        jButtonPokemon = new javax.swing.JButton();
        jButtonNaruto = new javax.swing.JButton();
        jButtonironman = new javax.swing.JButton();
        jButtonTeddybear = new javax.swing.JButton();
        jButtonWaterGun = new javax.swing.JButton();
        jButtonSwordToys = new javax.swing.JButton();
        jButtonSlime = new javax.swing.JButton();
        jButtondrone = new javax.swing.JButton();
        jButtonmotor = new javax.swing.JButton();
        jButtonMonopoly = new javax.swing.JButton();
        jButtonBonekaBarbie = new javax.swing.JButton();
        jButtonPancingan = new javax.swing.JButton();
        jButtonroblox = new javax.swing.JButton();
        jButtonBola = new javax.swing.JButton();
        jButtonbakugan1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtamount = new javax.swing.JTextField();
        txtitem = new javax.swing.JTextField();
        txtquantity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblclock = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Payment Method");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 210, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Cash ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, 30));

        jTextDisplay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDisplayActionPerformed(evt);
            }
        });
        jPanel3.add(jTextDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 200, 40));

        jTextChange.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextChangeActionPerformed(evt);
            }
        });
        jPanel3.add(jTextChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 200, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Change           ");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 210, 30));

        jComboPayment.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jComboPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Debit", "Credit", "QR Pay" }));
        jComboPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboPaymentActionPerformed(evt);
            }
        });
        jPanel3.add(jComboPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 200, 40));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 440, 200));

        jPanel5.setBackground(new java.awt.Color(102, 153, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Total");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Subtotal");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Discount");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 30));

        jTextTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel5.add(jTextTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 200, 40));

        jTextSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSubtotalActionPerformed(evt);
            }
        });
        jPanel5.add(jTextSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 200, 40));

        jTextDiscount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDiscountActionPerformed(evt);
            }
        });
        jPanel5.add(jTextDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 200, 40));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 200));

        jPanel6.setBackground(new java.awt.Color(102, 153, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonExit.setBackground(new java.awt.Color(255, 0, 0));
        jButtonExit.setFont(new java.awt.Font("Segoe UI", 1, 37)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("EXIT");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, 60));

        jButtonPay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonPay.setText("PAY");
        jButtonPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPayActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 50));

        jButtonReset.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonReset.setText("RESET");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 200, 50));

        jButtonDelete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonDelete.setText("DELETE");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 200, 50));

        jButtonexportexcel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonexportexcel.setText("Export Excel");
        jButtonexportexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonexportexcelActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonexportexcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 50));

        jButtonupdate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonupdate.setText("UPDATE");
        jButtonupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonupdateActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 200, 60));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 440, 200));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton07.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton07.setText("7");
        jButton07.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton07.setPreferredSize(new java.awt.Dimension(75, 80));
        jButton07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07ActionPerformed(evt);
            }
        });
        jButton07.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton07KeyPressed(evt);
            }
        });
        jPanel2.add(jButton07, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 100));

        jButton09.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton09.setText("9");
        jButton09.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton09.setPreferredSize(new java.awt.Dimension(75, 80));
        jButton09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton09ActionPerformed(evt);
            }
        });
        jButton09.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton09KeyPressed(evt);
            }
        });
        jPanel2.add(jButton09, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 90, 100));

        jButton08.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton08.setText("8");
        jButton08.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton08.setPreferredSize(new java.awt.Dimension(75, 80));
        jButton08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton08ActionPerformed(evt);
            }
        });
        jButton08.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton08KeyPressed(evt);
            }
        });
        jPanel2.add(jButton08, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 90, 100));

        jButton04.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton04.setText("4");
        jButton04.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton04.setPreferredSize(new java.awt.Dimension(75, 80));
        jButton04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton04ActionPerformed(evt);
            }
        });
        jButton04.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton04KeyPressed(evt);
            }
        });
        jPanel2.add(jButton04, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 100));

        jButton05.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton05.setText("5");
        jButton05.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton05.setPreferredSize(new java.awt.Dimension(75, 80));
        jButton05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton05ActionPerformed(evt);
            }
        });
        jButton05.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton05KeyPressed(evt);
            }
        });
        jPanel2.add(jButton05, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 90, 100));

        jButton06.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton06.setText("6");
        jButton06.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton06.setPreferredSize(new java.awt.Dimension(75, 80));
        jButton06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton06ActionPerformed(evt);
            }
        });
        jButton06.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton06KeyPressed(evt);
            }
        });
        jPanel2.add(jButton06, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 90, 100));

        jButton01.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton01.setText("1");
        jButton01.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton01.setPreferredSize(new java.awt.Dimension(75, 80));
        jButton01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton01ActionPerformed(evt);
            }
        });
        jButton01.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton01KeyPressed(evt);
            }
        });
        jPanel2.add(jButton01, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 90, 100));

        jButton02.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton02.setText("2");
        jButton02.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton02.setPreferredSize(new java.awt.Dimension(75, 80));
        jButton02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton02ActionPerformed(evt);
            }
        });
        jButton02.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton02KeyPressed(evt);
            }
        });
        jPanel2.add(jButton02, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 90, 100));

        jButton03.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton03.setText("3");
        jButton03.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton03.setPreferredSize(new java.awt.Dimension(75, 80));
        jButton03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton03ActionPerformed(evt);
            }
        });
        jButton03.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton03KeyPressed(evt);
            }
        });
        jPanel2.add(jButton03, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 90, 100));

        jButton00.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton00.setText("0");
        jButton00.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton00.setPreferredSize(new java.awt.Dimension(75, 80));
        jButton00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton00ActionPerformed(evt);
            }
        });
        jButton00.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton00KeyPressed(evt);
            }
        });
        jPanel2.add(jButton00, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 90, 100));

        jButtonPeriod.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButtonPeriod.setForeground(new java.awt.Color(255, 0, 0));
        jButtonPeriod.setText(".");
        jButtonPeriod.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonPeriod.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPeriodActionPerformed(evt);
            }
        });
        jButtonPeriod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonPeriodKeyPressed(evt);
            }
        });
        jPanel2.add(jButtonPeriod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 90, 100));

        jButtonCancel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButtonCancel.setForeground(new java.awt.Color(255, 0, 51));
        jButtonCancel.setText("C");
        jButtonCancel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCancel.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jButtonCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonCancelKeyPressed(evt);
            }
        });
        jPanel2.add(jButtonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 90, 100));

        jTable1.setBackground(new java.awt.Color(204, 255, 255));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Amount"
            }
        ));
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonLego.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLego.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButtonLego.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/8b3db5f5cdc544aa80b1314084f9b328-removebg-preview (1).png"))); // NOI18N
        jButtonLego.setText("Rp.150.000");
        jButtonLego.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonLego.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLego.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonLego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLegoActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonLego, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 100));

        jButtonRubik.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonRubik.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRubik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rubik-removebg blue.png"))); // NOI18N
        jButtonRubik.setText("Rp.50.000");
        jButtonRubik.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRubik.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRubik.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonRubik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRubikActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonRubik, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 90, 100));

        jButtonRemoteCar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButtonRemoteCar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRemoteCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/remote_cars blue.png"))); // NOI18N
        jButtonRemoteCar.setText("Rp.300.000");
        jButtonRemoteCar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRemoteCar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRemoteCar.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonRemoteCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoteCarActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonRemoteCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 90, 100));

        jButtonNintendo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButtonNintendo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNintendo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nintendo blue.png"))); // NOI18N
        jButtonNintendo.setText("Rp.370.000");
        jButtonNintendo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonNintendo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNintendo.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonNintendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNintendoActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonNintendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 90, 100));

        jButtonspinner.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonspinner.setForeground(new java.awt.Color(255, 255, 255));
        jButtonspinner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spinner-blue.png"))); // NOI18N
        jButtonspinner.setText("Rp.15.000");
        jButtonspinner.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonspinner.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonspinner.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonspinner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonspinnerActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonspinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 90, 100));

        jButtonspidermanmask.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonspidermanmask.setForeground(new java.awt.Color(255, 255, 255));
        jButtonspidermanmask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spiderman_mask-blue.png"))); // NOI18N
        jButtonspidermanmask.setText("Rp.10.000");
        jButtonspidermanmask.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonspidermanmask.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonspidermanmask.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonspidermanmask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonspidermanmaskActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonspidermanmask, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, 100));

        jButtonhotwheel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonhotwheel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonhotwheel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hot wheels.jpeg"))); // NOI18N
        jButtonhotwheel.setText("Rp.17.000");
        jButtonhotwheel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonhotwheel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonhotwheel.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonhotwheel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhotwheelActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonhotwheel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 90, 100));

        jButtonUno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonUno.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Uno blue.png"))); // NOI18N
        jButtonUno.setText("Rp.13.000");
        jButtonUno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonUno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUno.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnoActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 90, 100));

        jButtongundam.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButtongundam.setForeground(new java.awt.Color(255, 255, 255));
        jButtongundam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gundam-blue.png"))); // NOI18N
        jButtongundam.setText("Rp.150.000");
        jButtongundam.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtongundam.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtongundam.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtongundam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtongundamActionPerformed(evt);
            }
        });
        jPanel7.add(jButtongundam, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 90, 100));

        jButtonPokemon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonPokemon.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPokemon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pokemon.jpeg"))); // NOI18N
        jButtonPokemon.setText("Rp.4000");
        jButtonPokemon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonPokemon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPokemon.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonPokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPokemonActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 90, 100));

        jButtonNaruto.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButtonNaruto.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNaruto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/naruto.jpeg"))); // NOI18N
        jButtonNaruto.setText("Rp.13.000");
        jButtonNaruto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonNaruto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNaruto.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonNaruto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNarutoActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonNaruto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 90, 100));

        jButtonironman.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButtonironman.setForeground(new java.awt.Color(255, 255, 255));
        jButtonironman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ironman_png__Little_Ironman_-blue.png"))); // NOI18N
        jButtonironman.setText("Rp.100.000");
        jButtonironman.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonironman.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonironman.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonironman.setVerifyInputWhenFocusTarget(false);
        jButtonironman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonironmanActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonironman, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 90, 100));

        jButtonTeddybear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonTeddybear.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTeddybear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/teddy bear blue.png"))); // NOI18N
        jButtonTeddybear.setText("Rp.70.000");
        jButtonTeddybear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonTeddybear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonTeddybear.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonTeddybear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTeddybearActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonTeddybear, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 90, 100));

        jButtonWaterGun.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonWaterGun.setForeground(new java.awt.Color(255, 255, 255));
        jButtonWaterGun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/water_gun blue.png"))); // NOI18N
        jButtonWaterGun.setText("Rp.50.000");
        jButtonWaterGun.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonWaterGun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonWaterGun.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonWaterGun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWaterGunActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonWaterGun, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 90, 100));

        jButtonSwordToys.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonSwordToys.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSwordToys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sword_toys-blue.png"))); // NOI18N
        jButtonSwordToys.setText("Rp.35.000");
        jButtonSwordToys.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSwordToys.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSwordToys.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonSwordToys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSwordToysActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonSwordToys, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 90, 100));

        jButtonSlime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonSlime.setForeground(new java.awt.Color(255, 0, 51));
        jButtonSlime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/slime blue.png"))); // NOI18N
        jButtonSlime.setText("Rp.7000");
        jButtonSlime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSlime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSlime.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonSlime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSlimeActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonSlime, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 90, 100));

        jButtondrone.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButtondrone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/drone-blue.png"))); // NOI18N
        jButtondrone.setText("Rp.135.000");
        jButtondrone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtondrone.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtondrone.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtondrone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtondroneActionPerformed(evt);
            }
        });
        jPanel7.add(jButtondrone, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 90, 100));

        jButtonmotor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonmotor.setForeground(new java.awt.Color(255, 255, 255));
        jButtonmotor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/motor_toys-blue.png"))); // NOI18N
        jButtonmotor.setText("Rp.3000");
        jButtonmotor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonmotor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonmotor.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonmotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonmotorActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonmotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 90, 100));

        jButtonMonopoly.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonMonopoly.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMonopoly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/monopoly-blue.png"))); // NOI18N
        jButtonMonopoly.setText("Rp.20.000");
        jButtonMonopoly.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonMonopoly.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMonopoly.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonMonopoly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMonopolyActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonMonopoly, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 90, 100));

        jButtonBonekaBarbie.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBonekaBarbie.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBonekaBarbie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boneka Barbie.jpeg"))); // NOI18N
        jButtonBonekaBarbie.setText("Rp.35.000");
        jButtonBonekaBarbie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonBonekaBarbie.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBonekaBarbie.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonBonekaBarbie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBonekaBarbieActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonBonekaBarbie, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 90, 100));

        jButtonPancingan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonPancingan.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPancingan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pancingan-blue.png"))); // NOI18N
        jButtonPancingan.setText("Rp.25.000");
        jButtonPancingan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonPancingan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPancingan.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonPancingan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPancinganActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonPancingan, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 90, 100));

        jButtonroblox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonroblox.setForeground(new java.awt.Color(255, 255, 255));
        jButtonroblox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Roblox_blue.png"))); // NOI18N
        jButtonroblox.setText("Rp.15000");
        jButtonroblox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonroblox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonroblox.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonroblox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonrobloxActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonroblox, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 90, 100));

        jButtonBola.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBola.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Bola.jpeg"))); // NOI18N
        jButtonBola.setText("Rp.12.000");
        jButtonBola.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonBola.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBola.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonBola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBolaActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonBola, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 90, 100));

        jButtonbakugan1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonbakugan1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonbakugan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bakugan.jpeg"))); // NOI18N
        jButtonbakugan1.setText("Rp.3000");
        jButtonbakugan1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonbakugan1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonbakugan1.setPreferredSize(new java.awt.Dimension(75, 80));
        jButtonbakugan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbakugan1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonbakugan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 90, 100));

        jLabel1.setBackground(new java.awt.Color(204, 0, 51));
        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 40)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TOYLAND (2) (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(3, 3, 3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 890));

        jTable2.setBackground(new java.awt.Color(204, 255, 255));
        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Amount"
            }
        ));
        jTable2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 160, 470, 450));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setText("Pusat Informasi Dan Edit");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel11.setText("Amount");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1710, 630, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel12.setText("Quantity");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 630, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel13.setText("Item");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 630, -1, -1));

        txtamount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 680, 150, -1));

        txtitem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 680, 150, -1));

        txtquantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 680, 150, -1));

        jLabel3.setBackground(new java.awt.Color(204, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/calendar.png"))); // NOI18N
        jLabel3.setText("Tanggal");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 50, 250, 30));

        lblclock.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        lblclock.setForeground(new java.awt.Color(255, 255, 255));
        lblclock.setText("-");
        getContentPane().add(lblclock, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 10, 220, -1));

        jPanel9.setBackground(new java.awt.Color(102, 153, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 0, 490, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void ItemCost() {
    double sum = 0;

    // Menghitung total dari kolom tertentu di jTable1
    for (int i = 0; i < jTable1.getRowCount(); i++) {
        String amountStr = jTable1.getValueAt(i, 2).toString(); // Ambil nilai dari kolom Amount
        amountStr = amountStr.replace("Rp. ", "").replace(".", "").trim(); // Hapus "Rp." dan titik
        sum += Double.parseDouble(amountStr); // Konversi ke double
    }

    // Format angka ke dalam Rupiah
    NumberFormat rupiahFormat = NumberFormat.getInstance(new Locale("id", "ID"));

    // Menampilkan subtotal di JTextField dengan format Rupiah
    jTextSubtotal.setText("Rp. " + rupiahFormat.format(sum));

    // Menghitung diskon sebesar 3%
    double discount = sum * 0.03; // Diskon 3%
    jTextDiscount.setText("Rp. " + rupiahFormat.format(discount));

    // Total setelah diskon
    double totalAfterDiscount = sum - discount;
    jTextTotal.setText("Rp. " + rupiahFormat.format(totalAfterDiscount));

}
    public void Change() {
        double sum = 0;
        double cash = Double.parseDouble(jTextDisplay.getText()); // Input jumlah uang dari pelanggan

        // Menghitung total dari kolom tertentu di jTable1
        for (int i = 0; i < jTable1.getRowCount(); i++) {
        String amountStr = jTable1.getValueAt(i, 2).toString(); // Ambil nilai dari kolom Amount
        amountStr = amountStr.replace("Rp. ", "").replace(".", "").trim(); // Hapus "Rp." dan spasi
        sum += Double.parseDouble(amountStr); // Konversi ke double
    }

        // format angka
        NumberFormat rupiahFormat = NumberFormat.getInstance(new Locale("id", "ID"));

        // Menghitung diskon sebesar 3.60%
        double cTextDiscount = (sum * (3.00 / 100));
        double total = sum - cTextDiscount;

        // Validasi apakah uang yang dibayar mencukupi
        if (cash < total) {
        // Tampilkan notifikasi menggunakan JOptionPane
        JOptionPane.showMessageDialog(
            this, 
            "Uang yang Anda masukkan tidak mencukupi untuk pembayaran!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE
        );
    }   else {
        // Menghitung kembalian jika uang mencukupi
        double cChange = cash - total;

        // Format kembalian dalam bentuk Rupiah
        String ChangeGiven = "Rp " + rupiahFormat.format(cChange);
        jTextChange.setText(ChangeGiven);
    }
}

    private void jTextDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDisplayActionPerformed

    private void jTextChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextChangeActionPerformed
    
    }//GEN-LAST:event_jTextChangeActionPerformed

    private void jComboPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboPaymentActionPerformed

    private void jTextSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSubtotalActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPayActionPerformed
                                               
    // Cek apakah metode pembayaran adalah "Cash"
    if (jComboPayment.getSelectedItem().equals("Cash")) {
        // Validasi input pembayaran untuk metode "Cash"
        try {
            // [Perubahan] Tambahkan format "Rp." pada cash
            String cashInput = jTextDisplay.getText().trim();
            if (!cashInput.startsWith("Rp.")) {
                cashInput = "Rp. " + cashInput; // Tambahkan Rp. jika belum ada
                jTextDisplay.setText(cashInput); // Update tampilan TextField
            }
            
            // Hapus "Rp." dan titik untuk melakukan perhitungan
            double cash = Double.parseDouble(cashInput.replace("Rp. ", "").replace(".", "").trim());
            double total = Double.parseDouble(jTextTotal.getText().replace("Rp. ", "").replace(".", "").trim());
            
            if (cash < total) { // Jika uang kurang
                JOptionPane.showMessageDialog(this, 
                    "Uang tidak cukup! Masukkan nominal yang sesuai.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                jTextDisplay.requestFocus(); // Fokus kembali ke input uang
                return; // Keluar tanpa melanjutkan pembayaran
            } else if (cash > total) { // Jika uang lebih
                int change = (int) (cash - total); // [Diperbarui] Kembalian tanpa desimal
                jTextChange.setText("Rp. " + change); // [Diperbarui] Tampilkan kembalian dengan format "Rp."
                JOptionPane.showMessageDialog(this, 
                    "Kembalian Anda: Rp. " + change, 
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                jTextChange.setText("Rp. 0"); // Tidak ada kembalian jika uang pas
            }

            // Simpan data dari JTable ke database
            saveDataToDatabase();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Input uang tidak valid! Harap masukkan angka yang benar.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            jTextDisplay.requestFocus(); // Fokus kembali ke input uang
            return;
        }
    } else {
        // Untuk metode pembayaran lain (Debit, Credit, Qr Pay), simpan data ke database tanpa menghitung kembalian
        saveDataToDatabase();
    }

    // Reset field pembayaran
    jTextSubtotal.setText("Rp. 0");
    jTextDiscount.setText("Rp. 0");
    jTextTotal.setText("Rp. 0");
    jTextDisplay.setText("");
    jTextChange.setText("");

}


// Fungsi untuk menyimpan data ke database
    private void saveDataToDatabase() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // Periksa apakah tabel memiliki data
    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "Tidak ada barang di tabel untuk disimpan!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Query untuk menyimpan data ke database
        String sql = "INSERT INTO kasir (item, quantity, amount) VALUES (?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);

        // Iterasi setiap baris di JTable
        for (int i = 0; i < model.getRowCount(); i++) {
            String item = model.getValueAt(i, 0).toString();
            int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());

            // Ambil nilai amount dan hapus "Rp." serta titik
            String amountStr = model.getValueAt(i, 2).toString();
            amountStr = amountStr.replace("Rp. ", "").replace(".", "").trim(); 
            double amount = Double.parseDouble(amountStr);

            // Set nilai parameter PreparedStatement
            pstmt.setString(1, item);
            pstmt.setInt(2, quantity);
            pstmt.setDouble(3, amount);

            // Eksekusi query untuk setiap baris
            pstmt.addBatch();
        }

        // Menjalankan batch insert untuk menyimpan semua data ke dalam database
        pstmt.executeBatch(); 

        // Menampilkan pesan sukses
        JOptionPane.showMessageDialog(null, "Pembayaran berhasil! Data telah disimpan ke database.");
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menyimpan data ke database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Format angka tidak valid: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButtonPayActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // Menampilkan dialog konfirmasi
        int option = JOptionPane.showConfirmDialog(null, 
                "Apakah Anda yakin ingin menghapus data ini dari tabel dan database?", 
                "Konfirmasi Penghapusan", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Jika user memilih Yes (yakin untuk menghapus)
        if (option == JOptionPane.YES_OPTION) {
            // Menghapus data dari tabel
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Menghapus data di tabel

            // Reset nilai input lainnya
            jTextChange.setText("");
            jTextDiscount.setText("");
            jTextTotal.setText("");
            jTextSubtotal.setText("");
            jTextDisplay.setText("");

            // Menghapus data di database
            try {
                // Buat koneksi ke database
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_kasir", "root", ""); // Ganti dengan username dan password Anda

                // Query untuk menghapus semua data di tabel kasir
                String query = "DELETE FROM kasir"; // Menghapus seluruh data dari tabel kasir
                PreparedStatement pst = con.prepareStatement(query);
                pst.executeUpdate(); // Eksekusi query

                // Menampilkan pesan konfirmasi sukses
                JOptionPane.showMessageDialog(null, "Data telah di-reset dan dihapus dari database.");
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data dari database: " + e.getMessage());
            }
        } else {
            // Jika user memilih No, tidak ada yang dihapus
            JOptionPane.showMessageDialog(null, "Data tidak dihapus.");
        }       
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
                                                  
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    // Mendapatkan baris yang dipilih
    int RemoveItem = jTable1.getSelectedRow();
    
    // Cek apakah ada item yang dipilih
    if (RemoveItem >= 0) {
        // Ambil data item yang dipilih (kolom pertama)
        String itemToRemove = model.getValueAt(RemoveItem, 0).toString();
        
        // Menghapus item dari JTable
        model.removeRow(RemoveItem);
        
        // Hapus item yang terpilih dari database
        try {
            // Query untuk menghapus data dari database berdasarkan item
            String sql = "DELETE FROM kasir WHERE item = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, itemToRemove);
            
            // Eksekusi query
            pstmt.executeUpdate();
            
            // Informasikan bahwa item telah berhasil dihapus
            JOptionPane.showMessageDialog(null, "Item berhasil dihapus dari tabel dan database.");
            
        } catch (SQLException e) {
            // Menangani kesalahan saat menghapus data dari database
            JOptionPane.showMessageDialog(null, "Gagal menghapus data dari database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonexportexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonexportexcelActionPerformed
                                                   
    // Ambil data dari JTable
    List<String[]> data = new ArrayList<>();
    for (int row = 0; row < jTable1.getRowCount(); row++) { // Ganti jTable1 dengan nama JTable Anda
        String[] rowData = new String[jTable1.getColumnCount()];
        for (int col = 0; col < jTable1.getColumnCount(); col++) {
            rowData[col] = jTable1.getValueAt(row, col).toString();
        }
        data.add(rowData);
    }

    // Memilih lokasi file menggunakan JFileChooser
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Simpan File Excel");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

    int userSelection = fileChooser.showSaveDialog(this); // this = parent JFrame
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

        // Tambahkan ekstensi .xlsx jika tidak ada
        if (!filePath.endsWith(".xlsx")) {
            filePath += ".xlsx";
        }

        // Membuat file Excel
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Data Kasir");

            // Style untuk header
            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderTop(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Style untuk data
            CellStyle dataStyle = workbook.createCellStyle();
            dataStyle.setBorderBottom(BorderStyle.THIN);
            dataStyle.setBorderTop(BorderStyle.THIN);
            dataStyle.setBorderLeft(BorderStyle.THIN);
            dataStyle.setBorderRight(BorderStyle.THIN);

            // Header
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Item", "Quantity", "Amount"}; // Header sesuai dengan tabel GUI
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            // Isi Data
            int rowNum = 1;
            for (String[] rowData : data) {
                Row row = sheet.createRow(rowNum++);
                for (int i = 0; i < rowData.length; i++) {
                    Cell cell = row.createCell(i);
                    if (i == 1) { // Kolom Quantity
                        try {
                            int quantity = Integer.parseInt(rowData[i]);
                            cell.setCellValue(quantity); // Sebagai angka
                        } catch (NumberFormatException e) {
                            cell.setCellValue(rowData[i]); // Jika gagal parsing, simpan sebagai teks
                        }
                    } else if (i == 2) { // Kolom Amount
                        cell.setCellValue(rowData[i]); // Tetap sebagai String
                    } else {
                        cell.setCellValue(rowData[i]); // Untuk kolom lainnya
                    }
                    cell.setCellStyle(dataStyle);
                }
            }

            // Auto-size kolom
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Menulis data ke file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(this, "Data berhasil diexport ke " + filePath);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file: " + e.getMessage());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat membuat file Excel: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Proses penyimpanan dibatalkan.");
    }

    }//GEN-LAST:event_jButtonexportexcelActionPerformed

    private void jButton07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07ActionPerformed
        String Enternumber = jTextDisplay.getText();

        if (Objects.equals(Enternumber, "")) {
            jTextDisplay.setText(jButton07.getText());
        }
        else {
            Enternumber = jTextDisplay.getText() + jButton07.getText();
            jTextDisplay.setText(Enternumber);
        }
    }//GEN-LAST:event_jButton07ActionPerformed

    private void jButton09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton09ActionPerformed
        String Enternumber = jTextDisplay.getText();

        if (Objects.equals(Enternumber, "")) {
            jTextDisplay.setText(jButton09.getText());
        }
        else {
            Enternumber = jTextDisplay.getText() + jButton09.getText();
            jTextDisplay.setText(Enternumber);
        }
    }//GEN-LAST:event_jButton09ActionPerformed

    private void jButton08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton08ActionPerformed
        String Enternumber = jTextDisplay.getText();

        if (Objects.equals(Enternumber, "")) {
            jTextDisplay.setText(jButton08.getText());
        }
        else {
            Enternumber = jTextDisplay.getText() + jButton08.getText();
            jTextDisplay.setText(Enternumber);
        }
    }//GEN-LAST:event_jButton08ActionPerformed

    private void jButton04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton04ActionPerformed
        String Enternumber = jTextDisplay.getText();

        if (Objects.equals(Enternumber, "")) {
            jTextDisplay.setText(jButton04.getText());
        }
        else {
            Enternumber = jTextDisplay.getText() + jButton04.getText();
            jTextDisplay.setText(Enternumber);
        }
    }//GEN-LAST:event_jButton04ActionPerformed

    private void jButton05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton05ActionPerformed
        String Enternumber = jTextDisplay.getText();

        if (Objects.equals(Enternumber, "")) {
            jTextDisplay.setText(jButton05.getText());
        }
        else {
            Enternumber = jTextDisplay.getText() + jButton05.getText();
            jTextDisplay.setText(Enternumber);
        }
    }//GEN-LAST:event_jButton05ActionPerformed

    private void jButton06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton06ActionPerformed
        String Enternumber = jTextDisplay.getText();

        if (Objects.equals(Enternumber, "")) {
            jTextDisplay.setText(jButton06.getText());
        }
        else {
            Enternumber = jTextDisplay.getText() + jButton06.getText();
            jTextDisplay.setText(Enternumber);
        }
    }//GEN-LAST:event_jButton06ActionPerformed

    private void jButton01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton01ActionPerformed
        String Enternumber = jTextDisplay.getText();

        if (Objects.equals(Enternumber, "")) {
            jTextDisplay.setText(jButton01.getText());
        }
        else {
            Enternumber = jTextDisplay.getText() + jButton01.getText();
            jTextDisplay.setText(Enternumber);
        }
    }//GEN-LAST:event_jButton01ActionPerformed

    private void jButton02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton02ActionPerformed
        String Enternumber = jTextDisplay.getText();

        if (Objects.equals(Enternumber, "")) {
            jTextDisplay.setText(jButton02.getText());
        }
        else {
            Enternumber = jTextDisplay.getText() + jButton02.getText();
            jTextDisplay.setText(Enternumber);
        }
    }//GEN-LAST:event_jButton02ActionPerformed

    private void jButton03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton03ActionPerformed
        String Enternumber = jTextDisplay.getText();

        if (Objects.equals(Enternumber, "")) {
            jTextDisplay.setText(jButton03.getText());
        }
        else {
            Enternumber = jTextDisplay.getText() + jButton03.getText();
            jTextDisplay.setText(Enternumber);
        }
    }//GEN-LAST:event_jButton03ActionPerformed

    private void jButton00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton00ActionPerformed
        String Enternumber = jTextDisplay.getText();

        if (Objects.equals(Enternumber, "")) {
            jTextDisplay.setText(jButton00.getText());
        }
        else {
            Enternumber = jTextDisplay.getText() + jButton00.getText();
            jTextDisplay.setText(Enternumber);
        }
    }//GEN-LAST:event_jButton00ActionPerformed

    private void jButtonPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPeriodActionPerformed
        if (! jTextDisplay.getText().contains(".")); {
            jTextDisplay.setText(jTextDisplay.getText() + jButtonPeriod.getText());
        }
    }//GEN-LAST:event_jButtonPeriodActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        jTextDisplay.setText("");
        jTextChange.setText("");
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorAdded

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed

    }//GEN-LAST:event_jTable1KeyPressed

    private void jButtonLegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLegoActionPerformed
        double priceOfItem = 150000.0;

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.addRow(new Object[] {"Lego: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
    ItemCost();
    }//GEN-LAST:event_jButtonLegoActionPerformed

    private void jButtonRubikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRubikActionPerformed
        double priceOfItem = 50000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Rubik: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonRubikActionPerformed

    private void jButtonRemoteCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoteCarActionPerformed
        double priceOfItem = 300000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Remote Car: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonRemoteCarActionPerformed

    private void jButtonNintendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNintendoActionPerformed
        double priceOfItem = 370000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"NIntendo: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonNintendoActionPerformed

    private void jButtonspinnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonspinnerActionPerformed
        double priceOfItem = 15000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Spinner : 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonspinnerActionPerformed

    private void jButtonspidermanmaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonspidermanmaskActionPerformed
        double priceOfItem = 10000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Spiderman Mask: pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonspidermanmaskActionPerformed

    private void jButtonhotwheelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhotwheelActionPerformed
        double priceOfItem = 17000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Hot Wheel: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonhotwheelActionPerformed

    private void jButtonUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnoActionPerformed
        double priceOfItem = 13000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Uno: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonUnoActionPerformed

    private void jButtongundamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtongundamActionPerformed
        double priceOfItem = 150000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Gundam: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtongundamActionPerformed

    private void jButtonPokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPokemonActionPerformed
        double priceOfItem = 4000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Pokemon: 1 set", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonPokemonActionPerformed

    private void jButtonNarutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNarutoActionPerformed
        double priceOfItem = 13000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Naruto: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonNarutoActionPerformed

    private void jButtonironmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonironmanActionPerformed
        double priceOfItem = 100000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Ironman: 1 box", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonironmanActionPerformed

    private void jButtonTeddybearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTeddybearActionPerformed
        double priceOfItem = 70000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Teddy Bear: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonTeddybearActionPerformed

    private void jButtonWaterGunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWaterGunActionPerformed
        double priceOfItem = 50000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Water Gun : 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonWaterGunActionPerformed

    private void jButtonSwordToysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSwordToysActionPerformed
        double priceOfItem = 35000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Sword Toys: 1 box", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonSwordToysActionPerformed

    private void jButtonSlimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSlimeActionPerformed
        double priceOfItem = 7000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Slime: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonSlimeActionPerformed

    private void jButtondroneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondroneActionPerformed
        double priceOfItem = 175000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Drone: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtondroneActionPerformed

    private void jButtonmotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonmotorActionPerformed
        double priceOfItem = 3000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Motor Toys: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonmotorActionPerformed

    private void jButtonMonopolyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMonopolyActionPerformed
        double priceOfItem = 20000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Monopoly: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonMonopolyActionPerformed

    private void jButtonBonekaBarbieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBonekaBarbieActionPerformed
        double priceOfItem = 35000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Boneka Barbie: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonBonekaBarbieActionPerformed

    private void jButtonrobloxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonrobloxActionPerformed
        double priceOfItem = 15000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Roblox: 1 box", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonrobloxActionPerformed

    private void jButtonBolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBolaActionPerformed
        double priceOfItem = 12000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Bola: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonBolaActionPerformed

    private void jButtonPancinganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPancinganActionPerformed
        double priceOfItem = 25000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Pancingan: 1 pcs", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonPancinganActionPerformed

    private void jButtonbakugan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbakugan1ActionPerformed
        double priceOfItem = 3000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[] {"Bakugan: 1 box", "1", "Rp. " + NumberFormat.getInstance(new Locale("id", "ID")).format(priceOfItem)});
        ItemCost();
    }//GEN-LAST:event_jButtonbakugan1ActionPerformed

    private void jButtonupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonupdateActionPerformed
        // Validasi data di jTable2
    if (jTable2.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "Tidak ada data untuk diupdate. Silakan pilih data terlebih dahulu.");
        return;
    }

    // Ambil data dari TextField
    String updatedItem = txtitem.getText().trim();
    int updatedQuantity;
    double updatedAmount;

    try {
        updatedQuantity = Integer.parseInt(txtquantity.getText().trim());
        updatedAmount = Double.parseDouble(txtamount.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Pastikan jumlah dan harga diisi dengan angka yang valid.");
        return;
    }

    // Update tabel utama (jTable1)
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    boolean isUpdated = false;
    for (int i = 0; i < model.getRowCount(); i++) {
        if (model.getValueAt(i, 0).toString().equals(updatedItem)) {
            model.setValueAt(updatedQuantity, i, 1);
            model.setValueAt(updatedAmount, i, 2);
            isUpdated = true;
            break;
        }
    }

    if (!isUpdated) {
        JOptionPane.showMessageDialog(null, "Item tidak ditemukan di tabel utama.");
        return;
    }

    // Update database (opsional)
    try {
        String updateSQL = "UPDATE kasir SET quantity = ?, amount = ? WHERE item = ?";
        PreparedStatement pstmt = con.prepareStatement(updateSQL);
        pstmt.setInt(1, updatedQuantity);
        pstmt.setDouble(2, updatedAmount);
        pstmt.setString(3, updatedItem);
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal mengupdate database: " + e.getMessage());
        e.printStackTrace();
    }

    // Bersihkan tabel pusat informasi/edit (jTable2) dan TextField
    ((DefaultTableModel) jTable2.getModel()).setRowCount(0);
    txtitem.setText("");
    txtquantity.setText("");
    txtamount.setText("");
    }//GEN-LAST:event_jButtonupdateActionPerformed

    private void jTable2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2AncestorAdded

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2KeyPressed

    private void jTextDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDiscountActionPerformed

    private void jButton01KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton01KeyPressed
    
    }//GEN-LAST:event_jButton01KeyPressed

    private void jButton02KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton02KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton02KeyPressed

    private void jButton03KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton03KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton03KeyPressed

    private void jButton04KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton04KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton04KeyPressed

    private void jButton05KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton05KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton05KeyPressed

    private void jButton06KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton06KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton06KeyPressed

    private void jButton07KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton07KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton07KeyPressed

    private void jButton08KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton08KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton08KeyPressed

    private void jButton09KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton09KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton09KeyPressed

    private void jButton00KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton00KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton00KeyPressed

    private void jButtonPeriodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonPeriodKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPeriodKeyPressed

    private void jButtonCancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCancelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelKeyPressed

    /**
     * @param args the command line arguments
     */public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kasir().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton00;
    private javax.swing.JButton jButton01;
    private javax.swing.JButton jButton02;
    private javax.swing.JButton jButton03;
    private javax.swing.JButton jButton04;
    private javax.swing.JButton jButton05;
    private javax.swing.JButton jButton06;
    private javax.swing.JButton jButton07;
    private javax.swing.JButton jButton08;
    private javax.swing.JButton jButton09;
    private javax.swing.JButton jButtonBola;
    private javax.swing.JButton jButtonBonekaBarbie;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonLego;
    private javax.swing.JButton jButtonMonopoly;
    private javax.swing.JButton jButtonNaruto;
    private javax.swing.JButton jButtonNintendo;
    private javax.swing.JButton jButtonPancingan;
    private javax.swing.JButton jButtonPay;
    private javax.swing.JButton jButtonPeriod;
    private javax.swing.JButton jButtonPokemon;
    private javax.swing.JButton jButtonRemoteCar;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonRubik;
    private javax.swing.JButton jButtonSlime;
    private javax.swing.JButton jButtonSwordToys;
    private javax.swing.JButton jButtonTeddybear;
    private javax.swing.JButton jButtonUno;
    private javax.swing.JButton jButtonWaterGun;
    private javax.swing.JButton jButtonbakugan1;
    private javax.swing.JButton jButtondrone;
    private javax.swing.JButton jButtonexportexcel;
    private javax.swing.JButton jButtongundam;
    private javax.swing.JButton jButtonhotwheel;
    private javax.swing.JButton jButtonironman;
    private javax.swing.JButton jButtonmotor;
    private javax.swing.JButton jButtonroblox;
    private javax.swing.JButton jButtonspidermanmask;
    private javax.swing.JButton jButtonspinner;
    private javax.swing.JButton jButtonupdate;
    private javax.swing.JComboBox<String> jComboPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextChange;
    private javax.swing.JTextField jTextDiscount;
    private javax.swing.JTextField jTextDisplay;
    private javax.swing.JTextField jTextSubtotal;
    private javax.swing.JTextField jTextTotal;
    private javax.swing.JLabel lblclock;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtitem;
    private javax.swing.JTextField txtquantity;
    // End of variables declaration//GEN-END:variables

    
    private void clock() {
     java.util.Timer tt = new java.util.Timer();
     tt.scheduleAtFixedRate(new TimerTask() {
         
         @Override
         public void run() {
             lblclock.setText(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));
             
         }
     }, 0, 1000);
 }

    
    private void tampildata() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel(); // Model tabel
    model.setRowCount(0); // Menghapus semua baris sebelum memuat data baru
    
    try {
        // Query untuk mengambil data dari database
        String sql = "SELECT * FROM kasir";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Iterasi melalui hasil query
        while (rs.next()) {
            // Ambil data dari kolom di database
            String item = rs.getString("item");
            int quantity = rs.getInt("quantity");
            double amount = rs.getDouble("amount");

            // Tambahkan data ke JTable
            model.addRow(new Object[]{item, quantity, amount});
        }

        rs.close();
        stmt.close();
    } catch (SQLException e) {
        // Tangani error SQL
        JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
