import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> szczepieniaPsa = new ArrayList<>(); // atrybut powtarzalny
        szczepieniaPsa.add("Wścieklizna");

        DaneKontaktowe dane1 = new DaneKontaktowe("780049400", "kacper@schronysko.dog"); // atrybut złożony
        Wlasciciel wlasciciel1 = new Wlasciciel("Kacper", "Ogórek", dane1);

        // atrybut opcjonalny "opis" w przypadku pies1 brak
        Pies pies1 = new Pies("Reks", 2000, "Owczarek Niemiecki", "Czarny", 32.0,
                szczepieniaPsa, "CHIP-001", wlasciciel1);
        // atrybut opcjonalny "opis" w przypadku pies2 znajduje się
        Pies pies2 = new Pies("Azor", 2000, "Dalmatyńczyk", "Biały", 33.0,
                szczepieniaPsa,"CHIP-002", wlasciciel1, "Super piesek, bardzo grzeczny, nie gryzie");

        Pies.setNazwaSchroniska("Zielona Buda"); // atrybut klasowy (nazwaSchroniska)
        System.out.println("Nazwa schroniska dla psów: " + Pies.getNazwaSchroniska());

        System.out.println(pies1.getSzczepienia());

        List<String> noweSzczepienia = Arrays.asList("HIV", "Bolerioza");
        pies1.addSzczepienie(noweSzczepienia); // przeciążenie metody addSzczepienie (wersja z listą)
        pies1.addSzczepienie("AntyKotoSzczepionka"); // przeciażenie metody addSzczepienie (wersja ze String)

        System.out.println(pies1.getSzczepienia());
        pies1.removeSzczepienie("AntyKotoSzczepionka");

        System.out.println(pies1.getSzczepienia());

        System.out.println(pies1.getImie() + " ma lat " + pies1.getWiek()); // atrybut pochodny

        System.out.println("pies1 " + pies1); // przesłonięcie (toString)
        System.out.println("pies2 " + pies2); // przesłonięcie (toString)

        System.out.println("pies1 " + pies1.getNumerChipa());

        System.out.println("Liczba psów: " + Pies.getLiczbaPsow()); // metoda klasowa

        DaneKontaktowe dane2 = new DaneKontaktowe("420672137", "anna@psipatrol.hauhau");
        Wlasciciel wlasciciel2 = new Wlasciciel("Anna", "Kowalska", dane2);
        pies1.setWlasciciel(wlasciciel2); // atrybut złożony
        System.out.println("Nowy właściciel pies1: " + pies1.getWlasciciel());

        System.out.println("Liczba zwierząt: " + Zwierze.getInstanceCount());
        System.out.println("Ekstensja zwierząt: " + Zwierze.getExtent()); // ekstensja

        Zwierze.saveExtent("schronisko.txt"); // Ekstensja trwałość (zapis)
        Zwierze.loadExtent("schronisko.txt"); // Ekstensja trwałość (odczyt)
        System.out.println("Po wczytaniu liczba zwierząt : " + Zwierze.getInstanceCount());
        System.out.println("Po wczytaniu ekstensja :" +  Zwierze.getExtent());
    }
}