import java.lang.*;
import java.util.*;


class Factorial{

    int number ; 

    public Factorial(){
        this.number = 0 ;
    }

    public Factorial(int number){
        this.number = number ; 
    }

    public static int getFact(int number){
        int fact = 1 ; 
        for(int i = 2 ; i <= number ; i++){
            fact *= i ; 
        }
        return fact ; 
    }

}
class MyException extends Exception{
    public MyException(String description) {
        super(description) ;
    }
    MyException(){
        super("Error Occured") ;
    }
    @Override
    public String toString() {
        return super.getLocalizedMessage() ; 
    }
}

public class Driver 
{  
    public static void main(String args[]) 
    { 
        int i = 0 ; 
         
        for(String k : args){
            try{
                i = Integer.parseInt(k) ; 
                if ((i<0 || i >12))
                    throw new MyException("ERROR :Out of Bounds  -> Number : " + i + " -> Not in defined Range") ;
                else {
                    System.out.println("Factorial of " + i + " is " + Factorial.getFact(i));
                }
            }

            catch(NumberFormatException ee){
                System.out.println("ERROR ->Number Format Mismatch : please enter correct Input") ;
            }
            
            catch (MyException ex){ 
                System.out.println(ex); 
            } 

            
        }
          
    } 
} 