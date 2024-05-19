
package View;
import Controler.ManagerControler;
import Model.ProductDetails;
import Controler.DBConnector;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import View.CreateNewAcc;
import View.UserLogin;

public class ManagerView extends javax.swing.JFrame {

    Connection  conn= null;
    public ManagerView()  {
        initComponents();
        try {
            ManagerControler manager = new ManagerControler(0, null, null, null, null);
            manager.loadTableData(jTable1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtquntitu = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager DashBoard");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 1020, 203));

        jLabel1.setBackground(new java.awt.Color(153, 255, 153));
        jLabel1.setForeground(new java.awt.Color(255, 255, 153));
        jLabel1.setText("Product Name  :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, 33));

        jLabel4.setBackground(new java.awt.Color(153, 255, 153));
        jLabel4.setForeground(new java.awt.Color(255, 255, 153));
        jLabel4.setText("Product Price  :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, -1, 33));

        jLabel5.setBackground(new java.awt.Color(153, 255, 153));
        jLabel5.setForeground(new java.awt.Color(255, 255, 153));
        jLabel5.setText("Product Qty   :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 310, -1, 33));

        jLabel6.setBackground(new java.awt.Color(153, 255, 153));
        jLabel6.setForeground(new java.awt.Color(255, 255, 153));
        jLabel6.setText("Product Id        :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 94, 33));

        jLabel7.setBackground(new java.awt.Color(153, 255, 153));
        jLabel7.setForeground(new java.awt.Color(255, 255, 153));
        jLabel7.setText(" Category       :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 80, 33));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 198, 33));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 198, 33));
        jPanel1.add(txtquntitu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 310, 198, 33));
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 198, 33));
        jPanel1.add(txtCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 198, 33));

        jButton1.setBackground(new java.awt.Color(179, 13, 29));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 255, 255));
        jButton1.setText("LogOut");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 90, 30));

        jButton2.setBackground(new java.awt.Color(0, 204, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 255, 255));
        jButton2.setText("ReFresh");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 690, 100, 30));

        jButton4.setBackground(new java.awt.Color(0, 51, 255));
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 120, 35));

        jButton5.setBackground(new java.awt.Color(0, 51, 255));
        jButton5.setText("Remove");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, 123, 33));

        jButton6.setBackground(new java.awt.Color(0, 51, 255));
        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 123, 33));

        jButton7.setBackground(new java.awt.Color(0, 0, 204));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton7.setText("Create New Account");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 490, 370, 60));

        jButton8.setBackground(new java.awt.Color(0, 0, 204));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setText("View Sells Details");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 620, 370, 60));

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 255));
        jLabel2.setText("Manager DashBoard");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 378, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 740));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            String Category = txtCategory.getText();
            int qnty = Integer.parseInt(txtquntitu.getText());
            double price = Double.parseDouble(txtPrice.getText());
            
            ManagerControler manager =  new ManagerControler(0, null, null, null, null);
            ProductDetails product = new ProductDetails(0, name, price, qnty, Category) {
            };
            manager.addProduct(product);
            manager.loadTableData(jTable1);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerView.class.getName()).log(Level.SEVERE, null, ex);
        }
 
      
        
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            String Category = txtCategory.getText();
            int qnty = Integer.parseInt(txtquntitu.getText());
            double price = Double.parseDouble(txtPrice.getText());
            
            ManagerControler manager = new ManagerControler(0,null,null,null,null);
            ProductDetails product = new ProductDetails(id, name, price, qnty, Category) {
            };
            manager.updateProduct(product);
            manager.loadTableData(jTable1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     try {
            int id = Integer.parseInt(txtId.getText());
            
            
            ManagerControler manager = new ManagerControler(0,null,null,null,null);
            ProductDetails product = new ProductDetails(id, null, 0, 0, null) {
            };
            manager.removeProduct(product);
            manager.loadTableData(jTable1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         new CreateNewAcc() .setVisible(true);
                     this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           new UserLogin().setVisible(true);
                     this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       new SellsDetails().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed
   
    
    
   
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
            java.util.logging.Logger.getLogger(ManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtquntitu;
    // End of variables declaration//GEN-END:variables
}
