package org.bitbuckets.puzzle.subsystems;

import org.bitbuckets.puzzle.lib.Graphics;
import org.bitbuckets.puzzle.lib.Textures;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TargetSystem {

    ArrayList<int[]> targetCoords;
    ArrayList<int[]> boxCoords;
    int numTargets;
    public TargetSystem(ArrayList<int[]> boxCoords)
    {
        numTargets = boxCoords.size();
        this.boxCoords = boxCoords;
        targetCoords = addTargets();
    }


    public ArrayList<int[]> addTargets()
    {
        ArrayList<int[]> list = new ArrayList<int []>();
        for (int i = 0; i < numTargets; i++)
        {
            int x = (int) (Math.random() * (8) + 2);
            int y = (int) (Math.random() * (8) + 2);
            list.add(new int[] {x,y});
        }

        return list;
    }

    public boolean isATarget(int x, int y) {
        for (int[] coord : targetCoords)
        {
            if (coord[0] == x && coord[1] == y)
            {
                return true;
            }
        }
        return false;
    }

    public boolean allBoxesOnTargets()
    {
        for (int[] box : boxCoords)
        {
            for (int[] target : targetCoords)
            {
                if (box[0] != target[0] && box[1] != target[1])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void periodic(Graphics graphics, ArrayList<int[]> newBoxCoords)
    {

        //System.out.println(targetCoords.size());
        for (int[] coords : targetCoords)
        {
            boxCoords = newBoxCoords;
            graphics.drawTexture(Textures.TARGET, coords[0], coords[1]);
        }


    }
}
