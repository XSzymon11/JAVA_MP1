import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pies extends Zwierze {
    private static final Set<String> wszystkieNumeryChipow = new HashSet<>();
    private String numerChipa;
    private Wlasciciel wlasciciel;
    private static String nazwaSchroniska = "Pod Budą";

    public Pies(String imie, int rokUrodzenia, String rasa, String kolor, double waga,
                List<String> szczepienia, String numerChipa, Wlasciciel wlasciciel) {
        super(imie, rokUrodzenia, rasa, kolor, waga, szczepienia);
        setWlasciciel(wlasciciel);
        setNumerChipa(numerChipa);
        addToExtent();
    }

    public Pies(String imie, int rokUrodzenia, String rasa, String kolor, double waga,
                List<String> szczepienia, String numerChipa, Wlasciciel wlasciciel, String opis) {
        super(imie, rokUrodzenia, rasa, kolor, waga, szczepienia, opis);
        setNumerChipa(numerChipa);
        setWlasciciel(wlasciciel);
        addToExtent();
    }

    public String getNumerChipa() {
        return numerChipa;
    }

    public void setNumerChipa(String nowyNumer) {
        if (nowyNumer == null || nowyNumer.isBlank()) {
            throw new IllegalArgumentException("Numer chipa nie może być pusty");
        }

        if (nowyNumer.equals(this.numerChipa)) {
            return;
        }

        if (wszystkieNumeryChipow.contains(nowyNumer)) {
            throw new IllegalArgumentException("Już istnieje taki numer chipa");
        }

        if (this.numerChipa != null) {
            wszystkieNumeryChipow.remove(this.numerChipa);
        }

        this.numerChipa = nowyNumer;
        wszystkieNumeryChipow.add(nowyNumer);
    }

    public Wlasciciel getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(Wlasciciel wlasciciel) {
        if (wlasciciel == null) {
            throw new IllegalArgumentException("Dodaj właściciela!");
        }
        this.wlasciciel = wlasciciel;
    }

    public static String getNazwaSchroniska() {
        return nazwaSchroniska;
    }

    public static void setNazwaSchroniska(String nazwa) {
        if (nazwa == null || nazwa.isBlank()) {
            throw new IllegalArgumentException("Dodaj nazwa schroniska!");
        }
        nazwaSchroniska = nazwa;
    }

    public static int getLiczbaPsow() {
        int num = 0;
        for (Zwierze zwierze : Zwierze.getExtent()) {
            if (zwierze instanceof Pies) {
                num++;
            }
        }
        return num;
    }

    public static void rebuildChipRegistry() {
        wszystkieNumeryChipow.clear();
        for (Zwierze zwierze : Zwierze.getExtent()) {
            if (zwierze instanceof Pies pies && pies.getNumerChipa() != null) {
                wszystkieNumeryChipow.add(pies.getNumerChipa());
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Numer chipa: " + numerChipa + ", Właściciel: " + wlasciciel;
    }
}