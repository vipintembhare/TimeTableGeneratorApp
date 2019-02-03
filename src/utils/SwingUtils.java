/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dbutils.DBUtils;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vipin
 */
public class SwingUtils {
    
    public static void showNextFrames(JFrame currentFrame, JFrame nextFrame){
         currentFrame.dispose();
         nextFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         nextFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        if (JOptionPane.showConfirmDialog(nextFrame, 
                            "Are you sure you want to close this window?", "Close Window?", 
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                            DBUtils.closeConnection();
                            System.exit(0);

                        }
                    }});
         nextFrame.pack();
         nextFrame.setLocationRelativeTo(null);
         nextFrame.setVisible(true);
    }
}
