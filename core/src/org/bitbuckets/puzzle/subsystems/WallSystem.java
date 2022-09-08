package org.bitbuckets.puzzle.subsystems;

import com.badlogic.gdx.Gdx;
import org.bitbuckets.puzzle.lib.Graphics;
import org.bitbuckets.puzzle.lib.SubSystem;
import org.bitbuckets.puzzle.lib.Textures;

import java.util.ArrayList;

public class WallSystem
{

    ArrayList<int[]> wallCoords = addWalls();

    public ArrayList<int[]> addWalls()
    {
        ArrayList<int[]> list = new ArrayList<>();

        for (int x = 1; x <= 10; x++)
        {
            for (int y = 1; y <= 10; y++)
            {
                if (x == 1 || x == 10 || y == 1 || y == 10)
                {
                    list.add(new int[] {x,y});
                }

            }

        }

        return list;

    }

    public boolean isAWall(int x, int y) {
        for (int[] coord : wallCoords)
        {
            if (coord[0] == x && coord[1] == y)
            {
                return true;
            }
        }
        return false;
    }

    public void init() {

    }

    public void periodic(Graphics graphics) {

        for (int[] coords : wallCoords)
        {
            graphics.drawTexture(Textures.TARGET, coords[0], coords[1]);
        }

    }



}
