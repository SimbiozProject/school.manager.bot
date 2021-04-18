package com.example.telegramBot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
// Аннотация, которая говорит нам, что это суперкласс для всех Entity
@MappedSuperclass
@Access(AccessType.FIELD)

@Getter
@Setter

public abstract class AbstractBaseEntity {
    public static final int START_SEQ = 100000;
    // Аннотации, описывающие механизм генерации id
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")

    protected Integer id;

    protected AbstractBaseEntity(){

    }

}
