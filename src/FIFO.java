import java.util.ArrayList;

/**
 * This class demonstrate the FIFO (First in first out) page replacement algorithm.
 * @author Suparida Silapasith
 * @version 1.0
 */

public class FIFO extends Page_replacement {

    /**
     * Constructor for object of class FIFO.
     *
     * @param frame_size number of frames
     */
    public FIFO(int frame_size) {
        super(frame_size);
    }

    /**
     * Runs the page replacement algorithm using FIFO method.
     * @param ref_string reference string
     */
    @Override
    public void run(String[] ref_string) {

        super.frame.clear();
        super.page_fault = 0;
        super.page_hit = 0;
        int pointer = 0;   // This pointer point the oldest frame

        // For each string in the reference string
        for (String j : ref_string) {
            // The string is presented in the memory >> page hit
            if (super.frame.contains(j)) {
                super.page_hit++;
            // There are empty frame to add new string >> page fault
            }else if (super.frame.size() < super.frame_size) {
                super.frame.add(j);
                super.page_fault++;
            // The string is not presented in the memory >> page fault
            }else{
                super.frame.set(pointer, j);              // Replace the oldest page with new string
                pointer = (pointer+1)%super.frame_size;   // Shift the pointer to the next page
                super.page_fault++;
            }
        }
    }

}


