package ru.levelup.Stanislav.Bortsukh.homework_2.task_1;

import java.sql.SQLOutput;
import java.util.*;

public class Airline {
    public static void main(String[] args) {
        List<Jet> jets = new ArrayList<>();
        List<Helicopter> helicopters = new ArrayList<>();
        List<Quadcopter> quadcopters = new ArrayList<>();
        //создание авиапарка
        jets.add(new Jet(6, 1000,1500,"gulfstream G300" , "2015", 1500 ));
        jets.add(new Jet(10, 1500,3000,"gulfstream G500" , "2015", 1500 ));
        helicopters.add(new Helicopter(20, 2000, 900, "Mi-8", "1995", 800));
        helicopters.add(new Helicopter(15,800, 400, "Eurocopter", "1995", 900 ));
        quadcopters.add(new Quadcopter(0,1,2,"symas","2015", 2000));
        quadcopters.add(new Quadcopter(0, 2, 4, "symas ultra", "2017", 4000));
        //посчитаем вместимомсть и грузоподъемность авиапарка с помощью методов
        int sumPassengers = 0;
        sumPassengers += passengersCapacityForType(jets);
        sumPassengers += passengersCapacityForType(helicopters);
        sumPassengers += passengersCapacityForType(quadcopters);
        System.out.println("Общая вместимость авиапарка:"+ sumPassengers + "пассажир");
        int sumCarrying = 0;
        sumCarrying += carryingCapacityForType(jets);
        sumCarrying += carryingCapacityForType(helicopters);
        sumCarrying += carryingCapacityForType(quadcopters);
        System.out.println("Общая грузоподъемность авиапарка:"+ sumCarrying +" кг");
        //создадим список всех воздушных средств
        List<Aircraft> allAircrafts = new ArrayList<>();
        allAircrafts.addAll(jets);
        allAircrafts.addAll(helicopters);
        allAircrafts.addAll(quadcopters);
        System.out.println(allAircrafts);
        //сортировка по дистанции полета:
        //System.out.println(allAircrafts.sort(Comparator.comparing(Aircraft::getDistance)));
        System.out.println("Сортировка аппаратов по дистанции полета:");
        SortedByDsitance(allAircrafts);
        //найти самолет удовлетворяющий условиям выбора:
        System.out.println("Вам подходит следующий самолет:");
        System.out.println(GoodChoice(jets, 1,7));
    }

    public static int passengersCapacityForType(List<? extends Aircraft> aircrafts){
        int quantityOfPassengers = 0;
        for(Aircraft item: aircrafts){
            quantityOfPassengers += item.getPassengersCapacity();
        }
        return quantityOfPassengers;
    }

    public static int carryingCapacityForType(List<? extends Aircraft> aircrafts){
        int carrying = 0;
        for(Aircraft item: aircrafts){
            carrying += item.getCarryingCapacity();
        }
        return carrying;
    }

    private static void SortedByDsitance (List<Aircraft> items) {
        for (int i = items.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (items.get(j).getDistance() < items.get(j + 1).getDistance()) {
                    items.add(j, items.get(j + 1));
                    items.remove(j + 2);
                }
            }
        }
        for (Aircraft aircraft: items) {
            System.out.println(aircraft);
        }
    }
    private static List<Jet> GoodChoice(List<Jet> items, int minPassangers, int maxPassangers){
        List<Jet> result = new ArrayList<>();
        for (Jet craft: items){
            if(craft.getPassengersCapacity()< maxPassangers && craft.getPassengersCapacity()>minPassangers){
                result.add(craft);
            }
        }
        return result;
    }

}
