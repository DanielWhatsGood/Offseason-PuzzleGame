package org.bitbuckets.puzzle.subsystems;

import org.bitbuckets.puzzle.lib.Graphics;
import org.bitbuckets.puzzle.lib.Textures;

public class FloorSystem {

    public void periodic(Graphics graphics) {
        for (int x = 2; x <= 9; x++) {
            for (int y = 2; y <= 9; y++) {
                //System.out.println(x + ", " + y);
                graphics.drawTexture(Textures.FLOOR, x, y);
            }
        }
    }

}
