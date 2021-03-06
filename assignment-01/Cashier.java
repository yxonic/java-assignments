public class Cashier {
    public static void main(String[] args) {
        int cost = Integer.parseInt(args[0]);
        int change = 100 - cost;
        
        // can't afford if cost is larger than 100
        if (change < 0) {
            System.out.println("A wrong input!");
        }
        
        // define the output name and their value
        String[] single_name = {"Quarter",  "Dime",  "Nickel",  "Penny"};
        String[] plurar_name = {"Quarters", "Dimes", "Nickels", "Pennies"};
        int[] value = {25, 10, 5, 1};
        // store the result
        int[] count = new int[4];
        
        // calculate the answer
        int x = change;
        for (int i = 0; i < 4; i++) {
            count[i] = x / value[i];
            x %= value[i];
        }

        // print the output
        System.out.println("Your change of " + change +
                           " cents is given as:");
        for (int i = 0; i < 4; i++) {
            if (count[i] == 1) {
                System.out.print(count[i]);
                System.out.println(" " + single_name[i]);
            } else {
                System.out.print(count[i]);
                System.out.println(" " + plurar_name[i]);
            }
        }
    }
}
