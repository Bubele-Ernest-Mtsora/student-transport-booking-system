package com.bubele.studentstransportsystem.Controller;

import com.bubele.studentstransportsystem.Dto.StudentLoginRequestDTO;
import com.bubele.studentstransportsystem.Dto.StudentLoginResponseDTO;
import com.bubele.studentstransportsystem.Dto.StudentRequestDTO;
import com.bubele.studentstransportsystem.Dto.StudentResponseDTO;
import com.bubele.studentstransportsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ==========================
    // REGISTER STUDENT
    // ==========================
    @PostMapping("/create")
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO dto) {
        return studentService.createStudent(dto);
    }

    // ==========================
    // STUDENT LOGIN
    // ==========================
    @PostMapping("/login")
    public StudentLoginResponseDTO loginStudent(@RequestBody StudentLoginRequestDTO dto) {
        return studentService.loginStudent(dto);
    }

    // ==========================
    // GET ALL STUDENTS
    // ==========================
    @GetMapping("/all")
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    // ==========================
    // GET STUDENT BY ID
    // ==========================
    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // ==========================
    // UPDATE STUDENT
    // ==========================
    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable Long id,
                                            @RequestBody StudentRequestDTO dto) {
        return studentService.updateStudent(id, dto);
    }

    // ==========================
    // DELETE STUDENT
    // ==========================
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}