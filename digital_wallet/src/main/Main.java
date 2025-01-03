
package main;

import java.awt.Color;
import swing.ScrollBar;
import com.event.EventMenuSelected;
import component.AccountInfoPanel;
//import component.ExpenseReportPanel;
//import component.SavingsFundsPanel;
import component.TransactionHistoryPanel;
import component.TransactionPanel;
import component.Form_Home;

public class Main extends javax.swing.JFrame {
    
    public String fullName;
    public String userName;
    public String dateOfBirth;
    public String gender;
    public String citizenID;
    public String email;
    public String phoneNumber;
    public String address;
    public String password;
    private component.Form_Home form_Home2;
    
    public Main(String[] loginInfo) {
        
        this.fullName = loginInfo[0];
        this.userName = loginInfo[1];
        this.dateOfBirth = loginInfo[2];
        this.gender = loginInfo[3];
        this.citizenID = loginInfo[4];
        this.email = loginInfo[5];
        this.phoneNumber = loginInfo[6];
        this.address = loginInfo[7];
        this.password = loginInfo[8];
        this.form_Home2 = new Form_Home(loginInfo);

        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        menu2.initMoving(Main.this);
        sp.setVerticalScrollBar(new ScrollBar());
        menu2.addEventMenuSelected(new EventMenuSelected(){
            @Override
            public void selected(int index) {
                switch (index) {
                    case 0: // Dashboard
                        setPanelContent(new Form_Home(loginInfo));
                        break;
                    case 2: // Transaction
                        setPanelContent(new TransactionPanel(loginInfo));
                        
                        //System.out.println("Transaction");
                        break;
                    case 4: // Account Information
                        setPanelContent(new AccountInfoPanel());
                        break;
                    case 6: // Transaction History
                        setPanelContent(new TransactionHistoryPanel());
                        break;
                    
                }
            }
        });
    }
    private void setPanelContent(javax.swing.JPanel panel) {
        //panel.setSize(686, 574); 
        //panel.setLocation(0, 0); 
        form_Home2.removeAll(); 
        form_Home2.add(panel); 
        form_Home2.revalidate(); 
        form_Home2.repaint(); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder3 = new swing.PanelBorder();
        header2 = new component.Header();
        menu2 = new component.Menu();
        sp = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        sp.setBorder(null);

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(form_Home2, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(sp)
                        .addContainerGap())
                    .addComponent(form_Home2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Header header2;
    private component.Menu menu2;
    private swing.PanelBorder panelBorder3;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
