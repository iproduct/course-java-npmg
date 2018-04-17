package strings;

public class ParseUrl {
	public static final String URL = "https://github.com/iproduct/course-java-npmg.git";

	public static void main(String[] args) {
		String[] segments = URL.split("/");
		for(String segment : segments) {
			if(segment.length() > 0)
				System.out.println(segment);
		}
	}

}
