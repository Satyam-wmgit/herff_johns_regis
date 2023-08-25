package com.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.FeUser;
import com.app.repo.FeUserRepo;

@Service
public class FeUserService {
    private final FeUserRepo feUserRepository;

    @Autowired
    public FeUserService(FeUserRepo feUserRepository) {
        this.feUserRepository = feUserRepository;
    }

    public FeUser registerUser(FeUser user) {
     
         FeUser g=feUserRepository.save(user);
         System.out.println(g);
         return g;
    }

    public FeUser getUserById(Character userId) {
        return feUserRepository.findById(userId).orElse(null);
    }

}
