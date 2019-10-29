import java.lang.*;
import java.util.*;

class RationalNo{

	private int numer , denom ;

	RationalNo(){
		this.numer = -1 ; 
		this.denom = -1 ;
	}

	RationalNo(int numer , int denom){
		this.numer = numer ;
		this.denom = denom ; 
	}

	public static RationalNo simplify(RationalNo rno){

		for(int i = 20 ; i >= 2 ;i--){

			if(rno.numer%i == 0 && rno.denom%i==0){
                rno.numer = rno.numer/i ;
                rno.denom = rno.denom/i ;
            }
		}
		return rno ; 
    }
    
    public static RationalNo addNo(RationalNo num1 ,RationalNo num2){

        RationalNo num3 = new RationalNo(1,1) ; 

        num3.numer = (num1.numer*num2.denom)+(num2.numer*num1.denom) ;
		num3.denom = (num1.denom)*(num2.denom) ; 
		
		

		return RationalNo.simplify(num3) ; 
	}
	
	public static RationalNo subtNo(RationalNo num1 ,RationalNo num2){

        RationalNo num3 = new RationalNo(1,1) ; 

        num3.numer = (num1.numer*num2.denom)-(num2.numer*num1.denom) ;
		num3.denom = (num1.denom)*(num2.denom) ; 
		
		num3 = RationalNo.simplify(num3) ;

		return num3 ; 
	}

	public static RationalNo mulNo(RationalNo num1 ,RationalNo num2){

        RationalNo num3 = new RationalNo(1,1) ; 

        num3.numer = (num1.numer) * (num2.numer);
		num3.denom = (num1.denom) * (num2.denom) ; 
		
		num3 = RationalNo.simplify(num3) ;

		return num3 ; 
	}
	
	public static RationalNo divno(RationalNo num1 ,RationalNo num2){

        RationalNo num3 = new RationalNo(1,1) ; 

        num3.numer = (num1.numer*num2.denom);
		num3.denom = (num1.denom)*(num2.numer) ; 
		
		num3 = RationalNo.simplify(num3) ;

		return num3 ; 
	}

	public String toString(){

		return (" " + this.numer + " / " + this.denom + " ") ;
	}

	public static float convertToFloat(RationalNo a){
		return ((float)a.numer/(float)a.denom); 
	}

	public static void compare(RationalNo a , RationalNo b ){

		if ((a.numer/a.denom) > (b.numer/b.denom)){
			System.out.println(a + " is greater than "+ b);
		}
		else if ((a.numer/a.denom) < (b.numer/b.denom)){
			System.out.println(a + " is smaller than "+ b);
		}

		else if ((a.numer/a.denom) == (b.numer/b.denom)){
			System.out.println(a + " is Equal to "+ b);
		}
	}	 
}

class Driver{

	public static void main(String[] args) {
		
		try {

			int i = Integer.parseInt(args[0])/Integer.parseInt(args[1]);
			int k = Integer.parseInt(args[2])/Integer.parseInt(args[3]);

			RationalNo rno1 = new RationalNo(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
			RationalNo rno2 = new RationalNo(Integer.parseInt(args[2]),Integer.parseInt(args[3]));
			System.out.println("addition :" + RationalNo.addNo(rno1 , rno2));

			System.out.println("subtraction :" + RationalNo.subtNo(rno1 , rno2));
			System.out.println("Multiplication :" + RationalNo.mulNo(rno1 , rno2));
			System.out.println("Division :" + RationalNo.divno(rno1 , rno2));
			System.out.println("Float point conversion of " +rno1+ " is : "+ RationalNo.convertToFloat(rno1));
			System.out.println("Float point conversion of " +rno2+ " is : "+ RationalNo.convertToFloat(rno2));
			RationalNo.compare(rno1, rno2);
		} 
		
		catch (ArithmeticException e) {
			System.out.println("Arithematic Expression error : Divide by zero \nPlease Enter proper inputs and try again") ;
		}
		catch (NumberFormatException e){
			System.out.println("Number Format Mismatch  error : Please enter Numbers only\nPlease Enter proper inputs and try again") ; 
		
		}
	}
}