package org.bitbuckets.puzzle.subsystems;

import org.bitbuckets.puzzle.lib.Graphics;
import org.bitbuckets.puzzle.lib.Textures;

import java.util.*;

public class BoxSystem {

    ArrayList<int[]> boxCoords = addBoxes();
    private int numBoxes;

    public void init () {
        ArrayList<int[]> boxCoords = addBoxes();
    }


    // makes sure boxes do not share coordinates
    // && (!wallSystem.isAWall(element[0], element[1]))
    public ArrayList<int[]> checkBoxes(ArrayList<int[]> lst)
    {
        HashSet<int[]> temp = new HashSet<int[]>();
        temp.addAll(lst);
        ArrayList<int[]> newList = new ArrayList<>(temp);
        return newList;

    }

    public ArrayList<int[]> addBoxes()
    {
        ArrayList<int[]> list = new ArrayList<>();

        list.add(new int[]{5,5});

        list.add(new int[]{6,6});

        list.add(new int[]{7,7});
/*
        for (int numBoxes = 8; numBoxes > 0; numBoxes--) {
            // int a = Math.random()*(max-min+1)+min;
            // max = 8, min = 3
            int x = (int) (Math.random() * (5) + 3);
            int y = (int) (Math.random() * (5) + 3);
            list.add(new int[]{x, y});
        }

 */

        ArrayList<int[]> checkedList = new ArrayList<>();

        checkedList = checkBoxes(list);

        numBoxes = checkedList.size();
        return checkedList;

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
        deleteBox(oldX, oldY);
        int[] newBox = {x, y};
        addBox(newBox);
        graphics.drawTexture(Textures.BOX, x, y);

    }

    public void addBox(int[] box)
    {
        boxCoords.add(box);
    }

    public void deleteBox(int x, int y)
    {
        for (int i = 0; i < boxCoords.size(); i++)
        {
            int [] coords = boxCoords.get(i);
            int boxX = coords[0];
            int boxY = coords[1];
            if (boxX == x && boxY == y)
            {
                boxCoords.remove(i);
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
