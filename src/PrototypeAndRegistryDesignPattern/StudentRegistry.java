package PrototypeAndRegistryDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {

    private Map<String, Prototype<Student>> registry;

    public StudentRegistry() {
        this.registry = new HashMap<>();
    }

    public Prototype<Student> addRegistry(String name, Prototype<Student> p) {
        registry.put(name, p);
        return p;
    }

    public Prototype<Student> getPrototype(String name) {
        return registry.get(name);
    }

}
