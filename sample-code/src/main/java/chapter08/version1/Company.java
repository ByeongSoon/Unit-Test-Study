package chapter08.version1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {
    public String DomainName;
    public int NumberOfEmployees;

    public Company(String domainName, int numberOfEmployees)
    {
        DomainName = domainName;
        NumberOfEmployees = numberOfEmployees;
    }

    public void ChangeNumberOfEmployees(int delta)
    {
//        Precondition.Requires(NumberOfEmployees + delta >= 0);

        NumberOfEmployees += delta;
    }

    public boolean IsEmailCorporate(String email)
    {
        String emailDomain = email.split("@")[1];
        return emailDomain == DomainName;
    }


}
