package Variables;

public class StaticVariable {

  private   static int counter=0;


  public void counter()
  {
      counter++;
      System.out.println("count is:"+counter);
  }

    public static void main(String[] args) {
        StaticVariable sv= new StaticVariable();
       // System.out.println("the value of for the first instamce:" +counter);
        sv.counter();
      //  System.out.println("the value of for the second instamce:" +counter);
        sv.counter();
       // System.out.println("the value of for the third instamce:" +counter);
        sv.counter();



    }


}
