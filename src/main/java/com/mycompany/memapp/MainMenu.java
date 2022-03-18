package com.mycompany.memapp;

import javax.swing.JOptionPane;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    /**
     * Local Variables for Saving Necessary Data
     * For methods used for only one panel format is: private void pnlName+Action() {...}
     */
    int mode; // 0 = Dashboard; 1 = Learn; 2 = Test Yourself; 3 = Password;
    
    private void setMode() {
        pnlDashboard.setVisible(false);
        pnlLearn.setVisible(false);
        pnlTest.setVisible(false);
        pnlPassword.setVisible(false);
        
        btnDashboard.setBackground(java.awt.Color.white);
        btnLearn.setBackground(java.awt.Color.white);
        btnTest.setBackground(java.awt.Color.white);
        btnPassword.setBackground(java.awt.Color.white);
        //Insert Set all panels visibility to false & Color to white
        if (mode == 0) {
            btnDashboard.setBackground(new java.awt.Color(218, 244, 246));
            pnlDashboard.setVisible(true);
        }
        else if (mode == 1) {
            btnLearn.setBackground(new java.awt.Color(218, 244, 246));
            pnlLearn.setVisible(true);
        }
        else if (mode == 2) {
            btnTest.setBackground(new java.awt.Color(218, 244, 246));
            pnlTest.setVisible(true);
        }
        else if (mode == 3) {
            btnPassword.setBackground(new java.awt.Color(218, 244, 246));
            pnlPassword.setVisible(true);
        }
    }
    
    private void passwordValidateData() {
        String oldPW = String.valueOf(txtOldPassword.getPassword()), 
                newPW = String.valueOf(txtNewPassword.getPassword()),
                confNewPW = String.valueOf(txtConfPass.getPassword());
        
        if(oldPW.isEmpty() || newPW.isEmpty() || confNewPW.isEmpty()) //If one is empyty
            JOptionPane.showMessageDialog(null, "A Field is be empty! Please input data needed.","Change Password: Error",2);
        else {
            if(Loader.credentials.get(Loader.LoggedUser).equals(oldPW)) { //If old pw matches saved pw
                if(!oldPW.equals(newPW)) { //If oldpw is NOT the same with newpw
                    if(newPW.equals(confNewPW)) {//If newPW matches ConfirmPW
                        Loader.credentials.replace(Loader.LoggedUser, newPW);
                        JOptionPane.showMessageDialog(null, "Password has been changed!","Change Password: Success",JOptionPane.INFORMATION_MESSAGE);
                        
                        Loader load = new Loader();
                        try {
                            load.dataExport();
                        } catch (Exception ex) {}
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error! New Password and Confirm Password does not match!","Change Password: Error",2);
                }
                else
                    JOptionPane.showMessageDialog(null, "Error! New Password is the same as the Old Password!", "Change Password: Error", 2);
            }
            else
                JOptionPane.showMessageDialog(null, "Error! Old Password is incorrect!", "Change Password: Error", 2);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBack = new javax.swing.JPanel();
        pnlSide = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnLearn = new javax.swing.JButton();
        btnPassword = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        pnlLearn = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlDashboard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlTest = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlPassword = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        txtConfPass = new javax.swing.JPasswordField();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlBack.setBackground(new java.awt.Color(241, 241, 241));
        pnlBack.setPreferredSize(new java.awt.Dimension(768, 480));

        pnlSide.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.home")+"\\AppData\\Roaming\\MemApp\\Sources\\prof.png"));
        jLabel2.setText("Welcome! "+Loader.LoggedUser);

        btnDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDashboard.setIcon(new javax.swing.ImageIcon(System.getProperty("user.home")+"\\AppData\\Roaming\\MemApp\\Sources\\btnDB.png"));
        btnDashboard.setText("Dashboard");
        btnDashboard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnDashboard.setFocusPainted(false);
        btnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnLearn.setBackground(new java.awt.Color(255, 255, 255));
        btnLearn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLearn.setIcon(new javax.swing.ImageIcon(System.getProperty("user.home")+"\\AppData\\Roaming\\MemApp\\Sources\\btnDB.png"));
        btnLearn.setText("Learn");
        btnLearn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnLearn.setFocusPainted(false);
        btnLearn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLearn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLearnActionPerformed(evt);
            }
        });

        btnPassword.setBackground(new java.awt.Color(255, 255, 255));
        btnPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPassword.setIcon(new javax.swing.ImageIcon(System.getProperty("user.home")+"\\AppData\\Roaming\\MemApp\\Sources\\btnDB.png"));
        btnPassword.setText("Password");
        btnPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnPassword.setFocusPainted(false);
        btnPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasswordActionPerformed(evt);
            }
        });

        btnTest.setBackground(new java.awt.Color(255, 255, 255));
        btnTest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTest.setIcon(new javax.swing.ImageIcon(System.getProperty("user.home")+"\\AppData\\Roaming\\MemApp\\Sources\\btnDB.png"));
        btnTest.setText("Test yourself");
        btnTest.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnTest.setFocusPainted(false);
        btnTest.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        btnSignOut.setBackground(new java.awt.Color(255, 255, 255));
        btnSignOut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSignOut.setIcon(new javax.swing.ImageIcon(System.getProperty("user.home")+"\\AppData\\Roaming\\MemApp\\Sources\\btnDB.png"));
        btnSignOut.setText("Sign out");
        btnSignOut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnSignOut.setFocusPainted(false);
        btnSignOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSideLayout = new javax.swing.GroupLayout(pnlSide);
        pnlSide.setLayout(pnlSideLayout);
        pnlSideLayout.setHorizontalGroup(
            pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLearn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(51, Short.MAX_VALUE))
            .addComponent(btnPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSignOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSideLayout.setVerticalGroup(
            pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnLearn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        pnlLearn.setBackground(new java.awt.Color(241, 241, 241));
        pnlLearn.setPreferredSize(new java.awt.Dimension(379, 157));

        jLabel3.setText("Learn Coming Soon!");

        javax.swing.GroupLayout pnlLearnLayout = new javax.swing.GroupLayout(pnlLearn);
        pnlLearn.setLayout(pnlLearnLayout);
        pnlLearnLayout.setHorizontalGroup(
            pnlLearnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLearnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLearnLayout.setVerticalGroup(
            pnlLearnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLearnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDashboard.setBackground(new java.awt.Color(241, 241, 241));
        pnlDashboard.setPreferredSize(new java.awt.Dimension(379, 157));

        jLabel1.setText("Dashboard Coming Soon!");

        javax.swing.GroupLayout pnlDashboardLayout = new javax.swing.GroupLayout(pnlDashboard);
        pnlDashboard.setLayout(pnlDashboardLayout);
        pnlDashboardLayout.setHorizontalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDashboardLayout.setVerticalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTest.setBackground(new java.awt.Color(241, 241, 241));
        pnlTest.setPreferredSize(new java.awt.Dimension(379, 157));

        jLabel4.setText("Test Coming Soon!");

        javax.swing.GroupLayout pnlTestLayout = new javax.swing.GroupLayout(pnlTest);
        pnlTest.setLayout(pnlTestLayout);
        pnlTestLayout.setHorizontalGroup(
            pnlTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTestLayout.setVerticalGroup(
            pnlTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPassword.setBackground(new java.awt.Color(241, 241, 241));
        pnlPassword.setPreferredSize(new java.awt.Dimension(379, 157));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel5.setText("Change Password");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Previous Password");

        txtOldPassword.setText("Password");
        txtOldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOldPasswordFocusGained(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("New Password");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Confirm Password");

        txtNewPassword.setText("Password");
        txtNewPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNewPasswordFocusGained(evt);
            }
        });

        txtConfPass.setText("Password");
        txtConfPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtConfPassFocusGained(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(121, 227, 235));
        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.setBorder(null);
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPasswordLayout = new javax.swing.GroupLayout(pnlPassword);
        pnlPassword.setLayout(pnlPasswordLayout);
        pnlPasswordLayout.setHorizontalGroup(
            pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPasswordLayout.createSequentialGroup()
                        .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPasswordLayout.setVerticalGroup(
            pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(58, 58, 58)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtConfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBackLayout = new javax.swing.GroupLayout(pnlBack);
        pnlBack.setLayout(pnlBackLayout);
        pnlBackLayout.setHorizontalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackLayout.createSequentialGroup()
                .addComponent(pnlSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 163, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTest, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLearn, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
        );
        pnlBackLayout.setVerticalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
            .addComponent(pnlTest, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
            .addComponent(pnlLearn, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
            .addComponent(pnlDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * ActionListener Methods
     * private void ObjectName+Action(...) {...}
     */
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mode = 0;
        setMode();
    }//GEN-LAST:event_formWindowOpened

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        mode = 0;
        setMode();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnLearnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLearnActionPerformed
        mode = 1;
        setMode();
    }//GEN-LAST:event_btnLearnActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        mode = 2;
        setMode();
    }//GEN-LAST:event_btnTestActionPerformed

    private void btnPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasswordActionPerformed
        mode = 3;
        setMode();
    }//GEN-LAST:event_btnPasswordActionPerformed

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        this.dispose();
        
        Loader.LoggedUser = null;
        
        SignIn sIn = new SignIn();
        sIn.setVisible(true);
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        passwordValidateData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtOldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOldPasswordFocusGained
        txtOldPassword.selectAll();
    }//GEN-LAST:event_txtOldPasswordFocusGained

    private void txtNewPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewPasswordFocusGained
        txtNewPassword.selectAll();
    }//GEN-LAST:event_txtNewPasswordFocusGained

    private void txtConfPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfPassFocusGained
        txtConfPass.selectAll();
    }//GEN-LAST:event_txtConfPassFocusGained

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLearn;
    private javax.swing.JButton btnPassword;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton btnTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel pnlBack;
    private javax.swing.JPanel pnlDashboard;
    private javax.swing.JPanel pnlLearn;
    private javax.swing.JPanel pnlPassword;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JPanel pnlTest;
    private javax.swing.JPasswordField txtConfPass;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtOldPassword;
    // End of variables declaration//GEN-END:variables
}
