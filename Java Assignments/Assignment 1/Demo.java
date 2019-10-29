import java.util.Scanner;
import java.lang.Math ;

class Calc{

	void putOps()
	{
		System.out.println("1. Addition ");
		System.out.println("2. Subtraction ");
		System.out.println("3. Multiplication ");
		System.out.println("4. Division ");	
		System.out.println("5. Calculate num1 with power num2 ");	
		System.out.println("6. Calculate Square Root of Entered Numbers : ");	
		System.out.println("7. Find Average of Entered Numbers  ");	
		System.out.println("8. Calculate GCD oF both Numbers ");
		System.out.println("9. Find Variance Of Entered Numbers ");
	}

	double add(double a, double b){
		return (a+b);
	}


	double multi(double a, double b){
		return (a*b);
	}

	double div(double a, double b){
		return (a/b);
	}

	double subt(double a, double b){
		return (a-b);
	}

	double sqrt(double a)
	{
		return (Math.pow(a,0.5));
	}

	double power(double a, double b)
	{
		return (Math.pow(a,b));
	}

	double avg( double arr[] , double size)
	{
		double sum = 0 ;
		for (int i =0 ; i <size ; i++)
		{
			sum += arr[i] ;
		}

		sum = sum/size ;
		return sum ; 
	}

	double GCD(double a , double b )
	{
		if (b==0) return a ;

		else if (a==0) return b ;

		else if (a > b ) return GCD(b , a % b);

		else return GCD(a , b % a );

	}

	double variance(double arr[] , double size)
	{
		double mean = avg(arr , size) ;
		double variance = 0 ;

		for (int i = 0 ; i < size ; i++)
			{
				variance = variance + Math.pow((arr[i]-mean) , 2 ) ; 
			}

		variance = variance / (size - 1) ;
		return variance;	
	}
}



class Demo{

	public static void main(String[] args) {


	Scanner sc = new Scanner(System.in);

	Calc c  = new Calc();
	double num1 = 0, num2 = 0 ;
	char exit = 'n';


	do
	{
		System.out.println("Enter What Operation to Run");

		c.putOps();
		System.out.println("Choice : ");
		int choice = sc.nextInt() ;
		
		
		if (choice != 7 && choice != 9) 
			{ 
				System.out.println("Enter Two Numbers :");

				num1 = sc.nextDouble() ;
				num2 = sc.nextDouble();

				System.out.println("\nYour Result Is :"); 
			}

		switch(choice)
		{
			case 1 : System.out.println(c.add(num1 , num2));
					 break ;

			case 2 : System.out.println(c.subt(num1 , num2));
					 break;
			case 3 : System.out.println(c.multi(num1 , num2));
					 break;
			case 4 : 
					 if(num2 != 0) System.out.println(c.div(num1 , num2));

					 else System.out.println("Denominator is Zero . Division Not Possible");
					 break;
					
			case 5 : System.out.println(c.power(num1 , num2));
					 break ;

			case 6 : System.out.println("Square root of First no :" +c.sqrt(num1));
					 System.out.println("Square root of Second no :" +c.sqrt(num2));
					 break ;

			case 7 : double arr[] = new double[10] ;

					 int i = 0 ;

					 System.out.println("Enter Number :   (Enter End to terminate entering numbers )");

	 				 for(i = 0 ; sc.hasNextDouble() ; i++)
	 				 {
	 				 	arr[i] = sc.nextDouble() ;
	 				 }

					 double avg = c.avg(arr , i) ;
					 System.out.println("Average is :" + avg);
					 break ;

			case 8 : {
						System.out.println("GCD of "+ num1 +" & "+ num2 + " is :" + c.GCD(num1 , num2));
						break ;
					 }


			case 9 : {
						 double arr2[] = new double[10] ;
						 int k = 0;

						 System.out.println("Enter Number :   (Enter End to terminate entering numbers )");

		 				 for(k = 0 ; sc.hasNextDouble() ; k++)
		 				 {
		 				 	arr2[k] = sc.nextDouble() ;
		 				 }

						 double variance = c.variance(arr2 , k) ;
						 System.out.println("variance is :" + variance);
						 break ;
					 }

			default : System.out.println("Wrong Choice Entered ");
		}

	System.out.println("Do Another Operation (y or n)");

	exit = sc.next().charAt(0); 
	}while (exit!= 'n' && exit != 'n');

	}
}