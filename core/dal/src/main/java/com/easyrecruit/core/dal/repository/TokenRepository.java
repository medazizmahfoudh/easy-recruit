package com.easyrecruit.core.dal.repository;

import com.easyrecruit.core.dal.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query("""
        select t from Token t inner join AppUserEntity u on t.user.id = u.id
        where u.id = :userId and   (t.revoked = false or t.expired = false )
    """)
    List<Token> findAllValidTokenByUser(Integer userId);

    Optional<Token> findByToken(String token);
}
