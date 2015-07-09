package com.mustafaiev.store;

import com.mustafaiev.models.Employee;

import java.util.Collection;

/**
 * Created by user on 08.07.2015.
 */
public interface Storage {

    public Collection<Employee> values();

    public void add(final Employee employee);

    public void edit(final Employee employee);

    public void delete(final int id);

    public Employee get(final int id);

}
