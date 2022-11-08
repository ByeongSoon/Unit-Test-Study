package chapter06.stylecompare;

import java.time.LocalDateTime;

public class Comment {

    public final String text;
    public final String author;
    public final LocalDateTime dateCreated;

    public Comment(String text, String author, LocalDateTime dateCreated) {
        this.text = text;
        this.author = author;
        this.dateCreated = dateCreated;
    }

    protected boolean equals(Comment other) {
        return text.equals(other.text)
            && author.equals(other.author)
            && dateCreated.equals(other.dateCreated);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Comment) {
            return true;
        }
        if(obj.getClass() != Comment.class) {
            return false;
        }

        return equals((Comment) obj);
    }

    @Override
    public int hashCode() {
        int hashCode = (text != null) ? text.hashCode() : 0;
        hashCode = (hashCode * 397) ^ (author != null ? author.hashCode() : 0);
        hashCode = (hashCode * 397) ^ dateCreated.hashCode();
        return hashCode;
    }

}
