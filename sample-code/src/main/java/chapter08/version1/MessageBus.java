package chapter08.version1;

public class MessageBus implements IMessageBus{

    @Override
    public void sendEmailChangedMessage(final int userId, final String newEmail) {
        IBus _bus = null;
            _bus.Send("Subject: USER; Type: EMAIL CHANGED; Id: {userId}; NewEmail: {newEmail}");
    }
}
