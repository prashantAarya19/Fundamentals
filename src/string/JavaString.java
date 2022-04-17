package string;

public class JavaString {
    public static void main(String[] args) {
        String s1 = "new";
        String s2 = "new";

        String s3 = new String("new");
        System.out.println(s2 == s1);
        System.out.println(s1 == s3.intern());
    }
}
