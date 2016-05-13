package test.java;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.java.LogAnalyzer;


@RunWith(Parameterized.class)
public class LogAnalyzerParametrizedTest {
    private LogAnalyzer logAnalyzer;
    private FileExtensionManagerStub fileExtensionManager;

    @Parameterized.Parameter
    public String input;

    @Parameterized.Parameter(value = 1)
    public boolean expected;



    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "something.slr", true }, { "something.slrr", false }
        });
    }

    @Before
    public void setUp() {
        fileExtensionManager = new FileExtensionManagerStub();
        logAnalyzer = new LogAnalyzer();
    }


    @Test
    public void test() {
        fileExtensionManager.setWillReturn(expected);
        Assert.assertEquals(expected, logAnalyzer.isValidLogFileName(input));
    }
}
