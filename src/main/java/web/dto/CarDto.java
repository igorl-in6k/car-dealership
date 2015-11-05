package web.dto;

import core.entity.Car;

/**
 * Created by employee on 11/5/15.
 */
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
