// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2 
   		System.out.println(minus(2,7));  // 2 - 7 
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5 
   		System.out.println(div(12,3));   // 12 / 3   
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36)); //6
		System.out.println(sqrt(263169)); // 513
   		System.out.println(sqrt(76123)); // 275
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// creating a loop to run x2 times and each time it will add 1 to x1

		if (x2<0)
		{for (int j = x2 ; j < 0; j++) {
			x1--;
			
			}
		}
		else {
			for (int j = 0; j < x2; j++) {
			x1++;
			
			}
		}
			return x1;
		}
		
	

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// creating a loop to run x2 times and each time it will minus 1 from x1
		if (x2<0) {
			for (int j = x2; j < 0; j++) {
			x1++;
			}
		}
		else {
			for (int j = 0; j < x2; j++) {
			x1--;
			
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// creating a loop to run x2-1 times and each time it will add num (origin x1) to x1 
		int num = 0;
		if ((x1>0 && x2>0)){
			num = x1;
			for (int j = 1; j < x2; j++) {
				num = plus(x1, num);
			}
		}
		if ((x2<0 && x1>0)){
			num = x2;
			for (int j = 1; j < x1; j++) {
				num = plus(x2, num);
			}
		}
		if (x1<0 && x2>0){
			num = x1;
			for (int j = 1; j < x2; j++) {
				num = plus(x1, num);
			}
		}
		if (x1<0 && x2<0){
			num = x1;
			for (int j = x2; j < 1; j++) {
				num = minus(num,x1);
			}
		}
		return num;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// each time will add the mult of x and x origin 
		if (x!=0){
			int num = x;
		for (int i = 1; i < n ; i++) {
			x = times(x, num);
			
		}
		}	
		else{
			x=0;
		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// the loop will end when x1 is lower than x2 
		int i = 0;
		int num = 0;
		int num1 = x1;
		int num2 = x2;
		if (x2<0){
			num2 = times(-1, x2);
		}
		if (x1<0){
			num1 = times(-1, x1);
		}
		num = num1;
		while (num>=num2){
			num = minus(num, num2);
				i++;
		}
		if (((x1<0)&&(x2>0))||(x1>0)&&(x2<0)){
			i = times(i, -1);
		}
			return i;
		}
	

	// Returns x1 % x2
	public static int mod(int x1, int x2){
		// decrease x2 from x1 until x1 is lower and thare is the rest
		int num = 0;
		int num1 = x1;
		int num2 = x2;
		if (x2<0){
			num2 = times(-1, x2);
		}
		if (x1<0){
			num1 = times(-1, x1);
		}
		num = num1;
		while (num>=num2){
			num = minus(num, num2);
		}
		
		return num;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// runing from 1 to x (num) until finding the num*num that would be X 
		int num = 0;
		while ((times(num, num)!=x)&&times(num, num)<=x){
			num++;
		}
		if (times(num,num)>x) {
			num--;
			
		}
		
			return num;
		}	
	
	}  	  
	