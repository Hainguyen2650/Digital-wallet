package main;

import component.Message;
import component.PanelCover;
import component.PanelLoginAndRegister;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class login_register extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginAndRegister LoginAndRegister;
    private boolean isRegister = false;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###");
    private boolean loginSuccess;
    
    public login_register() {
        initComponents();
        init();
    }
    
    private void init(){
        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("./icon/Logo_Đại_học_Bách_Khoa_Hà_Nội.svg.png"));
        this.setIconImage(img.getImage());
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        LoginAndRegister = new PanelLoginAndRegister();// behave opposite to cover
        TimingTarget target = new TimingTargetAdapter(){//create target obj to run animation 

            @Override
            public void timingEvent(float fraction) {
                // this run multiple time to create frame for animation
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                
                // make panel expand while animation
                if (fraction<=0.5f){
                    size += fraction * addSize;
                } else {
                    size += addSize -fraction * addSize;
                }
                //
                
                if (isRegister){
                    fractionCover = 1f - fraction;// return discrete value from 1 to 0 in fixed time
                    fractionLogin = fraction;
                    if (fraction>=0.5f){
                        cover.registerRight((1f-fraction) * 100);
                    } else {
                        cover.loginRight(fraction * 100);
                    }
                } else {
                    fractionCover = fraction;// return discrete value from 0 to 1 in fixed time
                    fractionLogin = 1f - fraction;
                    if (fraction<=0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                
                if (fraction>=0.5f) {
                    LoginAndRegister.showLogin(isRegister);
                }
                
                fractionCover = Double.valueOf(df.format(fractionCover));// round fractionCover to suit the format of the below line
                fractionLogin = Double.valueOf(df.format(fractionLogin));// round fractionCover to suit the format of the below line
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover+"al 0 n 100%");// create frame for animation
                layout.setComponentConstraints(LoginAndRegister, "width " + loginSize + "%, pos " + fractionLogin+"al 0 n 100%");// create frame for animation
                bg.revalidate();// draw frame
            }

            @Override
            public void end() {// called when event state change
                isRegister = !isRegister;// switch state everytime event state change
            }
            
        };
        Animator animator = new Animator(1000, target);// set time for animation
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);// for smooth animation
                
        bg.setLayout(layout);
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");// add panel cover with width "coverSize" at 0 pos to the bg
        bg.add(LoginAndRegister, "width " + loginSize + "%, pos 1al 0 n 100%");// add login panel to the opposite side to the cover
        
        cover.addEvent(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){// when event is stated, call this
                if (!animator.isRunning()){
                    animator.start();
                    //LoginAndRegister.resetLogin();
                    //LoginAndRegister.resetRegister();
                }
            }
        });
        
        LoginAndRegister.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getActionCommand()=="SIGN IN") {
                    String[] loginInfo = LoginAndRegister.getLogin_info();// [username, pass]
                    //check if login success or not
                    if (loginSuccess) {
                        showMessage(Message.MessageType.SUCCESS, "Log in success");
                        //go to main program
                    } else {
                        showMessage(Message.MessageType.ERROR, "Log in fail");
                        //noitice
                    }
                    LoginAndRegister.resetLogin();
                }
                else if (ae.getActionCommand()=="Next (1/3)") {
                    LoginAndRegister.showAddAcc();
                }
                else if(ae.getActionCommand()=="Forgot your password ?") {
                    //ask question
                }
            }
        });
    }
    
    private void showMessage(Message.MessageType messageType, String message) {
        Message ms = new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al -30", 0); //  Insert to bg fist index 0
                    ms.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                } else {
                    ms.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    animator.start();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
