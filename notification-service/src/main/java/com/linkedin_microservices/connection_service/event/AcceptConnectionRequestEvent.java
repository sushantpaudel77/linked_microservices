package com.linkedin_microservices.connection_service.event;

import lombok.Data;

@Data

public class AcceptConnectionRequestEvent {
    private Long senderId;
    private Long receiverId;
}
