import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;

public class Gracz {
    private String imie;
    private String nazwisko;
    private List<Karta> zdobyteKarty;
    private int dodajpunkty;

    public Gracz(boolean isKobieta) {
        Random random = new Random();
        List<String> MeskieNazwisko = Arrays.asList("Wójcik", "Kowalczyk", "Nowak", "Zieliński", "Zatka", "Kamiński");
        List<String> ZenskieNazwisko = Arrays.asList("Wójcik", "Wiśniewska", "Nowacka", "Zielińska", "Zatka", "Kamińska");
        List<String> MeskieImie = Arrays.asList("Jan", "Wojciech", "Krystian", "Igor", "Konrad");
        List<String> ZenskieImie = Arrays.asList("Agnieszka", "Wiktoria", "Magda", "Lidia", "Monika");

        this.imie = isKobieta ? ZenskieImie.get(random.nextInt(ZenskieImie.size())) : MeskieImie.get(random.nextInt(MeskieImie.size()));
        this.nazwisko = isKobieta ? ZenskieNazwisko.get(random.nextInt(ZenskieNazwisko.size())) : MeskieNazwisko.get(random.nextInt(MeskieNazwisko.size()));

        this.zdobyteKarty = new LinkedList<>();
        this.dodajpunkty = 0;
    }
    public void dodajpunkty() {
        this.dodajpunkty++;
    }

    public void dodajZdobyteKarty(List<Karta> karty) {
        zdobyteKarty.addAll(karty);
    }

    public int getPunkty() {
        return dodajpunkty;
    }
    public void setPunkty(int punkty) {
        this.dodajpunkty = punkty;
    }
    public String getImieNazwisko() {
        return imie + " " + nazwisko;
    }
    public List<Karta> getZdobyteKarty() {
        return zdobyteKarty;
    }
}
