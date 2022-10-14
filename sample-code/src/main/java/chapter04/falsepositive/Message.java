package chapter04.falsepositive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Message {

    public String header;
    public String body;
    public String footer;

}
