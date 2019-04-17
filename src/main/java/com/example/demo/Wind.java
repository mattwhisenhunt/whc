package com.example.demo;

class Wind {
	private double speed;
	private double direction;

    public Wind(double speed, double direction) {
        setSpeed(speed);
        setDirection(direction);
    }

    public Wind() {
        setSpeed(0.0);
        setDirection(0.0);
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getDirection() {
        return direction;
    }
    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Wind{" + "speed='" + speed + '\'' + ", direction='" + direction + '\'' + '}';
    }
}
