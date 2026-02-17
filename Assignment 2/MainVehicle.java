import java.time.Year;

public class MainVehicle{
    public static void main(String[] a){
        Vehicle v = new Vehicle(); 
        v.setMfgCode("HYU2023CRTA");
        v.setNoOfServices(1);

        Vehicle v1 = new Vehicle("Toyota", "Fortuner", Year.of(2024), "Black", 3200000.00);
        v1.setMfgCode("TYT2024FRTN");
        v1.setNoOfServices(4);

        Vehicle v2 = new Vehicle(6, 2750000.50, 'P', "HND2022CIVC", 2);

        int newSp = v.accelerate(20);
        System.out.println("New Speed: " + newSp);


        Vehicle[] garage = new Vehicle[3];
        garage[0] = v;
        garage[1] = v1;
        garage[2] = v2;
        System.out.printf("%-10s %-12s %-6s %-8s %-5s %-6s %-12s %-8s %-12s %-9s\n", "Brand", "Model", "Year", "Color", "Fuel", "Seats", "Price", "Mileage", "MfgCode", "Services");
        for(int i = 0; i < garage.length; i++){
            garage[i].accelerate(20);
            
            if (garage[i].fuelType == 'D'){
                float m = garage[i].calcMileage(50, 500);
                printTabular(garage[i], m );
        
            }
            if (garage[i].fuelType == 'P' || garage[i].fuelType == 'C'){
                float m = garage[i].calcMileage(40, 500);
                printTabular(garage[i], m );
    
            }
            else{
                float m = 0;
                printTabular(garage[i], m );
            }
        } 
    }

    public static void printTabular(Vehicle v, float m){
        System.out.printf(
            "%-10s %-12s %-6s %-8s %-5s %-6d %-12.2f %-8.2f %-12s %-9d\n",
            v.brand != null ? v.brand : "-",
            v.model != null ? v.model : "-",
            v.yearofMfg != null ? v.yearofMfg : "-",
            v.color != null ? v.color : "-",
            v.fuelType != '\0' ? v.fuelType : '-',
            v.seats,
            v.price,
            m,
            v.getMfgCode() != null ? v.getMfgCode() : "-",
            v.getNoOfServices()
        );
    }
    }