public class sleep {
    void sleep(int time_ms) {
        try {
            Thread.sleep(time_ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void processing(int time_ms, boolean complete){
        System.out.println("Processing transaction...");
        try {
            Thread.sleep(time_ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(complete){
            System.out.println("Complete");
        }
    }
}
