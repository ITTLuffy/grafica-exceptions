import java.io.File;
import java.util.Arrays;

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

//        try {
//            File f = new File("prova.txt");
//            Scanner in = new Scanner(f);
//            while (in.hasNextLine()) {
//                String dati = in.nextLine();
//                System.out.println(dati);
//            }
//            in.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            File f = new File("prova.txt");
//            if (f.delete()) {
//                System.out.println("File eliminato");
//            } else {
//                System.out.println("Problema ");
//            }
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        String file = "prova.txt";
//        File f = new File(file);
//        try {
//            f.createNewFile();
//            
//            if (f.exists()) {
//                System.out.println("permesso in scrittura " + f.canWrite());
//                System.out.println("permesso in lettura " + f.canRead());
//                System.out.println("dir ? " + f.isDirectory());
//                System.out.println("dimensione in byte " + f.length());
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(RipassoFile.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        System.out.println("Nome " + f.getName());
//        System.out.println("Percorso " + f.getPath());
//        System.out.println("Percorso assoluto " + f.getAbsolutePath());
//        System.out.println("Parent  " + f.getParent());
//        System.out.println("Esiste " + f.exists());

        File f = new File("C:\\","Lavoro-temp");
        if (f.exists()) {
            String arr[] = f.list();
            System.out.println(Arrays.toString(arr));
        }
    }

}
