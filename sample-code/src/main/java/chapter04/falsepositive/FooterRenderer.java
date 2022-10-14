package chapter04.falsepositive;

public class FooterRenderer implements IRenderer{
    @Override
    public String render(Message message) {
        return "<i>" + message.footer + "</i>";
    }
}
