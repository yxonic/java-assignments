public class LFSR {
    private int N;
    private byte[] value;
    private int tap;

    public LFSR(String seed, int tap) {
        value = seed.getBytes();
        N = seed.length;
        this.tap = tap;
    }

    public int step() {
        int tap, bit;
        if (value[0] == '0') bit = 0;
        else bit = 1;
        if (value[N - this.tap - 1] == '0') tap = 0;
        else tap = 1;
        bit ^= tap;
        byte c;
        if (bit == 0) c = '0';
        else c = '1';
        for (int i = 0; i < N - 1; ++i)
            value[i] = value[i + 1];
        value[value.length - 1] = c;
        return bit;
    }

    public int generate(int k) {
        int result = 0;
        for (int i = 0; i < k; ++i) {
            int b = step();
            result = result * 2 + b;
        }
        return result;
    }

    public String toString() {
        String s = new String(value);
        return s;
    }

    public static void main(String[] args) {
        LFSR lfsr = new LFSR("01101000010", 8);
        for (int i = 0; i < 10; i++) {
            int bit = lfsr.step();
            System.out.println(lfsr + " " + bit);
        }
        System.out.println();
        lfsr = new LFSR("01101000010", 8);
        for (int i = 0; i < 10; i++) {
            int r = lfsr.generate(5);
            System.out.println(lfsr + " " + r);
        }
    }
}
