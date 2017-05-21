package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

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
                    level = loader.loadImage("/level2.png");
                    break;
                case 2:
                    level = loader.loadImage("/secondlevel.png");
                    break;
            }

    }

}
