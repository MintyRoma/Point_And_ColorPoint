package com.unicorns.group;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Сколько точек сгенерировать?");
        int amount = in.nextInt();
        if (amount < 1) return;

        ArrayList<Point> massive = new ArrayList<Point>();
        for (int i=0;i<amount;i++)
        {
            boolean isColor = false;
            Random rnd = new Random();
            isColor = rnd.nextBoolean();
            if (isColor)
            {
                int x = rnd.nextInt(2000)-1000;
                int y = rnd.nextInt(2000)-1000;
                int color = rnd.nextInt(12);
                massive.add(new ColorPoint(x,y,ColorTypes.values()[color]));
            }
            else
            {
                int x = rnd.nextInt(2000)-1000;
                int y = rnd.nextInt(2000)-1000;
                massive.add(new Point(x,y));
            }
        }

        System.out.println("Точки успешно сгенерированы!");
        for(Point p : massive)
        {
            System.out.println(p.ToString());
        }


        System.out.println("\n\n==========================================");
        int colored = 0;
        for(Point p : massive)
        {
            if (p instanceof ColorPoint) colored++;
        }
        int uncolored = massive.size()-colored;
        System.out.println("Количество цветных точек: "+colored);
        System.out.println("Количество бесцветных точек: "+uncolored);
        System.out.println("==========================================");

        System.out.println("\n\n==========================================");
        double distance = 30000;
        Point near = new Point();
        for (Point p:massive)
        {
            if (p.DistanceFromNull()<distance)
            {
                near = p;
                distance = p.DistanceFromNull();
            }
        }
        System.out.println("Самая бляжняя точка:");
        System.out.println(near.ToString());
        System.out.println("Дистанция до начала координат: " + near.DistanceFromNull());
        System.out.println("==========================================");

        System.out.print("\n\nУкажите максимальную дистанцию до начала коррдинат: ");
        double maxdistance =  in.nextDouble();

        for (Point p:massive)
        {
            boolean Xchange = true;
            while (p.DistanceFromNull()>maxdistance)
            {
                if (Xchange)
                {
                    if (p.X >0)
                    {
                        p.SetLocation(p.X-10,p.Y);
                    }
                    if (p.X <0)
                    {
                        p.SetLocation(p.X+10,p.Y);
                    }
                    Xchange = false;
                }
                else
                {
                    if (p.Y >0)
                    {
                        p.SetLocation(p.X,p.Y-10);
                    }
                    if (p.Y <0)
                    {
                        p.SetLocation(p.X,p.Y+10);
                    }
                    Xchange = true;
                }
            }
            System.out.println("\nПозиция точки сменилась! \n"+p.ToString());
            System.out.println("Ее дистанция до центра координат: "+p.DistanceFromNull());
        }
    }
}
