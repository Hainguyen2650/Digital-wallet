
package component;
import javax.swing.JPanel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class TransactionPanel extends JPanel {
    
    public String fullName;
    public String userName;
    public String dateOfBirth;
    public String gender;
    public String citizenID;
    public String email;
    public String phoneNumber;
    public String address;
    public String password;
    
    private Connection con;
    private String userBal;
    //private String userID = "1";
    //private String password = "123";
    private String recipientName;
    private int recipientID;
    private int amount;
    public TransactionPanel(String[] loginInfo) {
        this.citizenID = loginInfo[4];
        this.password = loginInfo[8];
                
        connect();
        initComponents();
        
        
    }

 


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane3 = new javax.swing.JEditorPane();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jEditorPane4 = new javax.swing.JEditorPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jEditorPane5 = new javax.swing.JEditorPane();

        jTextField1.setText("jTextField1");

        jLabel5.setText("jLabel5");

        jLabel1.setText("Thong tin tai khoan ");

        jLabel3.setText("So tai khoan: "+userID);

        jLabel4.setText("So du kha dung: "+userBal);

        jLabel6.setText("Thong tin nguoi nhan");

        jLabel7.setText("So tien");

        jLabel9.setText("Noi dung CK");

        jLabel13.setText("Ten tai khoan");

        jToggleButton1.setText("Tiep tuc");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(93, 55, 218));
        jLabel14.setText("VND");

        jLabel15.setText("Mat khau");

        jScrollPane1.setViewportView(jEditorPane1);

        jEditorPane3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jEditorPane3KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jEditorPane3);

        jLabel17.setForeground(new java.awt.Color(255, 0, 0));

        jScrollPane4.setViewportView(jEditorPane4);

        jEditorPane5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jEditorPane5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jEditorPane5KeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jEditorPane5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5))
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel14))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95)
                        .addComponent(jToggleButton1))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
        );

        jLabel4.getAccessibleContext().setAccessibleName(userID);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:

        //Check if amount is greater than user balance or password is incorrect, create dialog showing error
        if (amount > Integer.parseInt(userBal)){
            jLabel17.setText("So du khong du");
        }
        else{
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject", "root", "");
                //Print user balance from table "account", column "balance", default id = 1
                String query = "SELECT password FROM user WHERE id = " + citizenID;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    String password = rs.getString("password");
                    if (jEditorPane1.getText().equals(password)){
                        //Update user balance
                        String query2 = "UPDATE account SET balance = balance - " + amount + " WHERE id = " + citizenID;
                        PreparedStatement pst = con.prepareStatement(query2);
                        pst.executeUpdate();
                        //Update recipient balance
                        String query3 = "UPDATE account SET balance = balance + " + amount + " WHERE id = " + recipientID;
                        PreparedStatement pst2 = con.prepareStatement(query3);
                        pst2.executeUpdate();
                        //Create transaction record
                        String query4 = "INSERT INTO transfer (f_account, to_account, amount) VALUES (?, ?, ?)";
                        PreparedStatement pst3 = con.prepareStatement(query4);
                        pst3.setString(1, citizenID);
                        pst3.setInt(2, recipientID);
                        pst3.setInt(3, amount);
                        //pst3.setString(4, jEditorPane4.getText());
                        pst3.executeUpdate();
                        jLabel17.setText("Chuyen khoan thanh cong");

                        //Create a dialog showing success
                        String receipt = "Transaction Successful!\n\n" +
                                         "From Account: " + citizenID + "\n" +
                                         "To Account: " + recipientID + "\n" +
                                         "Amount: " + amount + "\n" +
                                         "Description: " + jEditorPane4.getText();
                        JOptionPane.showMessageDialog(this, receipt, "Transaction Receipt", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        jLabel17.setText("Sai mat khau");
                    }
                }
            }catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jEditorPane5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEditorPane5KeyPressed
        // TODO add your handling code here:
        // get id after every key pressed, then print it
        
        
        
    }//GEN-LAST:event_jEditorPane5KeyPressed

    private void jEditorPane5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEditorPane5KeyReleased
        // TODO add your handling code here:
        recipientID = Integer.parseInt(jEditorPane5.getText());
        //System.out.println(recipientID);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject", "root", "");
            //Print user balance from table "account", column "balance", default id = 1
            String query = "SELECT firstname FROM customer WHERE id = " + recipientID;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                recipientName = rs.getString("firstname");
                //System.out.println(recipientName);
                jLabel16.setText(recipientName);
            }
        }catch (ClassNotFoundException | SQLException e) {
            //System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jEditorPane5KeyReleased

    private void jEditorPane3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEditorPane3KeyReleased
        // TODO add your handling code here:
        amount = Integer.parseInt(jEditorPane3.getText());
        if (amount > Integer.parseInt(userBal)){
            jLabel17.setText("So du khong du");
        }else{
            jLabel17.setText("");
        }
    }//GEN-LAST:event_jEditorPane3KeyReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JEditorPane jEditorPane3;
    private javax.swing.JEditorPane jEditorPane4;
    private javax.swing.JEditorPane jEditorPane5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject", "root", "");
            //Print user balance from table "account", column "balance", default id = 1
            String query = "SELECT balance FROM account WHERE id = " + citizenID;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                userBal = rs.getString("balance");
            }
        
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}