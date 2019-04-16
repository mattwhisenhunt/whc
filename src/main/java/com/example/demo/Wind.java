package com.example.demo;

class Wind {
	private Double speed;
	private Double direction;

    public Wind(Double speed, Double direction) {
        setSpeed(speed);
        setDirection(direction);
    }

    public Wind() {
        setSpeed(0.0);
        setDirection(0.0);
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public void setDirection(Double direction) {
        this.direction = direction;
    }

    public Double getDirection() {
        return direction;
    }
    public Double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Book{" + "speed='" + speed + '\'' + ", direction='" + direction + '\'' + '}';
    }
}
