public class MadLib {
    public static void main(String[] args) {
        String pre = "*** \"The ";
        String suf = ", and I've never recovered.\" ***";
        System.out.println(pre + args[0] + " professor " +
                           args[1] + " my " + args[2] + suf);
    }
}
