package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@code Controller} implementation to print on standard output
 */
public final class SimpleController implements Controller {

    private final List<String> printed = new ArrayList<>();
    private String next = null;

    @Override
    public void setNextString(String str) {
        this.next = str;
    }

    @Override
    public String getNextString() {
        return this.next;
    }

    @Override
    public List<String> getPrintHistory() {
        return this.printed;
    }

    @Override
    public void printString() throws IllegalStateException {
        if (this.next == null) {
            throw new IllegalStateException("No string has been set");
        }
        this.printed.add(this.next);
        System.out.println(this.next);
    }

}
