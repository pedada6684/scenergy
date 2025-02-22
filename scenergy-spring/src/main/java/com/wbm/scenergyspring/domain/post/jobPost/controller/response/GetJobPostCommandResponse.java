package com.wbm.scenergyspring.domain.post.jobPost.controller.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wbm.scenergyspring.domain.post.jobPost.entity.IsActive;
import com.wbm.scenergyspring.domain.post.jobPost.entity.JobPost;
import com.wbm.scenergyspring.domain.post.jobPost.entity.JobPostApply;
import com.wbm.scenergyspring.domain.post.jobPost.entity.JobPostGenreTag;
import com.wbm.scenergyspring.domain.post.jobPost.entity.JobPostInstrumentTag;
import com.wbm.scenergyspring.domain.post.jobPost.entity.JobPostLocationTag;
import com.wbm.scenergyspring.domain.tag.entity.GenreTag;
import com.wbm.scenergyspring.domain.tag.entity.InstrumentTag;
import com.wbm.scenergyspring.domain.tag.entity.LocationTag;
import com.wbm.scenergyspring.domain.user.entity.Gender;
import com.wbm.scenergyspring.domain.user.entity.Role;
import com.wbm.scenergyspring.domain.user.entity.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetJobPostCommandResponse {
    UserDto userDto;
    Long jobPostId;

    String title;
    String content;

    LocalDateTime expirationDate;
    IsActive isActive;

    Long peopleRecruited;

    Long bookMark;

    Long totalCount;

    private List<InstrumentTagDto> jobPostInstrumentTags = new ArrayList<>();

    private List<LocationTagDto> jobPostLocationTags = new ArrayList<>();

    private List<GenreTagDto> jobPostGenreTags = new ArrayList<>();

    private List<JobApplicantDto> jobApplicant = new ArrayList<>();

    public static GetJobPostCommandResponse from(JobPost jobPost) {
        User user = jobPost.getUserId();
        List<JobPostInstrumentTag> jobPostInstrumentTags1 = jobPost.getJobPostInstrumentTags();
        List<InstrumentTagDto> instrumentTags = new ArrayList<>();
        for (JobPostInstrumentTag tag : jobPostInstrumentTags1) {
            InstrumentTagDto from = InstrumentTagDto.from(tag.getInstrumentTag());
            instrumentTags.add(from);
        }
        List<JobPostGenreTag> jobPostGenreTags1 = jobPost.getJobPostGenreTags();
        List<GenreTagDto> genreTags = new ArrayList<>();
        for (JobPostGenreTag tag : jobPostGenreTags1) {
            GenreTagDto from = GenreTagDto.from(tag.getGenreTag());
            genreTags.add(from);
        }

        List<JobPostLocationTag> jobPostLocationTags1 = jobPost.getJobPostLocationTags();
        List<LocationTagDto> locationTags = new ArrayList<>();
        for (JobPostLocationTag tag : jobPostLocationTags1) {
            LocationTagDto from = LocationTagDto.from(tag.getLocationTag());
            locationTags.add(from);
        }
        Long cnt = 0L;
        List<JobPostApply> jobApplicantList = jobPost.getJobApplicant();
        List<JobApplicantDto> applicant = new ArrayList<>();
        for(JobPostApply jobApplicant : jobApplicantList) {
            JobApplicantDto from = JobApplicantDto.from(jobApplicant.getUser());
            cnt += 1;
            applicant.add(from);
        }

        return GetJobPostCommandResponse.builder()
            .jobPostId(jobPost.getId())
            .jobPostInstrumentTags(instrumentTags)
            .jobPostGenreTags(genreTags)
            .jobPostLocationTags(locationTags)
            .jobApplicant(applicant)
            .userDto(UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .build())
            .title(jobPost.getTitle())
            .content(jobPost.getContent())
            .expirationDate(jobPost.getExpirationDate())
            .isActive(jobPost.getIsActive())
            .peopleRecruited(jobPost.getPeopleRecruited())
            .bookMark(jobPost.getBookMark())
            .totalCount(cnt)
            .build();
    }
}

@Data
@Builder
class UserDto {
    Long id;
    String email;
    String nickname;
}

@Data
@Builder
class LocationTagDto {

    Long id;
    String locationName;

    static LocationTagDto from (LocationTag locationTag) {
        return LocationTagDto.builder()
            .id(locationTag.getId())
            .locationName(locationTag.getLocationName())
            .build();
    }
}

@Data
@Builder
class GenreTagDto {

    Long id;
    String genreName;

    static GenreTagDto from(GenreTag genreTag) {
        return GenreTagDto.builder()
            .id(genreTag.getId())
            .genreName(genreTag.getGenreName())
            .build();
    }
}
@Data
@Builder
class InstrumentTagDto {
    Long id;
    String instrumentName;

    static InstrumentTagDto from(InstrumentTag instrumentTag) {
        return InstrumentTagDto.builder()
            .id(instrumentTag.getId())
            .instrumentName(instrumentTag.getInstrumentName())
            .build();
    }
}

@Data
@Builder
class JobApplicantDto {
    Long id;
    String email;
    String nickname;
    String username;
    Gender gender;
    Role role;

    static JobApplicantDto from(User user) {
        return JobApplicantDto.builder()
            .id(user.getId())
            .email(user.getEmail())
            .nickname(user.getNickname())
            .username(user.getUsername())
            .gender(user.getGender())
            .role(user.getRole())
            .build();
    }
}