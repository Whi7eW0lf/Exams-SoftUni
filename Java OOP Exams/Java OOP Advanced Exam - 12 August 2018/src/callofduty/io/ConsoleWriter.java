package callofduty.io;

import callofduty.interfaces.io.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void print(String output) {
        System.out.print(output);
    }

    @Override
    public void println(String output) {
        System.out.println(output);
    }
}
