package com.example.wsdl_practice.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.io.StringWriter;

public class JaxbExample {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Customer.class);

        Customer customer = new Customer();
        customer.setName("younghyun");
        customer.setAge(30);

        // 마샬링 : XML -> Java Object
        StringWriter writer = new StringWriter();
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(customer, writer);
        System.out.println(writer.toString());

        // 언마샬링 : Java Object -> XML
        String xml = writer.toString();
        StringReader reader = new StringReader(xml);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Customer result = (Customer) unmarshaller.unmarshal(reader);
        System.out.println(result.getName() + ", " + result.getAge());
    }
}
