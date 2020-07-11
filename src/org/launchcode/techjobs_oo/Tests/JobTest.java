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
       job2 = new Job("", new Employer("Launch"),new Location(""),new PositionType(""), new CoreCompetency(""));
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
}
