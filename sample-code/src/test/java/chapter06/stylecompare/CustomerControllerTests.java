package chapter06.stylecompare;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerControllerTests {

    @Test
    @DisplayName("예제 6.4 많은 공간을 차지하는 상태 검증")
    public void addingACommentToAnArticle1() {
        Article sut = new Article();
        String text = "Comment text";
        String author = "John Doe";
        LocalDateTime now = LocalDateTime.of(2022,11,8,0,0);

        sut.addComment(text, author, now);

        assertEquals(1, sut.getCommentsCount());
        assertEquals(text, sut._comments.get(0).text);
        assertEquals(author, sut._comments.get(0).author);
        assertEquals(now, sut._comments.get(0).dateCreated);
    }

    @Test
    @DisplayName("예제 6.5 검증문에 헬퍼 메서드 사용")
    public void addingACommentToAnArticle2() {
        Article sut = new Article();
        String text = "Comment text";
        String author = "John Doe";
        LocalDateTime now = LocalDateTime.of(2022,11,8,0,0);
        ArticleExtensions helper = new ArticleExtensions();

        sut.addComment(text, author, now);

        helper.shouldContainNumberOfComments(sut,1)
            .withComment(sut, text, author,now);
    }

    @Test
    @DisplayName("예제 6.6 값으로 비교하는 Comment")
    public void addingACommentToAnArticle3() {
        Article sut = new Article();
        Comment comment = new Comment(
            "Comment text",
            "John Doe",
            LocalDateTime.of(2022,11,8,0,0)
        );

        sut.addComment(comment.text, comment.author, comment.dateCreated);

        assertEquals(comment, sut._comments.get(0));
    }

}
