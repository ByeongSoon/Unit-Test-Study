package chapter04.falsepositive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MessageRendererTests {

    /*
    * MessageRenderer의 식별할 수 있는 동작을 확인하지 않는다.
    * MessageRenderer의 BodyRenderer를 BoldRenderer로 변경한다면 기능상 문제는 없지만 해당 테스트는 실패한다.
     */
    @Test
    @DisplayName("MessageRenderer 구조가 올바른지 확인")
    public void messageRendererUsesCorrectSubRenderers() {
        MessageRenderer sut = new MessageRenderer();

        List<IRenderer> renderers = sut.subRenderers;

        Assertions.assertEquals(3, renderers.size());
        Assertions.assertInstanceOf(HeaderRenderer.class, renderers.get(0));
        Assertions.assertInstanceOf(BodyRenderer.class, renderers.get(1));
        Assertions.assertInstanceOf(FooterRenderer.class, renderers.get(2));
    }

    @Test
    @DisplayName("MessageRenderer 클래스의 소스ㅗ드 검증")
    public void messageRendererIsImplementedCorrectly() throws IOException {
        String sourceCode = Files.readString(
            Paths.get("./src/main/java/chapter04/falsepositive/MessageRenderer.java")
        );

        Assertions.assertEquals(
            "package chapter04.falsepositive;\n" +
                "\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.List;\n" +
                "import java.util.stream.Collectors;\n" +
                "\n" +
                "public class MessageRenderer implements IRenderer{\n" +
                "\n" +
                "    public List<IRenderer> subRenderers;\n" +
                "\n" +
                "    public MessageRenderer() {\n" +
                "        subRenderers = new ArrayList<>();\n" +
                "\n" +
                "        subRenderers.add(new HeaderRenderer());\n" +
                "        subRenderers.add(new BodyRenderer());\n" +
                "        subRenderers.add(new FooterRenderer());\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public String render(final Message message) {\n" +
                "        return String.join(\"\",\n" +
                "            subRenderers.stream()\n" +
                "                .map(r -> r.render(message))\n" +
                "                .collect(Collectors.toList())\n" +
                "        );\n" +
                "    }\n" +
                "\n" +
                "}\n",
            sourceCode
        );
    }

    @Test
    @DisplayName("MessageRenderer에서 생성하는 결과 검증")
    public void renderingAMessage() {
        MessageRenderer sut = new MessageRenderer();
        Message message = Message.builder()
            .header("h")
            .body("b")
            .footer("f")
            .build();

        String html = sut.render(message);
        Assertions.assertEquals("<h1>h</h1><b>b</b><i>f</i>", html);
    }

}
