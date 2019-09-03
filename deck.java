public class deck {
    dice random = new dice();
    private String[] cards = {
            "you Miss a go next turn.",
            "Get £100 from a generous donation",
            "You lose £100 to the lawd and savior needing money",
            "Go backwards 3 spaces. Moving...",
            "Go forward 3 space. nMoving...",
            "You lose your latest animal to theives", /* 5 */
            "You have been visited by peta, 2 of your animals have been euthanized",
            "You Have Been Caught By Peta Using Anti Animal Language! Pay A Fine Of £100",
            "You Have been visited by the flash, he has taken you around the board once",
/*"The shark tank has broken and your visitors have been eaten, pay £100 to advertise to get new customers!",*/
            "A mom has dropped their kid into your animals enclosure, gain £100 as you don't have to feed them for a while!",
            "Callums Corner called out one of your employees for being involved in noncence, pay £50 to repair your reputation",/* 10 */
            "You misgendered a child, you got sued for £100",
            "You had to pay for veterinary bills for your animals, pay £50",
            "You have been visited by Mr Beast, you get £200",
            "A russian has offered to buy one of your animals for £500, do you accept?",
            "One of your most dangerous animals has escaped, pay £100 to get it back",/* 15 */
            "You have been declared unfit for visitors, pay a bribe of £100 to get back into business or miss a go",
            "The European Union have given you £200 to stay alive!",
            "Oh no, the RSPCA Have Visited, they have found your animals to be in a bad condition and have fined you £100"/* 18 */
    };
    boolean doubles_deck(player player, board board){//TODO Make better text for the cards
        inp_out out = new inp_out();
        sleep sleep = new sleep();
        out.make_ASCII("Doubles!");
        System.out.println("\nYou rolled a double!\nDealing a card...");
        sleep.sleep(1800);
        int rand = random.random_number(5);
//System.out.println(rand);
        boolean moved = false;
        out.make_ASCII("Card drawn! Your card says: "+cards[rand]);
        String inp = "";
        switch (rand){
            case 0:
                player.set_miss_a_go();
                sleep.sleep(2000);
                break;
            case 1:
                player.give_money(100);
                sleep.sleep(2000);
                break;
            case 2:
                player.take_money(100);
                sleep.sleep(2000);
                break;
            case 3:
                player.move_backwards(3);
                sleep.sleep(2000);
                moved = true;
                break;
            case 4:
                sleep.sleep(2000);
                player.move_forwards(3);
                moved = true;
                break;
            case 5:
                player.lose_last_animal(board);
                sleep.sleep(2000);
                break;
            case 6:
                player.lose_last_animal(board);
                player.lose_last_animal(board);
                sleep.sleep(2000);
                break;
            case 7:
                player.take_money(100);
                sleep.sleep(1500);
                break;
            case 8:
                sleep.sleep(2000);
                player.move_forwards(28);
                moved = true;
                break;
            case 9:
                player.give_money(100);
                sleep.sleep(2000);
                break;
            case 10:
                player.give_money(50);
                sleep.sleep(2000);
                break;
            case 11:
                player.take_money(100);
                sleep.sleep(1500);
                break;
            case 12:
                player.give_money(50);
                sleep.sleep(2000);
                break;
            case 13:
                player.take_money(200);
                sleep.sleep(1500);
                break;
            case 14:
                inp = "";
                while(!(inp.equals('y') || inp.equals('n'))){
                    inp = out.get_string("You have been given the opurtunity to sell your"+player.get_last_animal()+", \n Please Enter y or n");
                }
                if(inp.equals('y')){
                    player.lose_last_animal(board);
                    player.give_money(500);
                    System.out.println("Your Animal Has Been Sold!");
                    player.print_balance();
                } else {
                    System.out.println("You Misssed A Good Opportunity!");
                }
                sleep.sleep(2000);
                break;
            case 15:
                inp = "";
                while(!(inp.equals('y') || inp.equals('n'))){
                    inp = out.get_string("Do You Want Your"+player.get_last_animal()+" Back For £100? \n Please Enter y or n");
                }
                if(inp.equals('y')){
                    player.take_money(100);
                    System.out.println("Your Animal Has Been Returned!");
                    player.print_balance();
                } else {
                    System.out.println("RIP"+player.get_last_animal());
                    player.lose_last_animal(board);
                }
                sleep.sleep(2000);
                break;
            case 16:
                inp = "";
                while(!(inp.equals('y') || inp.equals('n'))){
                    inp = out.get_string("Do You Want to miss a go or pay £100, y to miss a go, n to pay the bribe");
                }
                if(inp.equals('y')){
                    player.set_miss_a_go();
                } else {
                    System.out.println("You Are Paying £100 as a bribe!");
                    player.print_balance();
                }
                sleep.sleep(2000);
                break;
            case 17:
                player.give_money(100);
                sleep.sleep(2000);
                break;
            case 18:
                player.take_money(100);
                sleep.sleep(2000);
                break;
        }
        return moved;
    }


}






