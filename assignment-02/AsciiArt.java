public class AsciiArt {
    static void drawTriangle(int n) {
        for (int i = 0; i < n + 1; i++) {
            System.out.print("|");

            for (int j = 0; j < n + 1 - i; j++) 
                System.out.print(" ");
            for (int j = 0; j < i; j++)
                System.out.print("/");

            System.out.print("*");

            for (int j = 0; j < i; j++)
                System.out.print("\\");
            for (int j = 0; j < n + 1 - i; j++) 
                System.out.print(" ");

           System.out.println("|");
        }
    }

    static void drawInvertedTriangle(int n) {
        for (int i = 0; i < n + 1; i++) {
            System.out.print("|");

            for (int j = 0; j < i + 1; j++) 
                System.out.print(" ");
            for (int j = 0; j < n - i; j++)
                System.out.print("\\");

            System.out.print("*");

            for (int j = 0; j < n - i; j++)
                System.out.print("/");
            for (int j = 0; j < i + 1; j++) 
                System.out.print(" ");

           System.out.println("|");
        }
    }
    
    static void drawBorder(int n) {
        System.out.print("+");
        for (int i = 0; i < n * 2 + 3; i++)
            System.out.print("-");
        System.out.println("+");
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        
        // range check
        if (n < 1 || n > 20) {
            System.out.println("The number must be between 1 and 20.");
            return;
        }
        
        // draw
        drawBorder(n);
        drawTriangle(n);
        drawInvertedTriangle(n);
        drawBorder(n);
        drawInvertedTriangle(n);
        drawTriangle(n);
        drawBorder(n);
    }
}
