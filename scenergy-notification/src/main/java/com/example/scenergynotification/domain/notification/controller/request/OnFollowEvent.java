package com.example.scenergynotification.domain.notification.controller.request;

import lombok.Data;

@Data
public class OnFollowEvent {
	private Long followId;
	private Long fromUserId;
	private Long toUserId;
}
