package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Created by akupp_000 on 5/7/2017.
 */
public class Handler
{
    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    private GameObject tempObject;
    int currentLevel = 1;
    public boolean clear = false;
    public BufferedImage level = null;
    public static int score = 0;
    public Window window;
    private int count = 0;
    public void tick(){
        for(int i = 0; i < object.size();i++){
            tempObject = object.get(i);
            tempObject.tick(object);
        }
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void render(Graphics g){
        for(int i = 0; i < object.size();i++){
            tempObject = object.get(i);
            tempObject.render(g);

        }
    }
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
    	if(object.getID() == ObjectId.PlayerTank)
    	{
    		count++;
    		if(count == 2)
    		{
            JFrame frame = new JFrame("Game Over");
            JLabel label = new JLabel("Score: " + Handler.score, SwingConstants.CENTER);
            JLabel label2 = new JLabel("Press ESC to exit...", SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(300, 100));
            label2.setPreferredSize(new Dimension(300,100));
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.getContentPane().add(label2, BorderLayout.AFTER_LAST_LINE);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
    		}
    	}
    	else if(object.getID() == ObjectId.EnemyTank)
    	{
    		score++;
    	}
        this.object.remove(object);
    }
    public void clearLevel(){
        object.clear();
        clear = true;
    }
    public void decideLevel(){
        BufferedImageLoader loader = new BufferedImageLoader();
             switch (currentLevel){
                case 1:
                    level = loader.loadImage("/level1.png");
                    break;
                case 2:
                    level = loader.loadImage("/2.png");
                    break;
            }

    }

}
