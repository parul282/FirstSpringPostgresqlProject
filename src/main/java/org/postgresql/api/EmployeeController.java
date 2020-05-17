package org.postgresql.api;


import org.postgresql.dao.EmployeeDao;
import org.postgresql.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeDao empdao;

    public EmployeeController(EmployeeDao empdao) {
        this.empdao = empdao;
    }


    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer empId){

        Optional<Employee> empDetail = empdao.findById(empId);
        if(empDetail.isPresent()){
            return ResponseEntity.ok(empDetail.get());
        }
       return ResponseEntity.notFound().build();
    }

    @GetMapping("/employee")
    public ResponseEntity<Iterable<Employee>> getAllEmployee(){
        return ResponseEntity.ok( empdao.findAll());

    }
    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
        return ResponseEntity.ok( empdao.save(emp));
    }
}
