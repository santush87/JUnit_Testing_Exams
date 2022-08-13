package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private Cat cat;
    private Cat cat2;
    private House house;

    @Before
    public void setup(){
        cat = new Cat("Mira");
        cat2 = new Cat("Tom");
        house = new House("White", 2);
    }

    @Test
    public void testAddingCatToHouse(){
        Assert.assertEquals(0, house.getCount());
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
        house.addCat(cat2);
        Assert.assertEquals(2, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatToHouseThrow(){
        Cat cat3 = new Cat("Kot");
        house.addCat(cat);
        house.addCat(cat2);
        house.addCat(cat3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapasityBelowZeroThrow(){
        House house1 = new House("house", -1);
    }

    @Test
    public void testGetCapacity(){
        Assert.assertEquals(2, house.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testHouseNameNullThrows(){
        House house1 = new House(" ", 2);
    }

    @Test
    public void testRemoveCat(){
        house.addCat(cat);
        house.addCat(cat2);
        Assert.assertEquals(2, house.getCount());
        house.removeCat("Mira");
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatThrows(){
        house.removeCat("sdad");
    }

    @Test
    public void testCatForSale(){
        house.addCat(cat);
        house.addCat(cat2);

        Cat catSale = house.catForSale("Mira");
        Assert.assertEquals("Mira", catSale.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleThrow(){
        house.catForSale("dadfsd");
    }

    @Test
    public void testStatistics(){
        house.addCat(cat);
        Assert.assertEquals("The cat Mira is in the house White!", house.statistics());
        house.addCat(cat2);
        Assert.assertEquals("The cat Mira, Tom is in the house White!", house.statistics());
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("White", house.getName());
    }
}
