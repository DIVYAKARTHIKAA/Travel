package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.travel.Travel;
@Repository
public interface Repos extends JpaRepository<Travel, Long>{

}
