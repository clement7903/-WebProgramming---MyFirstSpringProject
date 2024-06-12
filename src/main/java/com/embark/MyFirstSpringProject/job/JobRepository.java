package com.embark.MyFirstSpringProject.job;

import org.springframework.data.jpa.repository.JpaRepository;

// For doing common CRUD operations through the use of JpaRepository...
// JpaRepository<Entity type, data type of primary key>
public interface JobRepository extends JpaRepository<Job, Long> {
}
