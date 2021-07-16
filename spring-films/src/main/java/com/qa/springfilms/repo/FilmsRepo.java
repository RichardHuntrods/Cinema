package com.qa.springfilms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springfilms.domain.Films;


@Repository
public interface FilmsRepo extends JpaRepository<Films, Long> {


}
