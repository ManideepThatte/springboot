package sbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbe.entity.Student;
import sbe.repo.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public List<Student> getAll(){
        return  studentRepo.findAll();
    }

    public Optional<Student> findById(int id){
        Optional<Student> optionalStudent = studentRepo.findById(id);
        return optionalStudent;
    }

    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }

    public String delete(int id){
        Optional<Student> optionalStudent = findById(id);
        if(optionalStudent.isPresent()){
            studentRepo.deleteById(id);
        }else{
            return "No data Has found";
        }
        return "data has been deleted";
    }

    public Student updateStudent(int id, Student student) throws Exception{
        Student std = studentRepo.findById(id)
                .orElseThrow(()->new NullPointerException("No data found with that Id"+id));

        std.setCourse(student.getCourse());
        //std.setMobile(student.getMobile());
        return studentRepo.save(std);

    }
}
