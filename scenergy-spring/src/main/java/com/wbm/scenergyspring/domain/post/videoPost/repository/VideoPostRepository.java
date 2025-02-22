package com.wbm.scenergyspring.domain.post.videoPost.repository;

import com.wbm.scenergyspring.domain.post.videoPost.entity.VideoPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoPostRepository extends JpaRepository<VideoPost, Long> {
    @Query("""
            select distinct vp from VideoPost vp
            left join UserLocationTag ut
                on vp.user = ut.user
            left join vp.videoPostGenreTags genre
            left join vp.videoPostInstrumentTags instru
            where (vp.title like %:word% or vp.writer like %:word% or vp.content like %:word% or vp.video.musicTitle like %:word% or vp.video.artist like %:word% or :word is null)
            and (genre.genreTag.id in :gt or :gt is null)
            and (instru.instrumentTag.id in :it or :it is null)
            and (ut.locationTag.id in :lt or :lt is null)
            """)
    List<VideoPost> searchVideoPostsByCondition(@Param("word") String word, @Param("gt") List<Long> gt, @Param("it") List<Long> it, @Param("lt") List<Long> lt);

    @Query("select vp from VideoPost vp " +
            "where vp.user.id in (select f.to.id from Follow f where f.from.id=:id)")
    List<VideoPost> findAllByFollowing(@Param("id") Long id);

    @Query("""
            select vp from VideoPost vp
            join vp.user u
            where u.id = :userId
            """)
    Optional<List<VideoPost>> getMyVideoPosts(@Param("userId") Long userId);

}