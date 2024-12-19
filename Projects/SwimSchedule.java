import java.util.Scanner;
public class SwimSchedule {
    /**
     * Recall that in every java program you must have a public class
     * In order to run the public class you must use a void main
     * method. Other methods defined in the class must have the modifer
     * static. That's because the main void method is static. A static
     * method can only invoke another static method. Unless you create an object of the class
     *
     */
    public static void main(String[] args) {
        //create two 2darray's
        String[][] Jeff = {
                {"", "Mon", "Tue", "Wed", "Thu"},
                {"11-12", "x", "x", "-", "-"},
                {"12-1", "-", "x", "x", "x"},
                {"1-2", "-", "x", "x", "-"},
                {"2-3", "x", "x", "x", "-"}
        };

        String[][] Anna = {
                {"", "Mon", "Tue", "Wed", "Thu"},
                {"11-12", "x", "x", "-", "x"},
                {"12-1", "-", "x", "-", "x"},
                {"1-2", "x", "x", "-", "-"},
                {"2-3", "x", "-", "x", "x"}
        };

        //info below is used for validating user input and creating menu driven program
        Scanner in = new Scanner(System.in);
        char UserInput = '/';
        char[] ans = new char[6];
        ans[0] = 'p';
        ans[1] = 's';
        ans[2] = 'f';
        ans[3] = 'i';
        ans[4] =  'g';
        ans[5] = 'q';
        boolean loop = false;
        do{
            menu();
            System.out.print("command: ");
            UserInput = in.next().charAt(0);
            switch(UserInput){
                case 'p':
                    print(Jeff, Anna);
                    break;
                case 's':
                    slot(Jeff, Anna);
                    break;
                case 'f':
                    free(Jeff, Anna);
                    break;
                case 'i':
                    individual(Jeff, Anna);
                    break;
                case 'g':
                    group(Jeff, Anna);
                    break;
                case 'q':
                    break;
                default:
                    while(loop == false){
                        System.out.println("Enter valid Option: ");
                        UserInput = in.next().charAt(0);
                        for(int i = 0; i<ans.length; i++){
                            if(UserInput==ans[i]){
                                loop = true;
                                break;
                            }
                        }
                    }
                    break;
            }


        }while(UserInput != 'q');
    }

    //function to create a menu
    public static void menu(){
        System.out.println("p - Print schedules");
        System.out.println("s - Schedule a slot");
        System.out.println("f - Free a slot");
        System.out.println("i - Show slots avaliable for individual lessons");
        System.out.println("g - Show slots avaliable for group lessons");
        System.out.println("q - Quit");
    }

    public static void print(String[][] J, String[][] A){
        System.out.println("Jeff: ");
        for(int i = 0; i<J.length; i++){
            for(int j = 0; j<J[i].length; j++){
                System.out.printf("%5s", J[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Anna: ");
        for(int a = 0; a<J.length; a++){
            for(int b = 0; b<J[a].length; b++){
                System.out.printf("%5s", A[a][b]);
            }
            System.out.println();
        }
    }

    //function to schedule a slot
    public static void slot(String[][] J, String[][] A){
        Scanner obj = new Scanner(System.in);
        System.out.print("Select instructor: (1 - Jeff, 2 - Anna): ");
        int instructor = obj.nextInt();
        //System.out.println();
        System.out.print("Select Day (1 - Mon, 2 - Tue, 3 - Wed, 4 - Thu): ");
        int Day = obj.nextInt();
        //System.out.println();
        System.out.print("Select Slot (1 - 11-12, 2 - 12-1, 3 - 1-2, 4 - 2-3): ");
        int slot = obj.nextInt();

        if(instructor == 1){
            J[slot][Day] = "x";
        }

        else{
            A[slot][Day] = "x";
        }

    }

    //free a slot
    public static void free(String[][] J, String[][] A){
        Scanner obj = new Scanner(System.in);
        System.out.print("Select instructor: (1 - Jeff, 2 - Anna): ");
        int instructor = obj.nextInt();
        //System.out.println();
        System.out.print("Select Day (1 - Mon, 2 - Tue, 3 - Wed, 4 - Thu): ");
        int Day = obj.nextInt();
        //System.out.println();
        System.out.print("Select Slot (1 - 11-12, 2 - 12-1, 3 - 1-2, 4 - 2-3): ");
        int slot = obj.nextInt();

        if(instructor == 1){
            J[slot][Day] = "-";
        }

        else{
            A[slot][Day] = "-";
        }

    }

    //avaliable slots for individual lessons
    public static void individual(String[][] J, String[][] A){
        String[][] individual = {
                {"", "Mon", "Tue", "Wed", "Thu"},
                {"11-12", "-", "-", "-", "-"},
                {"12-1", "-", "-", "-", "-"},
                {"1-2", "-", "-", "-", "-"},
                {"2-3", "-", "-", "-", "-"}
        };

        for(int i = 0; i<J.length; i++){
            for(int j = 0; j<J[i].length; j++){
                if((J[i][j] == "-") || (A[i][j] == "-")){
                    individual[i][j] = "I";
                }
            }
        }

        System.out.println();
        for(int a = 0; a<individual.length; a++){
            for(int b = 0; b<individual[a].length; b++){
                System.out.printf("%5s", individual[a][b]);
            }
            System.out.println();
        }
    }

    public static void group(String[][] J, String[][] A){
        String[][] Group = {
                {"", "Mon", "Tue", "Wed", "Thu"},
                {"11-12", "-", "-", "-", "-"},
                {"12-1", "-", "-", "-", "-"},
                {"1-2", "-", "-", "-", "-"},
                {"2-3", "-", "-", "-", "-"}
        };

        for(int i = 0; i<J.length; i++){
            for(int j = 0; j<J[i].length; j++){
                if((J[i][j] == "-") && (A[i][j] == "-")){
                    Group[i][j] = "G";
                }
            }
        }

        System.out.println();
        for(int a = 0; a<Group.length; a++){
            for(int b = 0; b<Group[a].length; b++){
                System.out.printf("%5s", Group[a][b]);
            }
            System.out.println();
        }
    }




}

