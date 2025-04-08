
import java.io.IOException;

public class IOExceptions {
    public static void main(String[] args) throws Exception {
        try {
            etaValida(12);
        } catch (InvalidEtaException ie) {
            System.out.println("InvalidEtaException " + ie.getMessage());
        } catch (IOException ioe) {
            System.out.println("IOException " + ioe.getMessage());
        }

        Studente s = new Studente("Davide", "Cesari", "4546123");
        try {
            studentNotPresent(s);
        }

    }

    public static void etaValida(int eta) throws InvalidEtaException, IOException { // si può mettere anche il generico Exception
        // controllo sull'eta
        if (eta < 18) {
            throw new InvalidEtaException("devi avere 18 anni"); // invoco la classe
        } else {
            System.out.println("Benvenuto a votare");
        }
    }
}
