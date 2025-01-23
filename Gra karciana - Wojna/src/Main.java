import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Talia talia = new Talia();
        Gracz gracz = new Gracz(false);
        Gracz przeciwnik = new Gracz(true);
        Thread.sleep(1600);
        System.out.println("Przeciwnik: " + przeciwnik.getImieNazwisko());
        Thread.sleep(1600);
        System.out.println("=======================");
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(1600);
        System.out.println("Wciśnij Enter, aby rozpocząć grę...");
        System.out.print("=======================");
        scanner.nextLine();
        boolean pierwszyRaz = true;

        while (gracz.getPunkty() < 26 && przeciwnik.getPunkty() < 26) {
            if (!pierwszyRaz) {
                Thread.sleep(1600);
                System.out.println("=======================");
                Thread.sleep(1600);
                System.out.println("Wciśnij Enter, aby przejść do kolejnej rundy...");
                System.out.print("=======================");
                scanner.nextLine();
            }
            pierwszyRaz = false;

            Karta kartaGracza = talia.pobierzKarte();
            Karta kartaPrzeciwnika = talia.pobierzKarte();

            if (kartaGracza == null || kartaPrzeciwnika == null) {
                Thread.sleep(1600);
                System.out.println("Talia się skończyła!");
                break;
            }
            Thread.sleep(1600);
            System.out.println("Karta przeciwnika: " + kartaPrzeciwnika);
            Thread.sleep(1600);
            System.out.println("Karta gracza: " + kartaGracza);

            int wynik = Integer.compare(kartaGracza.getWartosc(), kartaPrzeciwnika.getWartosc());
            if (wynik > 0) {
                Thread.sleep(1600);
                System.out.println("=======================");
                Thread.sleep(1600);
                System.out.println("Wygrywasz rundę!");
                gracz.dodajpunkty();
            } else if (wynik < 0) {
                Thread.sleep(1600);
                System.out.println("=======================");
                Thread.sleep(1600);
                System.out.println("Przeciwnik wygrywa rundę!");
                przeciwnik.dodajpunkty();
            } else {
                System.out.println("=======================");
                System.out.println("Wojna!");
                System.out.println("=======================");
                wojna(gracz, przeciwnik, talia);
            }
            Thread.sleep(1600);
            System.out.println("=======================");
            Thread.sleep(1600);
            System.out.println("Punkty: Gracz - " + gracz.getPunkty() + ", Przeciwnik - " + przeciwnik.getPunkty());
        }
        Thread.sleep(1600);
        System.out.println(gracz.getPunkty() > przeciwnik.getPunkty() ? "Gratulacje! Wygrałeś!" : "Niestety, przegrałeś.");
    }
    public static void wojna(Gracz gracz, Gracz przeciwnik, Talia talia) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("Zaczyna się wojna!");
        System.out.println("=======================");

        List<Karta> kartyGracza = new ArrayList<>();
        List<Karta> kartyPrzeciwnika = new ArrayList<>();

        Karta zakrytaKartaGracza = talia.pobierzKarte();
        Karta zakrytaKartaPrzeciwnika = talia.pobierzKarte();
        System.out.println("Zakryta karta przeciwnika: [zakryta]");
        System.out.println("Zakryta karta gracza: [zakryta]");
        System.out.println("=======================");
        Karta odkrytaKartaGracza = talia.pobierzKarte();
        Karta odkrytaKartaPrzeciwnika = talia.pobierzKarte();

        System.out.println("Odkryta karta przeciwnika: " + odkrytaKartaGracza);
        System.out.println("Odkryta karta gracza " + odkrytaKartaPrzeciwnika);
        System.out.println("=======================");

        kartyGracza.add(zakrytaKartaGracza);
        kartyPrzeciwnika.add(zakrytaKartaPrzeciwnika);

        kartyGracza.add(odkrytaKartaGracza);
        kartyPrzeciwnika.add(odkrytaKartaPrzeciwnika);

        int wynikWojny = Integer.compare(odkrytaKartaGracza.getWartosc(), odkrytaKartaPrzeciwnika.getWartosc());

        while (wynikWojny == 0 && talia.rozmiar() > 2) {
            System.out.println("Wojna trwa!");

            zakrytaKartaGracza = talia.pobierzKarte();
            zakrytaKartaPrzeciwnika = talia.pobierzKarte();

            if (zakrytaKartaGracza == null || zakrytaKartaPrzeciwnika == null) {
                System.out.println("Brak kart do kontynuowania wojny. Nastaje pokój!");
                break;
            }
            Thread.sleep(1600);
            System.out.println("Zakryta karta przeciwnika: [zakryta]");
            Thread.sleep(1600);
            System.out.println("Zakryta karta gracza: [zakryta]");
            Thread.sleep(1600);

            kartyGracza.add(zakrytaKartaGracza);
            kartyPrzeciwnika.add(zakrytaKartaPrzeciwnika);

            odkrytaKartaGracza = talia.pobierzKarte();
            odkrytaKartaPrzeciwnika = talia.pobierzKarte();

            if (odkrytaKartaGracza == null || odkrytaKartaPrzeciwnika == null) {
                Thread.sleep(1600);
                System.out.println("Brak kart do kontynuowania wojny. Nastaje pokój!");
                break;
            }
            Thread.sleep(1600);
            System.out.println("Odkryta karta przeciwnika: " + odkrytaKartaGracza);
            Thread.sleep(1600);
            System.out.println("Odkryta karta gracza: " + odkrytaKartaPrzeciwnika);
            Thread.sleep(1600);

            kartyGracza.add(odkrytaKartaGracza);
            kartyPrzeciwnika.add(odkrytaKartaPrzeciwnika);

            wynikWojny = Integer.compare(odkrytaKartaGracza.getWartosc(), odkrytaKartaPrzeciwnika.getWartosc());
        }
            if (wynikWojny > 0) {
                Thread.sleep(1600);
                System.out.println("Gracz wygrywa wojnę!");
                Thread.sleep(1600);
                gracz.dodajpunkty();
                gracz.dodajZdobyteKarty(kartyGracza);
                gracz.dodajZdobyteKarty(kartyPrzeciwnika);
            } else if (wynikWojny < 0) {
                Thread.sleep(1600);
                System.out.println("Przeciwnik wygrywa wojnę!");
                Thread.sleep(1600);
                przeciwnik.dodajpunkty();
                przeciwnik.dodajZdobyteKarty(kartyGracza);
                przeciwnik.dodajZdobyteKarty(kartyPrzeciwnika);
            } else {
                Thread.sleep(1600);
                System.out.println("Koniec wojny! Nastaje pokój!");
                Thread.sleep(1600);
            }
        }
    }
