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

	public String toString(){

		return (date+"-"+month+"-"+year);
	}
}
class Student{

	long  prn ;
	String name ; 
	DoB DateOfBirth ;
	double marks ;

	Student(){
		this.prn = 0 ;
		this.name = ""; 
		this.DateOfBirth = new DoB() ;
		this.marks = -1 ; 
	}

	Student(long prn ,String name , double marks ,int d , int m , int y){
		this.prn = prn ;
		this.name = name ; 
		this.DateOfBirth = new DoB(y , m , d) ;
		this.marks = marks ; 
	}

	public String toString(){

		return ("\nName :"+name+"\nPRN :"+prn + "\nDoB :"+DateOfBirth.toString()+"\nMarks :"+marks+"\n");
	}

	public long getPrn(){
		return this.prn ;
	}

	static void printAll(ArrayList<Student> stu){
		for (int k = 0 ; k < stu.size() ; k++)
			System.out.println("Student -"+(k+1)+"\n"+stu.get(k)) ;
	}


	public static int searchByPrn(ArrayList<Student> stu , long prn){

		boolean found = false ; 
		int indx = 0 ; 
		for(Student temp: stu){

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
}


class Driver{

	public static void main(String[] args) {
		ArrayList<Student> stu = new ArrayList<Student>();

		Scanner ip = new Scanner(System.in);
		boolean exit = false ;

		do{
			System.out.println("1.Enter Students");
			System.out.println("2.Display Students");
			System.out.println("3.Search by PRN ");
			System.out.println("4.Search by Name");
			System.out.println("Enter Choice :");

			int choice = ip.nextInt() ;

			switch(choice){

				case 1:
				
					/* Entering Details of Student*/ 
					char another = 'y' ;
					System.out.println("Enter The Details of Students : ");
					int i = 0 ; 
					while(another =='y'){
						System.out.println("Student - "+(i++)) ;
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
					}
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
					String name ; 
					boolean found = false ; 

					System.out.println("Enter the Name to Search");
					ip.nextLine() ; 
					name = ip.nextLine() ; 

					Iterator itr = stu.iterator() ; 

					while(itr.hasNext()){

						Student temp = (Student)itr.next() ; 

						if(temp.name.compareTo(name) == 0 ){

							found = true ; 
							System.out.println("Student Found with Entered Name .");
							System.out.println("Details as follows .") ; 
							System.out.println(temp);

							break ; 
						}
					}

						if(!found){
							System.out.println("no student found with entered name");
						}
				}
					break ; 
					
				case 5:
					{
						int pos ;
						int k = 0 ;

						System.out.println("Enter position which you want to search");
						pos = ip.nextInt() ;
						Iterator itr = stu.iterator() ; 
				
					if(pos <= stu.size()){
							while(itr.hasNext()){

								Student temp = (Student)itr.next() ; 

								if(k == pos-1){
									System.out.println("Student Found at entered position .");
									System.out.println("Details as follows .") ; 
									System.out.println(temp);

									break ; 
								}
							}

							break ; 

						}

						else{
							System.out.println("Entered Position is out of bounds of list . search not possible");
						}

						break ; 
					}

						
				case 6:
					exit = true ;
					break ;

			}
		}while(!exit);

		ip.close();
	}
}