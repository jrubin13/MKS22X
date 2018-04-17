public class Sort extends MyLinkedListImproved{
    public static void radixsort(MyLinkedListImproved<Integer> data) {
	int passes = 0;
	int maxPasses = 0;
	Integer maxVal = data.get(data.max());
	if (data.size < 2) {
	    return;
	}
	while (maxVal >= 10) {
	    maxPasses += 1;
	    maxVal = maxVal / 10;
	}
	maxPasses += 1;
	int a = 0;
	@SuppressWarnings("unchecked")MyLinkedListImproved<Integer>[] store = new MyLinkedListImproved [10];
	int place;
	int val;
	while (passes < maxPasses) {
	    while (a < data.size) {
		val = data.get(a);
		if (passes == 0) {
		    place = val % 10;
		    //System.out.println(val);
		    //System.out.println(place);
		}
		else {
		    place = val % (10*(passes*10));
		    //System.out.println(place);
		}
		store[place].add(val);
		a+=1;
	    }
	    data.clear();
	    for (int i = 0; i < 10; i++) {
		data.extend(store[i]);
	    }
	    a = 0;
	    passes += 1;
	}
    }
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data) {
	
    }
    public static void main(String[] args) {
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
        m.add(new Integer(31));
	m.add(new Integer(43));
	m.add(new Integer(0));
	m.add(new Integer(4));
	m.add(new Integer(4));
	m.add(new Integer(1));
	radixsort(m);
	System.out.println(m);
    }
}
