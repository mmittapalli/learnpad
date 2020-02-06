package DataStructures.allstrings;

import org.omg.PortableInterceptor.INACTIVE;

/*
return the first integer portion from a string, if it is outside the limits int, return the max/min

 */
public class ATOI {
	public static void main(String[] args) {
		System.out.println(myAtoi1("words and 987"));
		System.out.println(myAtoi1("-12342324124515"));
		System.out.println(myAtoi1("123 words and 987"));
	}

	// length(string)==0 => 0
	//sign=false,
	static int myAtoi1(String s) {
		if (s.length() == 0) return 0;
		boolean sign = false;
		double result = 0, pop = 0;
		int index = 0;
		int len = s.length();
		for (; index < len && s.charAt(index) == ' '; ++index) {
			//++index is needed because next line we are checking based on next character
			if (index == len || (s.charAt(index) != '-' && s.charAt(index) != '+' && !Character.isDigit(s.charAt(index))))
				return 0;
		}
		if (s.charAt(index) == '-') {
			sign = true;
			++index;
		} else if (s.charAt(index) == '+') {
			++index;
		}
		for (; index < len && Character.isDigit(s.charAt(index)); ++index) {
			pop = s.charAt(index) - '0';
			result = result * 10 + pop;
		}
		if (sign) result = -result;
		if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return (int) result;
	}


//	public static int myAtoi(String str) {
//		if(str.isEmpty()) return 0;
//		int index=0, len = str.length();
//		double result = 0, pop=0;
//		boolean sign = false;
//		for(; index < len && str.charAt(index) == ' ';++index);
//		//now the index at first non-whitespace character
//		if(index == len || (str.charAt(index) != '-' && str.charAt(index) != '+' && !Character.isDigit(str.charAt(index))))
//			return 0;
//
//		if(str.charAt(index)=='-'){
//			sign = true;
//			++index;
//		}else if(str.charAt(index)=='+'){
//			++index;
//		}
//		//now index is non-white space and non +/- character
//		for(; index < len && Character.isDigit(str.charAt(index)); ++index){
//			pop = str.charAt(index) - '0';
//			result = result *10 + pop;
//		}
//		if(sign) result = -result;
//		if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
//		else if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
//
//		return (int)result;
//	}
}
