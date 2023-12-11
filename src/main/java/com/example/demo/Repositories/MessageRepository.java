package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Mensaje;

@Repository
public interface MessageRepository extends JpaRepository<Mensaje, Long> {
    List<Mensaje> findByReceptor(String receptor);
	
}
