/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdemo.University;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author tarunganga
 */
public class CourseFrame extends javax.swing.JFrame {

    /**
     * Creates new form CourseFrame
     */
    public CourseFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_courseName = new javax.swing.JTextField();
        txt_courseNumber = new javax.swing.JTextField();
        txt_cHours = new javax.swing.JTextField();
        txt_department = new javax.swing.JTextField();
        btn_addCourse = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Course Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 202, -1, -1));

        jLabel2.setText("Course Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 322, -1, -1));

        jLabel3.setText("Credit hours");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 444, -1, -1));

        jLabel4.setText("Department");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 558, -1, -1));
        getContentPane().add(txt_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 199, 254, -1));
        getContentPane().add(txt_courseNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 319, 254, -1));
        getContentPane().add(txt_cHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 441, 254, -1));
        getContentPane().add(txt_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 552, 254, -1));

        btn_addCourse.setText("Add Course");
        btn_addCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addCourseActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 670, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Course");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addCourseActionPerformed
        // TODO add your handling code here:
        
        String cNumber = txt_courseNumber.getText();
        int cHours = Integer.parseInt(txt_cHours.getText());
        String cName = txt_courseName.getText();
        String department = txt_department.getText();

        Connection conn = null;

        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //demo is the name of the database
            conn = DriverManager.getConnection("jdbc:mysql:///university", "root","chowdarY@759");//replace XXXXXX with you password
            //employees is the name of the table
            //4 questions marks for 4 fields in the table that i want to insert into
            pstmt = conn.prepareStatement("insert into course values(?,?,?,?)");
            pstmt.setString(1, cName);
            pstmt.setString(2, cNumber);
            pstmt.setInt(3, cHours);
            pstmt.setString(4, department);
            int i = pstmt.executeUpdate();//will update database
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Data is saved");
            } else {

                JOptionPane.showMessageDialog(null, "Data not saved");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_addCourseActionPerformed

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
            java.util.logging.Logger.getLogger(CourseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_cHours;
    private javax.swing.JTextField txt_courseName;
    private javax.swing.JTextField txt_courseNumber;
    private javax.swing.JTextField txt_department;
    // End of variables declaration//GEN-END:variables
}