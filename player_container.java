public class player_container {

    private int num_of_players = 0;
    private inp_out input = new inp_out();
    public player[] players = {new player(), new player(),new player(),new player(),new player(),new player()};

    player_container(){
        String[] names = new String[6];
        char[] pieces = new char[6];
        String usr_name;
        char usr_piece;
        boolean cont;
        boolean multiple;
        boolean length_check;
        while(num_of_players<2 || num_of_players>6) {
            num_of_players = input.get_int("How many people are playing?");
            if((num_of_players<2 || num_of_players>6)){
                System.out.println("That's not a valid input!");
            }
        }

        for(int i = 0; i < num_of_players; i++){
            cont = false;

            while(!cont) {
                multiple = false;
                length_check = false;
                while(true){
                    usr_name = input.get_string("Player " + (i + 1) + ", Please Enter Your name: ");
                    if(usr_name.length()<2 || usr_name.length()>21){
                        System.out.println("Sorry, names must be between 2 - 20 characters long.");
                    }
                    else{
                        break;
                    }
                }

                System.out.println(usr_name);
                for(int j = 0; j < num_of_players; j++){
                    if(usr_name.equals(names[j])){
                        multiple = true;
                    }
                }
                if(usr_name.length() > 16){
                    System.out.println("Sorry, that");
                }
                if(!multiple){
                    players[i].set_name(usr_name);
                    names[i] = usr_name;
                    cont = true;
                }



                else{
                    System.out.println("Sorry, that name has been taken.");
                }
            }

            cont = false;

            while(!cont) {
                multiple = false;
                usr_piece = input.get_char("Please enter a playing piece e.g '/'");

                for(int j = 0; j < num_of_players; j++){
                    if(usr_piece==pieces[j]){
                        multiple = true;
                    }
                }
                if(!multiple){
                    players[i].set_piece(usr_piece);
                    pieces[i] = usr_piece;
                    cont = true;
                }
                else{
                    System.out.println("Sorry, that piece has been taken.");
                }
            }
        }
    }

    int get_num_of_players(){
        return num_of_players;
    }
}