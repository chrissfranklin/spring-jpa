package com.msh.lynx.analytics.util;

public class MyTest
{
  public static void main(String args)
  {
    MyTest t = new MyTest();
    t.go();
  }

  public void go()
  {
    String inputString = "abc123" +
                         "-- ORDER_BY_TOKEN_BEGIN\n" +
                         "ORDER BY one, two, three\n" +
                         "-- ORDER_BY_TOKEN_END";
    String replaceText = "ORDER BY ten DESC";
    //String regex = "^ORDER_BY_TOKEN_BEGIN*ORDER_BY_TOKEN_END$";
    String regex = "-- ORDER_BY_TOKEN_BEGIN[\\s\\S]*?ORDER_BY_TOKEN_END";
    String rezult = this.replaceTokenInString(inputString, replaceText, regex);
    System.out.println("inputString before: " + inputString);
    System.out.println("rezult after: " + rezult);
  }


  // Look for the given tokenText in sqlQuery and replace with replaceText
  // Replaces contents btwn ORDER_BY_TOKEN_START and ORDER_BY_TOKEN_END with given replaceText
  public String replaceTokenInString(String inputString, String replaceText, String regex)
  {
    String rezult = inputString.replaceAll(regex, replaceText);
    return rezult;
  }
}
