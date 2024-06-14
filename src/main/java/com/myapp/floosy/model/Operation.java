package com.myapp.floosy.model;

import com.myapp.floosy.model.enumeration.TypeOperation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double montant;

    private TypeOperation operation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public TypeOperation getOperation() {
        return operation;
    }

    public void setOperation(TypeOperation operation) {
        this.operation = operation;
    }
}
