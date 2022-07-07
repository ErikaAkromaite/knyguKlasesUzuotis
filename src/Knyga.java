public class Knyga
{
    private String isbn;
    private String pavadinimas;
    private String autorius;
    private int leidimoMetai;
    private String leidėjas;
    private String salis;
    private double kaina;


    public Knyga(String isbn, String pavadinimas, String autorius, int leidimoMetai, String leidėjas, String salis, Double kaina) {
        this.isbn = isbn;
        this.pavadinimas = pavadinimas;
        this.autorius = autorius;
        this.leidimoMetai = leidimoMetai;
        this.leidėjas = leidėjas;
        this.salis = salis;
        this.kaina = kaina;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getAutorius() {
        return autorius;
    }

    public void setAutorius(String autorius) {
        this.autorius = autorius;
    }

    public int getLeidimoMetai() {
        return leidimoMetai;
    }

    public void setLeidimoMetai(int leidimoMetai) {
        this.leidimoMetai = leidimoMetai;
    }

    public String getLeidėjas() {
        return leidėjas;
    }

    public void setLeidėjas(String leidėjas) {
        this.leidėjas = leidėjas;
    }

    public String getSalis() {
        return salis;
    }

    public void setSalis(String salis) {
        this.salis = salis;
    }

    public Double getKaina() {
        return kaina;
    }

    public void setKaina(Double kaina) {
        this.kaina = kaina;
    }

    @Override
    public String toString() {
        return "knyga{" +
                "isbn='" + isbn + '\'' +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", autorius='" + autorius + '\'' +
                ", leidimoMetai=" + leidimoMetai +
                ", leidėjas='" + leidėjas + '\'' +
                ", salis='" + salis + '\'' +
                ", kaina=" + kaina +
                '}';
    }
}
