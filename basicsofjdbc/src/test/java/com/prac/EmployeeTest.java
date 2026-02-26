package com.prac;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeTest {

    @Test
    public void testValidAge() {
        Employee e = new Employee(10, "anshuman", 20, "CSE");
        assertTrue(e.isValidAge());
    }
    
    @Test
    public void testValidName() {
    	  Employee e = new Employee(10, "anshum@n", 20, "CSE");
    	  assertTrue(e.isValidName());
    }
}
