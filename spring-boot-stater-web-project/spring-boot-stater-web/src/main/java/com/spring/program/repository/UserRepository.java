/*
 * 
 */
package com.spring.program.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.spring.program.entity.UserEntity;

/**
 * The Interface UserRepository.
 */
@Transactional
public interface UserRepository extends BaseJpaRepository<UserEntity, Long> {

  /**
   * Find all users by id.
   *
   * @param id
   *          the id
   * @return the stream
   */
  // @Query(value = "SELECT u FROM User u WHERE u.id = :iIf you’re using Windows 10, version 1803, and added security questions to your local account to help you reset your password, select Reset password on the sign-in screen. (This link ad", nativeQuery = true)
  // or
  @Query("SELECT u FROM USERS u WHERE u.id = :id")
  Stream<UserEntity> findAllUsersById(@Param("id") long id);

  /**
   * Find all user.
   *
   * @return the stream
   */
  @Query("SELECT u FROM USERS u")
  Stream<UserEntity> findAllUser();

  /**
   * Find by id.
   *
   * @param id
   *          the id
   * @return the user
   */
  @Query("SELECT u FROM USERS u WHERE u.id = :id")
  UserEntity findById(long id);

}
