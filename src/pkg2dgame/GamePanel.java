/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author osman
 */
public class GamePanel extends JPanel implements Runnable {
    //screen settings 
    final int originalTileSize = 16; //16x16 tile default size of any components 
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale; //48x48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768px
    final int screenHeight = tileSize * maxScreenRow; //576px
    
    //fps
    int FPS = 120;
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    //set player defult position
    int playerx = 100;
    int playery = 100;
    int playera = 100;
    int playerb = 100;
    int playerSpeed = 4;
    
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);// what does this do?
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS; //0.01666666 sec will draw screen
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        
        while(gameThread != null){
            //System.out.println("The Game Loop is running...");
            
            //uptare character peossion 
            update();
            
            
            //draw screen with upaded position
            repaint();
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if (remainingTime< 0){
                    remainingTime = 0;
                }
                
                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public void update(){
        if (keyH.upRight == true){
            playery +=
        }
        else if(keyH.downRight == true){
            
        }
        else if (keyH.leftDown == true){
            
        }
        else if(keyH.leftup == true){
            
        }
        else if (keyH.upPressed == true){
            playery -= playerSpeed;
        }
        else if(keyH.downPressed == true){
            playery += playerSpeed;
        }
        else if(keyH.leftPressed == true){
            playerx -= playerSpeed;
        }
        else if(keyH.rightPressed == true){
            playerx += playerSpeed;
        }
        
        
        
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.white);
        g2.fillRect(playerx, playery, tileSize, tileSize);
        g2.dispose();
        
    }
}
