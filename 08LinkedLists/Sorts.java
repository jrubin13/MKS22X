public class Sorts extends MyLinkedListImproved{
    public static void radixsort(MyLinkedListImproved<Integer> data) {
	int passes = 0;
	int maxPasses = 0;
	if (data.size < 2) {
	    return;
	}
	Integer maxVal = data.get(data.max());
	while (maxVal >= 10) {
	    maxPasses += 1;
	    maxVal = maxVal / 10;
	}
	maxPasses += 1;
	int a = 0;
	@SuppressWarnings("unchecked")MyLinkedListImproved<Integer>[] store = new MyLinkedListImproved [10];
	int make = 0;
        while (make < 10) {
	    store[make] = new MyLinkedListImproved<Integer>();
	    make += 1;
	}
	int place = 0;
	int val = 0;
	while (passes < maxPasses) {
	    while (a < data.size) {
		val = data.get(a);
		if (passes == 0) {
		    place = val % 10;
		    //System.out.println(val);
		    //System.out.println(place);
		}
		else {
		    //System.out.println(Math.pow(10, passes));
		    //System.out.println(val);
		    place = (val / (int)(Math.pow(10, passes))) % 10;
		    //System.out.println(place);
		}
		store[place].add(val);
		a+=1;
	    }
	    data.clear();
	    for (int i = 0; i < 10; i++) {
		if (store[i].size > 0) {
		    data.extend(store[i]);
		}
		store[i].clear();
	    }
	    a = 0;
	    passes += 1;
	}
    }
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data) {
	MyLinkedListImproved<Integer> positive = new MyLinkedListImproved<>();
	MyLinkedListImproved<Integer> negative = new MyLinkedListImproved<>();
	MyLinkedListImproved<Integer> temp = new MyLinkedListImproved<>();
	if (data.size < 2) {
	    return;
	}
	for (int i = 0; i < data.size; i++) {
	    if (data.get(i) <= 0) {
	        negative.add(data.get(i));
	    }
	    else {
		positive.add(data.get(i));
	    }
	}
	//System.out.println(positive);
	//System.out.println(negative);
	for (int i = 0; i < negative.size; i++) {
	    temp.add(negative.get(i) * -1);
	}
	radixsort(positive);
	radixsort(temp);
	negative.clear();
	for (int i = temp.size - 1; i >= 0; i--) {
	    negative.add(temp.get(i) * -1);
	}
        negative.extend(positive);
	data.start = negative.start;
	data.end = negative.end;
    }
    public static void main(String[] args) {
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
	m.add(new Integer(317));
	m.add(new Integer(432));
	m.add(new Integer(0));
	m.add(new Integer(428));
	m.add(new Integer(428));
	m.add(new Integer(1));
	radixsort(m);
	System.out.println(m);
	MyLinkedListImproved<Integer> n = new MyLinkedListImproved<>();
	n.add(new Integer(317));
	n.add(new Integer(-432));
	n.add(new Integer(0));
	n.add(new Integer(-428));
	n.add(new Integer(428));
	n.add(new Integer(1));
	radixsortIncludingNegatives(n);
	System.out.println(n);
    }
}
