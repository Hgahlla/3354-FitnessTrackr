
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.Scanner;


public class SignUp {
    private static final String database = "database.txt";
    public static final int password_length = 8;

    public static void main(String args[]) throws FileNotFoundException {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        
        //Prompting user for input
        System.out.println("Please enter the following information.");
        
        System.out.print("First name: ");
        String str = sc.nextLine();
        while(isValidName(str))
        {
            System.out.println("Your first name is invalid. Try again.");
            System.out.print("First name: ");
            str = sc.nextLine();
        }
        user.setFirstName(sc.nextLine());
        
        System.out.print("Last name: ");
        str = sc.nextLine();
        while(isValidName(str))
        {
            System.out.println("Your last name is invalid. Try again.");
            System.out.print("Last name: ");
            str = sc.nextLine();
        }
        user.setLastName(sc.nextLine());
        
        System.out.print("Email address: "); 
        str = sc.nextLine();
        while(exist(str))
        {
            System.out.println("Email has been use, please try another.");
            System.out.print("Email address: ");
            str = sc.nextLine();
        }
        user.setUsername(str);
        
        System.out.print("Password(use 8 or more characters with a mix of at least 1 letter and 1 number): ");
        str = sc.nextLine();
        while(!isValidPW(str))
        {
            System.out.println("Invalid password.");
            System.out.print("Password: ");
            str = sc.nextLine();
        }
        user.setPW(str);

        System.out.print("Height (in inches): ");
        while(!isNumber(str))
        {
            System.out.println("Invalid height.");
            System.out.print("Height (in inches): ");
            str = sc.nextLine();
        }
        user.setHeight(sc.nextLine());
        
        System.out.print("Weight (in lbs): ");
        while(!isNumber(str))
        {
            System.out.println("Invalid weight.");
            System.out.print("Weight (in lbs): ");
            str = sc.nextLine();
        }
        user.setWeight(sc.nextLine());
        
        System.out.print("Gender (male/female): ");
        str = sc.nextLine();
        while (str.toLowerCase().equals("male")||str.toLowerCase().equals("female"))
        {
            System.out.println("Invalid gender. Try again.");
            System.out.print("Gender (male/female): ");
            str = sc.nextLine();
        }
        user.setGender(str);

        
        System.out.print("DOB (mm/dd/yyyy): ");
        str = sc.nextLine();
        while (!isValidFormat(str))
        {
            System.out.println("Invalid date format. Try again.");
            System.out.print("DOB (mm/dd/yyyy): ");
            str = sc.nextLine();
        }
        user.setDOB(sc.nextLine());
        WriteInfoToDB(user);
    }
 
    public static boolean isValidName(String name)
    {
        for (int i = 0; i < name.length(); i++) 
        {
            char ch = name.charAt(i);
            if (!isLetter(ch)) return false;
        }
        return true;
    }
    public static boolean exist(String email) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File(database));
        while (sc.hasNext())
        {
            String info = sc.nextLine();
            int index = info.indexOf(' ',1);
            if (email.equals(info.substring(0,index)))
                return true;
        }
        return false;
    }
    
    public static boolean isValidPW(String pw)
    {
        if (pw.length()<password_length)
            return false;
        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < pw.length(); i++) {

            char ch = pw.charAt(i);

            if (isNumeric(ch)) numCount++;
            else if (isLetter(ch)) charCount++;
            else return false;
        }
        return (charCount >= 1 && numCount >= 1);
    }
    
    public static boolean isNumber(String str)
    {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!isNumeric(ch)) 
                return false;
        }
        return true;
    }
    
    public static boolean isLetter(char ch) 
    {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isNumeric(char ch) 
    {
        return (ch >= '0' && ch <= '9');
    }
    
    public static boolean isValidFormat(String value) 
    {
        LocalDateTime ldt = null;
        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        try {
            ldt = LocalDateTime.parse(value, fomatter);
            String result = ldt.format(fomatter);
            return result.equals(value);
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(value, fomatter);
                String result = ld.format(fomatter);
                return result.equals(value);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(value, fomatter);
                    String result = lt.format(fomatter);
                    return result.equals(value);
                } catch (DateTimeParseException e2) {
                }
            }
    }

    return false;
}
    
    public static void WriteInfoToDB(Object obj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(database);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(obj);
            objectOut.close();
            System.out.println("You have successfully signed up!");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
