package org.academiadecodigo.thunderstructs;

public final class UtilityMethods {

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

}
