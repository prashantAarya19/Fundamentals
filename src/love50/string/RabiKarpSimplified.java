package love50.string;

public class RabiKarpSimplified {
    private static int BASE = 10000000;
    private static int MAX_CHARS = 31;

    public static void main(String[] args) {
        String source = "mississippi";
        String target = "issi";
        int index = findPattern(source, target);
        System.out.println(index);
    }
    private static int findPattern(String source, String target) {
        if(source.equals("") || target.equals("")) return -1;

        int targetLen = target.length(), sourceLen = source.length();
        int power = 1;
        int targetHash = 0;

        for(int i = 0; i < targetLen; i++) {
            power = (power * MAX_CHARS) % BASE;
            targetHash = (targetHash * MAX_CHARS + target.charAt(i)) % BASE;
        }

        int sourceHash = 0;
        for(int i = 0; i < sourceLen; i++) {
            sourceHash = (sourceHash * MAX_CHARS + source.charAt(i)) % BASE;

            if(i < targetLen - 1) continue;
            if(i >= targetLen) sourceHash = (sourceHash - source.charAt(i - targetLen) * power) % BASE;
            if(sourceHash < 0) sourceHash += BASE;

            if(sourceHash == targetHash && source.substring(i - targetLen + 1, i + 1).equals(target))
                return i - targetLen + 1;

        }
        return -1;
    }
}
