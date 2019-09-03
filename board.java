public class board {
    private int num_of_spaces = 0;
    public board_space[] board_spaces = {
            new board_space("Start", 0, 0, 0, 0, 0, 0, false, true,"",1000),
            new board_space("Leech", 60, 120, 10, 20, 90, 160, false, false,"SOUNDS/z_leech.wav",1200),
            new board_space("Rat", 60, 120, 20, 60, 180, 320, false, false,"SOUNDS/z_rat.wav",2200),
            new board_space("Frog", 100, 200, 30, 90, 270, 400, false, false,"SOUNDS/z_frog.wav",2200),
            new board_space("Cow", 100, 200, 30, 90, 270, 400, false, false,"SOUNDS/z_cow.wav",2000),
            new board_space("Cat", 120, 240, 40, 100, 300, 450, false, false,"SOUNDS/z_cat.wav",1200),
            new board_space("Dog", 140, 280, 50, 150, 450, 625, false, false,"SOUNDS/z_dog.wav",1200),
            new board_space("Donkey", 140, 280, 50, 150, 450, 625, false, false,"SOUNDS/z_donkey.wav",2000),
            new board_space("Sea-Lion", 180, 360, 70, 200, 550, 750, false, false,"SOUNDS/z_sealion.wav",2000),
            new board_space("Beaver", 180, 360, 70, 200, 550, 750, false, false,"SOUNDS/z_beaver.wav",3000),
            new board_space("Parrot", 200, 400, 80, 220, 600, 800, false, false,"SOUNDS/z_parrot.wav",2000),
            new board_space("Snake", 220, 440, 90, 250, 700, 875, false, false,"SOUNDS/z_snake.wav",2000),
            new board_space("Penguin", 220, 400, 80, 220, 600, 800, false, false,"SOUNDS/z_penguin.wav",2000),
            new board_space("Miss A Go", 0, 0, 0, 0, 0, 0, true, false,"",1000),
            new board_space("Fire Ant Colony", 220, 400, 80, 220, 600, 800, false, false,"SOUNDS/z_ant.wav",2000),
            new board_space("Orangutan", 220, 440, 90, 250, 700, 875, false, false,"SOUNDS/z_orangutan.wav",2000),
            new board_space("Giraffe", 240, 456, 100, 300, 750, 925, false, false,"SOUNDS/z_giraffe.wav",2000),
            new board_space("Dolphin", 260, 468, 110, 330, 800, 975, false, false,"SOUNDS/z_dolphin.wav",2000),
            new board_space("Elephant", 260, 468, 110, 330, 800, 975, false, false,"SOUNDS/z_elephant.wav",2000),
            new board_space("Alligator", 280, 476, 120, 360, 850, 1025, false, false,"SOUNDS/z_alligator.wav",2000),
            new board_space("Cheetah", 300, 480, 130, 390, 900, 1100, false, false,"SOUNDS/z_cheetah.wav",2000),
            new board_space("Gorilla", 300, 480, 130, 390, 900, 1100, false, false,"SOUNDS/z_gorilla.wav",2000),
            new board_space("Shark", 350, 525, 150, 500, 1100, 1300, false, false,"SOUNDS/z_shark.wav",2000),
            new board_space("Lion", 400, 600, 150, 600, 1250, 1400, false, false,"SOUNDS/z_lion.wav",2000),
            new board_space("Tardigrade", 450, 675, 175, 700, 1350, 1500, false, false,"SOUNDS/z_tardigrade.wav",2000),
            new board_space("Unicorn", 500, 500, 200, 800, 1500, 1750, false, false,"SOUNDS/z_unicorn.wav",2000)
    };

    public void draw_board(player_container player_container) {
        //int[] positions = {67,75,83,91,99,107,115,123,255,387,519,651,783,915,1047,1039,1031,1023,1015,1007,999,991,859,727,595,463,331,199};
        //Old board and positions
        //String board = "*****************************************************************\n*       *       *       *       *       *       *       *       *\n*   *   *************************************************   *   *\n*       *************************************************       *\n*   *   *************************************************   *   *\n*       *************************************************       *\n*   *   *************************************************   *   *\n*       *************************************************       *\n*   *   *************************************************   *   *\n*       *************************************************       *\n*   *   *************************************************   *   *\n*       *************************************************       *\n*   *   *************************************************   *   *\n*       *************************************************       *\n*   *   *************************************************   *   *\n*       *       *       *       *       *       *       *       *\n*****************************************************************";
        int[] positions = {391,407,422,439,455,471,487,503,1023,1543,2063,2453,3103,3623,3607,3591,3575
                ,3559,3543,3527,3511,2991,2471,1951,1431,911};
        String board ="_________________________________________________________________________________________________________________________________\n" +
                "|     Start     |    Leech     |      Rat       |     Frog      |      Cow      |      Cat      |      Dog      |    Donkey     |\n" +
                "|               |              |                |               |               |               |               |               |\n" +
                "|               |              |                |               |               |               |               |               |\n" +
                "|_______________|______________|________________|_______________|_______________|_______________|_______________|_______________|\n" +
                "|  Tardigrade   |                                                                                               |    Sea-Lion   |\n" +
                "|               |                                                                                               |               |\n" +
                "|               |                                                                                               |               |\n" +
                "|_______________|                                                                                               |_______________|\n" +
                "|     Lion      |                                                                                               |    Beaver     |\n" +
                "|               |                                                                                               |               |\n" +
                "|               |                                                                                               |               |\n" +
                "|_______________|                                                                                               |_______________|\n" +
                "|    Shark      |                                                                                               |    Parrot     |\n" +
                "|               |                                                                                               |               |\n" +
                "|               |                                                                                               |               |\n" +
                "|_______________|                                                                                               |_______________|\n" +
                "|   Polar bear  |                                                                                               |    Snake      |\n" +
                "|               |                                                                                               |               |\n" +
                "|               |                                                                                               |               |\n" +
                "|_______________|                                                                                               |_______________|\n" +
                "|   Gorilla     |                                                                                               |   Penguin     |\n" +
                "|               |                                                                                               |               |\n" +
                "|               |                                                                                               |               |\n" +
                "|_______________|_______________________________________________________________________________________________|_______________|\n" +
                "|  Cheetah      |   Alligator   |   Elephant    |  Dolphin      |    Giraffe    |   Orangutan   |    Fire Ant   |   Miss a go   |\n" +
                "|               |               |               |               |               |               |               |               |\n" +
                "|               |               |               |               |               |               |               |               |\n" +
                "|_______________|_______________|_______________|_______________|_______________|_______________|_______________|_______________|\n";

        char[] temp = board.toCharArray();
        for (int i = 0; i < player_container.get_num_of_players(); i++) {
            temp[positions[player_container.players[i].get_position()]+i] = player_container.players[i].get_playing_piece();
            }
        String out = new String(temp);
        System.out.println(out);
    }
    public void increase_buffers(){
        for(int i = 0; i<26;i++){
            if(board_spaces[i].check_if_owned() == true){
                board_spaces[i].update_buffer();
            }
        }
    }

}
