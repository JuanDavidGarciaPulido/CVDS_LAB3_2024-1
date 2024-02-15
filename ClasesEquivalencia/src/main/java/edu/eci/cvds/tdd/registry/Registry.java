package edu.eci.cvds.tdd.registry;

import java.util.HashSet;
import java.util.Set;

public class Registry {
    private Set<Integer> registeredVotersIds = new HashSet<>();

    public RegisterResult registerVoter(Person p) {
        RegisterResult valid = RegisterResult.VALID;
        if (registeredVotersIds.contains(p.getId())) {
            valid = RegisterResult.DUPLICATED;
        } else if (p.getAge() == 0 || p.getAge() > 150) {
            valid = RegisterResult.INVALID_AGE;
        } else if (p.getAge() < 18) {
            valid = RegisterResult.UNDERAGE;
        } else if (!p.isAlive()) {
            valid = RegisterResult.DEAD;
        } else {
            registeredVotersIds.add(p.getId());
        }
        return valid;
    }

    public String getVotersIds() {
        StringBuilder voterIds = new StringBuilder();
        for (Integer id : registeredVotersIds) {
            voterIds.append(id).append(" ");
        }
        return voterIds.toString().trim();
    }
}

