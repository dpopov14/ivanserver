package com.ivan.server.repositories;

import com.ivan.server.entities.ServerItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerItemRepository extends JpaRepository<ServerItem, Integer> {

}
