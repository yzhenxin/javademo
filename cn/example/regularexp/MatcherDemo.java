package cn.example.regularexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherDemo {
	public static void main(String[] args) {
		String rawStr = "23好$你1hao$42雍正3正$你2hao$fsad啊收费的空间$你3hao$";
//		String regex = "[\\u0391-\\uFFE5]";
		String regex = "\\$.*?\\$";
//		String regex = "[0-9]{1,2}";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(rawStr);
		
//		System.out.println(matcher.replaceAll("new"));
		
//		System.out.println(matcher.replaceFirst("sdf"));
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
		
/*		System.out.println(matcher.find());
		System.out.println(matcher.groupCount());
		System.out.println(matcher.group());
		System.out.println(matcher.group(0));
		
		System.out.println(matcher.matches());
		System.out.println(matcher.toString());
		System.out.println(matcher.toMatchResult());*/
		
	}
}
