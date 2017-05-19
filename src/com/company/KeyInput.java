package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by akupp_000 on 5/5/2017.
 */
public class KeyInput extends KeyAdapter {
    Handler handler;
    float gunSpeed = 3.33f;
    float velocity = 5;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ObjectId.PlayerTank) { //Checks if the id is a player
                if (key == KeyEvent.VK_D)
                    tempObject.setVelX(velocity);
                    //System.out.println("Tank Pos: " + tempObject.getX() + "," + tempObject.getY());
                if (key == KeyEvent.VK_A)
                    tempObject.setVelX(-velocity);
                    //System.out.println("Tank Pos: " + tempObject.getX() + "," + tempObject.getY());


            }
            if (tempObject.getID() == ObjectId.Gun) {
                //initialize default gun
                Gun gun = (Gun) tempObject;
                if (key == KeyEvent.VK_D) {
                    if (gun.isPlayerTank()) {
                        gun.setVelX(3.33f);
                        //System.out.println("Gun Pos: " + tempObject.getX() + "," + tempObject.getY());
                    }
                }
                if (key == KeyEvent.VK_A) {
                    if (gun.isPlayerTank()) {
                        gun.setVelX(-3.33f);
                        //System.out.println("Gun Pos: " + tempObject.getX() + "," + tempObject.getY());
                    }

                }
                if (gun.getAngle() <= 90) {
                    if (key == KeyEvent.VK_LEFT) {
                        if (gun.isPlayerTank()){
                            gun.setAngle(gun.getAngle() + 10);
                    }
                    }
                }
                if (gun.getAngle() > 0) {
                    if (key == KeyEvent.VK_RIGHT) {
                        if (gun.isPlayerTank()){
                            gun.setAngle(gun.getAngle() - 10);
                    }
                    }
                }

                if (key == KeyEvent.VK_SPACE) {
                    if (gun.isPlayerTank()) {
                        handler.addObject(new Bullet(((float) ((gun.x) + gun.getRadius() * Math.cos(Math.toRadians(gun.getAngle())))), (float)
                                (gun.y - gun.getRadius() * Math.sin(Math.toRadians(gun.getAngle()))), ObjectId.Bullet, (float) (20 * Math.cos(Math.toRadians(gun.getAngle()))), gun, handler));
                    }
                }


            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ObjectId.PlayerTank) {
                if (key == KeyEvent.VK_D)
                    tempObject.setVelX(0);
                if (key == KeyEvent.VK_A)
                    tempObject.setVelX(0);
            }
            if (tempObject.getID() == ObjectId.Gun) {
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(0);
                    tempObject.setVelY(0);
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(0);
                    tempObject.setVelY(0);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(0);
                    tempObject.setVelY(0);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(0);
                    tempObject.setVelY(0);
                }

            }
        }
    }
}
