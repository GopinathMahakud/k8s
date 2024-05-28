package com.myproject.MySQL.Controller;

import com.myproject.MySQL.Service.MyEntityService;
import com.myproject.MySQL.Entity.MyEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entities")
public class DBOperationController {

    @Autowired
    private MyEntityService myEntityService;

    @GetMapping
    public List<MyEntity> getAllEntities() {
        return myEntityService.getAllEntities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyEntity> getEntityById(@PathVariable Long id) {
        MyEntity entity = myEntityService.getEntityById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping
    public MyEntity createEntity(@RequestBody MyEntity entity) {
        return myEntityService.createEntity(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyEntity> updateEntity(@PathVariable Long id, @RequestBody MyEntity entityDetails) {
        MyEntity updatedEntity = myEntityService.updateEntity(id, entityDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        myEntityService.deleteEntity(id);
        return ResponseEntity.noContent().build();
    }
}
