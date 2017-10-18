package com.company;

import java.util.*;

class Group
{
    static Group D6 = new Group(
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

    Set<Element> elements = new HashSet<>();

    Group(Element... elements)
    {
        this.elements.addAll(Arrays.asList(elements));
    }

    Group(Set<Element> set)
    {
        this.elements = set;
    }

    boolean containsIdentity()
    {
        return elements.contains(new Element(0, 0));
    }

    boolean containsInverse()
    {
        for (Element a : elements)
            if ((a.y == 0 && !elements.contains(new Element((((6 - a.x) + 600) % 6), 0)))
                    || (a.y == 1 && !elements.contains(new Element(a.x, 1))))
                return false;
        return true;
    }

    boolean isClosed()
    {
        for (Element a : elements)
            for (Element b: elements)
                if (!elements.contains(a.multiply(b)))
                {
                    return false;
                }
        return true;
    }

    boolean isSubgroup()
    {
        return containsIdentity() && isClosed() && containsInverse();
    }

    boolean isNormal()
    {
        boolean isNormal = true;
        for (Element g : D6.elements)
        {
            Set<Element> leftCoset = new HashSet<>(), rightCoset = new HashSet<>();
            for (Element h : elements)
            {
                leftCoset.add(g.multiply(h));
                rightCoset.add(h.multiply(g));
            }
            isNormal &= leftCoset.equals(rightCoset);
        }
        return isNormal;
    }

    @Override
    public String toString()
    {
        String output = "{";
        for (Element element : elements)
            output += element + ", ";
        output = output.substring(0, output.length() - 2);
        output += "}";
        return output;
    }

    static <T> Set<Set<T>> powerSet(Set<T> originalSet)
    {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}