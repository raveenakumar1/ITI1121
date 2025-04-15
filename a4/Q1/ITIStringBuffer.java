import java.util.Iterator;

public class ITIStringBuffer {

    SinglyLinkedList<String> buffer;
    int length;


    public ITIStringBuffer() {
        buffer = new SinglyLinkedList<>();
        length = 0;
    }


    public ITIStringBuffer(String firstString){
        buffer = new SinglyLinkedList<>();
        append(firstString);
    }


    public void append(String nextString){
        buffer.add(nextString);
        length += nextString.length();
    }


    public String toString(){
        char[] outp = new char[length];

        int cp = 0; // No that doesn't mean what urban dictonary says it does

        if(buffer.size() == 1){
            return buffer.get(0);
        }

        for(Iterator<String> a = buffer.iterator(); a.hasNext(); ){
            char[] data = a.next().toCharArray();
            buffer.removeFirst();
            for(int i = 0; i < data.length; i++){
                outp[cp] = data[i];
                cp++;
            }
        }

        buffer.add(new String(outp));
        return new String(outp);
    }

}