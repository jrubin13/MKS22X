import java.util.*; 
import java.io.*;
public class RunningMedian {
    private Double[] data;
    int size;
    public RunningMedian() {
	data = new Double[10];
	size = 0;
    }

    public void add(Double val) {
	if (size >= data.length-1) {
	    resize();
	}
	if (size == 0) {
	    data[size] = val;
	    size += 1;
	    return;
	}
	if (data[size-1] < val) {
	    data[size] = val;
	    size += 1;
	    return;
	}
        int i = 0;
	while (i <= size){
	    if (data[i] > val) {
	        for (int x = size; x >= i; x--) {
		    data[x+1] = data[x];
		}
		data[i] = val;
		i = size+5;
	    }
	    i += 1;
	}
	size += 1;
    }
    public double getMedian() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	if (size % 2 == 1) {
	    return data[size/2];
	}
	return (data[(size-1)/2] + data[size/2]) / 2;
    }
    
    
    private void resize() {
        Double[] newData = new Double[size() * 2+1];
	for (int i = 0; i < size(); i++) {
	    newData[i] = data[i];
	}
	data = newData;
    }
    public int size() {
	return size;
    }
    
    public static void main(String[] args) {
	RunningMedian test = new RunningMedian();
	//System.out.println(test.getMedian());
        for (int i = 0; i < 10000; i++) {
	    test.add(Math.random()*100);
	}
	System.out.println(test.getMedian());
    }
}
