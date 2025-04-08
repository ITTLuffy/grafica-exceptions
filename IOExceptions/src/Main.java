public class Main {
    public static void main(String[] args) throws Exception {

    }

    public static void etaValida(int eta) throws InvalidEtaException {
        // controllo sull'eta
        if (eta < 18) {
            throw new InvalidEtaException("Devi avere 18 anni"); // invoco la classe
        } else {
            System.out.println("Benvenuto a votare");
        }
    }
}
