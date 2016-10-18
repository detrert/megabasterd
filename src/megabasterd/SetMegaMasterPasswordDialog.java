package megabasterd;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static megabasterd.MainPanel.FONT_DEFAULT;
import static megabasterd.MainPanel.THREAD_POOL;
import static megabasterd.MiscTools.Bin2BASE64;
import static megabasterd.MiscTools.HashBin;
import static megabasterd.MiscTools.swingReflectionInvoke;
import static megabasterd.MiscTools.updateFont;


/**
 *
 * @author tonikelope
 */
public class SetMegaMasterPasswordDialog extends javax.swing.JDialog {

    private boolean _pass_ok;
       
    private String _new_pass_hash;
    
    private byte[] _new_pass;
    
    private final String _salt;

    public boolean isPass_ok() {
        return _pass_ok;
    }

    public byte[] getNew_pass() {
        return _new_pass;
    }
    
    public void deleteNewPass() {
        
        if(_new_pass != null) {
            
            Arrays.fill(_new_pass, (byte)0);
        }
        
        _new_pass = null;
    }

    public String getNew_pass_hash() {
        return _new_pass_hash;
    }

    /**
     * Creates new form MegaPassDialog
     */
    public SetMegaMasterPasswordDialog(java.awt.Frame parent, boolean modal, String salt) {
        super(parent, modal);
        initComponents();
        
        updateFont(new_pass_label, FONT_DEFAULT, Font.PLAIN);
        updateFont(confirm_pass_label, FONT_DEFAULT, Font.PLAIN);
        updateFont(ok_button, FONT_DEFAULT, Font.PLAIN);
        updateFont(cancel_button, FONT_DEFAULT, Font.PLAIN);
        updateFont(warning_label, FONT_DEFAULT, Font.PLAIN);
        updateFont(status_label, FONT_DEFAULT, Font.PLAIN);
        
        _pass_ok = false;
        
        _new_pass = null;
        
        _new_pass_hash = null;
        
        _salt = salt;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        confirm_pass_textfield = new javax.swing.JPasswordField();
        confirm_pass_label = new javax.swing.JLabel();
        cancel_button = new javax.swing.JButton();
        ok_button = new javax.swing.JButton();
        lock_label = new javax.swing.JLabel();
        warning_label = new javax.swing.JLabel();
        new_pass_label = new javax.swing.JLabel();
        new_pass_textfield = new javax.swing.JPasswordField();
        status_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MegaMasterPassword");
        setResizable(false);

        confirm_pass_textfield.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        confirm_pass_textfield.setDoubleBuffered(true);
        confirm_pass_textfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirm_pass_textfieldKeyPressed(evt);
            }
        });

        confirm_pass_label.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        confirm_pass_label.setText("Confirm new:");
        confirm_pass_label.setDoubleBuffered(true);

        cancel_button.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        cancel_button.setText("CANCEL");
        cancel_button.setDoubleBuffered(true);
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        ok_button.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        ok_button.setText("OK");
        ok_button.setDoubleBuffered(true);
        ok_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_buttonActionPerformed(evt);
            }
        });

        lock_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megabasterd/lock_medium.png"))); // NOI18N
        lock_label.setDoubleBuffered(true);

        warning_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        warning_label.setText("WARNING: if you forget this password, you will have to insert all your MEGA accounts again.");
        warning_label.setDoubleBuffered(true);

        new_pass_label.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        new_pass_label.setText("New pass:");
        new_pass_label.setDoubleBuffered(true);

        new_pass_textfield.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        new_pass_textfield.setDoubleBuffered(true);

        status_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        status_label.setDoubleBuffered(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lock_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirm_pass_label)
                            .addComponent(new_pass_label))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirm_pass_textfield)
                            .addComponent(new_pass_textfield))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(status_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ok_button)
                        .addGap(18, 18, 18)
                        .addComponent(cancel_button)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(warning_label, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lock_label)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(new_pass_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(new_pass_label))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(confirm_pass_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirm_pass_label))))
                .addGap(18, 18, 18)
                .addComponent(warning_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ok_button)
                        .addComponent(cancel_button))
                    .addComponent(status_label, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        
        swingReflectionInvoke("setVisible", this, false);
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void ok_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_buttonActionPerformed
       
        swingReflectionInvoke("setText", status_label, "Verifying your password, please wait...");
        
        final Dialog tthis = this;
        
        THREAD_POOL.execute(new Runnable(){
            
            @Override
            public void run() {
        
        try {

            if(Arrays.equals(new_pass_textfield.getPassword(), confirm_pass_textfield.getPassword())) {
                
                swingReflectionInvoke("setText", status_label, "Processing your password, please wait...");
                
                if(new_pass_textfield.getPassword().length > 0) {

                    _new_pass = CryptTools.PBKDF2HMACSHA256(new String(new_pass_textfield.getPassword()), MiscTools.BASE642Bin(_salt), CryptTools.PBKDF2_ITERATIONS);

                    _new_pass_hash =Bin2BASE64(HashBin("SHA-1", _new_pass));
                }

                _pass_ok = true;

                swingReflectionInvoke("setVisible", tthis, false);

            } else {
                
                JOptionPane.showMessageDialog(tthis, "Passwords does not match!", "Error", JOptionPane.ERROR_MESSAGE);
                
                swingReflectionInvoke("setText", status_label, "");
                
                swingReflectionInvoke("setText", new_pass_textfield, "");
                
                swingReflectionInvoke("setText", confirm_pass_textfield, "");
                
                swingReflectionInvoke("grabFocus", new_pass_textfield);
            }
          
        } catch (Exception ex) {
            Logger.getLogger(SetMegaMasterPasswordDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
            }});
    }//GEN-LAST:event_ok_buttonActionPerformed

    private void confirm_pass_textfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirm_pass_textfieldKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            ok_buttonActionPerformed(null);
        }
    }//GEN-LAST:event_confirm_pass_textfieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JLabel confirm_pass_label;
    private javax.swing.JPasswordField confirm_pass_textfield;
    private javax.swing.JLabel lock_label;
    private javax.swing.JLabel new_pass_label;
    private javax.swing.JPasswordField new_pass_textfield;
    private javax.swing.JButton ok_button;
    private javax.swing.JLabel status_label;
    private javax.swing.JLabel warning_label;
    // End of variables declaration//GEN-END:variables
}
