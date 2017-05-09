package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/7/2017.
 */
public abstract class GameObject
{
    protected float x,y;
    protected ObjectId id;
    protected boolean falling = true;
    protected boolean jumping = false;
    protected float velX = 0, velY = 0;
    public GameObject(float x, float y, ObjectId id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public float getVelX(){
        return velX;
    }
    public float getVelY(){
        return velY;
    }
    public void setVelX(float x){
        this.velX = x;
    }
    public void setVelY(float y){
        this.velY = y;
    }
    public ObjectId getID(){
        return id;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public void setFalling(boolean falling) {

        this.falling = falling;
    }

    public boolean isJumping() {

        return jumping;
    }

    public boolean isFalling() {

        return falling;
    }
    public abstract String toString();

}
