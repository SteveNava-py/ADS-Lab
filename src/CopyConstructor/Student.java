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
public class Student {
    int id;
    String name;
    ArrayList<Integer> grades;

    public Student(){
    }
    
    public Student(Student original) {
       if(original == null){
           System.out.println("Copy Constructor can't copy an empty object!!");
           System.exit(0);
       }
       
        this.id = original.id;
        this.name = original.name;
        //wrong way of doing it 
        //this.grades = original.grades;
        
        //right way of doing it
        this.grades = new ArrayList<Integer>();
        this.grades.addAll(original.grades);
    }
    
    @Override
    public String toString(){
        return this.id + " : " + this.name+ " : "+this.grades.toString();
    }
}
