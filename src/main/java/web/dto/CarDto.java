package web.dto;

import core.entity.Car;

public class CarDto extends Car {
    int brandId;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public Car toCar() {
        return new Car(getBrand(), getModel(), getPrice());
    }
}
