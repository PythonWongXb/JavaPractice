package org.example.generics.bound;
interface HasColor {
    String  getColor();
}
class Position {
    public int x;
    public int y;
    public int z;

}

interface Weight {
    int weight();
}

class WithColor<T extends HasColor> {
    T item;
    WithColor(T item) {
        this.item = item;
    }
    String  color() {
        return item.getColor();
    }
}
class WithColorPosition<T extends Position & HasColor> {
    T item;
    public WithColorPosition(T item) {
        this.item = item;
    }
    T getItem() { return this.item; }
    String color() { return item.getColor(); }
    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
}

class Solid <T extends Position & HasColor & Weight> {
    T item;
    public Solid(T item) {
        this.item = item;
    }
    T getItem() { return this.item; }
    String color() { return item.getColor(); }
    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
    int weight() { return item.weight(); }

}
class Bound extends Position implements HasColor, Weight {

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}
public class BasicBound {
    public static void main(String[] args) {
        Solid<Bound> solid = new Solid<>(new Bound());
        System.out.println(solid.color());
        System.out.println(solid.getY());
        System.out.println(solid.weight());
    }
}
