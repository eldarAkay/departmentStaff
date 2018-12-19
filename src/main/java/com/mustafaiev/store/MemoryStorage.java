package com.mustafaiev.store;

import com.mustafaiev.models.Employee;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStorage implements Storage {
    private final ConcurrentHashMap<Integer, Employee> employees = new ConcurrentHashMap<Integer, Employee>();
    public Collection<Employee> values() {
        return this.employees.values();
    }

    public void add(final Employee employee) {
        this.employees.put(employee.getId(), employee);
    }

    public void edit(final Employee employee) {
        this.employees.replace(employee.getId(), employee);
    }

    public void delete(final int id) {
        this.employees.remove(id);
    }

    public Employee get(final int id) {
        return this.employees.get(id);
    }

}
