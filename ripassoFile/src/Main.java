import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        try {
//        File f = new File("prova.txt");
//        FileWriter scrittore = new FileWriter("prova.txt");
//        scrittore.write("nuovo testo");
//        scrittore.close();
//        
//        System.out.println(f.getAbsolutePath());
//        if (f.createNewFile()) {
//            System.out.println("File creato " + f.getName());
//        } else {
//            System.out.println("File esiste già");
//        }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        
        try {
            File f = new File("prova.txt");
            try (Scanner in = new Scanner(f)) {
                while (in.hasNextLine()) {
                    String dati = in.nextLine();
                    System.out.println(dati);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
