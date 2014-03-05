class Date {
    int year, month, day;
    final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int y) {
        return (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0));
    }

    public Date(int y, int m, int d) {
        year = y; month = m; day = d;
    }

    public void shiftNDays(int n) {
        int y = year;
        int m = month - 1;
        int d = day;
        while (n > 0) {
            int remainder = days[m] - d;
            if (m == 1 && isLeapYear(y))
                remainder++;
            if (n <= remainder) {
                year = y; month = m + 1; day = d + n;
            }
            n -= remainder;
            d = 0; m++;
            if (m > 11) {
                m = 0; y++;
            }
        }
    }

    public void print() {
        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
    }
}
public class SpecDay {
    public static void main(String[] args) {
        int y, m, d;
        y = Integer.parseInt(args[0]);
        m = Integer.parseInt(args[1]);
        d = Integer.parseInt(args[2]);
        Date today = new Date(y, m, d);
        
        int n = Integer.parseInt(args[3]);
        // consider the birth date as the 0th birthday, then
        // we need to add 99 days to get the first birthday,
        // 199 the second, and so on
        today.shiftNDays(n * 100 - 1);
        today.print();
    }
}
