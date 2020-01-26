package org.example.repository;

import org.example.entity.NoteCurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteCursRepository extends JpaRepository<NoteCurs, Integer> {
}
