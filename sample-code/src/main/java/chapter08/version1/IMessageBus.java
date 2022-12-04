package chapter08.version1;

public interface IMessageBus {
    void sendEmailChangedMessage(int userId, String newEmail);
}
