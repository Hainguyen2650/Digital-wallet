package component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import swing.Button;
import swing.TextField;
import swing.PasswordField;
import swing.MyPasswordField;
import swing.MyTextField;


public class PanelLoginAndRegister extends javax.swing.JLayeredPane {
    
    private ActionListener event;
    private TextField txtFullName;
    private TextField txtUserName;
    private TextField txtEmail;
    private TextField citizenID;
    private PasswordField txtPass;
    private PasswordField cf_txtPass;
    private TextField gender;
    private TextField DoB;
    private MyTextField loginName;
    private MyPasswordField loginPass;
    
    
    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        initAddAcc();
        login.setVisible(true);// appear this
        register.setVisible(false);// hide login page at the first time
        account.setVisible(false);
        question.setVisible(false);
    }

    private void initRegister(){
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]10[]10[]40[]push"));// center the layout and set the space to add component in []
        JLabel label = new JLabel("Personal information");// new label
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(12, 157, 201));
        register.add(label);
        //FullName
        txtFullName = new TextField();
        txtFullName.setLabelText("FullName");
        register.add(txtFullName, "w 60%");
        //DoB
        DoB = new TextField();
        DoB.setLabelText("Date of birth");
        DoB.setHint("dd/mm/yyyy");
        register.add(DoB, "w 60%");
        //Gender
        gender = new TextField();
        gender.setLabelText("Gender");
        gender.setHint("Male/Female");
        register.add(gender, "w 60%");
        //citizenID
        citizenID = new TextField();
        citizenID.setLabelText("CitizenID (CCCD)");
        register.add(citizenID, "w 60%");
        //email
        txtEmail = new TextField();// text box to enter user email
        txtEmail.setLabelText("Email");
        register.add(txtEmail, "w 60%");// text box in write mode and width 60% register page
        //Sign up button
        Button cmd = new Button();
        cmd.setBackground(new Color(12, 157, 201));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("Next (1/3)");        
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });
        register.add(cmd, "w 40%, h 40");// text box in write mode and width 60% register page and height is 40
    }
    
    public void initAddAcc() {
        account.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25push"));
        //label
        JLabel label = new JLabel("Create account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(12, 157, 201));
        account.add(label);
        //username
        txtUserName = new TextField();// text box to enter username
        txtUserName.setLabelText("Username");
        txtUserName.setHint("How can we call you ?");
        account.add(txtUserName, "w 60%");// text box in write mode and width 60% register page
        //password
        txtPass = new PasswordField();// text box to enter user email
        txtPass.setLabelText("Password");
        txtPass.setShowAndHide(true);
        account.add(txtPass, "w 60%");// text box in write mode and width 60% register page
        //confirm pass
        cf_txtPass = new PasswordField();
        cf_txtPass.setLabelText("Confirm Password");
        cf_txtPass.setShowAndHide(true);
        account.add(cf_txtPass, "w 60%");
        
        Button next = new Button();
        next.setBackground(new Color(12, 157, 201));
        next.setForeground(new Color(250, 250, 250));
        next.setText("Next (2/3)");        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });
        
        Button back = new Button();
        back.setBackground(new Color(12, 157, 201));
        back.setForeground(new Color(250, 250, 250));
        back.setText("Back");        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });
        account.add(back, "w 40%, h 40");// text box in write mode and width 60% register page and height is 40
        account.add(next, "w 40%, h 40");// text box in write mode and width 60% register page and height is 40
    }
    
    private void initLogin(){
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));// center the layout and set the space to add component in []
        JLabel label = new JLabel("Sign in");// new label
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(12, 157, 201));
        login.add(label);
        //email
        loginName = new MyTextField();// text box to enter user email
        loginName.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        loginName.setHint("Username");
        login.add(loginName, "w 60%");// text box in write mode and width 60% register page
        //password
        loginPass = new MyPasswordField();// text box to enter user email
        loginPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        loginPass.setHint("Password");
        login.add(loginPass, "w 60%");// text box in write mode and width 60% register page
        //Forgot password button
        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setForeground(new Color(100,100,100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdForget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            } 
        });
        login.add(cmdForget);
        //Sign in button
        Button cmd = new Button();
        cmd.setBackground(new Color(12, 157, 201));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN IN");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });
        login.add(cmd, "w 40%, h 40");// text box in write mode and width 60% register page and height is 40
    }

    public void showLogin(boolean show){
        login.setVisible(show);
        register.setVisible(!show);
        account.setVisible(false);
        question.setVisible(false);
    }
    public void showAddAcc(){
        login.setVisible(false);
        register.setVisible(false);
        account.setVisible(true);
        question.setVisible(false);
    }
    public void showQuestion(){
        login.setVisible(false);
        register.setVisible(false);
        account.setVisible(false);
        question.setVisible(true);
    }
    
    public void addEvent(ActionListener event) {
        this.event = event;
    }
    
    public void resetRegister() {// use this to reset register page
        txtFullName.setText("");
        DoB.setText("");
        gender.setText("");
        citizenID.setText("");
        txtUserName.setText("");
        txtEmail.setText("");
        txtPass.setText("");
        cf_txtPass.setText("");
    }
    
    public void resetLogin() {// use this to reset login page
        loginName.setText("");
        loginPass.setText("");
    }
    
    public String[] getRegister_info() {// use this method to get register info
        String[] info = new String[5];
        info[0] = txtFullName.getText();
        info[1] = DoB.getText();
        info[2] = gender.getText();
        info[3] = citizenID.getText();
        info[4] = txtEmail.getText();
        return info;
    }
    
    public String[] getLogin_info() {// use this method to get login info
        String[] info = new String[2];
        info[0] = loginName.getText();
        char[] pwd = loginPass.getPassword();
        info[1] = new String(pwd);
        return info;
    }
    
    public boolean check() {
        char[] pwd1 = txtPass.getPassword();
        String pass1 = new String(pwd1);
        char[] pwd2 = cf_txtPass.getPassword();
        String pass2 = new String(pwd2);
        if (pass1 == null ? pass2 == null : pass1.equals(pass2)) {
            return true;
        } else {
            txtPass.setText("");
            cf_txtPass.setText("");
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        account = new javax.swing.JPanel();
        question = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        account.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout accountLayout = new javax.swing.GroupLayout(account);
        account.setLayout(accountLayout);
        accountLayout.setHorizontalGroup(
            accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        accountLayout.setVerticalGroup(
            accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(account, "card2");

        question.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout questionLayout = new javax.swing.GroupLayout(question);
        question.setLayout(questionLayout);
        questionLayout.setHorizontalGroup(
            questionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        questionLayout.setVerticalGroup(
            questionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(question, "card2");

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents
    
    public void enableAllComponent(boolean b) {
        txtFullName.setVisible(b);
        DoB.setVisible(b);
        gender.setVisible(b);
        citizenID.setVisible(b);
        txtUserName.setVisible(b);
        txtEmail.setVisible(b);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel account;
    private javax.swing.JPanel login;
    private javax.swing.JPanel question;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
