import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serializzazione {

    public static void main(String[] args) {
        ArrayList<Persona> persone = new ArrayList<>();

        boolean finito = false;

        Persona p = new Persona("Gino", "Verdi", "12Gino");
        Persona p1 = new Persona("Lino", "Gialli", "12Lino");

        try {
            FileOutputStream fos = new FileOutputStream("dati.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(p);
            oos.writeObject(p1);
            oos.flush();
            oos.close();
            fos.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ---------------------------------------------------------------------
        // DESERIALIZZAZIONE
        try {
            FileInputStream fis = new FileInputStream("dati.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (!finito) {
                Object obj = ois.readObject();
                if (obj instanceof Persona) {
                    persone.add((Persona) obj);
                } else {
                    System.out.println("Oggetto sconosciuto");
                }

            }
        } catch (EOFException e) {
            finito = true;
        } catch (Exception er) {
            System.out.println(er.getMessage());
        }
        System.out.println("Contenuto array");
        for (Persona persona : persone) {
            System.out.println(persona.toString());
        }

        // // serializzazione
        // try {
        // FileOutputStream fos = new FileOutputStream(file);
        // ObjectOutput oos = new ObjectOutputStream(fos);
        // oos.writeObject(p);
        // oos.flush();
        // fos.flush();
        // oos.close();
        // fos.close();
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }
        //
        // // DESERIALIZZAZIONE
        // Persona g = null;
        //
        // try {
        // FileInputStream fis = new FileInputStream(file);
        // ObjectInputStream ois = new ObjectInputStream(fis);
        //
        // g = (Persona) ois.readObject();
        // ois.close();
        // fis.close();
        // System.out.println("oggetto letto correttamente");
        // System.out.println(g.toString());
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }

    }

}
