package chapter08.version1;

import lombok.Getter;

@Getter
public class EmailChangedEvent {
    public int userId;
    public String newEmail;

    public EmailChangedEvent(int userId, String newEmail)
    {
        this.userId = userId;
        this.newEmail = newEmail;
    }

    protected boolean Equals(EmailChangedEvent other)
    {
        return userId == other.userId && newEmail.equals(other.newEmail);
    }

    @Override
    public boolean equals(Object obj)
    {
        /**
         * 비교 로직
         */

        return Equals((EmailChangedEvent)obj);
    }

    @Override
    public int hashCode()
    {
        return (userId * 397) ^ (newEmail != null ? newEmail.hashCode() : 0);
    }
}
