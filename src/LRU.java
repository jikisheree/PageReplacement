import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class LRU {

    ArrayList<String> frame;
    int frame_size;
    int page_fault = 0;
    int page_hit = 0;

    public LRU(int frame_size) {
        frame = new ArrayList<>(frame_size);
        this.frame_size = frame_size;
    }

    public void setFrame_size(int size){
        frame_size = size;
    }

    public void run(String[] ref_string) {

        frame.clear();
        page_fault = 0;
        page_hit = 0;
        int page_counter = -1;
        int select = 0;

        for (String j : ref_string) {
//            System.out.println("Num: " + j);
            // มีที่ว่างให้ใส่ string
            if (frame.contains(j)) {
//                System.out.println("Page hit!");
                page_hit++;
                page_counter++;
            }else if (frame.size() < frame_size) {
                frame.add(j);
                page_fault++;
                page_counter++;
                // page hit
            }else {
                ArrayList<Integer> period = new ArrayList<>();

                for (String k : frame) {
                    int temp = 0;
                    for (int i = page_counter; i > -1; i--) {
                        if (!Objects.equals(k, ref_string[i])) {
                            temp++;
                        } else {
                            period.add(temp);
                            break;
                        }
                    }
                }
//                for (int i : period) System.out.println(i + ",");
                int max = Collections.max(period);
                select = period.indexOf(max);

                frame.set(select, j);
                page_fault++;
                page_counter++;
            }
//            System.out.print("[ ");
//            for (int i : frame) {
//                System.out.print(i + " ");
//            }
//            System.out.print("]");
//            System.out.println(" >> Page fault = " + page_fault);
//            System.out.println("Page counter: " + page_counter);
        }
    }
    public void printInfo(String[] ref){
        run(ref);
        System.out.print("Frame size: "+frame_size);
        System.out.println("\tPage faults: "+page_fault);
    }

}

