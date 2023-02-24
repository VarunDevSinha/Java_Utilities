package com.utilities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class pojoTest extends pojo {

    @Test
    public void TestPojoGetSet() {

        System.out.println(getEmpId());
        System.out.println(getName());
        System.out.println(getGrade());
        System.out.println(getDepartment());
        System.out.println(getSalary());
    }

    @BeforeAll
    public static void setterTest() {

        setEmpId("TM23784");
        setName("Varun Dev Sinha");
        setGrade("C1");
        setDepartment("BFSI IT");
        setSalary(540000);
    }
}
