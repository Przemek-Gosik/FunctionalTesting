package com.example.functionaltesting.repository;

import com.example.functionaltesting.domain.ClientDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDetailsRepository extends JpaRepository<ClientDetailsEntity,Long> {
}
