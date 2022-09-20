package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infy.dto.UserDTO;
import com.infy.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	@Query("from UserEntity e where e.user_id=:x")
	 UserEntity getuser(@Param("x") int id);

	@Query("from UserEntity e where e.personal_identification_number=:x")
	UserEntity getuserById(@Param("x")  long l);

}
