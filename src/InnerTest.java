public class InnerTest {
    private static class MyInner {
        public int val;
        public MyInner(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        InnerTest.MyInner myInner = new InnerTest.MyInner(10);
        System.out.println(myInner.val);
    }
}
