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
	private Camera cam;
	
    public PlayerTank(float x, float y, ObjectId id, Handler handler, Camera cam){
        super(x,y,id, handler, cam);
        
    }
    @Override
    public void tick(LinkedList<GameObject> object) {
        super.tick(object);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }
}
