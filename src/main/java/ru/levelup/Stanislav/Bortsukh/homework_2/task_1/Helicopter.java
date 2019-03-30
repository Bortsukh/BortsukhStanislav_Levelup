package ru.levelup.Stanislav.Bortsukh.homework_2.task_1;

public class Helicopter extends FuelType {
    public Helicopter(int passengersCapacity, int carryingCapacity, int distance, String model, String productionYear, int tankCapacity) {
        super(passengersCapacity, carryingCapacity, distance, model, productionYear, tankCapacity);
    }
    @Override
    public String toString() {
        return "Количество пассажиров на борту " + this.passengersCapacity + " Грузоподъемность " + this.carryingCapacity + " Модель " + this.model + " Год производства " + this.productionYear + " Объем бака " + this.tankCapacity + " ";
    }
}
