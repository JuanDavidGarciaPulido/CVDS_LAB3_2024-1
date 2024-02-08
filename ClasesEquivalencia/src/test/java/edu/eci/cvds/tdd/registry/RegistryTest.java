package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person();
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    // TODO Complete with more test cases

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


}