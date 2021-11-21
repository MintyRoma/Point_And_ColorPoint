package com.unicorns.group;

public class ColorPoint extends Point{

    protected ColorTypes Color;

    public ColorPoint()
    {
        X = 0;
        Y = 0;
        Color = ColorTypes.WHITE;
    }

    public ColorPoint(int x, int y)
    {
        X = x;
        Y =y;
        Color = ColorTypes.WHITE;
    }

    public ColorPoint (int x,int y, ColorTypes color)
    {
        X = x;
        Y = y;
        Color = color;
    }

    public ColorPoint(ColorTypes color)
    {
        X = 0;
        Y = 0;
        Color = color;
    }

    public void ChangeColor(ColorTypes color)
    {
        Color = color;
    }

    public ColorTypes getColor()
    {
        return Color;
    }

    @Override
    public String ToString()
    {
        return "Цветная точка расположена на координатах: X = "+this.X+", Y = "+this.Y + "; и обладает цветом - "+this.Color.toString();
    }
}
