package com.ForoAlura.Repository;


import com.ForoAlura.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}