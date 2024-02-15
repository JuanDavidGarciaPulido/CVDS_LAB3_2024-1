package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person("María", 15431, 20, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateInvalidAgeUnderAge() {
        Person person = new Person("Juan", 14856, 15,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertTrue(RegisterResult.VALID != result);
    }
    @Test
    public void validateInvalidAgeInvalid() {
        Person person = new Person("David", 149856, 1000,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validatePersonModification(){
        Person person = new Person("Arturo",1000713816,23,Gender.MALE,true);
        person.setName("Gabriela");
        person.setId(1011232400);
        person.setAge(24);
        person.setGender(Gender.FEMALE);
        person.setAlive(false);
        Assert.assertEquals(person.toString(),"Person [name=Gabriela, id=1011232400, age=24, gender=FEMALE, alive=false]");
    }
    @Test
    public void invalidateRegistry(){
        registry = new Registry();
        Person person1 = new Person("David",1000713816,22,Gender.MALE,true);
        Person person2 = new Person("Arturo",1000713816,22,Gender.MALE,true);
        Person person3 = new Person("Francisco",1000713817,17,Gender.MALE,true);
        Person person4 = new Person("Andrea",1000713818,0,Gender.FEMALE,true);
        Person person5 = new Person("Daniela",1000713819,170,Gender.FEMALE,true);
        Person person6 = new Person("Miguel",1000713810,25,Gender.MALE,false);
        RegisterResult result1 = registry.registerVoter(person1);
        RegisterResult result2 = registry.registerVoter(person2);
        RegisterResult result3 = registry.registerVoter(person3);
        RegisterResult result4 = registry.registerVoter(person4);
        RegisterResult result5 = registry.registerVoter(person5);
        RegisterResult result6 = registry.registerVoter(person6);
        Assert.assertEquals(RegisterResult.DUPLICATED,result2);
        Assert.assertEquals(RegisterResult.UNDERAGE,result3);
        Assert.assertEquals(RegisterResult.INVALID_AGE,result4);
        Assert.assertEquals(RegisterResult.INVALID_AGE,result5);
        Assert.assertEquals(RegisterResult.DEAD,result6);
    }

    @Test
    public void validateRegistry(){
        registry = new Registry();
        Person person1 = new Person("María",1000713816,22,Gender.FEMALE,true);
        Person person2 = new Person("José",1000713817,27,Gender.MALE,true);
        Person person3 = new Person("Juan",1000713818,19,Gender.MALE,true);
        RegisterResult result1 = registry.registerVoter(person1);
        RegisterResult result2 = registry.registerVoter(person2);
        RegisterResult result3 = registry.registerVoter(person3);
        Assert.assertEquals(RegisterResult.VALID,result1);
        Assert.assertEquals(RegisterResult.VALID,result2);
        Assert.assertEquals(RegisterResult.VALID,result3);
    }

    @Test
    public void validateRegistries(){
        registry = new Registry();
        Person person1 = new Person("Camilo",1000713816,22,Gender.MALE,true);
        Person person2 = new Person("Roberto",1000713817,27,Gender.MALE,true);
        Person person3 = new Person("Mateo",1000713818,19,Gender.MALE,true);
        registry.registerVoter(person2);
        registry.registerVoter(person1);
        registry.registerVoter(person3);
        Assert.assertEquals(registry.getVotersIds(),"1000713817 1000713816 1000713818");
    }

}