package chapter08.version1;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {
    public int UserId;
    public String Email;
    public UserType Type;
    public boolean IsEmailConfirmed;
    public List<EmailChangedEvent> emailChangedEvents;

    public User(int userId, String email, UserType type, boolean isEmailConfirmed)
    {
        UserId = userId;
        Email = email;
        Type = type;
        IsEmailConfirmed = isEmailConfirmed;
        emailChangedEvents = new ArrayList<>();
    }

    public String canChangeEmail()
    {
        if (IsEmailConfirmed)
            return "Can't change email after it's confirmed";

        return null;
    }

    public void changeEmail(String newEmail, Company company)
    {
//        Precondition.Requires(canChangeEmail() == null);

        if (Email == newEmail)
            return;

        UserType newType = company.IsEmailCorporate(newEmail)
            ? UserType.Employee : UserType.Customer;

        if (Type != newType)
        {
            int delta = newType == UserType.Employee ? 1 : -1;
            company.ChangeNumberOfEmployees(delta);
        }

        Email = newEmail;
        Type = newType;
        emailChangedEvents.add(new EmailChangedEvent(UserId, newEmail));
    }

}
