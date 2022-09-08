package org.bitbuckets.puzzle.subsystems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.bitbuckets.puzzle.lib.Graphics;
import org.bitbuckets.puzzle.lib.SubSystem;
import org.bitbuckets.puzzle.lib.Textures;

//TODO very first subsystem
public class PlayerSystem {

    WallSystem wallSystem;

    BoxSystem boxSystem;

    TargetSystem targetSystem;

    public PlayerSystem(WallSystem wall, BoxSystem boxes) {
        this.wallSystem = wall;
        this.boxSystem = boxes;
    }

    int[] currentPos = new int[]{8,8};

    public void init() {

        System.out.println("Test");

    }

    public int[] transform() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            return new int[] {0, -1};
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            return new int[] {0, 1};
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            return new int[] {1, 0};
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            return new int[] {-1, 0};
        }

        return new int[]{0, 0};
    }


    /*
    public void moveFunction(Graphics graphics)
    {
        int[] transform = transform();
        int newX = currentPos[0] + transform[0];
        int newY = currentPos[1] + transform[1];
        if (!wallSystem.isAWall(newX, newY))
        {
            if (boxSystem.isABox(newX, newY) && canMoveBox(newX + transform[0], newY + transform[1]))
            {
                boxSystem.moveBox(graphics, newX, newY, newX + transform[0], newY + transform[1]);
            }
            currentPos[0] = newX;
            currentPos[1] = newY;

        }

    }

     */

    public boolean canMoveBox(int x, int y)
    {

        return !wallSystem.isAWall(x, y) && !boxSystem.isABox(x, y);
    }



    public void periodic(Graphics graphics) {

        int[] transform = transform();
        int newX = currentPos[0] + transform[0];
        int newY = currentPos[1] + transform[1];
        if (!wallSystem.isAWall(newX, newY))
        {
            if (boxSystem.isABox(newX, newY) && canMoveBox(newX + transform[0], newY + transform[1]))
            {
                boxSystem.moveBox(graphics, newX, newY, newX + transform[0], newY + transform[1]);
            }
            currentPos[0] = newX;
            currentPos[1] = newY;

        }

        graphics.drawTexture(Textures.PLAYER, currentPos[0], currentPos[1]);

    }

}
