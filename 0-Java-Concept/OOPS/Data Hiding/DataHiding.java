// DataHiding is one of the key feature of Object Oriented Programming
// Data Hiding actually means hiding the data so that outside class/person cannot use it directly
// So we can get/set data with the help of the methods  but only after the validations

// Data Hiding achieve by making the data member(variables) as private modifier

// Advantage -> Security

import java.util.Scanner;
//example of data hiding -> Bank class
class Bank
{
	//Implementation -> by making data member(variables) as Private modifier 
	private double balance;


	public double getBalance()
	{
		//validations
		return this.balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}


}



public class DataHiding
{
	//mainMethod()
	public static void main(String[] args)
	{
		Bank bank = new Bank();
		bank.setBalance(5000.00);
		System.out.println(bank.getBalance());
	}
}