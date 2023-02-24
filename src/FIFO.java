import java.util.ArrayList;

public class FIFO {

    ArrayList<String> frame;
    int frame_size;
    int page_fault = 0;
    int page_hit = 0;

    public FIFO(int frame_size) {
        frame = new ArrayList<>(frame_size);
        this.frame_size = frame_size;
    }

    public void setFrame_size(int size){
        frame_size = size;
        frame.clear();
    }

    public void run(String[] ref_string) {

        frame.clear();
        page_fault = 0;
        page_hit = 0;
        int pointer = 0;

        for (String j : ref_string) {
//            System.out.println("Num: "+j);
            // มีที่ว่างให้ใส่ string
            if (frame.contains(j)) {
//                System.out.println("Page hit!");
                page_hit++;
            }else if (frame.size() < frame_size) {
                frame.add(j);
                page_fault++;
                // page hit
            }else{
                frame.set(pointer%frame_size, j);
                pointer = (pointer+1)%frame_size;
                page_fault++;
            }
//            System.out.print("[ ");
//            for (int i : frame)
//            {
//                System.out.print(i+" ");
//            }
//            System.out.print("]");
//            System.out.println(" >> Page fault = "+page_fault);
//            System.out.println();
        }
    }
    public void printInfo(String[] ref){
        run(ref);
        System.out.print("Frame size: "+frame_size);
        System.out.println("\tPage faults: "+page_fault);
    }

}
