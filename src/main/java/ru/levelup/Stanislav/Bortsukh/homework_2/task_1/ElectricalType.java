package ru.levelup.Stanislav.Bortsukh.homework_2.task_1;

public class ElectricalType extends Aircraft {
    protected int batteryCapacity;//емкость батареи тыс mA;

    public ElectricalType(int passengersCapacity, int carryingCapacity, int distance, String model, String productionYear, int batteryCapacity) {
        super(passengersCapacity, carryingCapacity, distance, model, productionYear);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
