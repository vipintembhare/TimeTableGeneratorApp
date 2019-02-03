/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JFrame;

/**
 *
 * @author Vipin
 */
public class SwingUtils {
    
    public static void showNextFrames(JFrame currentFrame, JFrame nextFrame){
         currentFrame.dispose();
         nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         nextFrame.pack();
         nextFrame.setLocationRelativeTo(null);
         nextFrame.setVisible(true);
    }
}
