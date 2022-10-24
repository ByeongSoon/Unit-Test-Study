package chapter05.mockandstub;

import lombok.Getter;

@Getter
public class Report {

    public int numberOfUsers;

    public Report(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

}
