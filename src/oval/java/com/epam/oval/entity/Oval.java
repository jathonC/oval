package com.epam.oval.entity;

import java.util.Objects;

public class Oval {
    private Point firstpoint;
    private Point secondpoint;

    public Oval(Point firstpoint, Point secondpoint) {
        this.firstpoint = firstpoint;
        this.secondpoint = secondpoint;
    }

    public Point getFirstpoint() {
        return firstpoint;
    }

    public Point getSecondpoint() {
        return secondpoint;
    }

    public void setFirstpoint(Point firstpoint) {
        this.firstpoint = firstpoint;
    }

    public void setSecondpoint(Point secondpoint) {
        this.secondpoint = secondpoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        };
        Oval oval = (Oval) o;
        return Objects.equals(firstpoint, oval.firstpoint) && Objects.equals(secondpoint, oval.secondpoint);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + firstpoint.hashCode() + secondpoint.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Oval{" +
                "firstpoint=" + firstpoint +
                ", secondpoint=" + secondpoint +
                '}';
    }
}
