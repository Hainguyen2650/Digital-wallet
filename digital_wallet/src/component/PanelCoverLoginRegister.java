package component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import swing.ButtonOutLine;
import java.text.DecimalFormat;

public class PanelCoverLoginRegister extends javax.swing.JPanel {

    private final DecimalFormat df = new DecimalFormat("##0.##");
    private ActionListener event;
    private MigLayout layout;
    private JLabel title;
    private JLabel description;
    private JLabel description1;
    private ButtonOutLine button;
    private boolean isRegister;
    
    
    public PanelCoverLoginRegister() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);   
        init();
    }

    private void init(){
        title = new JLabel("Welcome Back!");
        title.setFont(new Font("sansserif",1,30));
        title.setForeground(new Color(245, 245, 245));
        this.add(title);
        description = new JLabel("To keep connected with us please sign in");
        description.setFont(new Font("sansserif", 1, 10));
        description.setForeground(new Color(245,245,245));
        this.add(description);
        description1 = new JLabel("Don't have account ? Sign up here!");
        description1.setFont(new Font("sansserif", 1, 10));
        description1.setForeground(new Color(245,245,245));
        this.add(description1);
        
        button = new ButtonOutLine();
        button.setBackground(new Color(255,255,255));
        button.setForeground(new Color(255,255,255));
        button.setText("SIGN UP");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }
        });
        this.add(button, "w 60%, h 40");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
// Fill panel cover with blue
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gra = new GradientPaint(0, 0, new Color(12, 157, 201), 0, getHeight(), new Color(12, 157, 201));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    
    public void addEvent(ActionListener event) {
        this.event = event;// set event of panel cover to the event state
    }
    
    //animation
    public void loginLeft(double v){
        v = Double.valueOf(df.format(v));
        register(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" + v + "% 0 0");
    }
    
    public void loginRight(double v){
        v = Double.valueOf(df.format(v));
        register(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" + v + "% 0 0");
    }
    
    public void registerLeft(double v){
        v = Double.valueOf(df.format(v));
        register(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + '%');
        layout.setComponentConstraints(description, "pad 0 " + v + "% 0 " + v + '%');
        layout.setComponentConstraints(description1, "pad 0 " + v + "% 0 " + v + '%');
    }
    
    public void registerRight(double v){
        v = Double.valueOf(df.format(v));
        register(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + '%');
        layout.setComponentConstraints(description, "pad 0 " + v + "% 0 " + v + '%');
        layout.setComponentConstraints(description1, "pad 0 " + v + "% 0 " + v + '%');
    }
    
    public void register(boolean resigter) {
        if (this.isRegister != resigter) {
            if (isRegister) {
                title.setText("Newbie ?");
                description.setText("Please let us know more about you");
                description1.setText("Have account ? This is not for you");
                button.setText("SIGN IN");
            } else {
                title.setText("Welcome Back!");
                description.setText("To keep connected with us please sign in");
                description1.setText("Don't have account ? Sign up here!");
                button.setText("SIGN UP");
            }
            this.isRegister = resigter;
        }
    }
    
    public void forgotPass() {
        this.isRegister = false;
        title.setText("Forgot your account");
        description.setText("Don't worry, we will help you find it");
        description1.setText("Just remembered your account ?");
        button.setText("Back to SIGN IN");      
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
