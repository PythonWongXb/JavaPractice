package org.example.generics.decorator;

import java.util.Date;

class Basic {
    private String value = "Basic";

    public void set(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
class Decorator extends Basic {
    Basic basic;
    public Decorator(Basic basic) {
        this.basic = basic;
    }

    @Override
    public void set(String value) {
        basic.set(value);
    }

    @Override
    public String get() {
        return basic.get() + " -> Decorator -> ";
    }
}

class Timestamped extends Decorator {
    private final long timestamp;

    public Timestamped(Basic basic) {
        super(basic);
        this.timestamp = new Date().getTime();
    }

    public long getStamp() {
        return timestamp;
    }

    @Override
    public String get() {
        return super.get() + " Timestamped";
    }
}

class SerialNumbered extends Decorator {
    private static long count = 1;
    private final long serialNum = count++;

    public SerialNumbered(Basic basic) {
        super(basic);
    }

    public long getSerialNum() {
        return serialNum;
    }

    @Override
    public String get() {
        return super.get() + " SerialNumbered ";
    }
}

public class Decoration {
    public static void main(String[] args) {
        Timestamped timestamped = new Timestamped(new Basic());
        System.out.println(timestamped.get());
        Timestamped timestamped2 = new Timestamped(
                new SerialNumbered(new Basic())
        );
        System.out.println(timestamped2.get());
        SerialNumbered timestamped3 = new SerialNumbered(
                new Timestamped(new Basic())
        );
        System.out.println(timestamped3.get());
    }
}


