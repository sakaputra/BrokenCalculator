package com.goacademy.ub;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() {
        App.result = 0.0;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void whenAdd1AppShouldPrintOne() {
        App.processInput("add 1");
        Assert.assertEquals("1.0\n", outContent.toString());
    }

    @Test
    public void whenSubtract1AppShouldPrintNegativeOne() {
        App.processInput("subtract 1");
        Assert.assertEquals("-1.0\n", outContent.toString());
    }

    @Test
    public void whenAdd5AndMultiply2ShouldPrint5And10() {
        App.processInput("add 5");
        App.processInput("multiply 2");
        Assert.assertEquals("5.0\n10.0\n", outContent.toString());
    }

    @Test
    public void whenAdd10AndDivide2ShouldPrint10And5() {
        App.processInput("add 10");
        App.processInput("divide 2");
        Assert.assertEquals("10.0\n5.0\n", outContent.toString());
    }

    @Test
    public void whenExitShouldExit() {
        App.processInput("exit");
        Assert.assertEquals("", outContent.toString());
    }

    @Test
    public void whenResetShouldResetToZero() {
        App.processInput("reset");
        Assert.assertEquals("0.0\n", outContent.toString());
    }
}
