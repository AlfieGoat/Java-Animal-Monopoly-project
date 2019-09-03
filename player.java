public class player {
    private String name;
    private int money = 2500; //Int because all values of transactions should be Ints
    private boolean alive = true;//Bool describing whether they are alive or not
    private int position = 0; //Int value of where on the board the player lies (0-26)
    private boolean miss_a_go = false; //A bool value which represents whether the player will miss their go
    private char playingPiece; //How their player will be represented on the board
    private inp_out inp = new inp_out();
    private String[] animals_owned = new String[50];//Creates a nwe string array with length 50
    private int number_of_animals = 0; //Keeps track of how many animals this player owns

    sleep sleep = new sleep();
    void options(board board){
        inp.make_ASCII(this.name+" Options");
        while (true){//TODO Add sending money to other players.
            System.out.println("\n"+this.name+" it is your go!");
            int choice = inp.get_int_normal("\n1. View your animals\n2. Upgrade your animals\n3. View balance\n4. continue to your roll");
            if(choice == 1){
                if(number_of_animals == 0){
                    System.out.println("You don't own any animals yet :(. Go buy some animals!");
                }
                else {
                    System.out.println("\nAnimals you own:");
                    for (int i = 0; i < number_of_animals; i++) {
                        System.out.println((i+1) + ": " + animals_owned[i]);
                    }

                    int animal_choice = inp.get_int_normal((this.number_of_animals+1)+": Exit\n\nType the number of the animal you want to view");
                    if((animal_choice>0)&&!(animal_choice>this.number_of_animals)){
                        for(int i = 0; i < 26; i++){
                            if(board.board_spaces[i].get_name().equals(animals_owned[animal_choice-1])){
                                board.board_spaces[i].get_stats();
                            }
                        }
                    }
                }
            }
            else if(choice ==2){
                if(number_of_animals == 0){
                    System.out.println("You don't own any animals yet :(. Go buy some animals!");
                }
                else {
                    System.out.println("\nAnimals you own:");
                    for (int i = 0; i < number_of_animals; i++) {
                        System.out.println((i + 1) + ": " + animals_owned[i]);
                    }

                    int animal_choice = inp.get_int_normal((this.number_of_animals + 1) +
                            ": Exit\n\nType the number of the animal you want to upgrade");
                    if ((animal_choice > 0) && !(animal_choice > this.number_of_animals)) {
                        for (int i = 0; i < 26; i++) {
                            if (board.board_spaces[i].get_name().equals(animals_owned[animal_choice - 1])) {
                                if (this.money > board.board_spaces[i].get_uprade_cost()) {
                                    if(board.board_spaces[i].upgrade()!=0) {
                                        this.money -= board.board_spaces[i].get_uprade_cost();
                                        sleep.processing(750, true);
                                        System.out.println(this.name + "'s new balance: " + this.money);
                                    }
                                } else {
                                    System.out.println("You don't have enough money to upgrade your " +
                                            board.board_spaces[i].get_name() + "\nYour " + board.board_spaces[i].get_name() +
                                            " costs" + board.board_spaces[i].get_uprade_cost() +
                                            "to upgrade!\nbalance: \"+this.money");
                                }
                            }
                        }
                    }
                }
            }
            else if(choice == 3){
                print_balance();
            }
            else{break;}
        }
    }
    void print_balance(){
        System.out.println(this.name+"'s balance: £"+this.money);
    }
    int get_position(){return this.position;}
    char get_playing_piece(){return this.playingPiece;}
    void check_if_bankrupt(board board){
        if(this.money < 1){
           inp.make_ASCII ("Oh no! You have gone bankrupt!\nThanks for playing " + this.name+"!");
            alive = false;
            for(int i = 0; i < this.number_of_animals; i++){
                for(int j = 0; j < 28; j++){
                    if(this.animals_owned[i].equals(board.board_spaces[j].get_name())){
                        board.board_spaces[j].reset();
                        inp.make_ASCII("The "+ board.board_spaces[j].get_name() + " has been placed back onto the board and can now be bought");
                    }

                }
            }
        }
    }

    void give_money(int amount){
        this.money += amount;
    }

    void set_animal_ownership(String animal_name){
        animals_owned[number_of_animals] = animal_name;
        number_of_animals ++;
    }

    void set_name(String name){
        this.name = name;
        inp.make_ASCII("Welcome "+ this.name+"!");
    }

    void set_piece(char playingPiece){
        this.playingPiece = playingPiece;
    }

    String get_name(){
        return this.name;
    }

    boolean check_if_alive(){
        return alive;
    }

    int get_money(){
        return this.money;
    }
    void take_money(int amount){
        this.money -= amount;
    }
    int go(){
        if(!miss_a_go) {
            inp.make_ASCII("Time to roll, "+this.name+"!");
            dice die = new dice();


            inp.await_user_input(("\n" + this.name + " it is time to roll!\nPress 'Enter' to roll the dice!"));//Wait for user
            System.out.println("Rolling...");

            sleep.sleep(1000);

            int roll_1 = die.roll();
            int roll_2 = die.roll();
            int total = roll_1 + roll_2;

            boolean doubles = false;//TODO add doubles card

            if (roll_1 == roll_2) {
                doubles = true;
            }

            System.out.println("You rolled a " + roll_1 + " and a " + roll_2 + "!\nMoving!");
            sleep.sleep(800);
            move_forwards(total);
            if(doubles){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            System.out.println("Oh no, "+this.name+", you miss a go!");
            sleep.sleep(1800);
            miss_a_go = false;
            return 2;
        }
    }

        void set_miss_a_go(){
            this.miss_a_go = true;
        }
    void set_pos(int pos){
        this.position = pos;
    }
    void move_forwards(int spaces){//Player movement
        int last_square = 25;

        if((this.position + spaces) > last_square){//If moving past go
            this.position = spaces - (last_square+1-this.position);
            if(this.position != 0){//Check if landed on go.
                System.out.println("\nYou passed go! Collect £500.\nProcessing...");
                this.money += 500;
            }
        }
        else{
            this.position += spaces;
        }
    }

    void move_backwards(int spaces){
        int last_square = 25;

        if(this.position - spaces < 0){
            this.position = -spaces + last_square + this.position + 1;
        }
        else{
            this.position -= spaces;
        }
    }
    void lose_last_animal(board board){
        if(number_of_animals==0){
            System.out.println("You were lucky you didn't have any animals!");
        }
        else {
            System.out.println("Oh no you lost your "+ this.animals_owned[this.number_of_animals-1]+"!");
            board.board_spaces[this.number_of_animals-1].reset();
            this.animals_owned[this.number_of_animals-1] = "";
            this.number_of_animals -= 1;


        }
    }
    String get_last_animal(){
        return this.animals_owned[this.number_of_animals-1];
    }
}
