import java.io.Serial;
import java.io.Serializable;

public class Wlasciciel implements Serializable {
    private String imie;
    private String nazwisko;
    private DaneKontaktowe daneKontaktowe;

    public Wlasciciel(String imie, String nazwisko, DaneKontaktowe daneKontaktowe) {
        setImie(imie);
        setNazwisko(nazwisko);
        setDaneKontaktowe(daneKontaktowe);
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

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        if (nazwisko == null || nazwisko.isBlank()) {
            throw new IllegalArgumentException("Parameter 'nazwikso' jest null'em lub jest pusty!");
        }
        this.nazwisko = nazwisko;
    }

    public DaneKontaktowe getDaneKontaktowe() {
        return daneKontaktowe;
    }

    public void setDaneKontaktowe(DaneKontaktowe daneKontaktowe) {
        if (daneKontaktowe == null) {
            throw new IllegalArgumentException("Dane kontaktowe nie moga byc null!");
        }
        this.daneKontaktowe = daneKontaktowe;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " " + daneKontaktowe;
    }
}