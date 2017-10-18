package com.company;

import java.util.Set;

public class Main
{
    Group D6 = new Group(
            new Element(0, 0),
            new Element(1, 0),
            new Element(2, 0),
            new Element(3, 0),
            new Element(4, 0),
            new Element(5, 0),
            new Element(0, 1),
            new Element(1, 1),
            new Element(2, 1),
            new Element(3, 1),
            new Element(4, 1),
            new Element(5, 1)
    );

    Main()
    {
        for (Set set : Group.powerSet(D6.elements))
        {
            Group group = new Group(set);
            if (group.isSubgroup())
                System.out.println(group);
        }
    }

    public static void main(String[] args)
    {
        new Main();
    }
}
