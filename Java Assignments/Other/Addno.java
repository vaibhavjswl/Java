
import java.util.Scanner ;


class Addno {
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in) ;

		int a = sc.nextInt();
			
		int b = sc.nextInt();

		sc.nextLine();

		Addno obj = new Addno();

		int c = obj.sum(a , b);

		System.out.println("Sum is  :" + c);

		String name = sc.nextLine();

		System.out.println("You name is :"+name);
	}

	private static int sum(int num1 , int num2)
	{
		return (num1 + num2);
	}
}