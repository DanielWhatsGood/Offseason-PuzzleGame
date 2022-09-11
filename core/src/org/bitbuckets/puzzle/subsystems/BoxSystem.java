package org.bitbuckets.puzzle.subsystems;

import org.bitbuckets.puzzle.lib.Graphics;
import org.bitbuckets.puzzle.lib.Textures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BoxSystem {

    ArrayList<int[]> boxCoords = addBoxes();
    private int numBoxes;

    /*
    WallSystem wallSystem;

    public BoxSystem(WallSystem wall) {
        this.wallSystem = wall;
    }

    */
    public void init () {
        ArrayList<int[]> boxCoords = addBoxes();
    }


    // makes sure boxes do not share coordinates and does not spawn on wall
    // && (!wallSystem.isAWall(element[0], element[1]))
    public ArrayList<int[]> checkBoxes(ArrayList<int[]> list)
    {
        ArrayList<int[]> newList = new ArrayList<int[]>();
        for (int[] element : list) {

            if (!newList.contains(element)) {

                newList.add(element);
            }
        }
        return newList;

    }

    public ArrayList<int[]> addBoxes()
    {
        ArrayList<int[]> list = new ArrayList<>();


        for (int numBoxes = 8; numBoxes > 0; numBoxes--) {
            // int a = Math.random()*(max-min+1)+min;
            // max = 9, min = 2
            int x = (int) (Math.random() * (8) + 2);
            int y = (int) (Math.random() * (8) + 2);
            list.add(new int[]{x, y});
        }

        list = checkBoxes(list);

        numBoxes = list.size();
        return list;

    }

    public boolean isABox(int x, int y) {
        for (int[] coord : boxCoords)
        {
            if (coord[0] == x && coord[1] == y)
            {
                return true;
            }
        }
        return false;
    }

    public void moveBox(Graphics graphics, int oldX, int oldY, int x, int y)
    {
        System.out.println("test 2");
        deleteBox(graphics, oldX, oldY);

    }

    public void deleteBox(Graphics graphics, int x, int y)
    {
        for (int i = 0; i < boxCoords.size(); i++)
        {
            int [] coords = boxCoords.get(0);
            int boxX = coords[0];
            int boxY = coords[1];
            if (boxX == x && boxY == y)
            {
                boxCoords.remove(i);
                //graphics.drawTexture(Textures.FLOOR, x, y);
            }
        }
    }

    public int getNumBoxes()
    {
        return numBoxes;
    }

    public ArrayList<int[]> getBoxCoords()
    {
        return boxCoords;
    }

    public void periodic(Graphics graphics) {

        for (int[] coords : boxCoords)
        {
            graphics.drawTexture(Textures.BOX, coords[0], coords[1]);
        }

    }

}
