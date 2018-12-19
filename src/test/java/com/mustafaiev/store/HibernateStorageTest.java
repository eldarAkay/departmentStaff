package com.mustafaiev.store;

import com.mustafaiev.models.Employee;
import junit.framework.TestCase;
import java.util.List;

public class HibernateStorageTest extends TestCase {

    public void testValues() throws Exception {
        HibernateStorage hs = new HibernateStorage();
        List<Employee> employees = (List<Employee>) hs.values();
    }
}