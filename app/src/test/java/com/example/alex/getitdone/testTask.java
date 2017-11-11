package com.example.alex.getitdone;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 11/11/2017.
 */

public class testTask {

    Task task;

    @Before
    public void before(){
        task = new Task("Milk", "get some milk", "shopping");
    }

    @Test
    public void testGetName(){
        assertEquals("Milk", task.getName());
    }

    @Test
    public void testGetDetails(){
        assertEquals("get some milk", task.getDetails());
    }

    @Test
    public void testSetName(){
        task.setName("Oatmilk");
        assertEquals("Oatmilk", task.getName());
    }
}
