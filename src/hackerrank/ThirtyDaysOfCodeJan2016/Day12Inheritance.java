package hackerrank.ThirtyDaysOfCodeJan2016;

import java.util.Scanner;

/**
 * Created by dtse7 on 21/01/2016.
 */
public class Day12Inheritance {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String firstName=sc.nextLine();
        String lastName=sc.nextLine();
        int phone=sc.nextInt();
        int score=sc.nextInt();
        Student stu=new Grade(firstName,lastName,phone,score);
        stu.display();
        Grade g=(Grade)stu;
        System.out.println("Grade: "+g.calculate());
    }

}

class Student{
    protected String firstName;
    protected String lastName;
    int phone;
    Student(String fname,String lname,int p){
        firstName=fname;
        lastName=lname;
        phone=p;

    }
    public void display(){// display the details of the student
        System.out.println("First Name: "+firstName+"\nLast Name: "+lastName+"\nPhone: "+phone);
    }

}

class Grade extends Student{
    private int score;

    Grade(String firstName, String lastName, int phone, int score) {
        super(firstName, lastName, phone);
        this.score = score;
    }

    char calculate() {
        if(score < 40) return 'D';
        else if(score < 60) return 'B';
        else if(score < 75) return 'A';
        else if(score < 90) return 'E';
        else return 'O';
    }

}