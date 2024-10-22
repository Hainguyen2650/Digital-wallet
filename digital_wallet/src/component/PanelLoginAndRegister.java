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
    private Button regisButton;
    private Button loginButton;
    private JButton forgetButton;
    private MyTextField ques1;
    private MyTextField answ1;
    private MyTextField ques2;
    private MyTextField answ2;
    private MyTextField ques3;
    private MyTextField answ3;
    private TextField forgotFullname;
    private TextField forgotDoB;
    private TextField forgotGender;
    private TextField forgotId;
    private TextField forgotQ1;
    private TextField forgotQ2;
    private TextField forgotQ3;
    private TextField forgotUsername;
    private PasswordField forgotPass;
    private PasswordField forgotCfPass;
    
    
    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        this.setAnimate(false);
        loginButton.setEnabled(true);
        forgetButton.setEnabled(true);
        initAddAcc();
        initQuestion();
        initPersonalCheck();
        initAnswerCheck();
        initResetPass();
        login.setVisible(true);// appear this
        register.setVisible(false);// hide login page at the first time
        account.setVisible(false);
        question.setVisible(false);
        personalCheck.setVisible(false);
        answerCheck.setVisible(false);
        
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
        regisButton = new Button();
        regisButton.setBackground(new Color(12, 157, 201));
        regisButton.setForeground(new Color(250, 250, 250));
        regisButton.setText("Create account");        
        regisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });
        register.add(regisButton, "w 40%, h 40");// text box in write mode and width 60% register page and height is 40
    }
    
    public void initAddAcc() {
        account.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]5[]push"));
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
        next.setText("One more step");        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });
        
        Button back = new Button();
        back.setBackground(new Color(141, 147, 158));
        back.setForeground(new Color(250, 250, 250));
        back.setText("Back to personal register");        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });
        
        account.add(back, "w 40%, h 40");// text box in write mode and width 60% register page and height is 40
        account.add(next, "w 40%, h 40");// text box in write mode and width 60% register page and height is 40
    }
    
    private void initQuestion() {
        question.setLayout(new MigLayout("wrap", "push[center]push", "push[]5[]5[]5[]25[]5[]15[]5[]15[]5[]push"));
        
        JLabel label = new JLabel("Your security step");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(12, 157, 201));
        question.add(label);
        
        JLabel desc = new JLabel("Please add 3 questions so we can identify you in case you forget your password");
        desc.setFont(new Font("sansserif", 1, 10));
        desc.setForeground(new Color(181, 36, 11));
        question.add(desc);
        
        JLabel desc2 = new JLabel("Make sure that only you can answer the question");
        desc2.setFont(new Font("sansserif", 1, 10));
        desc2.setForeground(new Color(181, 36, 11));
        question.add(desc2);
        
        JLabel desc3 = new JLabel("We recommend that you should write your answers in lowercase letters");
        desc3.setFont(new Font("sansserif", 1, 10));
        desc3.setForeground(new Color(181, 36, 11));
        question.add(desc3);
        //Q-A1
        ques1 = new MyTextField();
        ques1.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/Q.png")));
        ques1.setHint("Question 1");
        question.add(ques1, "w 60%");
        answ1 = new MyTextField();
        answ1.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/A.png")));
        answ1.setHint("Answer");
        question.add(answ1, "w 60%");
        //Q-A2
        ques2 = new MyTextField();
        ques2.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/Q.png")));
        ques2.setHint("Question 2");
        question.add(ques2, "w 60%");
        answ2 = new MyTextField();
        answ2.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/A.png")));
        answ2.setHint("Answer");
        question.add(answ2, "w 60%");
        //Q-A3
        ques3 = new MyTextField();
        ques3.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/Q.png")));
        ques3.setHint("Question 3");
        question.add(ques3, "w 60%");
        answ3 = new MyTextField();
        answ3.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/A.png")));
        answ3.setHint("Answer");
        question.add(answ3, "w 60%");
        
        Button cmd = new Button();
        cmd.setBackground(new Color(12, 157, 201));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("Finish");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });
        question.add(cmd, "w 40%, h 40");// text box in write mode and width 60% register page and height is 40
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
        forgetButton = new JButton("Forgot your password ?");
        forgetButton.setForeground(new Color(100,100,100));
        forgetButton.setFont(new Font("sansserif", 1, 12));
        forgetButton.setContentAreaFilled(false);
        forgetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            } 
        });
        login.add(forgetButton);
        //Sign in button
        loginButton = new Button();
        loginButton.setBackground(new Color(12, 157, 201));
        loginButton.setForeground(new Color(250, 250, 250));
        loginButton.setText("SIGN IN");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });
        login.add(loginButton, "w 40%, h 40");// text box in write mode and width 60% register page and height is 40
    }
    
    private void initPersonalCheck() {
        personalCheck.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]10[]50[]push"));
        JLabel label = new JLabel("Please let us know who are you");// new label
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(12, 157, 201));
        personalCheck.add(label);
        //FullName
        forgotFullname = new TextField();
        forgotFullname.setLabelText("FullName");
        personalCheck.add(forgotFullname, "w 60%");
        //DoB
        forgotDoB = new TextField();
        forgotDoB.setLabelText("Date of birth");
        forgotDoB.setHint("dd/mm/yyyy");
        personalCheck.add(forgotDoB, "w 60%");
        //Gender
        forgotGender = new TextField();
        forgotGender.setLabelText("Gender");
        forgotGender.setHint("Male/Female");
        personalCheck.add(forgotGender, "w 60%");
        //username / citizenID / email
        forgotId = new TextField();
        forgotId.setLabelText("Username / CitizenId / Email (Choose one you remember)");
        personalCheck.add(forgotId, "w 60%");

        //Next button
        Button next = new Button();
        next.setBackground(new Color(12, 157, 201));
        next.setForeground(new Color(250, 250, 250));
        next.setText("Next");        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });
        personalCheck.add(next, "w 40%, h 40");// text box in write mode and width 60% register page and height is 40
    }

    private void initAnswerCheck() {
        answerCheck.setLayout(new MigLayout("wrap", "push[center]push", "push[]30[]10[]10[]50[]push"));
        JLabel label = new JLabel("Do you remember these question ?");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(12, 157, 201));
        answerCheck.add(label);
        
        forgotQ1 = new TextField();
        forgotQ2 = new TextField();
        forgotQ3 = new TextField();
        answerCheck.add(forgotQ1, "w 60%");
        answerCheck.add(forgotQ2, "w 60%");
        answerCheck.add(forgotQ3, "w 60%");

        //Check button
        Button next = new Button();
        next.setBackground(new Color(12, 157, 201));
        next.setForeground(new Color(250, 250, 250));
        next.setText("Reset my password");        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });
        answerCheck.add(next, "w 40%, h 40");// text box in write mode and width 60% register page and height is 40
    }
    
    private void initResetPass() {
        resetPass.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]50[]push"));
        JLabel label = new JLabel("Reset your password");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(12, 157, 201));
        resetPass.add(label);
        
        forgotUsername = new TextField();
        forgotUsername.setLabelText("Username");
        resetPass.add(forgotUsername, "w 60%");
        forgotUsername.setEnabled(false);
        //password
        forgotPass = new PasswordField();// text box to enter user email
        forgotPass.setLabelText("Password");
        forgotPass.setShowAndHide(true);
        resetPass.add(forgotPass, "w 60%");// text box in write mode and width 60% register page
        //confirm pass
        forgotCfPass = new PasswordField();
        forgotCfPass.setLabelText("Confirm Password");
        forgotCfPass.setShowAndHide(true);
        resetPass.add(forgotCfPass, "w 60%");
        
        Button next = new Button();
        next.setBackground(new Color(12, 157, 201));
        next.setForeground(new Color(250, 250, 250));
        next.setText("Confirm");        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }            
        });

        resetPass.add(next, "w 40%, h 40");
    }
    
    public void showLogin(boolean show){
        this.reset();
        login.setVisible(show);
        register.setVisible(!show);
        account.setVisible(false);
        question.setVisible(false);
        personalCheck.setVisible(false);
        answerCheck.setVisible(false);
        resetPass.setVisible(false);
    }
    
    public void showPersonalCheck() {
        login.setVisible(false);
        register.setVisible(false);
        account.setVisible(false);
        question.setVisible(false);
        personalCheck.setVisible(true);
        answerCheck.setVisible(false);
        resetPass.setVisible(false);
    }
    
    public void showAnswerCheck(String[] questions) {
        login.setVisible(false);
        register.setVisible(false);
        account.setVisible(false);
        question.setVisible(false);
        personalCheck.setVisible(false);
        forgotQ1.setLabelText(questions[0]);
        forgotQ2.setLabelText(questions[1]);
        forgotQ3.setLabelText(questions[2]);
        answerCheck.setVisible(true);
        resetPass.setVisible(false);
    }
    
    public void showResetPass(String username) {
        login.setVisible(false);
        register.setVisible(false);
        account.setVisible(false);
        question.setVisible(false);
        personalCheck.setVisible(false);
        answerCheck.setVisible(false);
        forgotUsername.setText(username);
        resetPass.setVisible(true);
    }
    
    public void showAddAcc(){
        login.setVisible(false);
        register.setVisible(false);
        account.setVisible(true);
        question.setVisible(false);
        personalCheck.setVisible(false);
        answerCheck.setVisible(false);
        resetPass.setVisible(false);
    }
    
    public void showQuestion(){
        login.setVisible(false);
        register.setVisible(false);
        account.setVisible(false);
        question.setVisible(true);
        personalCheck.setVisible(false);
        answerCheck.setVisible(false);
        resetPass.setVisible(false);
    }
    
    public void addEvent(ActionListener event) {
        this.event = event;
    }
    
    public void reset() {// use this to reset register page
        txtFullName.setText("");
        DoB.setText("");
        gender.setText("");
        citizenID.setText("");
        txtEmail.setText("");
        txtUserName.setText("");
        txtPass.setText("");
        cf_txtPass.setText("");
        ques1.setText("");
        ques2.setText("");
        ques3.setText("");
        answ1.setText("");
        answ2.setText("");
        answ3.setText("");
        loginName.setText("");
        loginPass.setText("");
        forgotFullname.setText("");
        forgotDoB.setText("");
        forgotGender.setText("");
        forgotId.setText("");
        forgotQ1.setText("");
        forgotQ2.setText("");
        forgotQ3.setText("");
        forgotUsername.setText("");
        forgotPass.setText("");
        forgotCfPass.setText("");
        
    }
    
    public String[] getPersonal_info() {// use this method to get register info
        String[] info = new String[5];
        info[0] = txtFullName.getText();
        info[1] = DoB.getText();
        info[2] = gender.getText();
        info[3] = citizenID.getText();
        info[4] = txtEmail.getText();
        return info;
    }
    
    public String[] getAccount_info() {
        String[] info = new String[2];
        info[0] = txtUserName.getText();
        char[] pwd = txtPass.getPassword();
        info[1] = new String(pwd);
        return info;
    }
    
    public String[] getQA_info() {
        String[] info = new String[6];
        info[0] = ques1.getText();
        info[1] = ques2.getText();
        info[2] = ques3.getText();
        info[3] = answ1.getText();
        info[4] = answ2.getText();
        info[5] = answ3.getText();
        return info;
    }
    
    public String[] getLogin_info() {// use this method to get login info
        String[] info = new String[2];
        info[0] = loginName.getText();
        char[] pwd = loginPass.getPassword();
        info[1] = new String(pwd);
        return info;
    }
    
    public String[] getPersonalCheck() {
        String[] info = new String[4];
        info[0] = forgotFullname.getText();
        info[1] = forgotDoB.getText();
        info[2] = forgotGender.getText();
        info[3] = forgotId.getText();
        return info;
    }
    
    public String[] getAnswerCheck() {
        String[] info = new String[3];
        info[0] = forgotQ1.getText();
        info[1] = forgotQ2.getText();
        info[2] = forgotQ3.getText();
        return  info;
    }
    
    public boolean checkAddAcc() {
        char[] pwd1 = txtPass.getPassword();
        String pass1 = new String(pwd1);
        char[] pwd2 = cf_txtPass.getPassword();
        String pass2 = new String(pwd2);
        if (pass1.equals(pass2)) {
            return true;
        } else {
            txtPass.setText("");
            cf_txtPass.setText("");
            return false;
        }
    }
    
    public boolean checkResetPass() {
        char[] pwd1 = forgotPass.getPassword();
        String pass1 = new String(pwd1);
        char[] pwd2 = forgotCfPass.getPassword();
        String pass2 = new String(pwd2);
        if (pass1.equals(pass2)) {
            return true;
        } else {
            forgotPass.setText("");
            forgotCfPass.setText("");
            return false;
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        account = new javax.swing.JPanel();
        question = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        personalCheck = new javax.swing.JPanel();
        answerCheck = new javax.swing.JPanel();
        resetPass = new javax.swing.JPanel();
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

        personalCheck.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout personalCheckLayout = new javax.swing.GroupLayout(personalCheck);
        personalCheck.setLayout(personalCheckLayout);
        personalCheckLayout.setHorizontalGroup(
            personalCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        personalCheckLayout.setVerticalGroup(
            personalCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(personalCheck, "card2");

        answerCheck.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout answerCheckLayout = new javax.swing.GroupLayout(answerCheck);
        answerCheck.setLayout(answerCheckLayout);
        answerCheckLayout.setHorizontalGroup(
            answerCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        answerCheckLayout.setVerticalGroup(
            answerCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(answerCheck, "card2");

        resetPass.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout resetPassLayout = new javax.swing.GroupLayout(resetPass);
        resetPass.setLayout(resetPassLayout);
        resetPassLayout.setHorizontalGroup(
            resetPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        resetPassLayout.setVerticalGroup(
            resetPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(resetPass, "card2");

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
    
    public void setAnimate(boolean b) {
        txtFullName.setAnimate(b);
        txtEmail.setAnimate(b);
        gender.setAnimate(b);
        DoB.setAnimate(b);
        citizenID.setAnimate(b);
        regisButton.setEnabled(b);
        loginButton.setEnabled(b);
        forgetButton.setEnabled(b);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel account;
    private javax.swing.JPanel answerCheck;
    private javax.swing.JPanel login;
    private javax.swing.JPanel personalCheck;
    private javax.swing.JPanel question;
    private javax.swing.JPanel register;
    private javax.swing.JPanel resetPass;
    // End of variables declaration//GEN-END:variables
}
