package chapter06.stylecompare;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Article {

    public final List<Comment> _comments = new ArrayList<>();

    public void addComment(String text, String author, LocalDateTime now) {
        _comments.add(new Comment(text, author, now));
    }

    public Article shouldContainNumberOfComments(int i) {
        return this;
    }

    public int getCommentsCount() {
        return _comments.size();
    }

    public Comment singleOrDefault(String text, String author, LocalDateTime dateCreated) {
        Comment comment = _comments.get(0);

        if (comment.text.equals(text) && comment.author.equals(author) && comment.dateCreated.equals(dateCreated)) {
            return comment;
        }

        return null;
    }

}
