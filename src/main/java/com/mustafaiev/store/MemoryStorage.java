package com.mustafaiev.store;

import com.mustafaiev.models.Employee;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 08.07.2015.
 */
public class MemoryStorage implements Storage {

    private final ConcurrentHashMap<Integer, Employee> employees = new ConcurrentHashMap<Integer, Employee>();

   // @Override
    public Collection<Employee> values() {
        return this.employees.values();
    }

   // @Override
    public void add(final Employee employee) {this.employees.put(employee.getId(), employee);}

   // @Override
    public void edit(final Employee employee) {
        this.employees.replace(employee.getId(), employee);
    }

   // @Override
    public void delete(final int id) {
        this.employees.remove(id);
    }

   // @Override
    public Employee get(final int id) {
        return this.employees.get(id);
    }


}
