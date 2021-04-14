package com.Igor;

import java.util.*;

class MergeSort{
    public int [] sortArray (int [] array){
        if (array == null){
            return null;

        }
        if (array.length < 2){
            return array;
        }
        int [] arrayLeft = new int[array.length/2];
        System.arraycopy(array, 0, arrayLeft, 0, array.length/2);

        int [] arrayRight = new int[array.length - array.length/2];
        System.arraycopy(array, array.length/2, arrayRight, 0, array.length - array.length/2);

        arrayLeft = sortArray(arrayLeft);
        arrayRight = sortArray(arrayRight);

        array = mergeArray(arrayLeft,arrayRight);

        return array;
    }
    public int [] mergeArray (int [] arrayLeft,int []arrayRight){
        int lindex=0, rindex=0;
        int [] array;

        if (arrayLeft.length + arrayRight.length < 1) {
            return null;
        }
        else {
            array = new int [ arrayLeft.length + arrayRight.length];
        }
        for (int i = 0; i < arrayLeft.length + arrayRight.length; i++){
            if (lindex < arrayLeft.length){
                if (rindex < arrayRight.length){
                    if (arrayLeft[lindex] < arrayRight[rindex]){
                        array[i]=arrayLeft[lindex];
                        lindex++;
                    }
                    else{
                        array[i] = arrayRight[rindex];
                        rindex++;
                    }
                }
                else {//arrayRight is over
                    for (;i<arrayLeft.length + arrayRight.length;i++) {
                        array[i] = arrayLeft[lindex];
                        lindex++;
                    }
                }
            }
            else{//arrayLeft is over
                for(;i < arrayLeft.length + arrayRight.length;i++){
                    array[i] = arrayRight[rindex];
                    rindex++;
                }
            }
        }
        return array;
    }
}

class Student implements Comparable<Student>{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
    public int compareTo(Student s){
        if (s.getCgpa()=this.getCgpa()){
            return 0;
        }
        else if(s.getCgpa()<this.getCgpa()){
            return 1;
        }
        return 0;
    }
}

//Complete the code
public class Solution
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}
