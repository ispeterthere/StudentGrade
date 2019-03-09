/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentGrade;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


/**
 *
 * @author plsan
 */
public class Utility {

    private int numStudent = 0;
    private int numOfPrograms = 0;
    private int numOfQuizzes = 0;

    ArrayList<String> name;
    ArrayList<String> surname;
    ArrayList<String> students;

    Array[][] quizAverage;
    Array[][] programAverage;
    Array[][] attendanceScore;


    public void getFile() throws IOException
    {
        students = new ArrayList<String>();

        //Declaration of variables
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = keyboard.nextLine().trim();
        String fileNameTxt = fileName + ".txt";
        createFile(fileNameTxt, numStudent, numOfPrograms, numOfQuizzes);

    }

    public  void createFile(String fileNameTxt, int numStudent, int numOfPrograms, int numOfQuizzes) {
        //Creating the file
        File inputFile = new File(fileNameTxt);

        try
        {
            if(inputFile.createNewFile())
            {
                Scanner keyboard = new Scanner(System.in);
                //Asking for input for number of students
                System.out.print("File created! Answer the following questions:");
                System.out.print("\nEnter Number of Students to be graded: ");
                numStudent = keyboard.nextInt();
                while(numStudent < 1)
                {
                    System.out.print("Please enter a valid number of Students: ");
                    numStudent = keyboard.nextInt();
                }
                //number of programs
                System.out.print("Enter number of programs: ");
                numOfPrograms = keyboard.nextInt();
                while (numOfPrograms < 1)
                {
                    System.out.print("Please enter a valid number of Programs: ");
                    numOfPrograms = keyboard.nextInt();
                }
                //Number of quizzes
                System.out.print("Enter number of Quizzes: ");
                numOfQuizzes = keyboard.nextInt();
                while (numOfQuizzes < 1)
                {
                    System.out.println("Please enter a valid number of Quizzes: ");
                    numOfQuizzes = keyboard.nextInt();
                }

                //Saves information to file
                write_file(fileNameTxt, numStudent, numOfPrograms, numOfQuizzes);
                //getStudent info
                //Index for each student
                int index = 0;

                for(int countStudent = 1; countStudent <= numStudent; countStudent++)
                {
                    do{
                        getStudent();
                        //formats the arraylist to display name without characters
                        System.out.println("Student number is " + students.get(index).replace("," , "").replace("[", "")
                                .replace("]","").replace(" ", "").trim());
                        index++;


                    }
                    while (countStudent<= numStudent)

                }
            }
            else
            {
                System.out.println("Searching for information...");
                //Read from file
                FileReader fileReader = new FileReader(fileNameTxt);
                BufferedReader bufferedReader =  new BufferedReader(fileReader);


                numStudent = Integer.parseInt(bufferedReader.readLine());
                numOfPrograms = Integer.parseInt(bufferedReader.readLine());
                numOfQuizzes = Integer.parseInt(bufferedReader.readLine());



                bufferedReader.close();
            }
        }
        catch (IOException e)
        {
            System.out.print("An Error Occured");
            e.printStackTrace();
        }

        System.out.println(numStudent+" "+ numOfPrograms + " " + numOfQuizzes );
    }



    public void write_file(String fileNameTxt, int numStudent, int numOfPrograms, int numOfQuizzes) throws IOException
    {
        FileWriter fileWriter = new FileWriter(fileNameTxt);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(numStudent +"\n"+ numOfPrograms + "\n" + numOfQuizzes);


        bufferedWriter.close();


    }

    public void saveStudentFile(String fileNameTxt) throws IOException
    {
        FileWriter fileWriter = new FileWriter(fileNameTxt);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);



    }

    public void getStudent()
    {
        Scanner keyboard = new Scanner(System.in);
        //Get student information
        System.out.print("Enter student First name: ");
        name.add(keyboard.nextLine().trim());
        System.out.print("Enter student Last name: ");
        surname.add(keyboard.nextLine().trim());

        //Get 1st letter of name and surname
        char letter1 = name.charAt(0);
        char letter2 = surname.charAt(0);
        //generate random number
        Random randomNum = new Random();
        //Created array for random num
        ArrayList<Integer> idNum =  new ArrayList<Integer>();
        int num;
        //Loop to generate 6 random numbers
        for(int i = 0; i < 6; i++)
        {
            num = randomNum.nextInt(10);
            idNum.add(num);
        }
        //Adds the information to the students array list
        students.add(String.valueOf(letter1) + letter2 + idNum.toString());

    }





}
