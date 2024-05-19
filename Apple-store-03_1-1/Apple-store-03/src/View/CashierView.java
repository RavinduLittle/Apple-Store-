
package View;
import Controler.CashierControler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Model.ProductDetails;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import Model.SellsDetails;
import static Model.User.conn;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class CashierView extends javax.swing.JFrame {

    private ProductDetails selectedProduct;
      private  double   totalBill;
  private int totalQuantity;
  private CashierControler cashier;
  private  double  productPrice;
   private DefaultListModel<String> sellProductListModel;
   
    public CashierView() {
        sellProductListModel = new DefaultListModel<>();
        initComponents();
        
        
        try {
            cashier = new CashierControler(0, null, null, null, null);
            cashier.loadTableDataProduct(jTable1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CashierView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btnSelect.addActionListener(new ActionListener(){
      @Override
             public void actionPerformed(ActionEvent e) {
            
                    if (selectedProduct != null) {
                    
                    txtProductId.setText(Integer.toString(selectedProduct.getProductId()));
                    txtProductName.setText(selectedProduct.getProductName());
                    txtProductPrice.setText(Double.toString(selectedProduct.getProductPrice()));
                  
                    
                    }
               
             }  
    
    });
           jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) {
                    int selectedRow = jTable1.getSelectedRow();

                    // Get the product data from the selected row
                    int productId = (int) jTable1.getValueAt(selectedRow, 0); // Assuming the first column contains product ID
                    String productName = (String) jTable1.getValueAt(selectedRow, 1); // Assuming the second column contains product name
                    double price = (double) jTable1.getValueAt(selectedRow, 4); // Assuming the third column contains price
                    int quantity = (int) jTable1.getValueAt(selectedRow, 3); // Assuming the fourth column contains quantity
                    String category = (String) jTable1.getValueAt(selectedRow, 2); 
            
            
                    selectedProduct = new ProductDetails(productId,productName,price,quantity,category)
                    {
                    };
            }
            }
       });
      btndone.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
             
                
                 String productName = txtProductName.getText();
                  double  price = Double.parseDouble(txtProductPrice.getText());
                 int   quantity = Integer.parseInt(txtProductQuantity.getText());
                 productPrice = price * quantity;
                 totalBill += price*quantity;
                 totalQuantity += quantity;
                 
                  String productDetails = "Product Name: " + productName + "     | "
                        + "Price: $" + price + "     | "
                        + "Quantity: " + quantity + "      | "
                        + "Full Price: " +productPrice ;
               
                sellProductListModel.addElement(productDetails); 
                 jList1.setModel(sellProductListModel);
                    
                 txttPrice.setText(Double.toString(productPrice));
                 lblPrice.setText(" Total Price : $"+ Double.toString( totalBill));
                 lblQuantity.setText(" Total Quantity : "+Integer.toString(totalQuantity));
                 
             
             }     
      });
           btnInvoice.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) { 
                   
           Document document = new Document();
           
             
              try {
            // Define a file path where the PDF will be saved
            String outputPath = "D:\\test\\invoic.pdf";

            // Create a PdfWriter to write content to the PDF
            PdfWriter writer = null;
            try {
                writer = PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            } catch (DocumentException ex) {
                Logger.getLogger(CashierView.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.open(); // Open the document for writing
             // Add a logo as a background image
             // Generate an alphanumeric invoice number
//                    String productDetails = generateAlphanumericInvoiceNumber();

           
             // Store Information
            Paragraph storeInfo = new Paragraph();
            storeInfo.add(new Chunk("Apple Store", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            storeInfo.add(Chunk.NEWLINE);
          
            storeInfo.setAlignment(Element.ALIGN_CENTER);
            document.add(storeInfo);
 // Invoice Information
                    Paragraph invoiceInfo = new Paragraph();
                    invoiceInfo.add("Invoice Number: " + "87");
                              
                    invoiceInfo.setAlignment(Element.ALIGN_RIGHT);
                    
                    document.add(invoiceInfo);
                    
                    // Add a table for product details
                    PdfPTable table = new PdfPTable(4);
                    
                    table.setWidthPercentage(100);
                    table.setSpacingBefore(10f);
                    table.setSpacingAfter(10f);
//                 
//              float borderWidthe = if;
//              BaseColor borderColr =BaseColor.BLACK;

                    // Table headers
                    PdfPCell cell = new PdfPCell(new Phrase("Product Name"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    
                    
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase("Quantity"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                   
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase("price"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                 
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase("Full Price"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                    table.addCell(cell);
            
                    
                    double total = 0;
                    int totaQuntity = 0;
                    
            // Iterate through your invoiceListModel and add each element to the PDF
            for (int i = 0; i < sellProductListModel.size(); i++) {
//                String productInfo = invoiceListModel.getElementAt(i).toString();
                String productInfo =sellProductListModel.get(i);
                            String[] productData = productInfo.split("\\|");
                            String productName = productData[0].trim().split(":")[1].trim();
                            double price = Double.parseDouble(productData[1].trim().split(":")[1].trim().replace("$", ""));
                            int quantity = Integer.parseInt(productData[2].trim().split(":")[1].trim());
                            
                           double productPrice = price * quantity;
                            // Add product details to the table
                            table.addCell(productName);
                            table.addCell(String.valueOf(quantity));
                            table.addCell("$" + price);
                            table.addCell("$" + productPrice);
                            
                            total += price*quantity;
                           
                  
            }
             document.add(table);
             Paragraph totalPrice = new Paragraph();
             
             totalPrice.add("Total Price : $"+total);
             totalPrice.setAlignment(Element.ALIGN_RIGHT);
             document.add(totalPrice);
            
             
             Paragraph cloceLine = new Paragraph();
             cloceLine.add("********************************************************************************** ");
             cloceLine.setAlignment(Element.ALIGN_CENTER);
             document.add(cloceLine);
            
Desktop.getDesktop().open(new File("D:\\test\\invoic.pdf"));
            // Close the document and writer to save the PDF
            document.close();

        } catch ( IOException ex) {
            ex.printStackTrace();
        }       catch (DocumentException ex) {
                    Logger.getLogger(CashierView.class.getName()).log(Level.SEVERE, null, ex);
                }
             
             }  
             
        });
    }

 public void tableLoardSell(JTable jTable){
        
         try {
             String sql = "SELECT  sells_id, product_id,product_name ,sells_quantity ,product_price FROM sells_detailss";
             PreparedStatement pps = conn.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();
            jTable.setModel(DbUtils.resultSetToTableModel(rs));
         } catch (Exception e) {
             
         }
         
     }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSelect = new javax.swing.JButton();
        txtProductQuantity = new javax.swing.JTextField();
        txtProductId = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtProductPrice = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btndone = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lblQuantity = new javax.swing.JLabel();
        txttPrice = new javax.swing.JTextField();
        btnInvoice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cashier DashBooard");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, -1));

        jPanel3.setBackground(new java.awt.Color(0, 51, 204));

        jLabel1.setBackground(new java.awt.Color(0, 102, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("Cashier DashBoard");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(526, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(448, 448, 448))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 1000, 220));

        btnSelect.setBackground(new java.awt.Color(0, 51, 255));
        btnSelect.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSelect.setText("Select Product");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        jPanel1.add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 310, 180, 40));
        jPanel1.add(txtProductQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 440, 240, 30));
        jPanel1.add(txtProductId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 240, 30));
        jPanel1.add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 240, 30));
        jPanel1.add(txtProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 240, 30));

        btnClear.setBackground(new java.awt.Color(255, 0, 0));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 490, 110, 30));

        btndone.setBackground(new java.awt.Color(0, 204, 0));
        btndone.setText("Done");
        btndone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoneActionPerformed(evt);
            }
        });
        jPanel1.add(btndone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 490, 110, 30));

        lblPrice.setBackground(new java.awt.Color(255, 102, 102));
        lblPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(0, 0, 102));
        jPanel1.add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 230, 30));

        jScrollPane2.setViewportView(jList1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 750, 170));

        jButton3.setBackground(new java.awt.Color(0, 204, 0));
        jButton3.setText("View Sells Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 730, 130, 40));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setText("LOGOUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 800, -1, -1));

        lblQuantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(0, 0, 102));
        jPanel1.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 250, 30));
        jPanel1.add(txttPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 440, 250, 30));

        btnInvoice.setBackground(new java.awt.Color(0, 204, 0));
        btnInvoice.setText("print invoice");
        jPanel1.add(btnInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 730, 130, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtProductId.setText("");
        txtProductName.setText("");
        txtProductQuantity.setText("");
        txtProductPrice.setText("");
        lblPrice.setText("");
        lblQuantity.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btndoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoneActionPerformed
        int pId = Integer.parseInt(txtProductId.getText());
        String pName = txtProductName.getText();
        double pPrice = Double.parseDouble(txtProductPrice.getText());
        int pQuantity = Integer.parseInt(txtProductQuantity.getText());
        double toPrice = Double.parseDouble(txttPrice.getText());
        
        
        
         if(pQuantity != 0){  
       
       SellsDetails sells = new SellsDetails(pId, pName, pPrice, pQuantity, null, pQuantity, 0);
      
      cashier.sellProduct(sells);
      cashier.loadTableDataProduct(jTable1);
      JOptionPane.showMessageDialog(this, "added");
        
             txtProductId.setText("");
             txtProductName.setText("");
             txtProductPrice.setText("");
             txtProductQuantity.setText("");
             txttPrice.setText("");
         }
         else{
         JOptionPane.showMessageDialog(this, "check quantity");
         
         }
    }//GEN-LAST:event_btndoneActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
       
    }//GEN-LAST:event_btnSelectActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       new View.SellsView2().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new UserLogin().setVisible(true);
                     this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

  
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
            java.util.logging.Logger.getLogger(CashierView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashierView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashierView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashierView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CashierView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnInvoice;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btndone;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTextField txtProductId;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductQuantity;
    private javax.swing.JTextField txttPrice;
    // End of variables declaration//GEN-END:variables
}
