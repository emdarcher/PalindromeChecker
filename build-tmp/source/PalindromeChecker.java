import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}
public boolean palindrome(String word)
{
  String p_str = noSpaces(onlyLetters(word)).toLowerCase();
  int p_str_len = p_str.length(); 
  for(int i=0;i<(p_str_len/2);i++){
    if(p_str.charAt(i) != p_str.charAt(p_str_len-(i+1))){
      return false;
    }

  }

  return true;
}

public String noSpaces(String sWord){
  String out = new String();
  for(int i=0;i<sWord.length();i++){
    if(!(sWord.charAt(i) == ' ')){
      out += sWord.charAt(i);
    }
  }
  return out;
}
public String onlyLetters(String sString){
  String outstr = new String();
  for(int i=0;i<sString.length();i++){
    if(Character.isLetter(sString.charAt(i))){
      outstr += sString.charAt(i);
    } else {  }
  }
  return outstr;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
