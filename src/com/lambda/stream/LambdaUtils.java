package com.lambda.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LambdaUtils {

    public static List<Employee> getEmployees(){
        List<Employee> empList = new LinkedList<>();
        empList.add(new Employee(1,"Ravindra","IT",34000));
        empList.add(new Employee(2,"Jon","OPS",2090));
        empList.add(new Employee(3,"Ankit","OPS",89000));
        empList.add(new Employee(4,"Raj","IT",36000));
        empList.add(new Employee(5,"Ram","Manu",3000));
        empList.add(new Employee(6,"Ved","IT",4000));

        return empList;

    }

    public static List<String> getNames(){

        List<String> memberNames = new LinkedList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Ravindra");


        memberNames.add("Lokesh");
        return memberNames;
    }
}
