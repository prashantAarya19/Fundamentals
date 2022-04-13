package generics;

public class ReadAnything <T>{
    T t;

    public ReadAnything(T t) {
        this.t = t;
    }

    public void printAnythig() {
        System.out.println(t);
    }
}
