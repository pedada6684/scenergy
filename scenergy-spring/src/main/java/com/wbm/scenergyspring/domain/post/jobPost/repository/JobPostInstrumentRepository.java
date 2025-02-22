package com.wbm.scenergyspring.domain.post.jobPost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wbm.scenergyspring.domain.post.jobPost.entity.JobPostInstrumentTag;

@Repository
public interface JobPostInstrumentRepository extends JpaRepository<JobPostInstrumentTag, Long> {
}
