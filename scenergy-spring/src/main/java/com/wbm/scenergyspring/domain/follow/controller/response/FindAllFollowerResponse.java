package com.wbm.scenergyspring.domain.follow.controller.response;

import java.util.ArrayList;
import java.util.List;

import com.wbm.scenergyspring.domain.follow.entity.Follow;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindAllFollowerResponse {
	List<FollowDto> findAllResponseList;

	public static FindAllFollowerResponse fromList(List<Follow> followList) {
		List<FollowDto> followDtoList = new ArrayList<>();
		for (Follow follow : followList) {
			FollowDto from = FollowDto.from(follow);
			followDtoList.add(from);
		}
		return FindAllFollowerResponse.builder()
			.findAllResponseList(followDtoList)
			.build();
	}
}

@Data
@Builder
class FollowDto {
	Long id;
	UserDto from;
	UserDto to;

	static FollowDto from(Follow follow) {
		return FollowDto.builder()
			.id(follow.getId())
			.from(UserDto.fromUser(follow.getFrom()))
			.to(UserDto.fromUser(follow.getTo()))
			.build();
	}
}
