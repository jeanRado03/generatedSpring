package com.generated.project.repository;


import com.generated.project.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UtilisateurRepository extends CrudRepository<Utilisateur, String> {

    @Query(value = "select nextval('utilisateur_seq') ",nativeQuery = true)
    int getNextval();
    @Query(value = "select * from getsequence (:length , :prefix , :sequence)", nativeQuery = true)
    String getSequence(@Param("length") int length, @Param("prefix") String prefix, @Param("sequence") int sequence);

    Optional<Utilisateur> findByEmail(String email);
}
