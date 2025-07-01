package classesandobjects;

public class Student {
        //Properties of Pen Object
        String name;
        int age;

        public String getInformation()
        {
          return  "my name is :"+name+" my age is : "+age ;

        }


        public static void main(String[] args)
        {
            Student s = new Student();
            s.name="sowmya";
            s.age=21;
           // s.getInformation();

            String information = s.getInformation();
            System.out.println(information);



        }

    }

