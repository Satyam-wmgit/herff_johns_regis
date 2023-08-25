package com.app.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.FeUser;

public interface FeUserRepo extends JpaRepository<FeUser, Character> {

}


