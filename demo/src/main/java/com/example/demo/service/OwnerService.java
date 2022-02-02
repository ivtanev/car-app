package com.example.demo.service;



import com.example.demo.model.Owner;

import java.util.Optional;

public interface OwnerService {
    Optional<Owner> findById(Long id);

    Owner saveOwner(Owner owner);

    void deleteOwner(Long id);

}
