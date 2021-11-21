package com.unicorns.group;

public class Point {
    protected int X;
    protected int Y;

    public void SetLocation(int x, int y)
    {
        X = x;
        Y = y;
    }

    public double DistanceFromNull()
    {
        double c = Math.sqrt((X*X)+(Y*Y));
        return c;
    }
    public Point()
    {
        X = 0;
        Y = 0;
    }

    public Point(int x, int y)
    {
        X = x;
        Y = y;
    }

    public String ToString()
    {
        return "Точка расположена на кординатах: X = "+this.X+", Y = "+this.Y;
    }
}
