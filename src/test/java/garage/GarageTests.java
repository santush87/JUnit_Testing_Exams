package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GarageTests {
    private Garage garage;
    private Car audi;
    private Car bmw;
    private Car mercedes;

    @Before
    public void setup(){
        audi = new Car("Audi", 280, 30000);
        bmw = new Car("BMW", 260, 25000);
        mercedes = new Car("Mercedes", 300, 32000);
        garage = new Garage();
    }

    @Test
    public void testAddCar(){
        Assert.assertEquals(0, garage.getCount());
        garage.addCar(audi);
        Assert.assertEquals(1, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarThrow(){
        Car car = null;
        garage.addCar(car);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove(){
        garage.addCar(audi);
        garage.addCar(bmw);
        garage.addCar(mercedes);
        Assert.assertEquals(1,garage.findAllCarsWithMaxSpeedAbove(290).size());
        Assert.assertEquals(2,garage.findAllCarsWithMaxSpeedAbove(270).size());
        Assert.assertEquals(3,garage.findAllCarsWithMaxSpeedAbove(250).size());
    }

    @Test
    public void testGetTheMostExpensiveCar(){
        garage.addCar(audi);
        garage.addCar(bmw);
        garage.addCar(mercedes);
        Assert.assertEquals(mercedes, garage.getTheMostExpensiveCar());
    }

    @Test
    public void testFindAllCarsByBrand(){
        garage.addCar(audi);
        garage.addCar(bmw);
        garage.addCar(mercedes);
        Assert.assertEquals(1, garage.findAllCarsByBrand("Mercedes").size());
        Assert.assertEquals(1, garage.findAllCarsByBrand("BMW").size());
        Assert.assertEquals(1, garage.findAllCarsByBrand("Audi").size());
        Assert.assertEquals(0, garage.findAllCarsByBrand("Skoda").size());
    }

    @Test
    public void testGetCars(){
        garage.addCar(audi);
        Assert.assertEquals(1, garage.getCars().size());
        garage.addCar(bmw);
        Assert.assertEquals(2, garage.getCars().size());
        garage.addCar(mercedes);
        Assert.assertEquals(3, garage.getCars().size());


    }
}