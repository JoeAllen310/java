// Joseph Allen
package boardingpass;

import java.util.Random;

public class BoardingPass
{
    public static void main(String[] args) 
    {
        System.out.println( "Hello everyone!!! Welcome to The Springfield International Airlines."+"\n Thank you for choosing our airlines, and I hope you enjoy your flight." +"\n"  );
        BoardPass();
    }

    public static void BoardPass() 
    {
       
        PplBoarding P1 = new PplBoarding("Montgomery", "Burns", "First Class", " 08/ 28/ 30", 15);
        PplBoarding P2 = new PplBoarding("Disco", "Stu ", "Economy ", "11/ 01/ 78 ", 20);
        PplBoarding P3 = new PplBoarding("Ned", "Flanders", "Elderly", " 02/ 25/55 ", 5);
        PplBoarding P4 = new PplBoarding("Krusty", "Clown ", "Veteran ", "11/ 11/ 78 ", 10);
        PplBoarding P5 = new PplBoarding("Abe", "Simpson", "Elderly", " 05/ 18/ 32", 5);
        PplBoarding P6 = new PplBoarding("Waylon", " Smithers", "Economy ", "01/ 01/ 68 ", 20);
        PplBoarding P7 = new PplBoarding("Marge", " Simpson", "Traveling with Infant", " 02/ 6/ 70", 1);
        PplBoarding P8 = new PplBoarding("Doctor", "Hibbert ", "First Class ", "3/ 15/ 59 ", 15);
        PplBoarding P9 = new PplBoarding("Apu", "Nahasapeemapetilon,", "Traveling with Infant", " 04/ 27/ 69", 1);
        PplBoarding P10 = new PplBoarding("Captain", " McAllister", "Veteran ", "10/ 17/ 75 ", 10);
        PplBoarding P11 = new PplBoarding("Bart", "Simpson", "First Class ", " 04/ 6/ 90", 15);
        PplBoarding P12 = new PplBoarding("Homer", " Simpson ", "Economy ", "06/ 03/ 78 ", 20);
        PplBoarding P13 = new PplBoarding(" Jasper", "Beardly", "Veteran", " 07/ 21/ 35", 10);
        PplBoarding P14 = new PplBoarding("Brandine", "Spuckler ", "Traveling with Infant ", "05 16/ 78 ", 1);
        PplBoarding P15 = new PplBoarding("Crazy", "CatLady ", "Elderly ", "09 07/ 49 ", 5);

        PplBoarding[] Pass = new PplBoarding[15];

        Pass[0] = P1;
        Pass[1] = P2;
        Pass[2] = P3;
        Pass[3] = P4;
        Pass[4] = P5;
        Pass[5] = P6;
        Pass[6] = P7;
        Pass[7] = P8;
        Pass[8] = P9;
        Pass[9] = P10;
        Pass[10] = P11;
        Pass[11] = P12;
        Pass[12] = P13;
        Pass[13] = P14;
        Pass[14] = P15;
        
        for (int i = 0; i < Pass.length; i++) {
            System.out.println(Pass[i]);
            System.out.println("");
        }
        
        ShuffleBoarding(Pass);
    }

  
    public static void ShuffleBoarding(PplBoarding[] array) {
        System.out.println(" Now that everyone is here, we now will be seating everyone on the flight in order to highest Priority" +"\n"  );
        BPQueue Line = new BPQueue (15);
        int index;
        PplBoarding temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }

        
        for (int i = 0; i < array.length; i++) {
            Line.insert(array[i]);
        }
        for (int j = 0; j < 15; j++) {
           System.out.println(Line.delete());
             System.out.println("");
        }
       
    }

}
