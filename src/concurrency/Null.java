package concurrency;

public class Null {

    public static void print() {
        System.out.println("123");
    }

    public static void main(String[] args) {
        ((Null)null).print();
    }
}
