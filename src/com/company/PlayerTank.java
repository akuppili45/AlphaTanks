package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by akupp_000 on 5/3/2017.
 */
public class PlayerTank extends Tank
{
	private Handler handler;
	
    public PlayerTank(float x, float y, ObjectId id, Handler handler){
        super(x,y,id, handler);
        this.handler = handler;
    }
    @Override
    public void tick(LinkedList<GameObject> object) {
        super.tick(object);
        Collision(object);
    }

    public void Collision(LinkedList<GameObject> object) {
    	for(int i=0; i < handler.object.size();i++)
    	{
    		GameObject tempObject = handler.object.get(i);
    		
    		if(tempObject.getID() == ObjectId.Block)
    		{
    			if(getBoundsTop().intersects((tempObject.getBounds())))
    			{
    				y = tempObject.getY() + (height/2);
    				velY= 0;
    			}
    			
    			if(getBounds().intersects((tempObject.getBounds())))
    			{
    				y = tempObject.getY() - height;
    				velY= 0;
    			}	
    			
    			if(getBoundsRight().intersects((tempObject.getBounds())))
    			{
    				x = tempObject.getX() - width;
    			}
    			
    			if(getBoundsLeft().intersects((tempObject.getBounds())))
    			{
    				x = tempObject.getX() - width;
    			}
    		}
    	}
    }
    
    @Override
    public void render(Graphics g) {
        super.render(g);
        
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.GREEN);
        g2d.draw(getBounds());
        g.setColor(Color.RED);
        g2d.draw(getBoundsRight());
        g.setColor(Color.YELLOW);
        g2d.draw(getBoundsLeft());
        g.setColor(Color.WHITE);
        g2d.draw(getBoundsTop());
    }

    public Rectangle getBounds(){
    	return new Rectangle((int) ((int)x + (width/2)-((width/2)/2)), (int) ((int)y+(height/2))+5, (int)width/2, (int)(height/2)-10);
    }
    
    public Rectangle getBoundsTop(){
    	return new Rectangle((int) ((int)x + (width/2)-((width/2)/2)), (int)y+5, (int)width/2, (int)(height/2)-10);
    }
    
    public Rectangle getBoundsRight(){
    	return new Rectangle((int) ((int)x+width-7), (int)y+5, (int)1, (int)height-10);
    }
    
    public Rectangle getBoundsLeft(){
    	return new Rectangle((int)x+6, (int)y+5, (int)1, (int)height-10);
    }
    
}
