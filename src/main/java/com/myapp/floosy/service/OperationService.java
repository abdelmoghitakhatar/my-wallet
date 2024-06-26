package com.myapp.floosy.service;

import com.myapp.floosy.dao.OperationRepository;
import com.myapp.floosy.model.Operation;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class OperationService {

    private final OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public List<Operation> getAllOperations(){
        return operationRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Operation save(Operation operation){
        return operationRepository.save(operation);
    }
}
