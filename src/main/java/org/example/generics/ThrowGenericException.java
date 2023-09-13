package org.example.generics;

import java.util.ArrayList;
import java.util.List;

interface Process<T, E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T> extends ArrayList<Process<T, Failure1>> {
    List<T> processAll () throws Failure1 {
        List<T> resultCollector = new ArrayList<>();
        for (Process<T, Failure1> processor: this ) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception {
    Failure1(String message) {
        super(message);
    }
}
class Processor1 implements Process<String, Failure1> {
    static int count = 3;
    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        if (count-- > 1) {
            resultCollector.add("Help");
        } else {
            resultCollector.add("Ho");
        }
        if (count < 0) {
            throw new Failure1("demo");
        }
    }
}
public class ThrowGenericException<T> {
    public static void main(String[] args) {
        ProcessRunner<String> runner = new ProcessRunner<>();
        runner.add(new Processor1());
        runner.add(new Processor1());
        runner.add(new Processor1());
        try {
            System.out.println(runner.processAll());
        } catch (Failure1 e) {
            System.out.println(e.toString());
        }
    }
}
