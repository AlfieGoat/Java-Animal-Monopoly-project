public class Main {

    public static void main(String[] args){
        inp_out inp_out= new inp_out();
        inp_out.ASCII_Monopoly();
        Threading sound_thread = new Threading();
        sound_thread.run();

        player_container container = new player_container();//Creates all players
        board board = new board();
        deck deck = new deck();
        boolean moved;
        int check;
        int error_count = 0;

        while (true){
            for(int count = 0; count < container.get_num_of_players(); count++){
                if(container.players[count].check_if_alive()){//Check if player is alive
                    try {
                        moved = false;
                        board.draw_board(container);
                        container.players[count].options(board);
                        check = container.players[count].go();//Rolls the die, checks if they pass go and checks for doubles.
                        if(check != 2){board.board_spaces[container.players[count].get_position()].land(container.players[count], container, container.get_num_of_players());}//Land
                        if(check == 1){ moved = deck.doubles_deck(container.players[count], board); }//Checks for doubles
                        if(moved){board.board_spaces[container.players[count].get_position()].land(container.players[count], container, container.get_num_of_players());}//Checks if they moved, if so they land again.
                        container.players[count].check_if_bankrupt(board);//Checks if the current player is bankrupt
                    }
                    ///**
                    catch(Exception e){//Catches any errors and will try to ignore them
                        System.out.println("\nSorry, that was invalid.");
                        error_count ++;
                        if(error_count>100){//If error happens more than 100 times, the program assumes its in a loop and dies
                            inp_out.epic_fail();
                            break;
                        }
                    }
                     //**/
                }
            }
            board.increase_buffers();
         }
    }
}