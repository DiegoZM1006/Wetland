package ui;
import java.util.Scanner;
import model.Municipe;

public class MainWetland{

	/**
	 * wetland is the connection to the Municipality class in the model package
	 */
	private Municipe wetland;
	/**
	 * sc is the object that allows reading information typed by the user
	 */
	public Scanner sc;
	/**
	 * option is the variable to store user decisions
	 */
	public static int option;
	/**
	 * Constructor of the Main Westland class, takes no parameters. 
	 * The method initializes the reader object
	 */
    public MainWetland(){
        sc = new Scanner(System.in);
    }	
	/**
	 * This method initialized the connection with the controller class
	 */
	public void setNameMunicipe() {
		System.out.print("\n!!! Enter the name of the municipality: ");
		String nameMunicipe = sc.nextLine();

		wetland = new Municipe(nameMunicipe);
	}
	/**
	 * Main method where the program will be executed in general
	 */
	public static void main(String [] args) {
		
		System.out.println(
			"\n" +
			"*------------------------*\n" +
			"|STARTING THE APPLICATION|\n" +
			"*------------------------*"
			);
		
        int option = 0;
        MainWetland myMain = new MainWetland();

		myMain.setNameMunicipe();

		do{
			option = myMain.showMenu();
			myMain.executeOperation(option);
		}while (option!=0);
		
	}	
	/**
	 * This class displays the program's menu.
	 * @return option, int which is the value of the option that the user chose
	 */
	public int showMenu() {
		int option=0;

		System.out.print(
				"\nSelect an option to get started\n\n" +
				"(1) To create the wetland\n" +
				"(2) To create a species in the wetland  \n"+
				"(3) To create a event \n"+
				"(4) To Create a management plan \n" +
				"(5) Show maintenance of the Wetlands \n" +  
				"(6) Show wetland with the minimun species of flora \n" +  
				"(7) Search for species in wetlands \n" +
				"(8) Show all information of wetlands \n" +
				"(9) Show wetland with the more species of flora \n" +
				"(0) To go out \n\n" +
				"--> "
				);

		option= sc.nextInt();
		return option;
	}
	/**
	 * This method is used to execute the method/Option that the user chose.
	 * @param operation, has to be initialized,int containing the value entered by the user  
	 */
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			createWetland();
			break;
		case 2:
			createSpecies();
			break;
		case 3:
			wetlandEvent();
			break;
		case 4:
			wetlandManagementPlan();
			break;
		case 5:
			showMaintenance();
			break;	
		case 6:
			showWetlandWithFewerSpecies();
			break;	
		case 7:
			showSpecieWithName();
			break;	
		case 8:
			showAllWetlands();
			break;
		case 9:
			showWetlandWithMostSpecies();
			break;		
		default:
			System.out.println("Error, opción no válida");
		}
	}
	/**
	 * This method create a new wetland
	 */
	public void createWetland() {
		
		if(wetland.hasSpace() == true){

		
			System.out.println("Creating the Wetland");

			String name,urlPicture, nameOfTheZone, locationZone = "", type = "";
			int opLocationZone, opType, opProtection;
			double size;
			boolean protection = false;

			System.out.println("Please enter the name of the wetland");
			sc.nextLine();
			name = sc.nextLine();
			
			do {
				System.out.println("Please enter the location of the wetland \n 1.) Urban \n 2.) Rural");
				opLocationZone= sc.nextInt();
			} while(opLocationZone != 1 && opLocationZone != 2);

			switch(opLocationZone) {
				case 1:
					locationZone = "Urban";
					break;
				case 2:
					locationZone = "Rural";
					break;
			}

			do {
				System.out.println("Please enter the type of the wetland \n 1.) Public \n 2.) Private");
				opType= sc.nextInt();
			} while(opType != 1 && opType != 2);

			switch(opType) {
				case 1:
					type = "Public";
					break;
				case 2:
					type = "Private";
					break;
			}

			System.out.println("Please enter the size of the wetland");
			size = sc.nextDouble();		

			System.out.println("Please enter the URL of the wetland picture");
			sc.nextLine();
			urlPicture= sc.nextLine();

			do {
				System.out.println("Define the type of protection as a boolean \n 1.) Protected \n 2.) Not Protected");
				opProtection = sc.nextInt();
			} while(opProtection != 1 && opProtection != 2);

			switch(opProtection) {
				case 1:
					protection = true;
					break;
				case 2:
					protection = false;
					break;
			}
			
			if(opLocationZone==1){
				System.out.println("Please enter the name of the neighborhood");
				sc.nextLine();
				nameOfTheZone= sc.nextLine();
			} else {
				System.out.println("Please enter the name of the small towm ");
				sc.nextLine();
				nameOfTheZone= sc.nextLine();
			}

			// Se crea el Wetland
			System.out.println(wetland.addWetland(name, locationZone, type, size, urlPicture, protection, nameOfTheZone));
		} else {
			System.out.println("You can't create another wetland, the array it's full");
		}
	}
	/**
	 * This method create a new specie in a specific wetland
	 */
	public void createSpecies() {

		System.out.print("Please enter the name of the Wetland you are going to add the species: ");
		sc.nextLine();
		String nameToSearch = sc.nextLine();

		String name, scientificName, migratoryType, type = "";
		int opType;
		int opToLeave = 0;

		if (wetland.findWetland(nameToSearch) == true) {

			do {
				System.out.println("Creating the species");

				System.out.println("Please enter the name of the species");
				name= sc.nextLine();
		
				System.out.println("Please enter the scientific name of the species");
				scientificName= sc.nextLine();
		
				System.out.println("Please enter the if it's a migratory type of the species \n 1.)Yes \n 2.)No ");
				migratoryType = sc.nextLine();

				do {
					System.out.println("Please enter the type of the species \n"+ 
					"1.) Terrestrial flora\n"+
					"2.) Aquatic flora\n"+
					"3.) Bird \n"+
					"4.) Mammal \n"+
					"5.) Aquatic \n"
					);
					opType = sc.nextInt();
				} while(
					opType != 1 && opType != 2 && opType != 3 && opType != 4 && opType != 5
					);
				
				switch (opType) {
					case 1:
						type = "Terrestrial flora";
						break;
					case 2:
						type = "Aquatic flora";
						break;
					case 3:
						type = "Bird";
						break;
					case 4:
						type = "Mammal";
						break;
					case 5:
						type = "Aquatic";
						break;
				}

				System.out.println(wetland.addSpecieToWetland(nameToSearch, name, scientificName,migratoryType, type));
				
				System.out.print("Introduce -1 to leave: ");
				opToLeave = sc.nextInt();

				sc.nextLine();

			} while(opToLeave != -1);

			// System.out.println(wetland.callToPrintAllSpecie());

		} else {
			System.out.println("The wetland does not exists");
		}
	}
	/**
	 * This method create a new event in a specific wetland
	 */
	public void wetlandEvent() {

		System.out.print("Please enter the name of the Wetland you are going to add the events: ");
		sc.nextLine();
		String nameToSearch = sc.nextLine();

		String manager,description;
		double cost;
		int opToLeave = 0, day, month, year;

		if (wetland.findWetland(nameToSearch) == true) {

			do {
				System.out.println("Creating the Event");
	
				System.out.println("Please enter the name of the manager of the event");
				manager= sc.nextLine();
				System.out.println("Please enter the price of the event");
				cost= sc.nextDouble();		
				System.out.println("Please enter the name of the description of the event");
				sc.nextLine();
				description= sc.nextLine();
				System.out.println("Please enter the day of the event");
				day = sc.nextInt();
				System.out.println("Please enter the month of the event");
				month = sc.nextInt();
				System.out.println("Please enter the year of the event");
				year = sc.nextInt();
		
				System.out.println(wetland.addEventToEvent(nameToSearch,manager, description, cost, day, month, year));
	
				System.out.print("Introduce -1 to leave: ");
				opToLeave = sc.nextInt();
			} while (opToLeave != -1);

		} else {
			System.out.println("The wetland does not exists");
		}
	}
	/**
	 * This method create a new management plan in a specific wetland
	 */
	public void wetlandManagementPlan() {

		System.out.print("Please enter the name of the Wetland you are going to add the events: ");
		sc.nextLine();
		String nameToSearch = sc.nextLine();

		String typePlan = "";
		double porcentage;
		int opToLeave = 0, opType, day, month, year;

		if (wetland.findWetland(nameToSearch) == true) {

			do {
				System.out.println("Creating the Management Plan");
	
				do {
					System.out.println(
					"Please enter the type of the Management Plan \n" +
					"(1) Restoration \n" +
					"(2) Maintenance \n" +
					"(3) Conservation \n"
				);
				opType = sc.nextInt();
				} while (opType != 1 && opType != 2 && opType != 3);

				switch (opType) {
					case 1:
						typePlan = "Restoration";
						break;
					case 2:
						typePlan = "Maintenance";
						break;
					case 3:
						typePlan = "Conservation";
						break;
				}

				System.out.print("Please enter the porcentage of the management plan: ");
				porcentage = sc.nextDouble();

				System.out.println("Please enter the day of the event");
				day = sc.nextInt();
				System.out.println("Please enter the month of the event");
				month = sc.nextInt();
				System.out.println("Please enter the year of the event");
				year = sc.nextInt();	
		
				System.out.println(wetland.addManagementPlanToWetland(nameToSearch,typePlan, porcentage, day, month, year));
	
				System.out.print("Introduce -1 to leave: ");
				opToLeave = sc.nextInt();
			} while (opToLeave != -1);

		} else {
			System.out.println("The wetland does not exists");
		}
	}
	/**
	 * This method shows the environmental management plans of all wetlands
	 */
	public void showMaintenance() {
		System.out.println(
			"*-- Management Plans of Wetlands --*" + wetland.showMaintenanceInWetland() + "\n\n"
		);
	}
	/**
	 * This method show the name of the wetland with less species
	 */
	public void showWetlandWithFewerSpecies() {
		System.out.println(
			"*-- Wetland with fewer species (" + wetland.wetlandWithFewerSpecies() + ") --*\n"
		);
	}
	/**
	 * This method show the name of the wetland with most species
	 */
	public void showWetlandWithMostSpecies() {
		System.out.println(
			"*-- Wetland with most species (" + wetland.wetlandWithMostSpecies() + ") --*\n"
		);
	}
	/**
	 * This method shows the name of the wetlands with the name of a specific species.
	 */
	public void showSpecieWithName() {
		System.out.print("Pleas enter the name of the specie you want search: ");
		sc.nextLine();
		String nameSpecieToSearch = sc.nextLine();
		if (wetland.searchSpecieInWetlands(nameSpecieToSearch).equals("")) {
			System.out.println(
				"\n*-- Wetlands that have the specie (" + nameSpecieToSearch + ")" +
				"\n There is not :C \n"
			);
		} else {
			System.out.println(
				"*-- Wetlands that have the specie (" + nameSpecieToSearch + ")" +
				wetland.searchSpecieInWetlands(nameSpecieToSearch) + "\n"
			);
		}
	}
	/**
	 * This method shows all the information of all the wetlands
	 */
	public void showAllWetlands() {
		System.out.println(
			"*-- ALL WETLANDS --* " + 
			wetland.showAllWetlands() + "\n"
		);
	}
} 