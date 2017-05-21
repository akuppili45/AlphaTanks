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
    private Camera cam;
    Game game;
    private BufferedImage level2 = null;
    public Handler(Camera cam){
    	this.cam = cam;
    	
    	BufferedImageLoader loader = new BufferedImageLoader();
        level2 = loader.loadImage("levela.png");
    }
    public void tick(){
        for(int i = 0; i < object.size();i++){
            tempObject = object.get(i);
            tempObject.tick(object);
        }
    }
    public void render(Graphics g){
        for(int i = 0; i < object.size();i++){
            tempObject = object.get(i);
            tempObject.render(g);
        }
    }
    public void loadImageLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        int xx;
        int yy ;
        PlayerTank pT;
        //EnemyTank eT = new EnemyTank(xx*32, yy*32,ObjectId.EnemyTank, handler);
        System.out.println("width, height" + w + "," + h);
        for( xx = 0; xx < h; xx++){
            for( yy = 0; yy < w; yy++){

                int pixel = image.getRGB(xx,yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if(red == 255 && green == 255 && blue == 255)
                    addObject(new Platform(xx * 32, yy * 32, ObjectId.Platform, game));
                if(red == 0 && green == 0 && blue == 255) {
                    pT = new PlayerTank(xx*32, yy*32, ObjectId.PlayerTank, this, cam);
                    addObject(pT);
                }
                if(red == 255 && green == 0 && blue == 0){
                    addObject(new EnemyTank(xx*32, yy*32,ObjectId.EnemyTank, this, cam));
                }
                if(red == 255 && green == 216 && blue == 0){
                    addObject(new Flag(xx*32, yy*32,ObjectId.Flag));
                }
            }
        }
    }
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    public void switchLevel(){
    	clearLevel();
    	cam.setX(0);
    	
    	switch(Game.LEVEL)
    	{
    	case 1:
    		loadImageLevel(level2);
    		break;
    	}
    	
    }
    private void clearLevel(){
        object.clear();
    }
}
