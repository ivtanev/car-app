package com.example.demo.service.impl;

import com.example.demo.model.Owner;
import com.example.demo.repository.OwnerRepository;
import com.example.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Optional<Owner> findById(Long id) {
        return this.ownerRepository.findById(id);
    }

    @Override
    public Owner saveOwner(Owner owner) {
        return this.ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        this.ownerRepository.deleteById(id);
    }
}
