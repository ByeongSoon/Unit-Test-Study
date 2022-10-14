package chapter04.falsepositive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageRenderer implements IRenderer{

    public List<IRenderer> subRenderers;

    public MessageRenderer() {
        subRenderers = new ArrayList<>();

        subRenderers.add(new HeaderRenderer());
        subRenderers.add(new BodyRenderer());
        subRenderers.add(new FooterRenderer());
    }

    @Override
    public String render(final Message message) {
        return String.join("",
            subRenderers.stream()
                .map(r -> r.render(message))
                .collect(Collectors.toList())
        );
    }

}
