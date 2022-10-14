package chapter04.falsepositive;

public class HeaderRenderer implements IRenderer{
    @Override
    public String render(Message message) {
        return "<h1>" + message.header + "</h1>";
    }
}
