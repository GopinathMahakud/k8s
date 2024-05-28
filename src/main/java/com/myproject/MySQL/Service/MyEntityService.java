package com.myproject.MySQL.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.MySQL.Entity.MyEntity;
import com.myproject.MySQL.Repository.MyEntityRepository;

@Service
public class MyEntityService {

    @Autowired
    private MyEntityRepository myEntityRepository;

    public List<MyEntity> getAllEntities() {
        return myEntityRepository.findAll();
    }

    public Optional<MyEntity> getEntityById(Long id) {
        return myEntityRepository.findById(id);
    }

    public MyEntity createEntity(MyEntity entity) {
        return myEntityRepository.save(entity);
    }

    public MyEntity updateEntity(Long id, MyEntity entityDetails) {
        MyEntity entity = myEntityRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));

        entity.setName(entityDetails.getName());
        entity.setAddress(entityDetails.getAddress());

        return myEntityRepository.save(entity);
    }

    public void deleteEntity(Long id) {
        myEntityRepository.deleteById(id);
    }
}
