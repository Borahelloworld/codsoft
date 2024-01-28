package codsoft;

import java.util.Scanner;
class Task_2{
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of subjects:");
        int s=sc.nextInt();
        int totalmarks=0;
        for(int i=1;i<=s;i++){
            System.out.println("Enter marks for subject" + i + " ");
            int marks=sc.nextInt();
            totalmarks+=marks;
        }
        double percentage=(double) totalmarks/s;
        System.out.println("Results:");
        System.out.println("Total marks:"+totalmarks);
        System.out.println("Average percentage:"+percentage+"%");
        if(percentage>=90){
            System.out.println("Grade:A");
        }
        else if(percentage>=80){
            System.out.println("Grade:B");
        }
        else if(percentage>=70){
            System.out.println("Grade:C");
        }
        else if(percentage>=60){
            System.out.println("Grade;D");
        }
        else{
            System.out.println("Grade:E");
        }
        System.out.println("Grade:");
    }
}