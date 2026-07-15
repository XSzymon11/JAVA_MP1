import java.io.*;
import java.util.*;

public class Zwierze implements Serializable {
    private static final List<Zwierze> extent = new ArrayList<>();
    private static int instanceCount = 0;

    private String imie;
    private int rokUrodzenia;
    private String rasa;
    private String kolor;
    private double waga;
    private ArrayList<String> szczepienia;
    private String opis;

    public Zwierze(String imie, int rokUrodzenia, String rasa, String kolor, double waga, List<String> szczepienia) {
        setImie(imie);
        setRokUrodzenia(rokUrodzenia);
        setRasa(rasa);
        setKolor(kolor);
        setWaga(waga);
        setSzczepienia(szczepienia);
    }

    public Zwierze(String imie, int rokUrodzenia, String rasa, String kolor,
                   double waga, List<String> szczepienia, String opis) {
        this(imie, rokUrodzenia, rasa, kolor, waga, szczepienia);
        setOpis(opis);
    }

    protected void addToExtent() {
        extent.add(this);
        instanceCount++;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        if (imie == null || imie.isBlank()) {
            throw new IllegalArgumentException("Parameter 'imie' jest null'em lub jest pusty!");
        }
        this.imie = imie;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (rokUrodzenia > currentYear) {
            throw new IllegalArgumentException("Rok się nie zgadza (impossible)");
        }
        this.rokUrodzenia = rokUrodzenia;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        if (rasa == null || rasa.isBlank()) {
            throw new IllegalArgumentException("Parameter 'rase' jest null'em lub jest pusty!");
        }
        this.rasa = rasa;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        if (kolor == null || kolor.isBlank()) {
            throw new IllegalArgumentException("Parameter 'kolor' jest null'em lub jest pusty!");
        }
        this.kolor = kolor;
    }

    public double getWaga() {
        return waga;
    }

    public void setWaga(double waga) {
        if (waga <= 0) {
            throw new IllegalArgumentException("Waga musi być większa od zera");
        }
        this.waga = waga;
    }

    public List<String> getSzczepienia() {
        return Collections.unmodifiableList(szczepienia);
    }

    private void setSzczepienia(List<String> szczepienia) {
        if (szczepienia == null || szczepienia.isEmpty()) {
            throw new IllegalArgumentException("Lista szczepień nie może być pusta");
        }

        for (String szczepienie : szczepienia) {
            if (szczepienie == null || szczepienie.isBlank()) {
                throw new IllegalArgumentException("Szczepienie nie może być puste");
            }
        }

        this.szczepienia = new ArrayList<>(szczepienia);
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        if (opis != null && opis.isBlank()) {
            throw new IllegalArgumentException("Opis nie może być pusty");
        }

        this.opis = opis;
    }

    public void addSzczepienie(String szczepienie) {
        if (szczepienie == null || szczepienie.trim().isEmpty()) {
            throw new IllegalArgumentException("Szczepienie nie może być puste");
        }
        this.szczepienia.add(szczepienie);
    }

    public void addSzczepienie(List<String> szczepieniaList) {
        if (szczepieniaList == null || szczepieniaList.isEmpty()) {
            throw new IllegalArgumentException("Lista szczepień nie może być pusta");
        }
        for (String s : szczepieniaList) {
            addSzczepienie(s);
        }
    }

    public void removeSzczepienie(String szczepienie) {
        if (szczepienie == null || szczepienie.isBlank()) {
            throw new IllegalArgumentException("Nazwa szczepienia przekazanego do usunięcia nie może być puta");
        }

        if (!szczepienia.contains(szczepienie)) {
            throw new IllegalArgumentException("Lista nie zawiera szczepienia zgłoszonego do usunięcia");
        }

        if (szczepienia.size() == 1) {
            throw new IllegalStateException("Nie można usunać ostatniego elementu z listy");
        }



        szczepienia.remove(szczepienie);
    }

    public int getWiek() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - this.rokUrodzenia;
    }

    public static List<Zwierze> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    public static void saveExtent(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(extent);
            System.out.println("Ekstensja zwierząt zapisana do pliku: " + fileName);
        } catch (IOException e) {
            System.err.println("Błąd zapisu ekstensji: " + e.getMessage());
        }
    }

    public static void loadExtent(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Zwierze> loadedExtent = (List<Zwierze>) ois.readObject();
            extent.clear();
            extent.addAll(loadedExtent);
            instanceCount = extent.size();

            Pies.rebuildChipRegistry();

            System.out.println("Ekstensja zwierząt wczytana z pliku: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Błąd odczytu ekstensji: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Zwierzę: " + imie +
                ", Wiek: " + getWiek() +
                ", Rasa: " + rasa +
                ", Kolor: " + kolor +
                ", Waga: " + waga + "kg" +
                ", Szczepienia: " + szczepienia +
                (opis != null ? ", Opis: " + opis : "");
    }
}