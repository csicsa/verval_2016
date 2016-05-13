package test.java;

import main.java.FileExtensionManager;
import main.java.LogAnalyzer;

public class TestableLogAnalyzer extends LogAnalyzer {
    private FileExtensionManager fileExtensionManager;

    public TestableLogAnalyzer(FileExtensionManager fileExtensionManager) {
        this.fileExtensionManager = fileExtensionManager;
    }

    @Override
    public FileExtensionManager getFileExtensionManager() {
        return fileExtensionManager;
    }
}
