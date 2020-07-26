package MavenAndOops.MavenAndOopsEclipsePrj;
//import java.io.*;
import java.util.Scanner;
public class NewYearGift {
	Scanner scan=new Scanner(System.in);
	static int weight=0;
    static int price=0;
	Sweet sweet;
	Chocolate chocolate;
	public void setSweet(Sweet sweet)
	{
		this.sweet=sweet;
	}
	public void setChocolate(Chocolate chocolate)
	
	{
		this.chocolate=chocolate;
	}
	public void sweetInput()
	{
		sweet.inputSweet();
	}
	public void chocolateInput()
	{
		chocolate.inputChocolate();
	}
}
