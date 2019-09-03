import java.util.Scanner;
public class inp_out {
    private Scanner reader = new Scanner(System.in);

    String get_string(String msg){
        String ascii = "****";
        for(int i = 0; i<msg.length(); i++){
            ascii +="*";
        }
        System.out.println("\n"+ascii+"\n* "+msg+" *\n"+ascii);
        System.out.println("Enter: ");
        return reader.next();
    }

    String get_string_normal(String msg){

        System.out.println(msg);
        System.out.println("Enter: ");
        return reader.next();
    }

    int get_int(String msg){

        while(true) {
            try {
                String ascii = "****";
                for(int i = 0; i<msg.length(); i++){
                    ascii +="*";
                }
                System.out.println("\n"+ascii+"\n* "+msg+" *\n"+ascii);
                System.out.println("Enter: ");
                return reader.nextInt();
            } catch (Exception e) {
                System.out.println("That's not a valid number");
                reader.next();
            }
        }
    }

    int get_int_normal(String msg){

        while(true) {
            try {

                System.out.println(msg);
                System.out.println("Enter: ");
                return reader.nextInt();
            } catch (Exception e) {
                System.out.println("That's not a valid number");
                reader.next();
            }
        }
    }

    char get_char(String msg){

        String initial = get_string(msg);
        while(initial.length() > 1){
            System.out.println("Your piece must be one char long.\nEnter your piece: ");
            initial = get_string(msg);
        }

        return initial.charAt(0);
    }

    void await_user_input(String msg){
        System.out.println(msg);
        reader.nextLine();
    }
    void make_ASCII(String OG_string){
        String ascii = "****";
        for(int i = 0; i<OG_string.length(); i++){
            ascii +="*";
        }
        System.out.println("\n"+ascii+"\n* "+OG_string+" *\n"+ascii);
    }

    void ASCII_Monopoly(){
        System.out.println("\n\n***********************************************************************************************************************************************\n*   ______             __                          __        __       __                                                    __            __  *\n* " +
                " /      \\           /  |                        /  |      /  \\     /  |                                                  /  |          /  | *\n* " +
                "/$$$$$$  | _______  $$/  _____  ____    ______  $$ |      $$  \\   /$$ |  ______   _______    ______    ______    ______  $$ | __    __ $$ | *\n* " +
                "$$ |__$$ |/       \\ /  |/     \\/    \\  /      \\ $$ |      $$$  \\ /$$$ | /      \\ /       \\  /      \\  /      \\  /      \\ $$ |/  |  /  |$$ | *\n* " +
                "$$    $$ |$$$$$$$  |$$ |$$$$$$ $$$$  | $$$$$$  |$$ |      $$$$  /$$$$ |/$$$$$$  |$$$$$$$  |/$$$$$$  |/$$$$$$  |/$$$$$$  |$$ |$$ |  $$ |$$ | *\n* " +
                "$$$$$$$$ |$$ |  $$ |$$ |$$ | $$ | $$ | /    $$ |$$ |      $$ $$ $$/$$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |$$ |  $$ |$$/  *\n* " +
                "$$ |  $$ |$$ |  $$ |$$ |$$ | $$ | $$ |/$$$$$$$ |$$ |      $$ |$$$/ $$ |$$ \\__$$ |$$ |  $$ |$$ \\__$$ |$$ |__$$ |$$ \\__$$ |$$ |$$ \\__$$ | __  *\n* " +
                "$$ |  $$ |$$ |  $$ |$$ |$$ | $$ | $$ |$$    $$ |$$ |      $$ | $/  $$ |$$    $$/ $$ |  $$ |$$    $$/ $$    $$/ $$    $$/ $$ |$$    $$ |/  | *\n* " +
                "$$/   $$/ $$/   $$/ $$/ $$/  $$/  $$/  $$$$$$$/ $$/       $$/      $$/  $$$$$$/  $$/   $$/  $$$$$$/  $$$$$$$/   $$$$$$/  $$/  $$$$$$$ |$$/  *\n* " +
                "                                                                                                     $$ |                    /  \\__$$ |     *\n* " +
                "                                                                                                     $$ |                    $$    $$/      *\n* " +
                "                                                                                                     $$/                      $$$$$$/       *\n***********************************************************************************************************************************************");

    }

    void epic_fail(){

        System.out.println("Oh no, the program has failed and cannot be recovered.\nWe here at monopoly inc. are very sorry this has happened.");
        System.out.println("\n" +
                " (                               (             (    (        )   (     \n" +
                " )\\ )    (       *   )    (      )\\ )          )\\ ) )\\ )  ( /(   )\\ )  \n" +
                "(()/(    )\\    ` )  /(    )\\    (()/(     (   (()/((()/(  )\\()) (()/(  \n" +
                " /(_))((((_)(   ( )(_))((((_)(   /(_))    )\\   /(_))/(_))((_)\\   /(_)) \n" +
                "(_))_| )\\ _ )\\ (_(_())  )\\ _ )\\ (_))     ((_) (_)) (_))    ((_) (_))   \n" +
                "| |_   (_)_\\(_)|_   _|  (_)_\\(_)| |      | __|| _ \\| _ \\  / _ \\ | _ \\  \n" +
                "| __|   / _ \\    | |     / _ \\  | |__    | _| |   /|   / | (_) ||   /  \n" +
                "|_|    /_/ \\_\\   |_|    /_/ \\_\\ |____|   |___||_|_\\|_|_\\  \\___/ |_|_\\  \n" +
                "                                                                       \n");
    }
}
