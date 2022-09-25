package org.bitbuckets.puzzle.subsystems;

import org.bitbuckets.puzzle.lib.Graphics;
import org.bitbuckets.puzzle.lib.Textures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TargetSystem {

    ArrayList<int[]> targetCoords;
    ArrayList<int[]> boxCoords;
    public TargetSystem(ArrayList<int[]> boxCoords)
    {
        this.boxCoords = boxCoords;
        targetCoords = addTargets();
    }


    public ArrayList<int[]> addTargets()
    {
        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < boxCoords.size(); i++)
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

    public boolean boxOnTarget(int index)
    {
        int[] checkTarget = targetCoords.get(index);
        for (int[] box : boxCoords)
        {
            if (checkTarget[0] == box[0] && checkTarget[1] == box[1])
            {
                return true;
            }
        }
        return false;
    }

    public boolean allBoxesOnTargets()
    {
        boolean[] boxOnTargets = new boolean[targetCoords.size()];
        for (int i = 0; i < targetCoords.size(); i++) {
            boxOnTargets[i] = boxOnTarget(i);
        }

        for (boolean bool : boxOnTargets)
        {
            if (bool == false)
            {
                return false;
            }
        }

        return true;
        /*
        Arrays.asList(targetCoords);
        Arrays.asList(boxCoords);
        CollectionUtils.isEqualCollection(targetCoords,boxCoords);

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
         */

    }

    boolean hasWonYet = false;

    public void periodic(Graphics graphics, ArrayList<int[]> newBoxCoords)
    {

        for (int[] coords : targetCoords)
        {
            boxCoords = newBoxCoords;
            graphics.drawTexture(Textures.TARGET, coords[0], coords[1]);
        }

        if (allBoxesOnTargets())
        {
            if (hasWonYet == false) {
                System.out.println("Congratulations on clearing the game!");
                hasWonYet = true;
                System.exit(0);
            }

        }

    }
}
