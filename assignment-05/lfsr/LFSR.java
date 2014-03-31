/**********************************************************************
 *   File: LFSR.java        Assignment 6
 *
 *   Author: Zhong Shao     Email: zhong.shao@yale.edu
 *
 *   Class: LFSR
 *   -----------
 *      Dependencies: 
 *      Description:  LFSR template
 *
 **********************************************************************/

public class LFSR {
    // declare instance variables
    private int N;       // number of bits in the LFSR
    private int[] reg;   // reg[i] = ith bit of LFSR, reg[0] is rightmost bit
    private int tap;     // index of the tap bit

    // constructor to create LFSR with the given initial seed and tap
    public LFSR(String seed, int t) {
        // PUT YOUR CODE HERE
    }
  
    // simulate one step and return the new bit as 0 or 1
    public int step() {
        // PUT YOUR CODE HERE
    }
  
    // simulate k steps and return k-bit integer
    public int generate(int k) {
        // PUT YOUR CODE HERE
    }

    // return a string representation of the LFSR
    public String toString()  {
        // PUT YOUR CODE HERE
    }
   
  
    // test client
    public static void main(String[] args)  {
       // PUT YOUR TEST CODE HERE
    }

}
