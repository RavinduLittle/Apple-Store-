
package View;

import Controler.ManagerControler;
import static Model.User.conn;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import View.ManagerView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class CreateNewAcc extends javax.swing.JFrame {
private  ManagerControler manager;
   
    public CreateNewAcc() {
        initComponents();
    try {
        manager  = new ManagerControler(0, null, null, null, null);
        manager.loadTableDataUsers(jTable1);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(CreateNewAcc.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public void search(){
    
     String user  = txt_search.getText();
        try {
            String sql = "SELECT * FROM users_details WHERE user_name LIKE '%"+user+"%' OR user LIKE '%"+user +"%'";
            PreparedStatement pps = conn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtRole = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager DashBoard");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Id  :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 70, 30));

        jTable1.setBackground(new java.awt.Color(51, 153, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 640, 200));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Passwoed  :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 100, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User Name  :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 80, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email  :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 60, 30));
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 220, 30));
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 240, 30));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 220, 30));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 240, 30));
        jPanel1.add(txtRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 220, 30));

        btnAdd.setBackground(new java.awt.Color(0, 51, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 90, 30));

        btnRemove.setBackground(new java.awt.Color(0, 51, 255));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, -1, 30));

        btnBack.setBackground(new java.awt.Color(204, 0, 0));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnUpdate.setBackground(new java.awt.Color(0, 51, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 80, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Role  :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 70, 30));

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 650, 160, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 690, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String newUserName = txtName.getText();
            String newPassword = txtPass.getText();
            String newUserType = txtRole.getText();
            String newUserEmail = txtEmail.getText();
            ManagerControler manager = new ManagerControler(0,null,null,null,null);
            manager.loadTableDataUsers(jTable1);
            
             if( newUserName.isEmpty()|| newPassword.isEmpty()|| newUserEmail.isEmpty() || newUserType.isEmpty()){
           JOptionPane.showMessageDialog(this, "fill all ");
          
          
          }
             else if(newPassword.length() < 8 || !newPassword.matches("^(?=.*[a-zA-Z])(?=.*\\d).{8,}$")){
          JOptionPane.showMessageDialog(this, "Password must include at least one symbol and one digit ");
          
          }
             else{
            if ("admin".equals(newUserType) || "cashier".equals(newUserType) || "user".equals(newUserType)) {
           boolean userCreated = manager.createUsreAccount(newUserName, newPassword, newUserType, newUserEmail);
           if( userCreated ){
            JOptionPane.showMessageDialog(null, "user Created!!!");
           }
            else{
            JOptionPane.showMessageDialog(this, "please check again");
            
            }
            }
            else{
            JOptionPane.showMessageDialog(this, "none type role");
            
            }
             }
            
        } catch (ClassNotFoundException e) {
                e.fillInStackTrace();
                }
         
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String newUserName = txtName.getText();
            String newPassword = txtPass.getText();
            String newUserType = txtRole.getText();
            String newUserEmail = txtEmail.getText();
            int  userId  = Integer.parseInt(txtid.getText());
            ManagerControler manager = new ManagerControler(0,null,null,null,null);
           
             if ("admin".equals(newUserType) || "cashier".equals(newUserType) || "user".equals(newUserType)) {
           boolean userUpdate = manager.updateUserAccount(newUserName, newPassword, newUserType, newUserEmail, userId);
           if( userUpdate ){
            JOptionPane.showMessageDialog(null, "user updated!!!");
           }
            else{
            JOptionPane.showMessageDialog(this, "please check again");
            
            }
            }
            else{
            JOptionPane.showMessageDialog(this, "none type role");
            
            }
            manager.loadTableDataUsers(jTable1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateNewAcc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
    try {
        int userId  = Integer.parseInt(txtid.getText());
        ManagerControler manager = new ManagerControler(0,null,null,null,null);
        
        manager.removeUserAccount(userId);
        manager.loadTableDataUsers(jTable1);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(CreateNewAcc.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       new ManagerView().setVisible(true);
                     this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
search();
    }//GEN-LAST:event_txt_searchKeyReleased

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
            java.util.logging.Logger.getLogger(CreateNewAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNewAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNewAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNewAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateNewAcc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
