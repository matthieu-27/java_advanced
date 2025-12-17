import fr.fms.resto.*;
import java.io.*;
import java.util.*;

public class TestRestaurant {
    public static void main(String[] args) {
        // Simuler l'entrée utilisateur
        String input = "1\n1\n1\n1\n1\n1\n"; // 1 menu avec tous les choix à 1
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        // Appeler le programme principal
        Restaurant.main(new String[0]);
        
        // Lire et afficher le résultat
        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "\\src\\fr\\fms\\resto\\output.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}