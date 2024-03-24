import java.util.*;
import java.util.stream.Collectors;

public class CarShowroom {
    String nazwaSalonu;
    Integer maksymalna_poj_salonu;
    private List<Vehicle> listaSamochodow;

    public CarShowroom(String nazwa_salonu, Integer maksymalna_poj_salonu){
        listaSamochodow = new ArrayList<>();
        this.nazwaSalonu = nazwa_salonu;
        this.maksymalna_poj_salonu = maksymalna_poj_salonu;
    }
    public void addProduct(Vehicle vehicle){
    boolean istnieje = false;
    for(Vehicle v : listaSamochodow){
        if(v.getMarka().equals(vehicle.getMarka()) && v.getModel().equals(vehicle.getModel())){
            v.setIlosc(v.getIlosc() + 1);
            istnieje = true;
            break;
        }
        }
        if(!istnieje){
            if(listaSamochodow.size()< maksymalna_poj_salonu){
                vehicle.setIlosc(1);
                listaSamochodow.add(vehicle);
            }else{
                System.err.println("Nie ma miejsca w salonie");
            }
        }
    }
    public void getProduct(Vehicle vehicle){
        boolean istnieje = false;
        for (Vehicle v : listaSamochodow) {
            int ilosc = v.getIlosc();
            if (ilosc > 1) {
                v.setIlosc(ilosc - 1);
            }else {
                listaSamochodow.remove(v);
            }
            istnieje = true;
            break;
        }
        if (!istnieje) {
            System.err.println("Pojazd nie istnieje w salonie.");
        }

    }
    public void removeProduct(Vehicle vehicle){
        boolean istnieje = false;
        for(Vehicle v : listaSamochodow){
            if(v.equals(vehicle)) {
                listaSamochodow.remove(v);
                System.out.println("usunieto pojazd");
            }
                istnieje = true;
                break;
        }
        if(istnieje){
            System.err.println("Nie ma takiego pojazdu");
        }
    }
    public Vehicle search(String marka, String model){
        Comparator<Vehicle> comparator = (v1, v2) -> {
            String marka1 = v1.getMarka().toLowerCase();
            String marka2 = v2.getMarka().toLowerCase();
            String model1 = v1.getModel().toLowerCase();
            String model2 = v2.getModel().toLowerCase();
            if(marka1.equals(marka) && model1.equals(model)){
                return 0;
            }else{
                return marka1.compareTo(marka2) != 0 ? marka1.compareTo(marka2) : model1.compareTo(model2);
            }
        };
        int index = Collections.binarySearch(listaSamochodow, new Vehicle(marka, model), comparator);

       if(index >= 0){
           return listaSamochodow.get(index);
       }else{
           return null;
       }
    }
    public List<Vehicle> searchPartial(String fragment){
        Comparator<Vehicle> comparator = (v1, v2) -> {
            String marka1 = v1.getMarka().toLowerCase();
            String marka2 = v2.getMarka().toLowerCase();
            String model1 = v1.getModel().toLowerCase();
            String model2 = v2.getModel().toLowerCase();
            if(marka1.contains(fragment) || model1.contains(fragment)){
                return -1;
            } else if (marka2.contains(fragment) || model2.contains(fragment)) {
                return 1;
            } else{
                return 0;
            }
        };
        return  listaSamochodow.stream().filter(v -> comparator.compare(v, new Vehicle("", fragment)) != 0).collect(Collectors.toList());
    }
    public Integer countByCondition(ItemCondition x){
        int count = 0;
        for(Vehicle v : listaSamochodow){
            if(v.getStan() == x){
                count++;
            }
        }
        return count;
    }
    public String summary() {
        StringBuilder summaryBuilder = new StringBuilder();
        summaryBuilder.append("Podsumowanie salonu: ").append(nazwaSalonu).append("\n");
        summaryBuilder.append("Liczba pojazdów w salonie: ").append(listaSamochodow.size()).append("\n");

        if (!listaSamochodow.isEmpty()) {
            sortByName();
            summaryBuilder.append("Największa ilość dostępnych egzemplarzy jednego modelu: ").append(max().getIlosc()).append("\n");
            summaryBuilder.append("Pojazdy w salonie (posortowane alfabetycznie):\n");
            for (Vehicle vehicle : listaSamochodow) {
                summaryBuilder.append(vehicle).append("\n");
            }
        } else {
            summaryBuilder.append("Brak pojazdów w salonie\n");
        }

        return summaryBuilder.toString();
    }
    public void sortByName(){
        listaSamochodow.sort(Comparator.comparing(Vehicle::getMarka));
    }

    public void sortByAmount(){
        listaSamochodow.sort(Comparator.comparingInt(Vehicle::getIlosc).reversed());

    }
    public Vehicle max(){
        return Collections.max(listaSamochodow, Comparator.comparingInt(Vehicle::getIlosc));

    }

    public Map<Object, Object> getListaSamochodow() {
        Map<Object, Object> mapaSamochodow = new HashMap<>();
         for (int i = 0; i < listaSamochodow.size(); i++) {
             mapaSamochodow.put(i, listaSamochodow.get(i));
         }
         return mapaSamochodow;
    }

    public int getMaksymalnaPojemnosc() {
        return maksymalna_poj_salonu;
    }
}
