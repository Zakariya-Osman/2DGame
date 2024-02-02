/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author osman
 */
public class KeyHandler implements KeyListener {
    
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    
    public boolean upRight, downRight, leftDown, leftup;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W && code == KeyEvent.VK_D){
            upRight = true;
        }
        if (code == KeyEvent.VK_D && code == KeyEvent.VK_S){
            downRight = true;
        }
        if (code == KeyEvent.VK_S && code == KeyEvent.VK_A){
            leftDown = true;
        }
        if (code == KeyEvent.VK_A && code == KeyEvent.VK_W){
            leftup = true;
        }
        if (code == KeyEvent.VK_W){
            upPressed = true;
            
        }
        if (code == KeyEvent.VK_S){
            downPressed = true;
            
        }
        if (code == KeyEvent.VK_A){
            leftPressed = true;
            
        }
        if (code == KeyEvent.VK_D){
            rightPressed = true;
            
        }
            
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W && code == KeyEvent.VK_D){
            upRight = false;
        }
        if (code == KeyEvent.VK_D && code == KeyEvent.VK_S){
            downRight = false;
        }
        if (code == KeyEvent.VK_S && code == KeyEvent.VK_A){
            leftDown = false;
        }
        if (code == KeyEvent.VK_A && code == KeyEvent.VK_W){
            leftup = false;
        }
        if (code == KeyEvent.VK_W){
            upPressed = false;
            
        }
        if (code == KeyEvent.VK_S){
            downPressed = false;
            
        }
        if (code == KeyEvent.VK_A){
            leftPressed = false;
            
        }
        if (code == KeyEvent.VK_D){
            rightPressed = false;
            
        }
        
        
    }
    
}
