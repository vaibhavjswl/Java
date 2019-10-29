import java.lang.*;
import java.util.*;



class NOMATCHEXCEPTION extends Exception{

    public NOMATCHEXCEPTION(String description) {
        super(description) ;
    }

    NOMATCHEXCEPTION(){
        super("Error Occured") ;
    }
    
    @Override
    public String toString() {
        return super.getLocalizedMessage() ; 
    }
}

class Driver2{
    public static void main(String[] args) {
        
        String sample ; 

        Scanner sc = new Scanner(System.in) ;

        System.out.println("Enter a String : "); 
        sample = sc.nextLine() ; 

        try{

            if(!(sample.equals("India")))
                throw  (new NOMATCHEXCEPTION(" : String -> "+sample+" is not equal to India")); 
            else{
                System.out.println("Correct input");
            }
        }

        catch(NOMATCHEXCEPTION excp){
            System.out.println("Error on Line no :"+excp.getStackTrace()[0].getLineNumber() + excp);
        }

        sc.close();
    }
}