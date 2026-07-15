import java.io.Serializable;

public class DaneKontaktowe implements Serializable {
    private String numerTelefonu;
    private String email;

    public DaneKontaktowe(String numerTelefonu, String email) {
        setNumerTelefonu(numerTelefonu);
        setEmail(email);
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        if (numerTelefonu == null || numerTelefonu.isBlank()) {
            throw new IllegalArgumentException("Numer telefonu nie moze byc pusty!");
        }
        this.numerTelefonu = numerTelefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email nie moze byc pusty!");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "telefon=" + numerTelefonu + ", email=" + email;
    }
}