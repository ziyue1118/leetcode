public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int divider = 1 << 31;
        for (int i = divider; divider != 0; divider = divider >>> 1) {
            if ((n & divider) == divider) {
                count++;
            }
        }
        return count;
    }

    //2147483648 (10000000000000000000000000000000)
    // 7 (00000000000000000000000000000111)

    public static void main(String[] args) {
        NumberOf1Bits no1b = new NumberOf1Bits();
        System.out.println(no1b.hammingWeight(7));
    }
}