package edu.eci.cvds.tdd.registry;
public class Registry {
    public RegisterResult registerVoter(Person p) {
        RegisterResult validation = RegisterResult.VALID;
        if(p.getAge() == 0 || p.getAge() > 120){
            validation = RegisterResult.INVALID_AGE;
        } else if (p.getAge() < 18) {
            validation = RegisterResult.UNDERAGE;
        } else if (!p.isAlive()) {
            validation = RegisterResult.DEAD;
        }
        return validation;
    }
}
