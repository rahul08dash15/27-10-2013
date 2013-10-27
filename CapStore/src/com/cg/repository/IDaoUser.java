package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.domain.User;
@Repository
public interface IDaoUser extends JpaRepository<User,String>{

}
