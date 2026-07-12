package com.bubele.studentstransportsystem.Service;

import com.bubele.studentstransportsystem.Dto.StudentLoginRequestDTO;
import com.bubele.studentstransportsystem.Dto.StudentLoginResponseDTO;
import com.bubele.studentstransportsystem.Dto.StudentRequestDTO;
import com.bubele.studentstransportsystem.Dto.StudentResponseDTO;
import com.bubele.studentstransportsystem.Entity.StudentEntity;
import com.bubele.studentstransportsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // ==========================
    // CREATE STUDENT
    // ==========================
    public StudentResponseDTO createStudent(StudentRequestDTO dto) {

        StudentEntity student = new StudentEntity();

        student.setStudentNumber(dto.getStudentNumber());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setPassword(dto.getPassword());

        StudentEntity saved = studentRepository.save(student);

        return mapToResponse(saved);
    }

    // ==========================
    // STUDENT LOGIN
    // ==========================
    public StudentLoginResponseDTO loginStudent(StudentLoginRequestDTO dto) {

        StudentEntity student = studentRepository.findByEmail(dto.getEmail()).orElse(null);

        StudentLoginResponseDTO response = new StudentLoginResponseDTO();

        if (student == null) {
            response.setMessage("Student not found.");
            return response;
        }

        if (!student.getPassword().equals(dto.getPassword())) {
            response.setMessage("Incorrect password.");
            return response;
        }

        response.setStudentId(student.getStudentId());
        response.setStudentNumber(student.getStudentNumber());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setMessage("Login successful.");

        return response;
    }

    // ==========================
    // GET ALL STUDENTS
    // ==========================
    public List<StudentResponseDTO> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================
    // GET STUDENT BY ID
    // ==========================
    public StudentResponseDTO getStudentById(Long id) {

        StudentEntity student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        return mapToResponse(student);
    }

    // ==========================
    // UPDATE STUDENT
    // ==========================
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {

        StudentEntity student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        student.setStudentNumber(dto.getStudentNumber());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setPassword(dto.getPassword());

        StudentEntity updated = studentRepository.save(student);

        return mapToResponse(updated);
    }

    // ==========================
    // DELETE STUDENT
    // ==========================
    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);

    }

    // ==========================
    // ENTITY -> RESPONSE DTO
    // ==========================
    private StudentResponseDTO mapToResponse(StudentEntity student) {

        StudentResponseDTO dto = new StudentResponseDTO();

        dto.setStudentId(student.getStudentId());
        dto.setStudentNumber(student.getStudentNumber());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setPhoneNumber(student.getPhoneNumber());

        return dto;
    }
}