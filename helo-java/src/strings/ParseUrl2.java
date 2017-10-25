package strings;

public class ParseUrl2 {
	public static final String URL = "https://github.com/iproduct/course-java-npmg.git";

	public static void main(String[] args) {
		StringBuilder segment = new StringBuilder();
		for(int i = 0; i < URL.length(); i++) {
			char currentChar = URL.charAt(i);
			if(currentChar == '/'  ) {
				if(segment.length() > 0) {
					System.out.println(segment);
					segment.delete(0, segment.length());
				}
			} else {
				segment.insert(0, currentChar);
			}
		}
		
		System.out.println(segment);
	}

}
