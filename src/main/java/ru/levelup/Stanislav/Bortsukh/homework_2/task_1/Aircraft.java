package ru.levelup.Stanislav.Bortsukh.homework_2.task_1;

public class Aircraft {
    protected int passengersCapacity;// количетсво пассажиров на борту
    protected int carryingCapacity;// грузоподъемность кг
    protected int distance; //дальность полета км
    protected String model;//модель летательного средства
    protected String productionYear;//год производства

    public Aircraft(int passengersCapacity, int carryingCapacity, int distance, String model, String productionYear) {
        this.passengersCapacity = passengersCapacity;
        this.carryingCapacity = carryingCapacity;
        this.distance = distance;
        this.model = model;
        this.productionYear = productionYear;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPassengersCapacity(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }
}
