package com.otoklix.repository;

import com.otoklix.dto.PostDto;
import com.otoklix.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT CURRENT_TIMESTAMP", nativeQuery = true)
    Timestamp getSysDate();

    @Query(value = "SELECT new com.otoklix.dto.PostDto(p.id, p.title, p.content, p.published_at, p.created_at, p.updated_at) "
    + "FROM Post p",
    countQuery = "SELECT COUNT(*) FROM Otoklix")
    List<PostDto> getAllEntities();

}
