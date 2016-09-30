package org.webonise.polygonapp;

import org.springframework.stereotype.Component;

@Component
public class Polygon {
    private int numberOfSides;
    private double lengthOfEachSide;

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public void setLengthOfEachSide(double lengthOfEachSide) {
        this.lengthOfEachSide = lengthOfEachSide;
    }

    public int calculateSumOfInteriorAngles() {
        return 180 * (numberOfSides - 2);
    }

    public double calculateParameter() {
        return (numberOfSides * lengthOfEachSide);
    }
}
