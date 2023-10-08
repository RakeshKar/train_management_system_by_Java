/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Railway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rakesh win10
 */
public class show_reserve extends javax.swing.JFrame {

    /**
     * Creates new form show_reserve
     */
    public show_reserve() {
        initComponents();
        Connect ();
        showTable ();
    }
    
    
    Connection con;//connection object
    PreparedStatement pst;//Prepared statement object
    //connecting database of mysql now
    ResultSet rs;
    
    
    
    public void Connect () //method for connect
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registering the mysql driver... +after writing this line, did cover this in try and catch
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway", "root", "1234");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(show_reserve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(show_reserve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showTable ()
    {
        try {
            pst = con.prepareStatement("select * from reservation");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c;//getting the coloumn number in the interger c, fetched from the database table
            c = rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();//casting done by using (DefaultTableModel).
            //creating runtime table (by getting the column number and row number.
            String [] colName = new String [c]; //string type array, in java, array stores object
            for (int i = 0; i < c; i++)
            {
                colName [i] = rsd.getColumnName(i + 1);//here, in coding, array starts from 0, so i is 0. But in dbms, it starts from 1, sor, i + 1
            }
            d.setColumnIdentifiers(colName);
            String cpno, csplace, ceplace, ctno, ctname, cprice, cdate, cticket, ctot;
            while (rs.next())
            {
                cpno = rs.getString(1);
                csplace = rs.getString(2);
                ceplace = rs.getString(3);
                ctno = rs.getString(4);
                ctname = rs.getString(5);
                cprice = rs.getString(6);
                cdate = rs.getString(7);
                cticket = rs.getString(8);
                ctot = rs.getString(9);
                String [] row = {cpno, csplace, ceplace, ctno, ctname, cprice, cdate, cticket, ctot};
                d.addRow(row);
            }

        }
        
        catch (SQLException ex) {
            Logger.getLogger(show_reserve.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Go_Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowSorter(jTable1.getRowSorter());
        jScrollPane1.setViewportView(jTable1);

        Go_Back.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Go_Back.setText("Go Back");
        Go_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Go_BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Go_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Go_Back, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Go_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Go_BackActionPerformed
        // TODO add your handling code here:
        dispose ();
    }//GEN-LAST:event_Go_BackActionPerformed

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
            java.util.logging.Logger.getLogger(show_reserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(show_reserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(show_reserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(show_reserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new show_reserve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Go_Back;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
