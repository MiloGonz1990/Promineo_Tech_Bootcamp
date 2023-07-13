package projects;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import projects.exception.DbException;
import projects.service.ProjectService;
import projects.entity.Project;

//class that contains the main method 
//methods that gets user input to interact with projects database
//performs CRUD operations on the project tables.

public class ProjectsApp {

	private Scanner scanner = new Scanner(System.in);
	private ProjectService projectService = new ProjectService();
	private Project curProject; //Added variable of type Project named curProject.
	Integer difficulty;

	// @formatter:off
	private List<String> operations = List.of(
			"1) Add a project",
			"2) list projects",
			"3) Select a project"
	);
	// formatter:on
	
	public static void main(String[] args) {
		new ProjectsApp().processUserSelections();	
	}
	
	// method to process user input 
	//added new options to the list by creating another "case" to switch 
	private void processUserSelections() {
		boolean done = false;
		
		while(!done) {
		try {
			int selection = getUserSelection();
				
			switch (selection) {
				case -1:
					done = menuExit();
					break;
				case 1:
					createProject();
					break;
				case 2:
					listProjects();
					break;
				case 3:
					selectProjects();
					break;
					
				default: 
		  		 System.out.println("\n" + selection + " is not a vaild selection. Try again.");
				}

			} catch (Exception e) {
				System.out.println("\nError: " + e + " Try again.");
			}
		}
	}
        //This method will list the project IDs and names so that the user can select a project ID.
	private void selectProjects() {
        listProjects();
		
		Integer projectId = getIntInput("Enter a project ID to select a project");

		//Used to unselect a current project 
		curProject = null;
		//this will throw an exception if an invalid project ID is entered
		curProject = projectService.fetchProjectById(projectId);
		
	}
     //new method to print the ID and name for each Project. 
	private void listProjects() {
       List<Project> projects = projectService.fetchAllProjects();
		
		       System.out.println("\nProjects:");
		
		projects.forEach(project -> System.out.println("   " + project.getProjectId() + ": " + project.getProjectName()));
		
	}

	//Adds a row into the project table in the database using the input from the user
	private void createProject() {
		int i = 0;

		String projectName = getStringInput("Enter the project name");
		BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours");
		BigDecimal actualHours = getDecimalInput("Enter the actual hours");
		Integer validateDifficulty = getIntInput("Enter the project difficulty (1-5)");
		//Validates that the project difficulty level input by the user is between 1 and 5 
		while (i >= 0) {
			if (validateDifficulty >= 1 && validateDifficulty <= 5) {
				difficulty = validateDifficulty;
				i = -1;
			} else {
				validateDifficulty = getIntInput("Enter a valid project difficulty value (1-5)");
			}
		}
		String notes = getStringInput("Enter the project notes");
		
		Project project = new Project();
		
		//Sets the values of the object of the Project class
		project.setProjectName(projectName);
		project.setEstimatedHours(estimatedHours);
		project.setActualHours(actualHours);
		project.setDifficulty(difficulty);
		project.setNotes(notes);
		
		//Passes the project object into a method in the ProjectService class 
		Project dbProject = projectService.addProject(project);
		System.out.println("You have successfully created project: " + dbProject);
		
	}

	//Converts the String input by the user into a BigDecimal
	private BigDecimal getDecimalInput(String prompt) {
		String input = getStringInput(prompt);
		
		//Returns null if there was no input from the user
		if (Objects.isNull(input)) {
			return null;
		}
		
		try {
			return new BigDecimal(input).setScale(2);
		} catch (NumberFormatException e) {
			throw new DbException(input + " is not a valid decimal number.");
		}
	}

	//Prints that the user is exiting the menu and returns true to exit the while loop 
	private boolean menuExit() {
		System.out.println("Exiting the menu.");
		return true;
	}

	//Prints the operations and gets the operation selected by the user 
	private int getUserSelection() {
		printOperations();
		Integer input = getIntInput("Enter a menu selection");
		
		//Returns null if the user did not input data, but if they did it return the input
		return Objects.isNull(input) ? -1 : input; 
	}

	//Converts the String input by the user into an Integer
	private Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);
		
		if (Objects.isNull(input)) {
			return null;
		}
		
		try {
			return Integer.valueOf(input);
		} catch (NumberFormatException e) {
			throw new DbException(input + " is not a valid number.");
		}
	}

	//Prompts the user for information about a project and gets the user's input
	private String getStringInput(String prompt) {
		System.out.print(prompt + ": ");
		String input = scanner.nextLine();
		return input.isBlank() ? null : input.trim();
	}

	//Prints out the operations
	private void printOperations() {
		System.out.println("\nThese are the available selections. Press the Enter key to quit:");
		
		for (String operation : operations) {
			System.out.println(operation);
		}
		
		//Checks if a project is selected
		if (Objects.isNull(curProject)) {
			System.out.println("\nYou are not working with a project.");
		} else {
			System.out.println("\nYou are working with project: " + curProject);
		}
	}

}