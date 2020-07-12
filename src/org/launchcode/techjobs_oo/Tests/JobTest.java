package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class JobTest {
    Job job1,job2,job3,job4;

    @Before
    public void initialize() {
       job1 = new Job("", new Employer("Launch"),new Location(""),new PositionType(""), new CoreCompetency(""));
       job2 = new Job("", new Employer(""),new Location(""),new PositionType(""), new CoreCompetency(""));
       job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId()
    {
        assertTrue(job1.getId() != job2.getId());
        assertTrue(job1.getId() + 1 == job2.getId());
    }

    @Test
    public  void testJobConstructorSetsAllFields()
    {
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality()
    {
        assertFalse(job3.equals(job4));
    }

    @Test
    public void toStringTestStartsAndEndWithBlankLine()
    {
        int length = 0;
        System.out.println(job4);
        assertTrue(job4.toString().substring(0,1).equals("\n"));
        length = job4.toString().length();
        assertTrue(job4.toString().substring(length-1,length).equals("\n"));
    }

    @Test
    public void toStringTestHasLabelForFields()
    {
        assertTrue(job4.toString().contains("ID: "));
        assertTrue(job4.toString().contains("Name: "));
        assertTrue(job4.toString().contains("Employer: "));
        assertTrue(job4.toString().contains("Location: "));
        assertTrue(job4.toString().contains("Position Type: "));
        assertTrue(job4.toString().contains("Core Competency: "));
    }

    @Test
    public void toStringAdviceNullFields()
    {
        assertTrue(job1.toString().contains("Name: Data not available"));
        assertFalse(job2.toString().contains("Employer: Data not available"));
        assertTrue(job1.toString().contains("Location: Data not available"));
        assertTrue(job1.toString().contains("Position Type: Data not available"));
        assertTrue(job1.toString().contains("Core Competency: Data not available"));
    }

    @Test
    public void toStringAdviceAllFieldsNull()
    {
        System.out.println(job2.toString());
        assertEquals(job2.toString(),"OOPS! This job does not seem to exist.");
    }

}
