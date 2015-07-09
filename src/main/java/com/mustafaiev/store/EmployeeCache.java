package com.mustafaiev.store;

import com.mustafaiev.models.Employee;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by user on 08.07.2015.
 */
public class EmployeeCache  {

    private static final EmployeeCache INSTANCE = new EmployeeCache();

    private final Storage storage = new MemoryStorage();

    public static EmployeeCache getInstance() {
        return INSTANCE;
    }

    public Collection<Employee> values() {
        return this.storage.values();
    }

    public void add(final Employee employee) {
        this.storage.add(employee);
    }

    public void edit(final Employee employee) {this.storage.edit(employee);}

    public void delete(final int id) {this.storage.delete(id);}

    public Employee get(final int id) {
        return this.storage.get(id);
    }

}
