import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PagrindinePrograma0214 {
    public static void main(String[] args) {
        ArrayList<Knyga> knygos = new ArrayList<>();
        String failoPavadinimas = "knygos.csv";

        knygos = duomenuNuskaitymas(failoPavadinimas);
        knygos.forEach(System.out::println);
        System.out.println("Visų knygų kainų suma yra: " + kainuSuma(knygos));
        System.out.println("Visų knygų kainų vidurkis yra: " + vidurkis(knygos));
        System.out.println( "isbn sutampa su ieškomu: " + knygosPaieska("99-9055-756-10" , knygos));
        HashMap<String, Integer> kiekYraKnyguSalyje = knygoSaliesDaznumoMapRadimas(knygos);
        System.out.println(kiekYraKnyguSalyje);
        System.out.println("daugiausia knygu pagal MAP yra: "+ maxKeyIsMapo(kiekYraKnyguSalyje));
        System.out.println("autoriaus knygos"+ autoriausKnygos("Turner Sandoval Loya", knygos));


    }

    public static ArrayList<Knyga> duomenuNuskaitymas(String failoPavadinimas){
        ArrayList<Knyga>knygos = new ArrayList<>();
        try {
            File failas = new File(failoPavadinimas);
            Scanner failoSkaitytuvas = new Scanner(failas);

            failoSkaitytuvas.nextLine();
            while (failoSkaitytuvas.hasNextLine()){
                String eilute = failoSkaitytuvas.nextLine();
                String [] isskaidytaEilute = eilute.split(",");

               String isbn = isskaidytaEilute[0];
               String pavadinimas = isskaidytaEilute [1];
               String autorius = isskaidytaEilute [2];
               int leidimoMetai = Integer.parseInt (isskaidytaEilute[3]);
               String leidėjas = isskaidytaEilute [4];
               String salis = isskaidytaEilute [5];
               double kaina = Double.parseDouble(isskaidytaEilute[6]);

               Knyga laikinaKnyga = new Knyga(isbn,pavadinimas,autorius,leidimoMetai,leidėjas,salis,kaina);
               knygos.add(laikinaKnyga);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return knygos;
    }

    public static double kainuSuma(ArrayList<Knyga>knygos) {
        double suma = 0;
        for (Knyga knygo : knygos) {
            suma = suma + knygo.getKaina();
        }
        return suma;
    }
    public static double vidurkis (ArrayList<Knyga>knygos) {
        return kainuSuma(knygos) / knygos.size();
    }
    public static Knyga knygosPaieska(String isbn, ArrayList<Knyga>knygos) {
        for (Knyga knygo : knygos) {
            if (knygo.getIsbn().equals(isbn)) {
                return knygo;
            }
        }
        return null;
    }
    HashMap<String, Integer> salys = new HashMap<String, Integer>();

    public static HashMap<String, Integer> knygoSaliesDaznumoMapRadimas (ArrayList<Knyga>knygos) {
        HashMap<String, Integer> kiekKnyguSalyje = new HashMap<>();
        for (Knyga knyga:knygos) {
            if (kiekKnyguSalyje.containsKey(knyga.getSalis())) {
                kiekKnyguSalyje.put(knyga.getSalis(),kiekKnyguSalyje.get(knyga.getSalis()) +1);
            }
            else {

                kiekKnyguSalyje.put(knyga.getSalis(),1);
            }
        }
        return kiekKnyguSalyje;
    }
    public static String maxKeyIsMapo(HashMap<String, Integer> daznumoMap) {
            Map.Entry<String, Integer> maxPora = null;
        for (Map.Entry<String, Integer> salisKnygaEntry: daznumoMap.entrySet()) {
            if (maxPora == null ||salisKnygaEntry.getValue().compareTo(maxPora.getValue()) >0) {
                maxPora = salisKnygaEntry;
            
            }
        }
        return maxPora.getKey();

        }
        public static ArrayList<Knyga> autoriausKnygos (String autorius,ArrayList<Knyga>knygos){
            ArrayList<Knyga> rastosKnygos = new ArrayList<>();
            for (Knyga knygo : knygos) {
                if (knygo.getAutorius().equals(autorius)){
                    rastosKnygos.add(knygo);

                }
                
            }
            return rastosKnygos;

        }

    }


