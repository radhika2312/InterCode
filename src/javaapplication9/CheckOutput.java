
package javaapplication9;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ankit Raj
 */
public class CheckOutput {

  private  final static String javaComp="javac";
  private  final static String javaExec="java";
  private  final static String cComp="gcc";
  private  final static String cExec="a.exe";
  private  final static String cppComp="g++";
  private final static String cppExec="a.exe";
  private  final static long timeAllotted=1000;
  private static boolean success;
  private static  String compile=null;
  private static String runResult=null;
  private static String language="C++";
  private static  String direc="C:\\Users\\Ankit Raj\\Documents\\NetBeansProjects\\InterCode-myfeature";
 
  /* public CheckOutput(String language){
       this.language=language;
      // checkOutput();
   }*/
    /*public static void main(String[] args) {
        checkOutput();
    }*/
   CheckOutput(String lan)
    {
       language = lan;
        System.out.println("IN class" + language);
        String[] compCommand=null;
        String[] execCommand=null;
        switch(language){
            case "Java":
             compCommand=new String[]{javaComp,"C:\\Users\\Ankit Raj\\Documents\\NetBeansProjects\\InterCode-myfeature\\testjava.java"};
             execCommand=new String[]{javaExec,"testjava"};
             break;
            case "C":
             compCommand=new String[]{cComp,"C:\\Users\\Ankit Raj\\Documents\\NetBeansProjects\\InterCode-myfeature\\testc.c"};
             execCommand=new String[]{"C:\\Users\\Ankit Raj\\Documents\\NetBeansProjects\\InterCode-myfeature\\a.exe"};
              break;
            case "C++":
             compCommand=new String[]{cppComp,"C:\\Users\\Ankit Raj\\Documents\\NetBeansProjects\\InterCode-myfeature\\testcpp.cpp"};
             execCommand=new String[]{"C:\\Users\\Ankit Raj\\Documents\\NetBeansProjects\\InterCode-myfeature\\a.exe"};
             break;
          //Time to compile
        }
        try{
           //    System.out.println(execCommand[1]);
               ProcessBuilder pb=new ProcessBuilder(compCommand);
              Process cmp=pb.start();
               int compileResult=cmp.waitFor();
               if(compileResult!=0){
                   System.out.println("Compile Fail");
                   //compile="Compile Fail";
                  // return;
               }   
               else
               {
                   System.out.println("Compile Successful");
                   compile="Compile Successful";
               }
                   
               ProcessBuilder builder=new ProcessBuilder(execCommand);
               File input=new File(direc + "\\input.txt");
               File output=new File( direc + "\\output.txt");
               File error=new File(direc + "\\error.txt");
               builder.redirectInput(input);
               builder.redirectOutput(output);   
               builder.redirectError(error);
              // builder.directory(new File(direc));
              Process run=builder.start();
               long startTime=Calendar.getInstance().getTimeInMillis();
               /*boolean ankit=run.waitFor(timeAllotted, TimeUnit.MILLISECONDS);
               if(ankit)
                   System.out.println("Run successful");
               else
                   System.out.println("TLE");*/
                   try{
                       run.exitValue();
                   }
                   catch(Exception e){
                       long timeTaken=Calendar.getInstance().getTimeInMillis() - startTime;
                       System.out.println(timeTaken);
                       if(timeTaken> timeAllotted)
                       {
                           System.out.println("TLE");
                           success=false;
                           runResult="Failed";
                           run.destroy();
                       }
                       
                   }
         
               //boolean correct=checkResult(output);
              
        }
        catch(IOException | InterruptedException e){
            
        }  
    }
    
    
}
