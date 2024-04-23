package com.example.wsdl_practice.jaxb;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement
public class Customer {
    private String name;
    private int age;
}
