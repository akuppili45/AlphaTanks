package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class EnemyTank extends Tank {
	
	private Handler handler;
	
    public EnemyTank(float x, float y, ObjectId id, Handler handler){
        super(x,y,id, handler);
        this.handler = handler;
    }
    @Override
    public void tick(LinkedList<GameObject> object) {
    	Collision(object);
    }
    
    public void Collision(LinkedList<GameObject> object) {
    	for(int i=0; i < handler.object.size();i++)
    	{
    		GameObject tempObject = handler.object.get(i);
    		
    		if(tempObject.getID() == ObjectId.PlayerTank) //if you want to collide with other objects add an 'or' statement
    		{
    			if(getBoundsTop().intersects((tempObject.getBounds())))
    			{
    				y = tempObject.getY() + (height/2);
    				velY= 0;
    				System.out.println("collision");

    			}
    			
    			if(getBounds().intersects((tempObject.getBounds())))
    			{
    				y = tempObject.getY() - height;
    				velY= 0;
    				System.out.println("collision");

    			}	
    			
    			if(getBoundsRight().intersects((tempObject.getBounds())))
    			{
    				x = tempObject.getX() - width;
    				System.out.println("collision");

    			}
    			
    			if(getBoundsLeft().intersects((tempObject.getBounds())))
    			{
    				x = tempObject.getX() - width;
    				System.out.println("collision");

    			}
    		}
    	}
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, (int)width, (int)height);
        gun.render(g);
        
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.black);
        g2d.draw(getBounds());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsLeft());
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
