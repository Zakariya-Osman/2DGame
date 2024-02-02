/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change window license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit window template
 */
package pkg2dgame;

import javax.swing.JFrame;

/**
 *
 * @author osman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //frame set up
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Game Window");
        //window.setLayout(null);
        //window.setSize(1000, 500);
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); // what does this do?
        
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
        gamePanel.startGameThread();
        
    }
    
}
