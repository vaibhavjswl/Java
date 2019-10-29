import java.util.*;
import java.io.*;

class fact{

	public static void main(String[] args) throws IOException{
		Scanner sc= new Scanner(System.in);
		fact obj = new fact();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("choose");
		System.out.println("1.command line args\n2.scanner\n3.buffered reader\n4.console\n");
		int ch= sc.nextInt();
		
		switch(ch){
			case 1:
				System.out.println("Factorial Is : " + obj.factorial(Integer.parseInt(args[0])));
				break;
			case 2:
				System.out.println("Enter an Integer");
				int number = sc.nextInt();
				System.out.println("Factorial Is : " + obj.factorial(number));
				break;
			case 3:
				System.out.println("Enter an Integer");
				int number1 = Integer.parseInt(br.readLine());
				System.out.println("Factorial Is : " + obj.factorial(number1));
				break;
			case 4:
				System.out.println("Enter an Integer");
				int number2 = Integer.parseInt(System.console().readLine());
				System.out.println("Factorial Is : " + obj.factorial(number2));
				break;		
		}
	}
	int factorial(int number){

		if(number==1 ||number==0) return 1;
		return number*factorial(number-1);
	}
}