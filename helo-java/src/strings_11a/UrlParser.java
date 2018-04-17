package strings_11a;

public class UrlParser {
	private static String url = "https://github.com/iproduct/course-java-npmg/";

	private static void printIfNotEmpty(StringBuilder buffer) {
		if(buffer.length() > 0) {
			System.out.println(buffer.toString());
		}
	}
	
	public static void main(String[] args) {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < url.length(); i++) {
			char currentChar = url.charAt(i);
			if (currentChar == '/') {
				printIfNotEmpty(buffer);
				buffer.delete(0, buffer.length());
			} else {
				buffer.append(currentChar);
			}
		}
		printIfNotEmpty(buffer);
	}

}
