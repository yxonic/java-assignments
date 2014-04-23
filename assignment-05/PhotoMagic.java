import java.awt.Color;

public class PhotoMagic {
    public static Picture transform(Picture picture, LFSR lfsr) {
        int h = picture.height(), w = picture.width();
        Picture result = new Picture(w, h);
        for (int i = 0; i < w; i++)
            for (int j = 0; j < h; j++) {
                Color c = picture.get(i, j);
                int r = c.getRed(), g = c.getGreen(), b = c.getBlue();
                int x = lfsr.generate(8);
                r = x ^ r;
                x = lfsr.generate(8);
                g = x ^ g;
                x = lfsr.generate(8);
                b = x ^ b;
                result.set(i, j, new Color(r, g, b));
            }
        return result;
    }

    public static void main(String[] args) {
        String file_name = args[0];
        Picture src = new Picture(file_name);
        String seed = args[1];
        int tap = Integer.parseInt(args[2]);
        LFSR lfsr = new LFSR(seed, tap);
        Picture t = transform(src, lfsr);
        t.show();
        t.save("X-" + file_name);
    }
}
