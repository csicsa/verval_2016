package test.java;


import org.junit.*;
import org.mockito.Mockito;

import main.java.FileExtensionManagerFactory;
import main.java.LogAnalyzer;
import main.java.WebService;

public class LogAnalyzerTest {

    private static final String validLogFileName = "text.slr";
    private static final String invalidLogFileName = "text.slkr";
    private LogAnalyzer logAnalyzer;
    private FileExtensionManagerStub fileExtensionManager;
    private WebService webService;

    @Before
    public void setUp() {
        fileExtensionManager = new FileExtensionManagerStub();
        logAnalyzer = new TestableLogAnalyzer(fileExtensionManager);
        FileExtensionManagerFactory.getInstance().setFileExtensionManager(fileExtensionManager);
        webService = new ManualWebService();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void isValidLogFileName_ValidLogFileName_ReturnsTrue() {
        fileExtensionManager.setWillReturn(true);
        Assert.assertEquals(validLogFileName + " valid",
                logAnalyzer.isValidLogFileName(validLogFileName), true);
    }

    @Test
    public void isValidLogFileName_InvalidLogFileName_ReturnsFalse() {
        fileExtensionManager.setWillReturn(false);
        Assert.assertEquals(invalidLogFileName + " invalid",
                logAnalyzer.isValidLogFileName(invalidLogFileName), false);

    }

    @Test
    public void IsValidLogFileNameTestable_NotValid_ReturnFalse() {
        fileExtensionManager.setWillReturn(false);
        Assert.assertEquals("should be invalid", logAnalyzer.isValidLogFileName(""), false);
    }

    @Test
    public void IsValidLogFileNameTestable_Valid_ReturnTrue() {
        fileExtensionManager.setWillReturn(true);
        Assert.assertEquals("should be valid", logAnalyzer.isValidLogFileName(""), true);
    }

    @Test
    public void isValidLogFileName_FileNameTooShort_CallsWebService() {
        logAnalyzer.isValidLogFileName("12");
        Assert.assertEquals("should be too short", webService.getLastError(), "12 too short");
    }

    @Test
    public void isValidLogFileNameMock_FileNameTooShort_CallsWebService() {
        WebService mockedWebService = Mockito.mock(WebService.class);
        logAnalyzer.setWebService(mockedWebService);
        logAnalyzer.isValidLogFileName("12");
        Mockito.verify(mockedWebService, Mockito.times(2)).logError("12 too short");

    }
}
