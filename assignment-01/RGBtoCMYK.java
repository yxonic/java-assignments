public class RGBtoCMYK {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int g = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        
        double w = (double) Math.max(r, Math.max(g, b)) / 255;
        double c, m, y, k;
        if (w == 0) {
            c = m = y = 0;
            k = 1;
        } else {
            c = 1 - r / w / 255;
            m = 1 - g / w / 255;
            y = 1 - b / w / 255;
            k = 1 - w;
        }
        
        System.out.println("cyan = " + c);
        System.out.println("magenta = " + m);
        System.out.println("yellow = " + y);
        System.out.println("black = " + k);
    }
}
