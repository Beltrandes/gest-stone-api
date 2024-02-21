package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.EmployeeDTO;
import com.beltrandes.geststoneapi.enums.EmployeeRole;
import com.beltrandes.geststoneapi.models.Employee;
import com.beltrandes.geststoneapi.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAll() {
        return employeeRepository.findAll().stream().map((result) -> modelMapper.map(result, EmployeeDTO.class)).toList();
    }

    public EmployeeDTO getById(UUID id) {
        var entity = employeeRepository.findById(id).orElseThrow();
        return modelMapper.map(entity, EmployeeDTO.class);
    }

    public EmployeeDTO create(EmployeeDTO employeeDTO) {
       return modelMapper.map(employeeRepository.save(modelMapper.map(employeeDTO, Employee.class)), EmployeeDTO.class);
    }

    public EmployeeDTO update(UUID id, EmployeeDTO employeeDTO) {
        var entity = employeeRepository.findById(id).orElseThrow();
        entity.setName(employeeDTO.getName());
        entity.setDocumentNumber(employeeDTO.getDocumentNumber());
        entity.setEmployeeRole(EmployeeRole.valueOf(employeeDTO.getEmployeeRole()));
        return modelMapper.map(employeeRepository.save(entity), EmployeeDTO.class);
    }

    public void delete(UUID id) {
        var entity = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(entity);
    }
}
