package chapter06.communication;

import chapter05.mockandstub.Controller;

import chapter05.mockandstub.IEmailGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CustomerControllerTests {

    @Test
    @DisplayName("예제 6.3 통신 기반 테스트")
    public void sendingGreetingsEmail() {
        IEmailGateway emailGatewayMock = mock(IEmailGateway.class);
        Controller sut = new Controller(emailGatewayMock);

        sut.greetUser("user@email.com");

        verify(emailGatewayMock, times(1)).sendGreetingsEmail("user@email.com");
    }

}
