import java.util.ArrayList;

public abstract class Page_replacement {

    ArrayList<String> frame;
    int frame_size;
    int page_fault = 0;
    int page_hit = 0;

    /**
     * Constructor for object of class.
     * @param frame_size number of frames
     */
    public Page_replacement(int frame_size){
        this.frame = new ArrayList<>(frame_size);
        this.frame_size = frame_size;
    }

    /**
     * Sets the current number of frames.
     * @param size Number of frames
     */
    public void setFrame_size(int size){
        frame_size = size;
        frame.clear();
    }

    /**
     * Runs the page replacement algorithm.
     * @param ref_string reference string
     */
    public abstract void run(String[] ref_string);

    /**
     * Runs the page replacement algorithm.
     * Then print all th e result after running the algorithm.
     * @param ref reference string
     */
    public void printInfo(String[] ref){
        run(ref);
        System.out.print("Frame size: "+frame_size);
        System.out.println("\tPage faults: "+page_fault);
    }

}
