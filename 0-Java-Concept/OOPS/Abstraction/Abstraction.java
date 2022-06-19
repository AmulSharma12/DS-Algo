// Abstract means -> partial
// Abstraction means hiding the internal implementation and showing only the required set of services 
// for partial abstraction -> abstract class used
// for full abstraction -> interfaces used

//Being a user they dont know what is the internal implementation
// By Making GUI Screen 

import java.util.Scanner;

class Atm
{
	//data hiding 
	private double balance;

	//services
	public void deposit(double amount)
	{
		//validation
		this.balance += amount;
	}


	public double withdrawl()
	{
		//validation
		return this.balance;
	}
}

public class Abstraction
{
	public static void main(String[] args)
	{
		//code here...
		Atm atm = new Atm();
		atm.deposit(5000);
		System.out.println(atm.withdrawl());
		atm.deposit(2000);
		System.out.println(atm.withdrawl());
	}
}