import java.util.*;

public class Talia {
        private Deque<Karta> karty;

        public Talia() {
            List<Karta> tempKarty = new ArrayList<>();
            List<String> figury = Arrays.asList("Dwójka", "Trójka", "Czwórka", "Piątka", "Szóstka", "Siódemka", "Ósemka", "Dziewiątka", "Dziesiątka", "Jopek", "Dama", "Król", "As");
            List<String> symbole = Arrays.asList("Serce", "Karo", "Trefl", "Pik");

            for (String figura : figury) {
                for (String symbol : symbole) {
                    tempKarty.add(new Karta(figura, symbol));
                }
            }
            Collections.shuffle(tempKarty);
            karty = new ArrayDeque<>(tempKarty);
        }
        public Karta pobierzKarte() {
                return karty.poll();
            }
        public void dodajKarty(List<Karta> wygraneKarty) {
            karty.addAll(wygraneKarty);
        }

        public int rozmiar() {
            return karty.size();
        }
}
