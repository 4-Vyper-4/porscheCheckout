package porsche;

public class TextTrim {

	public static String TextTrimmer(String s) {
		s = s.replaceAll("[$]", "").trim();
		s = s.replaceAll(" ", "").trim();
		s = s.replaceAll("From", "").trim();
		s = s.replaceAll(",", "").trim();
		s = s.replaceAll("\\*", "").trim();
		s = s.replace(".00", "");
		return s;
	}
}
