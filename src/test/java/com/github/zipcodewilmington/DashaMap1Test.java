package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap1Test {

    DashaMap map;

    @Before
    public void before(){
        map = new DashaMap();
    }
    @Test
    public void testSet(){
        //Given
        String key = "key";
        String value = "value";
        long expected = 1L;

        //When
        map.set(key, value);
        long actual = map.bucketSize("k");

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDelete(){
        //Given
        String key = "key";
        String value = "value";
        long expected = 0;

        //When
        map.set(key, value);
        map.delete(key);
        long actual = map.bucketSize("k");

        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGet(){
        //Given
        String key = "ki";
        String expected = "energy";

        //When
        map.set(key, expected);
        String actual = map.get(key);

        //Then
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testIsEmpty1(){
        //Given
        String key = "chuck";
        String expected = "norris";

        //When
        map.set(key, expected);

        //Then
        Assert.assertFalse(map.isEmpty());

    }
    @Test
    public void testIsEmpty2(){
        Assert.assertTrue(map.isEmpty());
    }
    @Test
    public void testSize(){
        //Given
        String key = "key";
        String value = "value";
        long expected = 1;

        //When
        map.set(key, value);
        long actual = map.size();

        //Then
        Assert.assertEquals(expected, actual);
    }
}
