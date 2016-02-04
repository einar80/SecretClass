
 // need to import ArrayList util since we will be storing prime numbers in ArrayList
import java.util.ArrayList;

/*
Class: SecretClass

You are given a function 'secret()' that accepts a single integer parameter and 
returns an integer. In your favorite programming language, write a command-line 
program that takes one command-line argument (a number) and determines if the 
secret() function is additive [secret(x+y) = secret(x) + secret(y)], for all 
combinations x and y, where x and y are all prime numbers less than the number 
passed via the command-line argument.

author: Einar Rivera

 */

public class SecretClass {
    
    /*
    secret:
        function will accept an integer and return it back
        n = single integer parameter passed to the function
        return number passed
    */
    public static int secret(int n) {
        return n;
    }
    
    /*
    isPrime:
        A prime number is a natural number greater than 1 that has no positive divisors other than 
		1 and itself. Function will loop between 2 and n-1 (number provided) to determine if any of
		those numbers have remainder of 0. If they do then we know the number is not a prime number.
        n = number passed as integer to verify if its a prime number
        return true when n is prime number
        return false when n is not a prime number
    */
    public static boolean isPrime(int n) {
        // prime number has to be greater than 1
        if (n < 2)
            return false;
        
        // prime number has no positive divisors other than 1 and itself
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        
		// number passed is a prime number
        return true;
    }
    
    /*
    allPrimes:
        creates an ArrayList of prime numbers from 3 to n. 
        n = number passed as integer we want to check prime numbers up to n-1
        returns ArrayList of prime numbers
    */
    public static ArrayList<Integer> allPrimes(int n) {
        
        ArrayList<Integer> primes = new ArrayList<>();
        
        // call isPrime function to check each number between 1 and n-1 to 
        // verify which numbers are prime
        for (int i = 1; i < n; i++) {
            if (isPrime(i))
				// add to ArrayList all numbers that return true as being prime
                primes.add(i);
        }

        return primes;
    }
    
    /*
	isAdditive: 
		runs the secret function passing all prime numbers from x and y
		returns true when left side of secret matches right side of secret so additive
		returns false when left side and right side do not match
	*/
    public static boolean isAdditive(int x, int y) {
        if (secret(x + y) == secret(x) + secret(y)) {
            return true;
        }
        
        return false;
    }
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		
		// default user input number to 0
		int userNum = 0;
			
		// since Java is expecting a String argument from the command line, we need to convert to
		// integer prior to running the program. If string is passed instead of integer, we will
		// catch and display error message.
		if (args.length > 0) {       
			try {
				// set userNum variable to argument passed via command line
				userNum = Integer.parseInt(args[0]); 
			} 
			catch (NumberFormatException e) {
				System.err.println("invalid input " + args[0] + " must be an integer.");
				System.exit(1);
			}
		}
		
		// the first prime number is 2. Since excersice is asking for primes < number passed 
		// we need to make sure user passes positive integer > 2.
		if (userNum <= 2) {
			System.out.println("Please enter a positive number >= 3");
		}
		else {
			// define variable used
			// allPrimes is called to get ArrayList of all prime numbers between 2 and n-1
			ArrayList<Integer> primeList = allPrimes(userNum);
			int x;
			int y;
			
			// find all combinations of x and y and see which are additives
			// x and y come from the list of prime numbers from 2 to n-1
			for (int i = 0; i < primeList.size(); i++) {
				x = primeList.get(i);
				
				for (int j = 0; j < primeList.size(); j++) {
					y = primeList.get(j);
					
					// if combination is additive x, y then display combination as additive
					if (isAdditive(x, y)) {
						System.out.println("X: " + x + " Y: " + y + " is additive");
					}
					// combination is not additive
					else {
						System.out.println("X: " + x + " Y: " + y + " is NOT additive");
					}
				}
			}
		}
    }
}
