/**
 * Creates menu objects.
 *
 *
 */
public class Menu {
	private String content;
	private int nOptions;
	private int maxChances;
	
	/**
	 * Starts the object menu.
	 * @param content the string representation of the options on the menu.
	 * @param nOptions the int representation of options on the menu.
	 * @param maxChances number of chances to select a valid option.
	 */
	public Menu(String content, int nOptions, int maxChances)
	{
		this.content = content;
		this.nOptions = nOptions;
		this.maxChances = maxChances;
	}
	
	/**
	 * Displays the content on the menu.
	 */
	public void display() { 
		ProjectUtils.println(content);  
	}
	/**
 	  Asks for and reads the user's selection. 
  	  @return Returns 0 if all the attempts allowed have been
	  used by the user, without entering a valid selection. 
	  Otherwise, it returns the integer value corresponding to
	  the valid selection by the user. 
	*/
	public int getUserSelection() { 
		int opportunity = 0; 
		int selection = 0;
		boolean valid = false; 
		 
		while (!valid && opportunity < maxChances) { 
			opportunity++; 
			ProjectUtils.print("\n\nEnter valid selection for this menu: "); 
			selection = ProjectUtils.readInteger(); 
			if (selection >= 1 && selection <= nOptions) 
				valid = true; 
		}
		if (!valid) 
			return 0; 
		else
			return selection; 
	}

	/**
	   Get the int value representing the exit option in menu
	   @return the int value corresponding to the exit option 
	 */
	public int getExitChoice() { 
		return nOptions; 
	}
}
