package studentadmission;


import java.util.Scanner;

class CourseDetail {

    Scanner s1;

	public CourseDetail(Scanner s1)
	{
            this.s1=s1;
		course(s1);
	} 
    	public void course(Scanner s1) 
	{	        
       		System.out.println("1. JAVA");
	        System.out.println("2. MCA");
        	System.out.println("3. JAVA");
	        System.out.println("4. BACK");
                System.out.println("------------------------");
                System.out.println("ENTER YOUR CHOICE:");
	        int sc = s1.nextInt();
                System.out.println("------------------------");
        	switch (sc) {
           		 case 1:
                	 new Java_Detail(s1);
                	break;
            	case 2:
                	new Python_Detail(s1);
                	break;
            	case 3:
                	new PHP_Detail(s1);
                	break;
            	case 4:
                	new Menu(s1);
                	break;
            	default:
                	System.out.println("Enter Valid Choice !");
                        System.out.println("------------------------");
                        System.out.println("------------------------");
                        break;
        }
    }
}
