package com.mustafaiev.store;

import com.mustafaiev.models.Employee;
import java.util.Collection;

public interface Storage {

    Collection<Employee> values();

    void add(final Employee employee);

    void edit(final Employee employee);

    void delete(final int id);

    Employee get(final int id);
}
