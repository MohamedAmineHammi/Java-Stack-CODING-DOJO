package com.amine.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.studentroster.models.Dorm;
import com.amine.studentroster.models.Student;
import com.amine.studentroster.repositories.DormRepository;

@Service
public class DormService {

	// C R U D

	// adding the dorm repository as a dependency
	@Autowired
	private DormRepository dormRepo;

	// ReadAll
	// returns all the Dorms
	public List<Dorm> allDorms() {
		return dormRepo.findAll();
	}

	// CREATE
	// creates a Dorm
	public Dorm createDorm(Dorm d) {
		// on peut ajouter d'aute modification avant la creation ==
		// ex(p.getTitle.toLowerCase();)
		return dormRepo.save(d);
	}

	// FIND by ID / Read One
	// retrieves a Dorm
	public Dorm findDorm(Long id) {
		Optional<Dorm> maybeDorm = dormRepo.findById(id);
		if (maybeDorm.isPresent()) {
			return maybeDorm.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Dorm updateDorm(Dorm d) {
		return dormRepo.save(d);
	}

	// DELETE
	public void deleteDorm(Long id) {
		dormRepo.deleteById(id);
	}

	// bonus
	@Autowired
	private StudentService studentServ;

	public void addStudentToDorm(Long dormId, Long studentId) {
		Dorm dorm = findDorm(dormId);
		Student student = studentServ.findStudent(studentId);

		if (dorm != null && student != null) {
			student.setDorm(dorm);
			studentServ.updateStudent(student);
		}
	}
}
