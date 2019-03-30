package ru.levelup.Stanislav.Bortsukh.homework_2.task_1;

public class FuelType extends Aircraft {
    protected int tankCapacity;//емкость бака

    public FuelType(int passengersCapacity, int carryingCapacity, int distance, String model, String productionYear, int tankCapacity) {
        super(passengersCapacity, carryingCapacity, distance, model, productionYear);
        this.tankCapacity = tankCapacity;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
