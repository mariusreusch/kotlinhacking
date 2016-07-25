package ch.mare.java.nullchecks;

public class LengthCalculator {

    public int strLen(String s) {
        return s.length();
    }

    public static void main(String[] args) {
        new LengthCalculator().strLen(null);
    }
}


