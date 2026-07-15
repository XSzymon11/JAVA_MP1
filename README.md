# MP1 – schronisko dla zwierząt

Prosty projekt w Javie przygotowany na przedmiot MAS. Modeluje zwierzęta w schronisku, psy, ich właścicieli oraz dane kontaktowe. Projekt prezentuje konstrukcje wymagane w MP1.

## Zaimplementowane konstrukcje

- ekstensja klasy `Zwierze` oraz licznik utworzonych obiektów,
- trwałość ekstensji przez serializację do pliku,
- atrybut złożony: `DaneKontaktowe` właściciela,
- atrybut opcjonalny: `opis` zwierzęcia,
- atrybut powtarzalny: lista `szczepienia`,
- atrybut klasowy: `nazwaSchroniska`,
- atrybut pochodny: wiek obliczany przez `getWiek()`,
- ograniczenie unikalności numeru chipa,
- przeciążenie metody `addSzczepienie(...)`,
- przesłonięcie metody `toString()`,
- dziedziczenie: `Pies` rozszerza klasę `Zwierze`,
- walidacja danych w setterach.

## Struktura

- `Zwierze` – klasa bazowa, wspólne dane zwierzęcia i obsługa ekstensji.
- `Pies` – specjalizacja zwierzęcia, przechowuje numer chipa i właściciela.
- `Wlasciciel` – dane właściciela psa.
- `DaneKontaktowe` – numer telefonu i adres e-mail właściciela.
- `Main` – przykłady użycia wszystkich konstrukcji.

## Uruchomienie

Wymagana jest Java 17 lub nowsza. Z katalogu głównego projektu:

```powershell
javac -encoding UTF-8 -d out src/DaneKontaktowe.java src/Wlasciciel.java src/Zwierze.java src/Pies.java src/Main.java
java -cp out Main
```

Program tworzy plik `schronisko.txt`, w którym zapisuje ekstensję zwierząt, a następnie ją odczytuje.
