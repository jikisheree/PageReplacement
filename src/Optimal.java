import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * This class demonstrate the Optimal page replacement algorithm.
 * @author Suparida Silapasith
 * @version 1.0
 */
public class Optimal extends Page_replacement {

    /**
     * Constructor for object of class Optimal.
     * @param frame_size number of frames
     */
    public Optimal(int frame_size) {
        super(frame_size);
    }

    /**
     * Runs the page replacement algorithm using Optimal method.
     * @param ref_string reference string
     */
    public void run(String[] ref_string) {

        super.frame.clear();
        super.page_fault = 0;
        super.page_hit = 0;
        int page_counter = 0;   // This variable counts current page number.
        int select = 0;         // This variable contains the index of page to be replaced.

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
                /* This variable is used to check whether there are string that will not
                   be used anymore in the future.
                 */
                boolean find_no = false;
                /* This list is used to keep the period of time for each string in current pages
                   until it will exist again in the reference string.
                */
                ArrayList<Integer> period = new ArrayList<>();

                // Iterates each page in the memory.
                for (String k : super.frame) {
                    /* If finding at least one string that will not be used anymore in the future,
                       then end the iteration and select that string to be replaced.
                     */
                    if (find_no) break;
                    int temp = 0;  // this variable keep the period of time.
                    /*  Iterating each string in the reference string.
                        From current the string to the end.
                     */
                    for (int i = page_counter; i < ref_string.length; i++) {
                        // If current page string and current string in reference string are not the same,
                        if (!Objects.equals(k, ref_string[i])) {
                            // then if it is the last string then this page will be replaced.
                            if (i == ref_string.length - 1) {
                                select = super.frame.indexOf(k);
                                find_no = true;
                                break;
                            }
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
                /* If there are no string that is not existed later in the reference string,
                   then replaced the page of string that has the most time period counted.
                */
                if (!find_no) {
                    int max = Collections.max(period);
                    select = period.indexOf(max);
                }
                super.frame.set(select, j); // Replaces the index of selected page with new string
                super.page_fault++;
                page_counter++;
            }
        }
    }

}
