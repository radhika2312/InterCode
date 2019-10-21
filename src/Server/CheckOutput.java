
package javaapplication9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class CheckOutput {

  private  final static String javaComp="javac";
  private  final static String javaExec="java";
  private  final static String cComp="gcc";
  private  final static String cExec="a.exe";
  private  final static String cppComp="g++";
  private final static String pythonExec = "python";
  private final static String cppExec="a.exe";
  private  final static long timeAllotted=1000;
  private static boolean success;
  private static  String compile=null;
  private static String runResult=null;
  private static String language="C++";
  private static String compiling  = "any";
    //private static  String direc="C:\\Users\\Ankit Raj\\Documents\\NetBeansProjects\\InterCode-myfeature";
 private final String direc;
  /* public CheckOutput(String language){
       this.language=language;
      // checkOutput();
   }*/
    /*public static void main(String[] args) {
        checkOutput();
    }*/
  public  CheckOutput(String lan) throws IOException
    {
        this.direc = new java.io.File( "." ).getCanonicalPath();
       this.language = lan;
    }
  public String checkOutput()
  {
      String[] compCommand=null;
        String[] execCommand=null;
        switch(language){
            case "Java":
             compCommand=new String[]{javaComp, direc +"\\testjava.java"};
             execCommand=new String[]{javaExec,"testjava"};
             break;
            case "C":
             compCommand=new String[]{cComp, direc +"\\testc.c"};
             execCommand=new String[]{ direc +"\\a.exe"};
              break;
            case "C++":
             compCommand=new String[]{cppComp, direc + "\\testcpp.cpp"};
             execCommand=new String[]{ direc +"\\a.exe"};
             break;
            case "Python":
                execCommand = new String[]{pythonExec ,direc + "\\testpython.py"};
                compiling = "Python";
                break;
        }
        try{
         if(compiling!="Python"){
               ProcessBuilder pb=new ProcessBuilder(compCommand);
              Process cmp=pb.start();
               int compileResult=cmp.waitFor();
               if(compileResult!=0){
                   System.out.println("compile Fail");
                   return "Compile Fail";
                  
               }   
               else
               {
                   System.out.println("Compile Successful");
                   compile="CompileSuccessful";
               }
          
               ProcessBuilder builder=new ProcessBuilder(execCommand);
               File input=new File(direc+  "\\input.txt");
               File output=new File(  direc+"\\output.txt");
               File error=new File(direc+ "\\error.txt");
               builder.redirectInput(input);
               builder.redirectOutput(output);   
               builder.redirectError(error);
              // builder.directory(new File(direc));
              Process run=builder.start();
              try{
              boolean ans = run.waitFor(2, TimeUnit.SECONDS);
              if(ans==false)
              { run.destroy();
              return "TLE";}
              }
              catch(Exception e){
                  System.out.println(e);
              }       
      }
         
        }
        catch(IOException | InterruptedException e){
            
        }
        return "CompileSuccessful";
      
  }
    
   
}
