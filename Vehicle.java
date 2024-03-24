public class Vehicle implements Comparable<Vehicle> {
    String marka, model;
    ItemCondition stan;
    Double cena, przebieg, pojemnosc_silnika;
    Integer rok_produkcji,ilosc;
    public Vehicle(String marka, String model, ItemCondition stan, Double cena, Double przebieg, Double pojemnosc_silnika, Integer rok_produkcji){
        this.marka = marka;
        this.model = model;
        this.stan = stan;
        this.cena = cena;
        this.przebieg =przebieg;
        this.pojemnosc_silnika = pojemnosc_silnika;
        this.rok_produkcji = rok_produkcji;
        this.ilosc = 0;
        }

    public Vehicle(String marka, String model) {
        this.marka = marka;
        this.model = model;
    }

    public void print(){
        System.out.println("Marka:" + marka + ", Model: " + model + ", Stan: " + stan + ", Cena: " + cena + ", Przebieg: " + przebieg + ", Pojemność silnika: " + pojemnosc_silnika  + ", Rok produkcji: " + rok_produkcji +"\n");
    }
    public String getMarka() {
        return marka;
    }
    public String getModel() {
        return model;
    }
    public Integer getIlosc(){
        return ilosc;
    }
    public void setIlosc(Integer ilosc){
        this.ilosc  = ilosc;
    }
    public ItemCondition getStan(){
        return stan;
    }

    @Override
    public int compareTo(Vehicle other) {

        if (this.marka.compareTo(other.marka)!= 0) {
            return this.marka.compareTo(other.marka);
        }
        return this.model.compareTo(other.model);
    }
}
