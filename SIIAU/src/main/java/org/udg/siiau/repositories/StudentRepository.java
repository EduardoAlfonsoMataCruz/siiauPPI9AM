package org.udg.siiau.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.udg.siiau.models.StudentModel;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel,Long> {

    public Optional<StudentModel> findStudentModelByCode(String code);

    public Optional<StudentModel> findStudentModelByEmail(String email);
    public Optional<StudentModel> findStudentModelByName(String name);
}
