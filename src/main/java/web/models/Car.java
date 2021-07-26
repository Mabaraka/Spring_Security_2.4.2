package web.models;

public class Car {
    private int id;
    private int maxSpeed;
    private int maxDistance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Car(int id, int maxSpeed, int maxDistance) {
        this.id = id;
        this.maxSpeed = maxSpeed;
        this.maxDistance = maxDistance;
    }
}
