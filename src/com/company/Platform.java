package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Platform extends GameObject {

//Create a new Platform in game in the render method. Pass in this to the game parameter in the constructor.
<<<<<<< HEAD
// Pass in speed and y parameters for the speed location and the y location(use player position for that)
    public Platform(float x, float y, ObjectId id) {
=======
// Pass in gunSpeed and y parameters for the gunSpeed location and the y location(use player position for that)
    Game game;
    public Platform(float x, float y, ObjectId id, Game game) {
>>>>>>> refs/remotes/origin/master
        super(x, y, id);
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
        g.fillRect((int)x, (int)y, 32, 32 );
    }
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
