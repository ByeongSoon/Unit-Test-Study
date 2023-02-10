package chapter11.codepollution;

public class FakeLogger implements ILogger{
    @Override
    public void log(final String text) {
        /* 아무것도 하지 않음 */
    }
}
