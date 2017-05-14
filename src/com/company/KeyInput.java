package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by akupp_000 on 5/5/2017.
 */
public class KeyInput extends KeyAdapter
{
    Handler handler;
    float speed = 3.33f;
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i<handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ObjectId.PlayerTank ){ //Checks if the id is a player
                if(key == KeyEvent.VK_D)
                    tempObject.setVelX(5);
                if(key== KeyEvent.VK_A)
                    tempObject.setVelX(-5);


            }
            if(tempObject.getID() == ObjectId.Gun){
                if(key == KeyEvent.VK_D){
                    tempObject.setVelX(speed);
                    tempObject.setVelY(-speed);
                }
                if(key== KeyEvent.VK_A){
                    tempObject.setVelX(-speed);
                    tempObject.setVelY(speed);
                }

                if(key == KeyEvent.VK_LEFT) {

                        Gun gun = (Gun) tempObject;
                        gun.setAngle(gun.getAngle() + 10);

                }
                if(key == KeyEvent.VK_RIGHT) {

                    Gun gun = (Gun)tempObject;
                    gun.setAngle(gun.getAngle()-10);
                }
                if(key == KeyEvent.VK_SPACE)
                {
                    Gun gun = (Gun)tempObject;
                    handler.addObject(new Bullet(((float)((gun.x) + gun.getRadius() * Math.cos(Math.toRadians(gun.getAngle())))),(float)
                            (gun.y- gun.getRadius()*Math.sin(Math.toRadians(gun.getAngle()))), ObjectId.Bullet, (float)(20 * Math.cos(Math.toRadians(gun.getAngle()))), gun));
                }

            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i<handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ObjectId.PlayerTank){
                if(key == KeyEvent.VK_D)
                    tempObject.setVelX(0);
                if(key== KeyEvent.VK_A)
                    tempObject.setVelX(0);
            }
            if(tempObject.getID() == ObjectId.Gun){
                if(key == KeyEvent.VK_D){
                    tempObject.setVelX(0);
                    tempObject.setVelY(0);
                }
                if(key== KeyEvent.VK_A){
                    tempObject.setVelX(0);
                    tempObject.setVelY(0);
                }
                if(key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(0);
                    tempObject.setVelY(0);
                }
                if(key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(0);
                    tempObject.setVelY(0);
                }

            }
        }
    }
}
