package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Platform extends GameObject {

// Create a new Platform in game in the render method. Pass in this to the game parameter in the constructor.
// Pass in gunSpeed and y parameters for the gunSpeed location and the y location(use player position for that)
    Game game;
    public Platform(float x, float y, ObjectId id, Game game) {
        super(x, y, id);
        this.game = game;
    }
    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public String toString() {
        return "Platform";
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect((int)x, (int)y, 32,32 );
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32,32);
    }
}
