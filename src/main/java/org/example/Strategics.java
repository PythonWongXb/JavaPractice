package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

interface Strategy {
    String approach(String msg);
}

class Soft implements Strategy {
    @Override
    public String approach (String msg) {
        return msg.toLowerCase() + "";
    }
}

class Twice {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}
public class Strategics {
    private String msg;
    private Strategy strategy;
    Strategics(String msg) {
        this.msg = msg;
        this.strategy = new Soft();
    }
    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase();
                    }
                },
                new Soft(),
                msg -> msg.substring(0, 5),
                Twice::twice,
        };
        Strategics strategics = new Strategics("Hello there");
        Arrays.stream(strategies).collect(Collectors.toList())
                .forEach(s -> {
                    strategics.changeStrategy(s);
                    strategics.communicate();
                });
    }

    private void communicate() {
        System.out.println(strategy.approach(this.msg));
    }

    private void changeStrategy(Strategy s) {
        this.strategy = s;
    }
}
