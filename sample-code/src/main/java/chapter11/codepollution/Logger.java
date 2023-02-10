package chapter11.codepollution;

public class Logger {
    private final boolean _isTestEnvironment;

    public Logger(boolean isTestEnvironment) { // <- 스위치
        this._isTestEnvironment = isTestEnvironment;
    }

    public void log(String text) {
        if (_isTestEnvironment) {
            return;
        }
        /* text에 대한 로깅 */
    }
}
