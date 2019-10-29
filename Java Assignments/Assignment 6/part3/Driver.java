

import java.util.*;
import java.lang.*;
import pkg_stack.IntStack;


// An implementation of IntStack that uses fixed storage.
class FixedStack implements IntStack{

    private int stck[];    
    private int tos;

    public FixedStack (int size) {
        stck = new int[size];
        tos = -1;
    }

    public void printStack(){
        for(int i=0;i<stck.length;i++)
            System.out.print(stck[i]+"\t");
    }


    public void push(int item) {
        if (tos == stck.length-1) 
            System.out.println("Stack is full.");

        else
            stck[++tos] =item;

    }

    public int pop (){
        if (tos < 0) {
            System.out.println("Stack underflow.");
            return 0;
        }

        else
            return stck[tos--];

    }
}


class DynStack implements IntStack {

    private int stck[];
    private int tos;
    
    DynStack (int size) { 
        stck= new int[size];
        tos = -1;
    }

    public void printStack(){
        for(int i=0;i<stck.length;i++)
            System.out.print(stck[i]+"\t");
    }
    
    public void push(int item){
        if (tos==stck.length-1){
            int temp[] = new int[stck.length*2]; // double size
            for (int i=0; i<stck.length; i++){ 
                temp[i] = stck[i];
            }
            stck = temp;
            stck[++tos]= item;
        }
        else
            stck[++tos]=item;
    }
    
    public int pop(){
        if(tos<0){
            System.out.println("Stack underflow.");
            return 0;
        }
        else
            return stck[tos--];
    }
} 

class Driver{
    public static void main(String args[]){
        FixedStack fs = new FixedStack(5);

        System.out.println("Fixed Stack :\n");
        fs.push(6);
        fs.push(9);
        fs.printStack();
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        fs.pop();

        System.out.println("\nGrowable Stack :\n");
        DynStack ds = new DynStack(2);
        ds.push(9);
        ds.push(6);
        ds.push(4);
        ds.push(5);
        ds.push(8);
        ds.printStack();

        
    }
}


