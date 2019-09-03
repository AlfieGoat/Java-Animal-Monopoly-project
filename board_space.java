public class board_space {
    private String name;
    private int cost;
    private int level_up_cost;
    private int[] landing_cost_level_array = new int[4];
    private String owner;
    private boolean owned;
    private int current_level;
    private inp_out inp = new inp_out();
    private boolean miss_a_go;
    private boolean start;
    private sleep sleep = new sleep();
    private String file;
    private int time_ms;
    private sound sound = new sound();
    private float upgrade_buffer;

    board_space(String name, int cost,int level_up_cost, int level1, int level2, int level3, int level4, boolean miss_a_go, boolean start, String file, int time_ms){
        this.name = name;
        this.cost = cost;
        this.level_up_cost = level_up_cost;
        this.landing_cost_level_array[0] = level1;
        this.landing_cost_level_array[1] = level2;
        this.landing_cost_level_array[2] = level3;
        this.landing_cost_level_array[3] = level4;
        this.owner = null;
        this.owned = false;
        this.current_level = 1;
        this.miss_a_go = miss_a_go;
        this.start = start;
        this.file = file;
        this.time_ms = time_ms;
        this.upgrade_buffer = 0f;
    }

    void reset(){
        this.owned = false;
        this.owner = null;
        this.current_level = 0;

    }
    void update_buffer(){
        dice dice = new dice();
        int num = dice.random_number(4);
        float fnum = num/10f;
        upgrade_buffer+=fnum;
    }
    void play_sound(){
        sound.sound(this.file,this.time_ms);
    }
    String get_name(){
        return this.name;
    }

    int get_cost(){
        return this.cost;
    }

    int get_current_level(){
        return this.current_level;
    }

    int get_landing_prices(int level){
        return this.landing_cost_level_array[level-1];
    }

    void get_stats(){
        System.out.println("\nStats: "+"\nName: " + this.name+ "\ncost: " + this.cost+
                "\nLevel up cost: " + this.level_up_cost+
                "\nCurrent level: " +this.current_level+
                "\nLevel 1 landing cost: "+ this.landing_cost_level_array[0]+
                "\nLevel 2 landing cost: "+ this.landing_cost_level_array[1]+
                "\nLevel 3 landing cost: "+ this.landing_cost_level_array[2]+
                "\nLevel 4 landing cost: "+ this.landing_cost_level_array[3]+
                "\nUpgrade Buffer: " + this.upgrade_buffer);
    }
    int upgrade(){
        if(this.current_level < 4){
            if(this.upgrade_buffer>=this.current_level) {
                this.current_level += 1;
                System.out.println("Processing...");
                sleep.sleep(750);
                System.out.println(this.name + " upgraded!\nNew level: " + this.current_level);
                return this.get_uprade_cost();
            }
            else{
                System.out.println("You need to wait until your upgrade buffer increases!\nCurrent upgrade buffer level: "+ this.upgrade_buffer+"\nRequired upgrade buffer level: "+(this.current_level));//TODO check this
                return 0;
            }
        }
        else{
            System.out.println(this.name+" is already max level!");
            return 0;
        }
    }
    int get_uprade_cost(){
        return this.level_up_cost;
    }

    boolean check_if_owned(){
        return this.owned;
    }

    void land(player person, player_container players, int num_of_players){
        if(this.miss_a_go){
            inp.make_ASCII("Landing!");
            System.out.println("Oh no you landed on miss a go!\nYou will miss a go next turn!");
            //play_sound();
            person.set_miss_a_go();
        }
        else if(this.start){
            inp.make_ASCII("Landing!");
            person.give_money(1000);
            System.out.println("\nYou've been given ££1000 for landing on start!\n");
            sleep.sleep(2200);
            //play_sound();
        }
        else if(!this.owned){//If the animal is unowned
            inp.make_ASCII("Landing!");
            System.out.println("\n"+person.get_name()+", you landed on the "+this.name+".\n\nStats: "+//Gives Stats on the animal
                    "\nName: " + this.name+
                    "\ncost: " + this.cost+
                    "\nLevel up cost: " + this.level_up_cost+
                    "\nLevel 1 landing cost: "+ this.landing_cost_level_array[0]+
                    "\nLevel 2 landing cost: "+ this.landing_cost_level_array[1]+
                    "\nLevel 3 landing cost: "+ this.landing_cost_level_array[2]+
                    "\nLevel 4 landing cost: "+ this.landing_cost_level_array[3]+
                    "\n\nBalance: "+ person.get_money()+"\nThe "+ this.name + " is currently unowned, would you like to buy it?" +"\n'y' to buy it or anything else for no.");
            play_sound();
            String choice = inp.get_string_normal("");
            if(choice.equals("y") || choice.equals("Y")){//Checks if they wanna buy it

                if(person.get_money()<= this.cost){//Checks if the person has enough money
                    System.out.println("You do not have enough to afford this!");
                }
                else{//Processes the transaction and gives ownership.
                    this.owned = true;
                    this.owner = person.get_name();
                    person.take_money(this.cost);
                    person.set_animal_ownership(this.name);
                    sleep.processing(750,true);
                    System.out.println("Congratulations, you are now the proud owner of the " + this.name + "!");
                }
            }
        }

        else if(this.owner.equals(person.get_name())){//If the player who landed owns this fine animal
            System.out.println("You landed on your " + this.name + "!");
            play_sound();
        }

        else if(!this.owner.equals(person.get_name())){//If someone lands on an owned animal, which is not theirs.
            System.out.println("\n\nOh no! You landed on " + this.owner + "'s " + this.name + "!\nThis is gonna cost you "
                    + this.get_landing_prices(this.current_level) + "!");
            play_sound();
            System.out.println("Processing Transaction...");
            sleep.sleep(750);
            System.out.println("Transaction complete.\n"+person.get_name()+"'s Balance: "+ person.get_money());
            sleep.sleep(1000);
            for(int i = 0; i < num_of_players;i++){
                if(players.players[i].get_name().equals(this.owner)){
                    System.out.println("\n"+players.players[i].get_name() + " You just received £" +
                            this.get_landing_prices(this.current_level) + " from " + person.get_name());
                    players.players[i].give_money(this.get_landing_prices(this.current_level));
                }
            }
            sleep.sleep(1500);
        }
    }
}
