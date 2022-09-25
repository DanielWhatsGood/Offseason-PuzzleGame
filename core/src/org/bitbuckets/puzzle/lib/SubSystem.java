package org.bitbuckets.puzzle.lib;

public interface SubSystem {

    default void init() {}
    void periodic(Graphics graphics);

}
