import java.util.Scanner;

/**
 * Methods for operations on strings and numbers, shows stats, and read input/show.
 *
 */

public class ProjectUtils {
	// the unique Scanner object to be used for input from 
	// the user throughout the program. 
	private static final Scanner input = new Scanner(System.in);
	//Number of times the stats menu has been called
	private static int statisticsCounter = 0;
	// Method for read and return an integer value
    public static int readInteger() { 
		// for the moment, just assume that the input is a
		// valid integer.... but eventually we want to be 
		// more robust and explicitly read and test first if
		// the input was really an integer or not....
		return input.nextInt(); 
	}
	
	
	public static String readString(){
		input.nextLine();
		return input.nextLine();
	}
	
	// Methods for output
	public static void print(String s) { 
		System.out.print(s); 
	} 
	public static void println(String s) { 
		System.out.println(s); 
	}


	/**
	 * Initiates the execution of the menu for operations with numbers. 
	 * This is to be executed each time the user selects option 1 in main
	 * menu. 
	 */
	public static void operationsOnNumbers() {
		NumbersMenuManager numbersMenuManager = NumbersMenuManager.getInstance(); 
		numbersMenuManager.run(); 
	}

	/**
	 * Initiates the execution of the menu for operations with strings. 
	 * This is to be executed each time the user selects option 2 in main
	 * menu. 
	 */
	public static void operationsOnStrings() {
		StringsMenuManager stringMenuManager = StringsMenuManager.getInstance(); 
		stringMenuManager.run(); 
	}
	/**
	 * Method to show statistics of usage. Executed whenever the user selects
	 * option 3 in main menu as per the specifications at the moment.
	 */
	public static void showStatistics() {
		System.out.println("Show Statistics"); 
		ProjectUtils.statisticsCounter++;
		// TODO: add necessary code....
		ProjectUtils.println("\t\t Operation in the Program\t\t Number of Times Executed" 
			+ "\n\t\t==========================" + "\t\t=========================="	
			+ "\n\t\tProcess Quadratic Equation" + "\t\t\t    "     + NumbersMenuManager.equationCounter    
			+ "\n\t\tCompute Average of Numbers" + "\t\t\t    "     + NumbersMenuManager.averageCounter
			+ "\n\t\tReverse a String"           + "\t\t\t\t    "   + StringsMenuManager.reverseCounter 
			+ "\n\t\tFormat a String"            + "\t\t\t\t\t    " + StringsMenuManager.formatCounter 
			+ "\n\t\tShow Statistics"        	 + "\t\t\t\t\t    " + ProjectUtils.statisticsCounter);
			//+ "\n\n\tEnter any key to exit: ");
		
	}

	/**
	 * Method to initiate the actions to read and reverse a string. 
	 */
	public static void reverseAString() {
		System.out.println("Reversing a String"); 
		// TODO: add necessary code....
		String reversedString = ""; 
		System.out.println("Please enter a string to reverse: ");
		String string = ProjectUtils.readString();
		for(int i=string.length()-1; i>=0; i--)
		{
			//char letter = string.charAt(i);
			System.out.print(""+ /*letter*/ string.charAt(i));
		}
		StringsMenuManager.reverseCounter++;
		ProjectUtils.println(reversedString);
	}

	/**
	 * Method to initiate the actions to read and format a string
	 * as specified. 
	 */
	public static void formatAString() {
		ProjectUtils.println("Format a String"); 
		// TODO: add necessary code....
		Scanner in = new Scanner(System.in);
		ProjectUtils.println("Please enter a string to format: ");
		String string = in.nextLine();
		boolean finish = false;
		int iterations = 0;
		while(!finish)
		{
			System.out.println("Now enter a pattern consisting of x's and -");
			String pattern = in.next();
			//int i = 0;
			//while(i - iterations<string.length() && i < pattern.length())
			for(int i = 0 ; i - iterations<string.length() && i < pattern.length();i++)
			{
				if(pattern.charAt(i) == 'x')
				{
					System.out.print(string.charAt(i-iterations) + "");
					//i++;
				}
				else
				{
					System.out.print("-"); 
					iterations++;
					//i++;
				}			
			}
			StringsMenuManager.formatCounter++;
			iterations = 0;
			System.out.println();
			System.out.println("Do you want to enter another pattern? enter 'y' if yes or enter any other key to return. ");
			String answer = in.next();
			if(answer.equals("y"))
			{
				finish = false;
			}
			else
			{
				finish = true;
			}
		}	
	}

	/**
	 * Method to initiate the actions to process a quadratic equation. 
	 */
	public static void processQuadraticEquation() {
		System.out.println("Process a Quadratic Equation"); 
		// TODO: add necessary code....
		ProjectUtils.println("Please enter the three coefficents of the Quadratic Equation: ");
		float a = ProjectUtils.input.nextFloat();
		float b = ProjectUtils.input.nextFloat(); 
		float c = ProjectUtils.input.nextFloat();
		NumbersMenuManager.equationCounter++;
	    float discriminant = (b*b)-(4*a*c);
	    if (discriminant > 0)
	    {
	    	Float first = ((-b+(b*b)+(4*a*c))/(2*a));
	        Float second = ((-b+(b*b)-(4*a*c))/(2*a));
	        ProjectUtils.println("[" + first + ", " + second + "]");
	    }
	   	else if(discriminant == 0)
	   	{
	   		Float first = ((-b)/(2*a));
	        Float second = first;        			   
	        ProjectUtils.println("[" + first + ", " + second + "]");
	   	}
	   	else
	   	{
	   		ProjectUtils.println("This Quadratic Equation does not have any real solutions.");
    	}
	} 

	/**
	 * Method to initiate the actions to compute average of numbers.... 
	 */
	public static void computeAverageOfNumbers() {
		System.out.println("Compute Average of Numbers"); 
		// TODO: add necessary code....
		double sum = 0;
		double value = 0;
		double average = 0;
		int count = 0;
		int tries = 0;
		
		while (tries < 3)
		{
			System.out.println("Please enter numbers one at a time to calculate the average(Must be greater or equal to zero):\n(To finish enter any negative number) ");
			value = ProjectUtils.input.nextDouble();
			if(value >=0)
			{
				sum += value;
				count++;
			}
			else if(value < 0)
			{
				tries = 3;
			}
			else
			{
				tries++;
			}
		}
			
		if(count>0)
		{
			NumbersMenuManager.averageCounter++;
			average = sum/count;
			ProjectUtils.println("The average is: "+ average);
		}		
		else
		{   
			NumbersMenuManager.averageCounter++;
			average = 0;
			ProjectUtils.println("You did not enter any valid numbers to compute average.");
			
		}	
	}
}





