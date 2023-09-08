package org.example.generics.bound;

class HoldItem<T> {
    T item;
    HoldItem (T item) {
        this.item = item;
    }
    T getItem() {
        return this.item;
    }
}
class WithColor2<T extends HasColor> extends HoldItem<T> {
    WithColor2(T item) {
        super(item);
    }

    String color() {
        return item.getColor();
    }
}
class WithColorPosition2<T extends Position & HasColor> extends WithColor2<T> {
    WithColorPosition2(T item) {
        super(item);
    }
    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
}
class Solid2<T extends Position & HasColor & Weight> extends WithColorPosition2<T> {
    Solid2(T item) {
        super(item);
    }

    public int weight() {
        return 0;
    }
}
public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bound> solid = new Solid2<>(new Bound());
        System.out.println(solid.color());
        System.out.println(solid.getY());
        System.out.println(solid.weight());
    }
}
