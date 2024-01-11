package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentserviceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long deptId, Department department) {
        Department dep= departmentRepository.findById(deptId).get();
        if(department.getDepartmentName()!="" || department.getDepartmentName()!=null){
                    dep.setDepartmentName(department.getDepartmentName());
        }
        if(department.getDepartmentCode()!="" || department.getDepartmentCode()!=null){
            dep.setDepartmentCode(department.getDepartmentCode());
        }
        if(department.getDepartmentAddress()!="" || department.getDepartmentAddress()!=null){
            dep.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(dep);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

}
