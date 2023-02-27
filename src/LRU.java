import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * This class demonstrate the LRU (latest recently used) page replacement algorithm.
 * @author Suparida Silapasith
 * @version 1.0
 */
public class LRU extends Page_replacement{

    /**
     * Constructor for object of class LRU.
     * @param frame_size number of frames
     */
    public LRU(int frame_size) {
        super(frame_size);
    }

    /**
     * Runs the page replacement algorithm using LRU method.
     * @param ref_string reference string
     */
    public void run(String[] ref_string) {

        super.frame.clear();
        super.page_fault = 0;
        super.page_hit = 0;
        int page_counter = -1;
        int select;

        /* For each string in the reference string to be added into the memory,
           there are 3 cases to happen.
         */
        for (String j : ref_string) {
            // The string is presented in the memory >> page hit
            if (super.frame.contains(j)) {
                super.page_hit++;
                page_counter++;
            // There are empty frame to add new string >> page fault
            } else if (super.frame.size() < super.frame_size) {
                super.frame.add(j);
                super.page_fault++;
                page_counter++;
            // The string is not presented in the memory >> page fault
            } else {
                /* This list is used to keep the period of time for each string in current pages
                   back to when it was last used in the reference string.
                */
                ArrayList<Integer> period = new ArrayList<>();

                // Iterating each page in the memory.
                for (String k : super.frame) {
                    int temp = 0;   // This variable keep the period of time.
                    /*  Iterating each string in the reference string.
                        From the current string back to the start.
                     */
                    for (int i = page_counter; i > -1; i--) {
                        // If current page string and current string in reference string are not the same
                        if (!Objects.equals(k, ref_string[i])) {
                            temp++; // Increases the period of time count by one.
                        /* But if they are the same, then add the period of time
                           counted in the list and end reference string iteration.
                        */
                        } else {
                            period.add(temp);
                            break;
                        }
                    }
                }
                // Replaced the page of string that has the most time period counted.
                int max = Collections.max(period);
                select = period.indexOf(max);

                super.frame.set(select, j);   // Replaces the index of selected page with new string.
                super.page_fault++;
                page_counter++;
            }
        }
    }

}

