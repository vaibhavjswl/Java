
class SwapExample {

	public static void main(String[] args) {
		
		int num1 = 15 , num2 = 20;

		System.out.println("Before swap");
		System.out.println("Value of num1" + num1);
		System.out.println("Value of num2" + num2);
		swap(num1 , num2);


	}

	private static void swap(int num1 , int num2)
	{
		int temp1 = num1;
		num1 = num2;
		num2 = temp1;

		System.out.println("after swap");
		System.out.println("Value of num1" + num1);
		System.out.println("Value of num2" + num2);

	}
}