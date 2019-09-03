public class Threading extends Thread{
    public void run(){
        sound sound = new sound();
        sound.sound_loop("SOUNDS/animal_monopoly_new.wav");
    }
}