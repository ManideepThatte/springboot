package sbe.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbe.entity.Student;
import sbe.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController

public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @Operation(summary = "Find Student by ID", description = "Returns student details By ID", tags = { "Student" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Student.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Student ID ", content = @Content),
            @ApiResponse(responseCode = "404", description = "Student Details not found", content = @Content) })
    @GetMapping("/student/{id}")
    public Optional<Student> findById(@PathVariable int id){
        return studentService.findById(id);
    }
    @PostMapping("/savestudent")
    public Student saveStudent( @RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id){
        String mesg=studentService.delete(id);
        return mesg;
    }
    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) throws Exception{
        return studentService.updateStudent(id,student);
    }

}
