package test.java;

import main.java.FileExtensionManager;

public class FileExtensionManagerStub implements FileExtensionManager {
    private boolean willReturn;

    @Override
    public boolean isValid(final String fileName) {
        return willReturn;
    }

    public void setWillReturn(final boolean willReturn) {
        this.willReturn = willReturn;
    }
}
