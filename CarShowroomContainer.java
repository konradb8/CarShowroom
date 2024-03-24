import java.util.Map;
import java.util.*;
public class CarShowroomContainer {
    Map<String,CarShowroom> salony;

    public CarShowroomContainer() {
        this.salony = new HashMap<>();
    }

    public void addCenter(String name, double pojemnosc){
        if(!salony.containsKey(name)){
            salony.put(name, new CarShowroom(name, (int) pojemnosc));
            System.out.println("Dodano salon: " + name);
        }else{
            System.err.println("Salon o nazwie " + name + " już istnieje");
        }
    }
    public void removeCenter(String name){
        if (salony.containsKey(name)) {
            salony.remove(name);
            System.out.println("Salon o nazwie: " + name + " został usunięty");
        }else{
            System.err.println("Salon o nazwie " + name + "nie istnieje");
        }
    }
    public List<String> findEmpty() {
        List<String> pusteSalony = new ArrayList<>();
        for (Map.Entry<String, CarShowroom> entry : salony.entrySet()) {
            if (entry.getValue().getListaSamochodow().isEmpty()) {
                pusteSalony.add(entry.getKey());
            }
        }
        return pusteSalony;
    }


    public void summary() {
        for (Map.Entry<String, CarShowroom> entry : salony.entrySet()) {
            String nazwaSalonu = entry.getKey();
            CarShowroom salon = entry.getValue();
            double zapelnienie = ((double) salon.getListaSamochodow().size() / salon.getMaksymalnaPojemnosc()) * 100;
            System.out.println("Nazwa salonu: " + nazwaSalonu + ", Procentowe zapełnienie: " + zapelnienie + "%");
        }
    }
}
