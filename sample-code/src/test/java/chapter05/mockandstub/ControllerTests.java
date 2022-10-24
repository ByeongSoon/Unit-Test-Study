package chapter05.mockandstub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ControllerTests {

    @Test
    @DisplayName("목 라이브러리에서 Mock 클래스를 사용해 목을 생성")
    public void sendingAGreetingsEmail() {
        IEmailGateway mock = mock(IEmailGateway.class);
        Controller sut = new Controller(mock);

        sut.greetUser("user@email.com");

        verify(mock, times(1)).sendGreetingsEmail("user@email.com");
    }

    @Test
    @DisplayName("Mock 클래스를 사용해 스텁을 생성")
    public void creatingAReport() {
        IDatabase stub = mock(IDatabase.class);
        when(stub.getNumberOfUsers()).thenReturn(10);
        Controller sut = new Controller(stub);

        Report report = sut.createReport();

        Assertions.assertEquals(10, report.numberOfUsers);
        // 예저 5.3 스텁으로 상호 작용 검증 -> 과잉 명세
        verify(stub, times(1)).getNumberOfUsers();
    }

}
