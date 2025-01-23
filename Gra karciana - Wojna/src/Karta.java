public class Karta {
    private String figura;
    private String symbol;

    public Karta(String figura, String symbol) {
        this.figura = figura;
        this.symbol = symbol;
    }

    public String getFigura() {
        return figura;
    }

    public String getSymbol() {
        return symbol;
    }
    public String toString() {
        return figura + " " + symbol;
    }
    public int getWartosc() {
        switch (figura) {
            case "Dwójka": return 2;
            case "Trójka": return 3;
            case "Czwórka": return 4;
            case "Piątka": return 5;
            case "Szóstka": return 6;
            case "Siódemka": return 7;
            case "Ósemka": return 8;
            case "Dziewiątka": return 9;
            case "Dziesiątka": return 10;
            case "Jopek": return 11;
            case "Dama": return 12;
            case "Król": return 13;
            case "As": return 14;
            default: return 0;
        }
    }
}
