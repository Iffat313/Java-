
import java.util.Scanner;

public class Main {
    //recall that this is a menu-driven program
    //function for main part of the program
    public static void main(String[] args) {
        char MenuAnswer;
        String UserPhrase;
        String UserMorseCode;
        boolean determine = false;

        String[] MorseLetters = new String[26];
        MorseLetters[0] = ".-"; //A
        MorseLetters[1] = "-..."; //B
        MorseLetters[2] = "-.-."; //c
        MorseLetters[3] = "-.."; //d
        MorseLetters[4] = "."; //e
        MorseLetters[5] = "..-."; //f
        MorseLetters[6] = "--."; //g
        MorseLetters[7] = "...."; //h
        MorseLetters[8] = ".."; //i
        MorseLetters[9] = ".---"; //j
        MorseLetters[10] = "-.-"; //k
        MorseLetters[11] = ".-.."; //l
        MorseLetters[12] = "--"; //m
        MorseLetters[13] = "-."; //n
        MorseLetters[14] = "---"; //0
        MorseLetters[15] = ".--."; //p
        MorseLetters[16] = "--.-"; //q
        MorseLetters[17] = ".-."; //r
        MorseLetters[18] = "..."; //s
        MorseLetters[19] = "-"; //t
        MorseLetters[20] = "..-"; //u
        MorseLetters[21] = "...-"; //v
        MorseLetters[22] = ".--"; //w
        MorseLetters[23] = "-..-"; //x
        MorseLetters[24] = "-.--"; //y
        MorseLetters[25] = "--.."; //z

        String[] MorseDigits = new String[10];
        MorseDigits[0] = "----";
        MorseDigits[1] = ".----";
        MorseDigits[2] = "..---";
        MorseDigits[3] = "...--";
        MorseDigits[4] = "....-";
        MorseDigits[5] = ".....";
        MorseDigits[6] = "-....";
        MorseDigits[7] = "--...";
        MorseDigits[8] = "---..";
        MorseDigits[9] = "----.";


        String[] vocab = new String[26];
        for(int i = 0, j = 65; i<26; i++, j++) {
            vocab[i] = "" + (char)j;

        }


        Scanner in = new Scanner(System.in); //in is the object of the class scanner which holds the reference of the actual object created on the heap
        //anytime you see the new operator, we are dynamically allocating memory on the heap.
        Scanner input = new Scanner(System.in);
        Scanner enter = new Scanner(System.in);


        do {
            System.out.println("Hello this program allows you to translate text to more code or translate morse code to text.");
            menu();
            MenuAnswer = in.next().charAt(0);

            while(determine == false) {
                switch(MenuAnswer) {
                    case 't':
                        System.out.println("Please enter a valid phrase:");
                        UserPhrase = input.nextLine(); //originally used one object ofr inout from class scanner. This is not a good idea as it will ignore input. So, I created another object for input
                        UserPhrase = UserPhrase.toUpperCase();
                        char[] characters = new char[UserPhrase.length()];
                        for(int i = 0; i<UserPhrase.length(); i++) {
                            if((UserPhrase.charAt(i) >= 65) && (UserPhrase.charAt(i) <= 90)) {
                                characters[i] = UserPhrase.charAt(i);
                            }
                            else if((UserPhrase.charAt(i) >= 48) && (UserPhrase.charAt(i) <= 57)) {
                                characters[i] = UserPhrase.charAt(i);
                                //the goal here is to get user input numbers from the string to the array of type char if there are any
                                //recall that in ASCII table, chars can be accessed via there decimal value
                                //numbers in char specifically from 0-9 can be accessed the decimal value of 48 - 57
                                //just to be clear, we aren't grabbing the decimal value as the number but the number that is accessed by the decimal value
                            }
                            else {
                                characters[i] = '/'; // / represents a space is needed
                            }

                        }
                        // by now the array character should be initalized. The array contains each character that makes up the phrase created by the user
                        encode(characters, MorseLetters, MorseDigits); //remember when we pass an array to a method it is always pass by reference, in a case like this
                        determine = true;
                        break;
                    case 'm':
                        System.out.println("Please enter a Morse Code: ");
                        UserMorseCode = enter.nextLine();
                        decode(UserMorseCode, MorseLetters, MorseDigits, vocab);
                        determine = true;
                        break;
                    case 'e':
                        determine = true;
                        break;
                    default:
                        System.out.println("Please enter a valid Option");
                        MenuAnswer = in.next().charAt(0);
                }

            }

            determine = false; //if user passes a valid option, we need the while loop  (to account for invalid input) to have it's condition back.


        } while(MenuAnswer!='e');
    }
    //method to print menu - recall that void methods are stand alone methods
    public static void menu() {
        System.out.println("Please select one of the below options: ");
        System.out.println("*** Enter 't' for encoding text");
        System.out.println("*** Enter 'm' for decoding morse code");
        System.out.println("*** Enter 'e' to exit the program.");
    }

    public static void encode(char[] CharArray, String[] MorseStrArray, String[] MorseIntArray) {
        //encode or convert the english phrase to morse code.
        String conversion = "";
        int index = 0;
        for(int i = 0; i<CharArray.length; i++) {
            //this if statement is checking to see if the element at the specified index is a chaarcter of A to Z. We can express this with the decimal value
            if((CharArray[i] >= 65) && (CharArray[i] <= 90)) {
                index = CharArray[i] - 65;
                conversion = conversion + MorseStrArray[index];
                conversion = conversion + " ";
            }

            else if((CharArray[i] >= 48) && (CharArray[i] <= 57)) {
                index = CharArray[i] - 48;
                conversion = conversion + MorseIntArray[index];
                conversion = conversion + " ";
            }

            else {
                conversion = conversion + "   ";
            }

        }

        System.out.println("MorseCode:");
        System.out.println(conversion);
        /**
         * Explain your encode method; This method accepts three arrays per parameter.
         * 1- An array of type char (this is where broke down the english into characters, and stored each character into an element of the array. / slashes indicate a space)
         * 2- An array of type string (specifically, each element in this string corresponds to an alaphabets morse code. It should also be noted that by conveince, the morse code
         * in the array goes from A-Z so 0-26. Essentially, index 0 represents morse code of letter A as it's the first letter and index 1 would represent more code  of letter B and so fourth)
         * 3- Another array of type string (it is the same from 2 but here each index represents the morse code for each digit)
         * I created a string variable called conversion. I would traverse through array #1 and I would use ASCII values to see if the chaarcter in question was a letter or digit.
         * You can clearly see this in the if statement structure. If the character was a letter, how would I grab the correct morse code? I would use array #2. But how would the
         * JVM know which index to grab it from? Remember, integers and chars go hand in hand. I would take char letter and subtract it by 65. What happens here is that it takes the
         * decimal value difference as the output value. This value would represent the index of the character for it's morse code. What's nice is that I have arranged the indices
         * to follow the order of the alphabate + accouting for index coiunting. For example, if I grabbed the letter C, I would do C - 65 which is 67 - 65 = 2. C is the third letter
         * of the alphabet but because index counting we -1. As you can see, it's already -1 because of index couting. So I would use this index and grab the corresponding morse code
         * letter and add it to my convesion string variable.
         */
    }

    public static void decode(String InputMorseCode, String[] MorseLetters,
                              String[] MorseDigits, String[] letters) {
        String revert = "";
        String hold = "";
        int i = -1;
        int a = 0;
        int b = 0;
        while(i<InputMorseCode.length()) {
            i++;
            if((i<InputMorseCode.length()) && (InputMorseCode.charAt(i)== ' ') && (InputMorseCode.charAt(i+1) == ' ')) {
                revert = revert + " ";
                continue;
            }
            else if((i<InputMorseCode.length()) && (InputMorseCode.charAt(i) != ' ')) {
                hold = hold + InputMorseCode.charAt(i);
                continue;
            }
            else {
                for(int j = 0; j<MorseDigits.length; j++) {
                    if(hold.equals(MorseDigits[j])) {
                        revert = revert + j;
                    }
                }
                for(int m = 0; m<MorseLetters.length; m++) {
                    if(hold.equals(MorseLetters[m])) {

                        revert = revert + letters[m];
                    }
                }
                hold = "";
            }
        }
        System.out.println(revert);
    }
}
