package chapter11;

import java.time.LocalDateTime;

public class Inquiry {
    public boolean isApproved;
    public LocalDateTime timeApproved;

    private Inquiry(boolean isApproved, LocalDateTime timeApproved) throws Exception {
        if (isApproved && timeApproved == null) {
            throw new Exception();
        }
        this.isApproved = isApproved;
        this.timeApproved = timeApproved;
    }

    public void approve(LocalDateTime now) {
        if (isApproved) {
            return;
        }

        isApproved = true;
        timeApproved = now;
    }
}
