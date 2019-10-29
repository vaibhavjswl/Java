//Vector assignment 3 

import java.util.*; 
import java.lang.*; 
import java.io.*; 
  


class Employee{

    long id ; 
    String name ; 
    String gender ;
    String designation ; 
    String company ; 
    double salary ; 

    static int noOfEmps ; 

    Employee(long id , String name, String gender , String designation , String company , double salary){
        this.id = id ;
        this.name = name ;
        this.gender = gender ; 
        this.designation = designation ; 
        this.company = company ; 
        this.salary = salary ; 

    }

    Employee(){
        this(-1 , "" , "" , "" , "" , -1) ; 
    }


    public String toString(){
        System.out.println("*****************************************************************************************************");
        System.out.println("Id : " + id);
        System.out.println("Name : " + name);
        System.out.println("Gender : " + gender);
        System.out.println("Designation : " + designation);
        System.out.println("Company : " + company);
        System.out.println("Salary Per Month : " + salary);
        System.out.println("*****************************************************************************************************");

        return " " ; 
    }

    public static void printAll(Vector<Employee> emp){

        for(int i = 0 ; i < emp.size() ; i++){
            System.out.println("Employee "+ (i+1) );
            System.out.println(emp.get(i).toString());
        }
    }

    public static void compareBySalary(Employee e1 , Employee e2){

        double diff  = e1.salary - e2.salary ; 

        if (diff < 0 ){
            System.out.println(e2.name + " is paid " + Math.abs(diff) + "% more salary than "+ e1.name); 
        }

        else if (diff > 0 ){ 
            System.out.println(e1.name + " is paid " + diff + "% more Salary than "+ e2.name); 
        }
        else if (diff == 0 ){
            System.out.println(e2.name + " is paid the same amount as "+ e1.name); 
        }

    }

    public static int searchById(Vector<Employee> emp , long id){

        boolean found = false ; 
        int indx = 0 ; 

        for(Employee temp : emp){

            if (temp.id == id ){
                found = true ; 
                break ;
            }
            indx++ ; 
        }

        if(found){
            return indx ; 
        }

        else return -1 ; 
    }

    public static int searchByName(Vector<Employee> emp , String name){

        boolean found = false ; 
        int indx = 0 ; 

        for(Employee temp : emp){

            if (temp.name.compareTo(name) == 0){
                found = true ; 
                break ;
            }
            indx++ ; 
        }

        if(found){
            return indx ; 
        }

        else return -1 ; 
    }

    public String getName(){
        return this.name ; 
    }

    public static void empIncrement(){
        Employee.noOfEmps++ ; 
    }

    public static void empDecrement(){
        Employee.noOfEmps-- ; 
    }

    public static int getNumEmps(){
        return Employee.noOfEmps ; 
    }
}

class SortByName implements Comparator<Employee>{
    public int compare(Employee a , Employee b){
        return a.getName().compareTo(b.getName()) ; 
    }
}

class Driver2{

    public static void main(String[] args) {

        Vector <Employee> emp = new Vector<Employee>() ;

        Scanner ip = new Scanner(System.in);
        boolean exit = false ; 
    
    do{
        System.out.println("\n1.Add Employee") ;
        System.out.println("2.Print all Employee") ;
        System.out.println("3.Compare two employee by Salary") ;
        System.out.println("4.Search Employee by ID") ;
        System.out.println("5.Search Employee by Name") ;
        System.out.println("6.Sort Employee by Name") ;
        System.out.println("7.Delete Employee ") ;
        System.out.println("8.No of Employees ") ;
        System.out.println("9.Exit") ;

        System.out.println("\nYour Choice :") ;
        
        int choice = ip.nextInt() ; 
        
        switch(choice){

            case 1:
           /* {
                char another = 'y' ;

                while(another == 'y'){
                    
                    System.out.println("Enter the Employee id");
                    long id = ip.nextLong() ; 


                    System.out.println("Enter the Employee name : ");
                    ip.nextLine() ;
                    String name = ip.nextLine() ; 


                    System.out.println("Enter gender : \n1.Male\n2.Female\n3.Custom");

                    int genChoice = ip.nextInt() ; 

                    String gender ; 

                    if(genChoice == 1){
                        gender = "Male" ; 
                    }

                    else if(genChoice == 2){
                        gender = "Female" ; 
                    }
                    else{
                        System.out.println("Enter Custom Gender :");
                        ip.nextLine() ; 
                        gender = ip.nextLine() ;
                    }


                    System.out.println("Enter Designation : ");
                    if(!(genChoice == 3))
                        ip.nextLine() ; 

                    String designation = ip.nextLine() ;


                    System.out.println("Enter Company Name: ");
                    String company = ip.nextLine() ;

                    System.out.println("Enter Salary Per Month: ");
                    double salary = ip.nextDouble() ;

                    Employee temp = new Employee(id , name , gender , designation , company , salary);
                    emp.add(temp) ;

                    

                    System.out.println("Add Another : y/n");
                    another = ip.next().charAt(0) ;
                }*/

                Employee temp1 = new Employee(456 , "vaibhav jaiwal" , "boeing 747" , "nigga" , "testco1" , 123456);
                emp.add(temp1);
                Employee.empIncrement() ; 

                Employee temp2 = new Employee(654 , "akhil singh"   , "male"  , "test1" , "testco2" , 321654);
                emp.add(temp2);

                Employee.empIncrement() ; 

                Employee temp3 = new Employee(465 , "aarohi prasad" , "Female"  , "test2" , "testco3" , 123654);
                emp.add(temp3);
                Employee.empIncrement() ; 

                Employee temp4 = new Employee(546 , "Urvi rawat"    , "Female" , "test3" , "testco4" , 412563);
                emp.add(temp4);
                Employee.empIncrement() ; 

                Employee temp5 = new Employee(564 , "Mohammed Noor" , "male"  , "momo"  , "testco5" , 256314);
                emp.add(temp5);
                Employee.empIncrement() ; 

                break ; 
            /*}*/

            case 2:
                Employee.printAll(emp);
                break ; 

            case 3:
                Employee.printAll(emp) ; 

                System.out.println("Enter Index Of Two Employee which you want to compare :");

                int indx1 = ip.nextInt()-1 ; 
                int indx2 = ip.nextInt()-1 ; 

                Employee.compareBySalary(emp.get(indx1) , emp.get(indx2)) ; 

                break ;
            
            case 4:
                System.out.println("Enter the ID you want to search");
                long id = ip.nextLong() ; 

                int indx = Employee.searchById(emp, id) ; 

                if (indx != -1){
                    System.out.println("Employee found with entered ID\nDetails as follows ");
                    System.out.println(emp.get(indx));
                }

                else System.out.println("No employee found with entered ID ") ;

                break ; 

            case 5:
                System.out.println("Enter the Name you want to search");
                ip.nextLine() ; 
                String name = ip.nextLine() ; 

                int pos = Employee.searchByName(emp, name) ; 

                if (pos != -1){
                    System.out.println("Employee found with entered Name\nDetails as follows ");
                    System.out.println(emp.get(pos));
                }

                else System.out.println("No employee found with entered Name ") ;

                break ; 
            
            case 6:
                System.out.println("Sorting By Name Done");
                Collections.sort(emp , new SortByName()) ; 
                break ; 
            
            case 7:
                System.out.println("Current Enteries :") ;
                Employee.printAll(emp) ;  
                System.out.println("Enter The Index of Employee you want to delete") ; 
                int delIndx = ip.nextInt()  ; 

                emp.remove(delIndx-1) ;
                Employee.empDecrement() ; 
                System.out.println("Deleting Successfull") ; 

                break  ; 
                
            case 8:
                System.out.println("Current No of Employee Enteries : " + Employee.getNumEmps());
                break ;
                
            case 9:
                exit = true ; 
                break ;  



            default:
                System.out.println("Wrong Choice Please try Again");
        }
    }while(!exit);

        ip.close();
    }
}