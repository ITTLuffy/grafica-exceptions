public class MetodiStudente {
    public static void studentNotPresent(Studente[] studenti, Studente studente) throws StudenteNotFoundException{
        boolean presente = false;
        for (int idx = 0; idx < studenti.length; idx++) {    
            if (studenti[idx] == studente) {
                presente = true;
            }        
        }

        if(presente != true) {
            throw new StudenteNotFoundException("Studente non presente");
        }
    }
}
