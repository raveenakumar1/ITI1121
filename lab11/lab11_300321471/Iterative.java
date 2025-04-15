public class Iterative {

	public static BitList complement( BitList in ) {
		Iterator input = in.iterator(); 
		BitList a = new BitList();
		Iterator output = a.iterator();
		while (input.hasNext()) {
			if (input.next() == 0) {
				output.add(1);
			} else {
				output.add(0);
			}
		}
		return a;
	}

	public static BitList or( BitList a, BitList b ) {
		BitList c = new BitList();
		Iterator input = b.iterator(); 
		Iterator output = c.iterator();
		Iterator inputTwo = a.iterator();
		if (a == null || b == null || a.toString().length() != b.toString().length() || a.toString().length() ==0||!input.hasNext() )
			throw new IllegalArgumentException();
		while (input.hasNext()) {
			int f =input.next();
			int s =inputTwo.next();
			if (f == 1 || s ==1) {
				output.add(1);
			} else {
				output.add(0);
			}
		}
		return c;
	}

	public static BitList and( BitList a, BitList b ) {
		BitList c = new BitList();
		Iterator input = b.iterator(); 
		Iterator output = c.iterator();
		Iterator inputTwo = a.iterator();
		if (a == null || b == null || a.toString().length() != b.toString().length() ||!input.hasNext())
			throw new IllegalArgumentException();
		while (input.hasNext()) {
			if (input.next() == 1 && inputTwo.next() ==1) {
				output.add(1);
			} else {
				output.add(0);
			}
		}
		return c;
	}

	public static BitList xor( BitList a, BitList b ) {
		BitList c = new BitList();
		Iterator input = b.iterator(); 
		Iterator output = c.iterator();
		Iterator inputTwo = a.iterator();
		if (a == null || b == null || a.toString().length() != b.toString().length() ||!input.hasNext())
			throw new IllegalArgumentException();
		while (input.hasNext()) {
			int f =input.next();
			int s =inputTwo.next();
			if ((f == 1 && s ==0)||(f == 0 && s ==1)) {
				output.add(1);
			} else {
				output.add(0);
			}
		}
		return c;
	}
}