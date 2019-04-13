package IOio;
import java.io.*;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
public class sequence {
	public static void testSequenceInputStream() throws Exception {
		InputStream in1 = new FileInputStream("c://a.txt");
		InputStream in2 = new FileInputStream("c://b.txt");
		InputStream in3 = new FileInputStream("c://c.txt");

		LinkedHashSet<InputStream> set = new LinkedHashSet<InputStream>();
		set.add(in1);
		set.add(in2);
		set.add(in3);
		final Iterator<InputStream> iter = set.iterator();

		SequenceInputStream sin = new SequenceInputStream(
				new Enumeration<InputStream>() {
					@Override
					public boolean hasMoreElements() {
						return iter.hasNext();
					}

					@Override
					public InputStream nextElement() {
						return iter.next();
					}
				});

		FileOutputStream out = new FileOutputStream("c://z.txt");

		for (int b = -1; (b = sin.read()) != -1;) {
			out.write(b);
		}
        sin.close();
		out.close();
	}

}
