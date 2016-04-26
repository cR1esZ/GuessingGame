package com.epam.traine;

import com.sun.javafx.sg.prism.NGShape;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by andreyholovan on 4/26/16.
 */
public class ControllerTest {


    private Model model;
    private View view;
    private Controller controller;

    @Before
    public void initControllerTest(){
        model = new Model();
        view = new View();
        controller = new Controller(model,view);
    }
    @Test
    public void isGuessNumberOfRange() throws Exception {
        Assert.assertTrue(controller.isGuessNumberOfRange(50));

        Assert.assertFalse(controller.isGuessNumberOfRange(0));
        Assert.assertFalse(controller.isGuessNumberOfRange(100));
        Assert.assertFalse(controller.isGuessNumberOfRange(Integer.MAX_VALUE));
    }

    @Test
    public void compareLowerBoundAndUpperBound() throws Exception {
        Assert.assertTrue(controller.compareLowerBoundAndUpperBound(5,2));
        Assert.assertTrue(controller.compareLowerBoundAndUpperBound(5,5));

        Assert.assertFalse(controller.compareLowerBoundAndUpperBound(0,200));
    }

}