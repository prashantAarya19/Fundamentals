package generics;

public class ReadAnything <T>{
    T t;

    public ReadAnything(T t) {
        this.t = t;
    }

    public void printAnything() {
        System.out.println(t);
    }
}
