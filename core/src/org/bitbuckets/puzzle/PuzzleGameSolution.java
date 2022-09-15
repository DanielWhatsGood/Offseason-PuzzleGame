package org.bitbuckets.puzzle;

import org.bitbuckets.puzzle.lib.Graphics;
import org.bitbuckets.puzzle.lib.SubSystem;
import org.bitbuckets.puzzle.lib.Textures;
import org.bitbuckets.puzzle.subsystems.*;

/**
 * This is where you write the code that will make the game function!
 * The starting (this class) code are structured similarly to the robot code you'll see in the real world.
 *
 * Open {@link org.bitbuckets.puzzle.lib} to see the pre-written classes: {@link Graphics}, {@link System}, and {@link Textures}
 */
public class PuzzleGameSolution implements SubSystem {

    /**
     * This is your very first subsystem! We use the subsystem pattern in robot code as well. Press Ctrl + B while
     * highlighting it to open it, or double click it in the file browser
     */

    FloorSystem floorSystem = new FloorSystem();

    WallSystem wallSystem = new WallSystem();

    BoxSystem boxSystem = new BoxSystem();

    TargetSystem targetSystem = new TargetSystem(boxSystem.getBoxCoords());

    PlayerSystem playerSystem = new PlayerSystem(wallSystem, boxSystem);




    @Override
    public void init() {
        //This is the initialization, or "init" function and is only ran once
        //Use this to execute code that is used for startup

        //when you add new subsystems, make sure to add them here, in the periodic loop, and call their init function.

        playerSystem.init();




    }

    @Override
    public void periodic(Graphics graphics) {
        //The code you put here is run every game loop
        //For LibGDX this can vary
        //If you were writing a robot this code would be run every 20 milliseconds!
        //You can do stuff with the graphics in your periodic loop!
        //hover over the word Graphics to learn more about how to draw objects on the screen

        floorSystem.periodic(graphics);

        wallSystem.periodic(graphics);

        targetSystem.periodic(graphics, boxSystem.getBoxCoords());

        boxSystem.periodic(graphics);

        playerSystem.periodic(graphics);



    }

}
