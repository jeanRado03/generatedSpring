package com.generated.project.repository;

import com.generated.project.security.AuthenticationResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationResponeRepository extends CrudRepository<AuthenticationResponse, Long> {
    @Modifying
    @Query(value = "delete from token where id_user = :id", nativeQuery = true)
    @Transactional
    int deleteToken(@Param("id") String id);
}
