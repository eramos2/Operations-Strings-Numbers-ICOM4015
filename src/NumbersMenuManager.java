/**
 * Creates the numbers operations menu.
 * 
 *
 */
public class NumbersMenuManager {
	private static NumbersMenuManager uniqueInstance = null;
	private Menu menu;
	public static int equationCounter= 0;
	public static int averageCounter = 0;
	

	private NumbersMenuManager() 
	{
	}
	/**
	 * Creates menu with string of options of different operations on numbers, and sets options and chances.
	 * @return the instance for the menu on number operations.
	 */
	public static NumbersMenuManager getInstance() 
	{
		if (uniqueInstance == null) 
		{
			uniqueInstance = new NumbersMenuManager();
			String menuDisplay = "\n\tOperations on Numbers Menu: " 
			+ "\n\t\t1> Process Quadratic Equation"
			+ "\n\t\t2> Compute Average of List of Numbers" 
			+ "\n\t\t3> Exit" + "\n"	
			+ "\n\n\tEnter your selection: ";
			// Create a menu object as per the specifications of the main
			// menu. Notice that it displays the above string, it has 4 options
			// and for the user to select a valid option, we have establised
			// a maximum of 3 opportunities.
			uniqueInstance.menu = new Menu(menuDisplay, 3, 3);
		}
		return uniqueInstance;
	}

	/**
	 * Displays content on menu and listen for user input and runs the method for the desire option.
	 */
	public void run() 
	{
		boolean exitMenu = false;
		do 
		{					
			menu.display();
			int choice = menu.getUserSelection();
			// the above method call will return 0 if the user did not
			// entered a valid selection in the opportunities given...
			// Otherwise, it is valid...
			if (choice == 0)
			{
				// here the user can be informed that fail to enter a
				// valid input after all the opportunities given....
				// for the moment, just exit....
				exitMenu = true;
			}
			else if (choice == 1) 
			{
				// here goes your code to initiate action associated to
				// menu option 1....
				ProjectUtils.processQuadraticEquation();
			}
			else if (choice == 2)
			{
				ProjectUtils.computeAverageOfNumbers();
			}
			else if (choice == 3) 
			{
				exitMenu = true;
			}
		} while (!exitMenu);
	}

}
