package chapter06.stylecompare;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArticleExtensions {

    public ArticleExtensions shouldContainNumberOfComments(Article article, int commentCount) {
        assertEquals(commentCount, article.getCommentsCount());
        return this;
    }

    public ArticleExtensions withComment(Article article, String text, String author, LocalDateTime dateCreated) {
        Comment comment = article.singleOrDefault(text,author,dateCreated);

        return this;
    }

}
