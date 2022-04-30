package clone;

public class ShallowClone implements Cloneable{
    int a;

    public ShallowClone(int a) {
        this.a = a;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws Exception{
        ShallowClone a = new ShallowClone(10);
        ShallowClone b = (ShallowClone) a.clone();
        b.a = 20;
        System.out.println(a.a);
        System.out.println(b.a);
        System.out.println(a.a);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
