
/**
 * Lab02 yourDescription: tests all the parent and sub-classes, using a menu driven program creates an arraylist of different type of objects
 *						and experiment with polymorphism
 *
 * @author Abdullah Erkam Arslan
 * @version 1.00 2014/3/7
 */
 
import java.util.Scanner;
import cs1.*;
import java.util.ArrayList;

public class Lab02 
{		

    public static void main( String[] args) 
	{
    	Scanner scan = new Scanner( System.in);
		
    	System.out.println( "Start of Lab02\n");
		
		// CONSTANTS

		// VARIABLES
		SimpleURLReader reader;
		MySimpleURLReader myReader;
	 	HTMLFilteredReader filtReader;
		SuperHTMLFilteredReader superFiltReader;
		int choice;
		int indexNumOfPoem;
		String URLAdr;
		ArrayList<MySimpleURLReader> poemReaders;
		
		// PROGRAM CODE
		reader = new SimpleURLReader("http://www.cs.bilkent.edu.tr/~david/housman.txt");
		myReader = new MySimpleURLReader("http://www.cs.bilkent.edu.tr/~david/housman.txt");		
		filtReader = new HTMLFilteredReader("http://www.cs.bilkent.edu.tr/~david/housman.htm");
		superFiltReader = new SuperHTMLFilteredReader("http://www.cs.bilkent.edu.tr/~david/index.html");
		
		// Test all of the classes
		System.out.println("=== test the MySimpleURLReader class using myReader object"); 
		System.out.println("The URL adress of the file: " + myReader.getURL());
		System.out.println("The name of the file: " + myReader.getName());
		System.out.println();
		System.out.println();
		System.out.println("=== bugged Page Contents");
		System.out.println(reader.getPageContents());
		System.out.println("The number of the lines in the URL is " + reader.getLineCount());
		System.out.println();
		System.out.println("=== test overriding the bugged method of the SimpleURLReader class in the sub-class, MySimpleURLReader: ");
		System.out.println();
		System.out.println(myReader.getPageContents());
		System.out.println();
		
		System.out.println("=== TEST HTMLFilteredReader class by USING filtReader OBJECT: ");
		System.out.println();
		System.out.println("== full Page Contents:".toUpperCase ());
		//System.out.println(filtReader.getUnfilteredPageContents ()); CAN BE INCLUDED
		System.out.println();
		System.out.println("== filtered Page Contents:".toUpperCase ());
		System.out.println(filtReader.getPageContents ());
		System.out.println("=== END OF TEST HTMLFilteredReader".toUpperCase ());
		System.out.println();
		System.out.println("=== TEST SuperHTMLFilteredReader by USING superFiltReader OBJECT: " );
		System.out.println("== The overhead due to the html code: %" + superFiltReader.computeOverhead () );
		System.out.println();
		System.out.println("== Test the getLinks() method. The all links in the page: ");
		System.out.println(superFiltReader.getLinks ());
		System.out.println();
		System.out.println("=== END OF TEST SuperHTMLFilteredReader");
		System.out.println();
		System.out.println();
		System.out.println("=== Experiment with Java's extended type checking mechanism by calling the methods using variables of both HTMLFilteredReader and SuperHTMLFilteredReader types.");
		System.out.println();
		System.out.println("Call superFiltReader.getPageContents ():(should return the getPageContents() of the HTMLFilteredReader, because it comes first among the parent classes)) : \n" + superFiltReader.getPageContents ());
		System.out.println();
		System.out.println(); 
			
		// Design and implement a simple menu-driven program that will maintain a collection of MySimpleURLReader objects.
		poemReaders = new ArrayList<MySimpleURLReader>();
		do
		{
			System.out.println();
			System.out.println();
			System.out.println("=== MAIN MENU");
			System.out.println("(1) Enter an url of a poem to add to the collection");
			System.out.println("(2) List all poems in the collection");
			System.out.println("(3) Quit");
			System.out.print("Please enter your choice: ");
			choice = scan.nextInt();
			scan.nextLine();
			
			if(choice == 1)
			{
				System.out.print("Please enter the url of the poem to add to the collection: ");
				URLAdr = scan.nextLine();
				
				// if the entered URL is a text file create an object of MySimpleURLReader
				if(URLAdr.endsWith(".txt"))
					poemReaders.add(new MySimpleURLReader(URLAdr));
				
				// if the entered URL is a html or htm file create an object of HTMLFilteredReader to print the non-html code
				else if(URLAdr.endsWith(".htm") || URLAdr.endsWith(".html"))
					poemReaders.add(new HTMLFilteredReader(URLAdr));			
			}	
			
			if(choice == 2)
			{
				System.out.println(" All poems in the collection:");
				int i;
				for( i = 0; i < poemReaders.size(); i++)
				{
					System.out.print("[ " + i + " ]\t");
					System.out.println(poemReaders.get(i).getName()); 
				}
				System.out.println("[ " + (i) + " ] to return to main menu." );
				
				do
				{
					System.out.print("Please enter the index number of a poem to view it \n(to return the main menu please enter: last index number + 1, if no poem exists in the list enter 0 to return to main menu): ");
					indexNumOfPoem = scan.nextInt();
					
					if(indexNumOfPoem < poemReaders.size())
					{
						System.out.println("The selected poem is " + poemReaders.get(indexNumOfPoem).getName());
						System.out.println(poemReaders.get(indexNumOfPoem).getPageContents());
						System.out.println(" All poems in the collection:");
						
						for( i = 0; i < poemReaders.size(); i++)
						{
							System.out.print("[ " + i + " ]\t");
							System.out.println(poemReaders.get(i).getName()); 
						}
						System.out.println("[ " + (i) + " ] to return to main menu." );
								
					}
				}while(indexNumOfPoem != poemReaders.size());	
				
			}		
		
		}while(choice != 3);	
		
		System.out.println( "\nEnd of Lab02\n" );
	}
	
} // end of class Lab02
