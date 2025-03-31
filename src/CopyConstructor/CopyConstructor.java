package CopyConstructor;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author marianky
 */
public class CopyConstructor {
    
   public static void main(String[] args){
       Student s1;
       s1 = new Student();
       s1.id = 1;
       s1.name = "John";
       s1.grades = new ArrayList<Integer>();
       s1.grades.add(10);
       s1.grades.add(20);
       
       Student s2 = new Student(s1);
       s2.id = 2;
       s2.name = "Alex";
       s2.grades.add(30);
       
       System.out.println(s1);
       System.out.println(s2);
       
   }
}

