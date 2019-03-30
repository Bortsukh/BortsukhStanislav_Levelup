package ru.levelup.Stanislav.Bortsukh.homework_2.task_1;

public class Quadcopter extends ElectricalType {
    public Quadcopter(int passengersCapacity, int carryingCapacity, int distance, String model, String productionYear, int batteryCapacity) {
        super(passengersCapacity, carryingCapacity, distance, model, productionYear, batteryCapacity);
    }
    @Override
    public String toString() {
        return "Количество пассажиров на борту " + this.passengersCapacity + " Грузоподъемность " + this.carryingCapacity + " Модель " + this.model + " Год производства " + this.productionYear + " Объем бака " + this.batteryCapacity + " ";
    }
}
