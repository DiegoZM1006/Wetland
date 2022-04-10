package ui;
import java.util.Scanner;
import model.Municipe;

public class MainWetland{

	/**
	 * wetland es la conexion con la clase Municipe en el paquete model
	 */
	private Municipe wetland;
	/**
	 * sc es el objeto que permite leer informaciOn digitada por el usuario
	 */
	public Scanner sc;
	/**
	 * Constructor de la clase, no recibe prametros.  
	 * El mEtodo inicializa el objeto lector 
	 */

	//private Wetland newWetland;
	public static int option;

    public MainWetland(){
        sc = new Scanner(System.in);
    }	

	public void setNameMunicipe() {
		System.out.print("Digite el nombre del municipio: ");
		String nameMunicipe = sc.nextLine();

		wetland = new Municipe(nameMunicipe);
	}

	public static void main(String [] args) {
		
		System.out.println("Iniciando la aplicación");
		
        int option = 0;
        MainWetland myMain = new MainWetland();

		myMain.setNameMunicipe();

		do{
			option = myMain.showMenu();
			myMain.executeOperation(option);
		}while (option!=0);
		
	}	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Seleccione una opción para empezar\n" +
				"(1) To create the wetland\n" +
				"(2) To create a species in the wetland  \n"+
				"(3) Wetland Event Log \n"+
				"(4) Show maintenance of the Wetlands \n" +  
				"(5) Show wetland with the minimun species of flora \n" +  
				"(0) To go out"
				);

		option= sc.nextInt();
		return option;
	}
	
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
			//wetlandEvent();
			break;

		case 4:
			//	showFigures();
			break;

		case 5:
			//	showFigures();
			break;	

		case 6:
			//	showFigures();
			break;				
		default:
			System.out.println("Error, opción no válida");
		}
	}

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
				System.out.println("Please enter the location of the wetland \n 1.)Urban \n 2.)Rural");
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
				System.out.println("Please enter the type of the wetland \n 1) Public \n 2.)Private");
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
				System.out.println("Define the type of protection as a boolean \n 1.Protected \n 2.)Not Protected");
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
			
			System.out.println("Please enter the name of the zone");
			sc.nextLine();
			nameOfTheZone= sc.nextLine();

			System.out.println("Please enter the number of species in this wetland");
			int numberOfSpecies = sc.nextInt();

			// Se crea el Wetland
			System.out.println(wetland.addWetland(name, locationZone, type, size, urlPicture, protection, nameOfTheZone, numberOfSpecies));
		} else {
			System.out.println("You can't create another wetland, the array it's full");
		}
	}

	public void createSpecies() {

		System.out.print("Please enter the name of the Wetland you are going to add the species: ");
		sc.nextLine();
		String nameToSearch = sc.nextLine();

		if (wetland.findWetland(nameToSearch) == true) {

			System.out.println("Creating the species");

			String name, scientificName, migratoryType ,type;

			System.out.println("Please enter the name of the species");
			sc.nextLine();
			name= sc.nextLine();
		
			System.out.println("Please enter the scientific name of the species");
			sc.nextLine();
			scientificName= sc.nextLine();
		
			System.out.println("Please enter the if it's a migratory type of the species \n 1.)Yes \n 2.)No ");
			sc.nextLine();
			migratoryType= sc.nextLine();

			System.out.println("Please enter the type of the species"+ 
							"1.) Terrestrial flora"+
							"2.) Aquatic flora"+
							"3.) Bird "+
							"4.) Mammal"+
							"5.) Aquatic"
							);
			type= sc.nextLine();

			// System.out.println(wetland.addSpecieWetland(wetlandName, name, scientificName,migratoryType, type));

		} else {
			System.out.println("The wetland does not exists");
		}
	}
	
	/* public void wetlandEvent() {
		System.out.println("Creating the Event");

		String manager,description;
		double cost;
		System.out.println("Please choice the option of the event you want to register \1.) ");


		System.out.println("Please enter the name of the manager of the event");
		manager= sc.nextLine();
		System.out.println("Please enter the price of the event");
		cost= sc.nextDouble();		
		System.out.println("Please enter the name of the description of the event");
		description= sc.nextLine();

	//	Wetland.addWetland(name, locationZone,type, size, urlPicture, nameOfTheZone);
	}
	*/
} 