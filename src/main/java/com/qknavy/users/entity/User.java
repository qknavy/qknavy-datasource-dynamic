package com.qknavy.users.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable
{
    private static final long serialVersionUID = -5738590165229910140L;
    private int id;
    private String name;
    private int age;
    private double money;
}
