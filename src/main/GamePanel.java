/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import entity.Player;
import tile.TileManager;

/**
 *
 * @author osman
 */
public class GamePanel extends JPanel implements Runnable {
    //screen settings 
    final int originalTileSize = 16; //16x16 tile default size of any components 
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; //48x48
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768px
    public final int screenHeight = tileSize * maxScreenRow; //576px
    
    //  world settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int maxWidth = tileSize * maxWorldCol;
    public final int maxHeight = tileSize * maxWorldRow;
    
    //fps
    int FPS = 60;
    
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    //collision detection
    public collisionChecker cChecker = new collisionChecker(this);
    public Player player = new Player(this,keyH);
    
    //set player defult position
    int playerx = 100;
    int playery = 100;
    int playerSpeed = 20;
    
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
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
        long timer = 0;
        int drawCount = 0;
        
        
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
            drawCount++;
            System.out.println(drawCount);
        
        
    }
    
    public void update(){
        player.update();
        
        
        
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        tileM.draw(g2);
        player.draw(g2);
        
        g2.dispose();
        
    }
}
