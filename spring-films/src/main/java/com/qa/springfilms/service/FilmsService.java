package com.qa.springfilms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springfilms.domain.Films;
import com.qa.springfilms.repo.FilmsRepo;

@Service
public class FilmsService {

private FilmsRepo repo;

public FilmsService(FilmsRepo repo) {
this.repo = repo;
}

public Films create(Films fm) {
	return this.repo.saveAndFlush(fm);
}

public List<Films>read(){
	return this.repo.findAll();
}

public Films update(Long id, Films newFm) {
	Films existing = this.repo.getById(id);
existing.setName(newFm.getName());
existing.setGenre(newFm.getGenre());
existing.setRunTime(newFm.getRunTime());
existing.setCertification(newFm.getCertification());
existing.setNumberOfTickets(newFm.getNumberOfTickets());

Films updated = this.repo.save(existing);
return updated;
}

public boolean delete(Long id) {
	this.repo.deleteById(id);
	return this.repo.existsById(id);
}
}







