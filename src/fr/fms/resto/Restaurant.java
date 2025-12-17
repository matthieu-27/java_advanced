package fr.fms.resto;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Restaurant {
	public static void main(String[] args) {
		Map<Integer, Item> starter = new HashMap<>();
		Map<Integer, Item> mainCourse= new HashMap<>();
		Map<Integer, Item> sideDish= new HashMap<>();
		Map<Integer, Item> dessert= new HashMap<>();
		Map<Integer, Item> drink= new HashMap<>();
		Map<String, Map<Integer, Item>> categories = new HashMap<>();
		
		// populate maps
		starter.put(1, new Item("SALADE", 5.50));
		starter.put(2, new Item("SOUPE", 4.00));
		starter.put(3, new Item("QUICHE", 6.00));
		starter.put(4, new Item("AUCUNE", 0.00));
		
		mainCourse.put(1, new Item("POULET", 12.00));
		mainCourse.put(2, new Item("BOEUF", 15.00));
		mainCourse.put(3, new Item("POISSON", 14.00));
		mainCourse.put(4, new Item("VEGETARIEN", 11.00));
		mainCourse.put(5, new Item("VEGAN", 10.00));
		mainCourse.put(6, new Item("AUCUN", 0.00));
		
		sideDish.put(1, new Item("RIZ", 2.50));
		sideDish.put(2, new Item("PATES", 3.00));
		sideDish.put(3, new Item("FRITES", 3.50));
		sideDish.put(4, new Item("LEGUMES", 3.00));
		sideDish.put(5, new Item("AUCUN", 0.00));
			
		drink.put(1, new Item("EAU PLATE", 1.50));
		drink.put(2, new Item("EAU GAZEUSE", 2.00));
		drink.put(3, new Item("SODA", 2.50));
		drink.put(4, new Item("VIN", 5.00));
		drink.put(5, new Item("AUCUNE", 0.00));
		
		dessert.put(1, new Item("TARTE MAISON", 5.00));
		dessert.put(2, new Item("MOUSSE AU CHOCOLAT", 4.50));
		dessert.put(3, new Item("TIRAMISU", 5.50));
		dessert.put(4, new Item("AUCUN", 0.00));
		
		categories.put("entrée", starter);
		categories.put("plat", mainCourse);
		categories.put("accompagnement", sideDish);
		categories.put("boisson", drink);
		categories.put("dessert", dessert);
		
		
		
		// variable initialization
		Scanner userScan = new Scanner(System.in);
        Map<String, Item> userOrders = new HashMap<>();
        double orderPrice = 0.0;
        double totalPrice = 0.0;

        System.out.println("Bonjour, combien de menus souhaitez-vous ?");
        int numberOfOrders = askUserChoice(userScan);
        try {
        	String path = System.getProperty("user.dir");
        	Path dir = Path.of(path + "\\src\\fr\\fms\\resto\\output.txt");
        	List<String> orders = new ArrayList<String>();
        	
	        for (int order = 0; order < numberOfOrders; order++) {
	        	String[] lines = new String[7];
	            System.out.println("Menu " + (order + 1) + ":");
	            
	            lines[0] = "****** Commande numéro " + (order + 1) + " ******";
	            orderPrice = 0.0; // Reset total for each order

	            for (Map.Entry<String, Map<Integer, Item>> category : categories.entrySet()) {
	                System.out.println("Choix " + category.getKey() + ":");
	                category.getValue().forEach((key, item) -> System.out.print("[" + key + ": " + item + "] "));
	                System.out.println();
	                int userChoice = askUserChoice(userScan, category.getValue().size()-1);
	                Item selectedItem = category.getValue().get(userChoice);
	                userOrders.put(category.getKey(), selectedItem);
	                orderPrice += selectedItem.getPrice();
	                String key = category.getKey();
	                switch (key) {
	                	case "entrée":			lines[1] = isWanted(selectedItem) ? selectedItem.getName() : "";
	                							break;
	                	case "plat":			lines[2] = isWanted(selectedItem) ? selectedItem.getName() : "";
     											break;
	                	case "accompagnement":	lines[3] = isWanted(selectedItem) ? selectedItem.getName() : "";
   												break;
	                	case "dessert":			lines[4] = isWanted(selectedItem) ? selectedItem.getName() : "";
   												break;
	                	case "boisson":			lines[5] = isWanted(selectedItem) ? selectedItem.getName() : "";
   												break;
	                	default: 				break;
	                }
 
	            }
                lines[6] = "Total: " + String.format("%.2f", orderPrice) + " €";
                System.out.println("Récapitulatif de la commande : " + userOrders);
                System.out.println("Total: " + String.format("%.2f", orderPrice) + " €");
                totalPrice = totalPrice + orderPrice;
	            for (String line : lines) {
					orders.add(line);
				}
	        }
	    
	        
	    String totalStr = "Le montant total " + (numberOfOrders > 1 ? "des commandes" : "de la commande") + " est de " + totalPrice + "€";
	    orders.add(totalStr);
	    System.out.println(totalStr);
	        
        Files.write(dir, orders);

	                               
    	} catch(FileNotFoundException e) {
    		e.printStackTrace();
    	} catch(IOException e) {
    		e.printStackTrace();
    	} 
	}
        

	
	public static boolean isWanted(Item item) {
		// Check if item contains selection
		if(item.getName().equals("AUCUNE")) {
			return false;
		}
		return true;
	}
    
    public static int askUserChoice(Scanner scan, int maxOptions) {
        while (true) { // on boucle sur while true pour pouvoir retourner un entier
            if (scan.hasNextInt()) {
            	int result = scan.nextInt();
                return result > maxOptions + 1 ? maxOptions + 1 : result;
            } else {
                System.out.println("Veuillez entrer un numéro valide");
                scan.next();
            }
        }
    }

    public static int askUserChoice(Scanner scan) {
    	return askUserChoice(scan, 2147483646);
    }
}