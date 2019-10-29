class BonusEmployee extends Employee{
    int monthlyBonus;
    
    public int getMonthlyBonus(){
        return monthlyBonus;
    }
        
    public void setMonthlyBonus(int sal){
        monthlyBonus = sal;
    }
        
    public int getMonthlySalary()
    {
        int salary=(basicSalary/12)+monthlyBonus;
        return salary;
    }  
}