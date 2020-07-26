package MavenAndOops.MavenAndOopsEclipsePrj;
import java.util.Scanner;
//import java.io.*;

public class GiftPack extends NewYearGift
{
	static Scanner scan=new Scanner(System.in);
	static int[] sweetsWeight;
	static int[] sweetsPrice;
	static int noOfSweets;
	static int[] chocolatesWeight;
	static int[] chocolatesPrice;
	static int noOfChocolates;
	static String[] candyNames;
	static int[] candyWeights;
	static int[] candyPrices;
	static int noOfCandies=0;
	public static void takeInput() throws Exception
	{
		System.out.println("Enter the number of sweets:");
	    noOfSweets= scan.nextInt();
		sweetsWeight=new int[noOfSweets];
		sweetsPrice=new int[noOfSweets];	
		for(int i=0;i<noOfSweets;i++)
		{
			System.out.println("Enter the Type of Sweet: Laddu/Kalakand?");
			String typeOfSweet= scan.next();
			Class<?> cls=Class.forName(typeOfSweet);
			Object o=cls.newInstance();
	Sweet s=(Sweet)o;
	NewYearGift newyeargift=new NewYearGift();
			newyeargift.setSweet(s);
			newyeargift.sweetInput();	
		   
			
			sweetsWeight[i]=weight;
		    sweetsPrice[i]=price;
		}	
		System.out.println("Enter the number of Chocolates:");
		noOfChocolates= scan.nextInt();
		chocolatesWeight=new int[noOfChocolates];
		chocolatesPrice=new int[noOfChocolates];
		candyWeights=new int[noOfChocolates];
		candyPrices=new int[noOfChocolates];
		candyNames=new String[noOfChocolates];
		
		for(int c=0;c<noOfChocolates;c++)
		{
			System.out.println("Enter the name of chocolate: Cadbury/Candy ?");
			String typeOfChocolate=scan.next();
			Class<?> cls=Class.forName(typeOfChocolate);
			Object o=cls.newInstance();
			Chocolate choc=(Chocolate)o;
			NewYearGift newyeargift=new NewYearGift();
			newyeargift.setChocolate(choc);
			newyeargift.chocolateInput();	
		    chocolatesWeight[c]=weight;
		    chocolatesPrice[c]=price;
		    if(typeOfChocolate.equals("Candy"))
			{
				System.out.println("Enter the name of the candy:");
				String name= scan.next();
				candyNames[noOfCandies]=name;
				candyWeights[noOfCandies]=weight;
				candyPrices[noOfCandies]=price;
				noOfCandies++;
			}
		}	
	 }
	public static void totalGiftWeight()
	{
	    int giftPackWeight=0;
	     for(int sweet=0;sweet<noOfSweets;sweet++)
	     {
	    	 giftPackWeight+=sweetsWeight[sweet];
	     }
	     for(int chocolate=0;chocolate<noOfChocolates;chocolate++)
	     {
	    	 giftPackWeight+=chocolatesWeight[chocolate];
	     }
	    System.out.println("Total Weight of Gift Box is: "+giftPackWeight);
	}
	public static void sortChocolate(String sortType)
	{
		int t;
		if(sortType.equals("price"))
		{
		  for(int c=0;c<noOfChocolates-1;c++)
		  {
			  for(int d=0;d<noOfChocolates-c-1;d++)
			  {
				  if(chocolatesPrice[d]>chocolatesPrice[d+1])
				  {
					  t=chocolatesPrice[d];
					  chocolatesPrice[d]=chocolatesPrice[d+1];
					  chocolatesPrice[d+1]=t;
					  t=chocolatesWeight[d];
					  chocolatesWeight[d]=chocolatesWeight[d+1];
					  chocolatesWeight[d+1]=t;
				  }
			  }
		  }
		}
		else
		{
			for(int c=0;c<noOfChocolates-1;c++)
			  {
				  for(int d=0;d<noOfChocolates-c-1;d++)
				  {
					  if(chocolatesWeight[d]>chocolatesWeight[d+1])
					  {
						  t=chocolatesPrice[d];
						  chocolatesPrice[d]=chocolatesPrice[d+1];
						  chocolatesPrice[d+1]=t;
						  t=chocolatesWeight[d];
						  chocolatesWeight[d]=chocolatesWeight[d+1];
						  chocolatesWeight[d+1]=t;
					  }
			}
			  }
		}
		System.out.println("The Sorted Chocolates are:");
		System.out.println("WEIGHT        PRICE");
		for(int c=0;c<noOfChocolates;c++)
		{
          
			System.out.println(chocolatesWeight[c]+" "+chocolatesPrice[c]);
		}
	}
	public static void getCandies(String candyType)
	{
		System.out.println("Enter the lower limit:");
		int lowerLimit= scan.nextInt();
		System.out.println("Enter the higher limit:");
		int higherLimit= scan.nextInt();
		if(candyType.equals("price"))
		{
			for(int c=0;c<noOfCandies;c++)
			{
				if(candyPrices[c]>=lowerLimit && candyPrices[c]<=higherLimit)
				{
					System.out.println(candyNames[c]);
				}
			}
		}
		else
		{
			for(int c=0;c<noOfCandies;c++)
			{
				if(candyWeights[c]>=lowerLimit && candyWeights[c]<=higherLimit)
				{
					System.out.println(candyNames[c]);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		takeInput();
		totalGiftWeight();
		System.out.println("Enter the option by which you want to sort: price/weight ?");
		String sortType= scan.next();
		sortChocolate(sortType);
		System.out.println("Enter the option by which you want to get candies: price/weight ?");
		String candyType= scan.next();
		getCandies(candyType); 
	}
		
}
