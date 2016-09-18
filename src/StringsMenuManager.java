/**
 * Strings Menu
 *
 */
public class StringsMenuManager {
	private static StringsMenuManager uniqueInstance = null;
	private Menu menu;
	public static int reverseCounter= 0;
	public static int formatCounter = 0;
	

	private StringsMenuManager() 
	{
	}
/**
 * Has all string content # of options in menu and chances.
 * @return
 */
	public static StringsMenuManager getInstance() 
	{
		if (uniqueInstance == null) 
		{
			uniqueInstance = new StringsMenuManager();
			String menuDisplay = "\n\tOperations on Strings Menu: " 
			+ "\n\t\t1> Show Reverse of a Given String"
			+ "\n\t\t2> Format Strings" 
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
 * Displays content of strings menu and listens for user input.
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
				ProjectUtils.reverseAString();
			}
			else if (choice == 2)
			{
				ProjectUtils.formatAString();
			}
			else if (choice == 3) 
			{
				exitMenu = true; 
			}
		} while (!exitMenu);
	}

}
