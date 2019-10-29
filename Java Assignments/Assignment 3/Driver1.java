import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;

class DoB{
	int year ;
	int month ;
	int date ; 


	DoB(){
		this.year = 0 ; 
		this.month = 0 ; 
		this.date = 0 ; 
	}
	DoB(int year , int month , int date){
		this.year = year ; 
		this.month = month ; 
		this.date = date ; 
	}

	public String toString(){  // Modified toString to Print DoB in proper form

		return (date+" / "+month+" / "+year);  
	}

	public int getDate(){
		return date ; 
	}

	public int getMonth(){
		return month ; 
	}

	public int getYear(){
		return year ; 
	}
}

class Student{

	long  prn ;
	String name ; 
	DoB DateOfBirth ;
	double marks ;
	char grade ; 

	Student(){
		this.prn = 0 ;
		this.name = ""; 
		this.DateOfBirth = new DoB() ;
		this.marks = -1 ; 
		grade = ' ' ; 
	}

	Student(long prn ,String name , double marks ,int d , int m , int y){
		this.prn = prn ;
		this.name = name ; 
		this.DateOfBirth = new DoB(y , m , d) ;
		this.marks = marks ; 

		if (marks >= 80)                           // Grade Assignment
			grade = 'A' ;
		else if (marks >= 60)
			grade = 'B' ;
		else if (marks >= 40)
			grade = 'C' ;
		else 
			grade = 'D' ; 
	}

	public String toString(){     // Modified toString to Print Student Details 

		return ("\nName : "+name+"\nPRN : "+prn + "\nDoB : "+DateOfBirth.toString()+"\nMarks : "+marks+"\nGrade : "+grade);
	}

	public long getPrn(){
		return this.prn ;
	}

	static void printAll(ArrayList<Student> stu){              // Printing all the Student Enteries in Student ArrayList
		for (int k = 0 ; k < stu.size() ; k++){
			System.out.println("***************************************************************************************");
			System.out.println("Student - "+(k+1)+"\n"+stu.get(k));
			System.out.println("***************************************************************************************");
		 } ;
	}

	

	public static int searchByPrn(ArrayList<Student> stu , long prn){

		boolean found = false ; 
		int indx = 0 ; 
		for(Student temp: stu){                 // Using Enhanced For Loop To Traverse the ArrayList

			if(temp.prn == prn){
				found = true ;
				break  ;
			}
			indx++ ;
		}

		if(found == true)
			return indx ; 

		else return -1 ; 
	}

	public static  int searchByName(ArrayList<Student> stu , String name){

		boolean found = false ; 
		int indx = 0 ; 

		Iterator itr = stu.iterator() ;          // Using Iterators to traverse over Student ArrayList

		while(itr.hasNext()){
			Student temp = (Student)itr.next() ; 

			if(temp.name.compareTo(name) == 0 ){

				found = true ; 
				break ; 
			}
			indx++ ; 
		}

		if(found == true)
			return indx ; 

		else return -1 ; 

	}

	public static  int searchByPos(ArrayList<Student> stu , int pos){
		int indx = 0 ; 

		Iterator itr = stu.iterator() ; 

				
		if(pos <= stu.size()){

			while(itr.hasNext()){
				itr.next() ; 

				if(pos-1 == indx){

					return indx ; 
				}
				indx++ ; 
			}
		}

		return -1 ; 
	}

	public static void updateStud(ArrayList<Student> stu , int pos ){

		Student temp = (Student)stu.get(pos) ; 

		Scanner ip = new Scanner(System.in) ; 

		System.out.println("Current Details Of Student") ; 
		System.out.println(temp) ; 
		System.out.println("Enter which attribute do you want to change : ") ;
		System.out.println("1. PRN ");
		System.out.println("2. Name  ");
		System.out.println("3. DoB ");
		System.out.println("4. Marks ");
		System.out.println("Your Choice:");
		
		int date ,month , year ; 
		date = temp.DateOfBirth.getDate() ; 
		month = temp.DateOfBirth.getMonth() ; 
		year = temp.DateOfBirth.getYear() ; 
		int choice = ip.nextInt() ;

		switch(choice){
			case 1:
				temp.prn = ip.nextLong() ; 
				break ; 
			
			case 2:
				temp.name = ip.nextLine() ; 
				break ; 
			
			case 3 :
			{
				System.out.println("Update which parameter.\n1.date\n2.month\n3.year\nYour choice:");

				int dobchoice = ip.nextInt() ; 

				switch(dobchoice){
					case 1:
						System.out.println("Enter Date - ") ; 
						date = ip.nextInt() ; 
						break ; 
					
					case 2 : 
						System.out.println("Enter Month - ") ; 
						month = ip.nextInt() ; 
						break ; 
					
					case 3 : 
						System.out.println("Enter Year - ") ; 
						year = ip.nextInt() ; 
						break ; 
				}

				break ;
			
			}

			case 4: 
				System.out.println("Enter Marks - ");
				temp.marks = ip.nextDouble() ; 
				break  ; 
				
		}

		stu.set(pos, new Student(temp.prn , temp.name , temp.marks , date , month  , year)) ; 
		System.out.println("Updation Successfull") ; 
		
	}
}

class SortByMarks implements Comparator<Student>{

	public int compare(Student a , Student b){

		int x ; 
		x = (a.marks>b.marks)?-1:1 ; 
		x = (a.marks == b.marks)?0:x ; 
		return x ; 
	}
}



class Driver1{

	public static void main(String[] args) {
		ArrayList<Student> stu = new ArrayList<Student>();

		Scanner ip = new Scanner(System.in);
		boolean exit = false ;

		do{
			System.out.println("\nOperations :");
			System.out.println("1.Enter Students");
			System.out.println("2.Display Students");
			System.out.println("3.Search by PRN ");
			System.out.println("4.Search by Name");
			System.out.println("5.Search by Pos");
			System.out.println("6.Sort by Marks");
			System.out.println("7.Update/Edit details of Student");
			System.out.println("8.Delete Student ");
			System.out.println("9.Exit");
			System.out.println("Enter Choice :");

			int choice = ip.nextInt() ;

			switch(choice){

				case 1:
				
					/* Entering Details of Student*/ 
					/*char another = 'y' ;
					System.out.println("Enter The Details of Students : ");
					int i = 0 ; 
					while(another =='y'){
						System.out.println("Student - "+(++i)) ;
						ip.nextLine();
						System.out.println("Name :");
						String name = ip.nextLine() ;
						System.out.println("PRN :");
						long  prn = ip.nextLong();
						System.out.println("DOB (d m y with spaces btw them) :");
						int d = ip.nextInt() ;
						int m = ip.nextInt() ;
						int y = ip.nextInt() ;

						System.out.println("Total Marks :");
						double marks = ip.nextDouble() ; 

						stu.add(new Student(prn , name , marks , d , m  , y)) ;
						System.out.println("Do you want to get another Record : ");
						ip.nextLine();
						another = ip.next().charAt(0) ; 
					}*/

					stu.add(new Student(122071 , "Vaibhav Jaiswal" , 10 , 20 , 10  , 8687)) ;
					stu.add(new Student(122070 , "Uriv Rawat" , 20 , 10 , 10  , 1455)) ;
					stu.add(new Student(122059 , "Akhil Singh" , 60 , 10 , 10  , 1997)) ;
					stu.add(new Student(122066 , "Arohi prasad" , 85 , 1 , 1  , 6878)) ;

					break ;
				
				case 2: 
					/* Displaying The Whole */ 
					Student.printAll(stu) ;
					break ;

				case 3:
					/* Search By PRN */
					long  pr ; 
					int indx = 0 ; 

					System.out.println("Enter the Prn To Search");
					pr = ip.nextLong() ;
					indx = Student.searchByPrn(stu , pr) ;
					
					if (indx != -1) 
						{
							System.out.println("Student Found with Entered PRN :\n Details Of student ");
							System.out.println(stu.get(indx)) ; 
						}
					
					else{
						System.out.println("PRN not found ");
					}
					break ; 
				
				case 4:
				{
					/*Search by name*/
					String name ; 

					System.out.println("Enter the Name to Search");
					ip.nextLine() ; 
					name = ip.nextLine() ; 

					int indxname = Student.searchByName(stu , name) ; 

					if (indxname != -1) 
					{
						System.out.println("Student Found with Entered Name :\n Details Of student ");
						System.out.println(stu.get(indxname)) ; 
					}
				
					else{
						System.out.println("Entered Student  not found ");
					}
					break ;
				} 
					
				case 5:
					{
						/* Search by Pos */
						int pos ;

						System.out.println("Enter position which you want to search");
						pos = ip.nextInt() ;

						int indxpos = Student.searchByPos(stu , pos) ; 
						if (indxpos != -1) 
						{
							System.out.println("Student Found at entered pos :\n Details Of student ");
							System.out.println(stu.get(indxpos)) ; 
						}
					
						else{
							System.out.println("No student found at Entered position");
						}
						break ;
					}

				case 6:
				/*Sort on the Basis of Marks*/
					Collections.sort(stu , new SortByMarks());
					System.out.println("SOrting on Basis of Marks Done : \n ");
					Student.printAll(stu);
					break ;
					
				case 7:
					/*Update Student Entry*/
					Student.printAll(stu) ; 
					System.out.println("Enter the Index of which Student Entry to update :") ;
					int upIndx = ip.nextInt() ;  // Index which to Update

					Student.updateStud(stu , upIndx-1) ; 
					ip.nextLine() ;
					break ; 
				
				case 8:
					/*Delete Student Entry*/
					Student.printAll(stu) ; 
					System.out.println("Enter the Index of which Student Entry to Delete :") ;
					int delIndx = ip.nextInt() ;   // Index which to delete

					stu.remove(delIndx-1) ;
					break ; 
					

				case 9:
					exit = true ;
					break ;

			}
		}while(!exit);

		ip.close();
	}
}