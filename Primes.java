/**
 * Two examples of methods for determining whether an int is prime. 
 * You will be asked questions about this code on the loops test.
 * 
 * @author Jon Cooper
 * @version November 18, 2013
 */
public class Primes 
{
    /**
     * Determine if an int is prime.
     * 
     * @param n     number to test
     * @return      true if number is prime, false otherwise
     */
    public static boolean isPrime1(int n)
    {
        if (n == 2)     return true;
        else if (n < 2) return false;

        for (int i=2; i<n; i++)
        {
            if (n % i == 0) return false;
        }
        
        return true;
    }
    
    /**
     * A more efficient way to determine if an int is prime.
     * 
     * @param n     number to test
     * @return      true if number is prime, false otherwise
     */
    public static boolean isPrime2(int n)
    {
        if (n == 2)        return true;
        else if (n < 2)    return false;
        else if (n % 2==0) return false;
        
        double limit = Math.sqrt(n);
        
        for (int i=3; i<=limit; i+=2)
        {
            if (n % i == 0) return false;
        }
        
        return true;
    }
        
    
    public static void main(String[] args)
    {
        // test isPrime1
        System.out.println( isPrime1(19) );
        System.out.println( isPrime1(9) );
        System.out.println( isPrime1(17) );
        
        // test isPrime2
        System.out.println( isPrime2(2) );
        System.out.println( isPrime2(9) );
        System.out.println( isPrime2(17) );
        
        
        // Study the isPrime1 and isPrime2 methods to answer the following:
        
        // 0. Study the method isPrime1. Describe the set of numbers that would be 
        //    tested as divisors when checking the value 19 for primality. Do the 
        //    same for 91 and 643.

        /**
         *  isPrime1(19) would test numbers on the interval [2, 18];
         *  isPrime1(91) would test numbers on the interval [2, 90];
         *  isPrime1(643) would test numbers on the interval [2, 642];
         */
        
        // 1. Study the method isPrime2. Describe the set of numbers that would be 
        //    tested as divisors when checking the value 19 for primality. Do the 
        //    same for 91 and 643.

        /**
         * isPrime2(19) would test the number 2, then odd numbers on the interval [3, 4];
         * isPrime2(91) would test the number 2, then odd numbers on the interval [3, 9];
         * isPrime2(643) would test the number 2, then odd numbers on the interval [3, 25];
         */
        
        // 2. The number 15,485,863 is the 1 millionth prime number. Suppose it is 
        //    tested in both isPrime1 and isPrime2 for primality. About how much
        //    faster will isPrime2 finish testing. Show how you determined your answer.
        
        /**
         * isPrime1(15485863) would test numbers on the interval [2, 15485862],
         *   for a total of 15485861 tests.
         * isPrime2(15485863) would test the number 2, then odd numbers on the interval [3, 3935],
         *   for a total of 1962 tests.
         * 
         * Therefore, assuming that each division operation takes the same amount of time, the 
         *   second method is 7892x faster.
         */
        
        // 3. In isPrime2, why is the limit calculated before the loop rather than
        //    writing the loop as for (int i=3; i<=Math.sqrt(n); i=i+2)?
        
        /**
         * To prevent the computer from recalculating this limit at each iteration of the loop.
         *   This value will never change, so it makes no sense to continually recompute it. 
         */
        
        // 4. The number 1 is not prime, however both prime function say that it is.
        //    Negative numbers cannot be prime either. Fix each function so that all
        //    ints less than 2 return false.

        /**
         * Fixed.
         */
        
        // Write blocks of code that use isPrime2 to solve the following problems:
        
        // 5. Generate a list of the first 50 prime numbers.

        int[] prime50 = new int[50];
        int primesFound = 0;
        int currentTest = 1;
        while(primesFound < 50) {
            if (isPrime2(currentTest)) {
                prime50[primesFound++] = currentTest;
            }
            currentTest++;
        }
        
        for(int i: prime50) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        
        // 6. What is the 100th prime? the 1000th? The 12847th?
    
        primesFound = 0;
        currentTest = 1;
        while(primesFound < 12848) {
            if (isPrime2(currentTest)) {
                primesFound++;
                if (primesFound == 100 || primesFound == 1000 || primesFound == 12847)
                    System.out.println(currentTest);
            }
            currentTest++;
        }

        // 7. In the set of integers from 2-1000000, how many are prime?
        
        primesFound = 0;

        for (int i=2; i<1000000; i++) {
            if (isPrime2(i)) primesFound++;
        }

        System.out.println(primesFound);

        // 8. What is the sum of the all prime numbers below 1000000?
        
        long primeSum = 0;
        for (int i=2; i<1000000; i++) {
            if (isPrime2(i)) primeSum += i;
        }

        System.out.println(primeSum);

        // 9. What is the sum of the first 1000 prime numbers?

        primesFound = 0;
        currentTest = 1;
        primeSum = 0;
        while(primesFound < 1000) {
            if (isPrime2(currentTest)) {
                primeSum += currentTest;
                primesFound++;
            }
            currentTest++;
        }
        System.out.println(primeSum);
        
    }
    
}
