package org.kukuking.back.repository;

import lombok.extern.slf4j.Slf4j;
import org.kukuking.back.dox.User;
import org.kukuking.back.mapper.UserResultSetExtractor;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, String> {
    @Query(value = "select * from user where account = :account",
            resultSetExtractorClass = UserResultSetExtractor.class)
    User findUserByAccount(String account);

    @Query(value = "select * from user where account = :account and password = :password",
            resultSetExtractorClass = UserResultSetExtractor.class)
    User findUserByAccountAndPassword(String account, String password);
}