

class Driver{
    public static void main(String[] args) {
        
        NormalEmployee nemp1 =new NormalEmployee();
        nemp1.setName("Mukesh Rane");
        nemp1.setAddress("Lavale , Pune");
        nemp1.setBasicSalary(2400000);
        System.out.println( "Monthly Salary of  " + nemp1.getName() + " is : "+ nemp1.getMonthlySalary());
        
        BonusEmployee bemp1=new BonusEmployee();
        bemp1.setName("Rajiv Sharma");
        bemp1.setAddress("Vashi , Navi Mumbai");
        bemp1.setBasicSalary(1200000);
        bemp1.setMonthlyBonus(25000);
        System.out.println("Monthly Salary of  " + bemp1.getName() + " is : "+ bemp1.getMonthlySalary());
    }
}