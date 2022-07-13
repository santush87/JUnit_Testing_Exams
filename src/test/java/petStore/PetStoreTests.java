package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PetStoreTests {
    PetStore petStore;

    @Before
    public void setup(){
        Animal animal2 = new Animal("Cat", 5, 12);
        petStore = new PetStore();
    }
    @Test
    public void testAddAnimalsCorrect(){
        Animal animal = new Animal("Dog", 15, 20);
        petStore.addAnimal(animal);
        Assert.assertEquals(1, petStore.getCount());
        Animal animal1 = new Animal("Dog2", 10, 30);
        petStore.addAnimal(animal1);
        Assert.assertEquals(2, petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalsThrow(){
        Animal animal = null;
        petStore.addAnimal(animal);
    }

    @Test
    public void testFindAllAnimalsWithMaxKilograms(){
        Animal animal2 = new Animal("Cat", 5, 12);
        Animal animal1 = new Animal("Dog2", 10, 30);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        Assert.assertEquals(2, petStore.findAllAnimalsWithMaxKilograms(4).size());
        Assert.assertEquals(1, petStore.findAllAnimalsWithMaxKilograms(6).size());
    }

    @Test
    public void testGetTheMostExpensiveAnimal(){
        Animal animal2 = new Animal("Cat", 5, 12);
        Animal animal1 = new Animal("Dog2", 10, 30);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        Animal mostExp = petStore.getTheMostExpensiveAnimal();
        Assert.assertEquals(animal1.getSpecie(), mostExp.getSpecie());
        Assert.assertEquals(animal1.getMaxKilograms(), mostExp.getMaxKilograms());
    }

    @Test
    public void testFindAllAnimalBySpecie(){
        Animal animal2 = new Animal("Cat", 5, 12);
        Animal animal3 = new Animal("Cat", 6, 13);
        Animal animal1 = new Animal("Dog", 10, 30);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(petStore.findAllAnimalBySpecie("Cat").size(),2);
        Assert.assertEquals(petStore.findAllAnimalBySpecie("Dog").size(),1);
    }

    @Test
    public void testGetAnimals(){
        Animal animal2 = new Animal("Cat", 5, 12);
        Animal animal3 = new Animal("Cat", 6, 13);
        Animal animal1 = new Animal("Dog", 10, 30);
        PetStore testStore = new PetStore();
        testStore.addAnimal(animal1);
        testStore.addAnimal(animal2);
        testStore.addAnimal(animal3);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(petStore.getAnimals(), testStore.getAnimals());
    }
}

