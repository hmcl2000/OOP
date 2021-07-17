package com.example.doanoopkitchenmanage.repository;

import com.example.doanoopkitchenmanage.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist,Long> {
}
