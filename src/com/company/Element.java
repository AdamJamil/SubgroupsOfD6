package com.company;

public class Element
{
    int x = 0, y = 0;

    Element multiply(Element input)
    {
        if (y == 0)
        {
            return new Element(x + input.x, input.y);
        }
        else
        {
            return new Element(x - input.x, y + input.y);
        }
    }

    Element(int a, int b)
    {
        x = (a + 600) % 6;
        y = (b + 100) % 2;
    }

    @Override
    public boolean equals(Object obj)
    {
        return this.toString().equals(obj.toString());
    }

    @Override
    public int hashCode()
    {
        return 10 * x + y;
    }

    @Override
    public String toString()
    {
        if (x == 0)
            if (y == 0)
                return "1";
            else
                return "y";
        else if (y == 0)
        {
            if (x == 1)
                return "x";
            return "x^" + x;
        }
        else
        {
            if (x == 1)
                return "xy";
            return "x^" + x + "y";
        }
    }
}
