import java.util.List;
import java.util.ArrayList;
class RomanNumeral{
	private int arabicNumeral;
	private String romanNumeral = "";
	private String Rn = "IVXLCDM";
	public RomanNumeral(Integer number){
		arabicNumeral = number;
	}
	
	public List<Integer> reverseNumber(int num){
		int rN=0,r,digits=0;
		while(num>0){
			r = num%10;
			rN = (rN*10)+r;
			num = num/10;
			digits++;
		}
		List<Integer> digitsAndReversedNumber= new ArrayList<Integer>();
		digitsAndReversedNumber.add(new Integer(digits));
		digitsAndReversedNumber.add(new Integer(rN));
		return digitsAndReversedNumber;

	}

	public String getSubString(int digit,int r){
		String subString="";
		if(r == 4){
			subString += Character.toString(Rn.charAt((digit*2)-2)) + Character.toString(Rn.charAt((digit*2)-1));
			r -= 4;
		}
		else if(r == 9){
			subString += Character.toString(Rn.charAt((digit*2)-2)) + Character.toString(Rn.charAt(digit*2));
			r -= 9;
		}
		else if(r > 4){
			subString += Character.toString(Rn.charAt((digit*2)-1));
			r -= 5;
		}
		for (int i = 0; i < r; i++){
			subString += Character.toString(Rn.charAt((digit*2)-2));	
		}
		return subString;
	}

	public String getRomanNumeral() throws IllegalArgumentException{
		Integer aN = arabicNumeral;
		List<Integer> dAndRN = reverseNumber(aN);
		int digit = dAndRN.get(0).intValue();
		if(digit>4){
			throw new IllegalArgumentException();
		}
		int rN = dAndRN.get(1).intValue();
		int r;
		while(rN>0){
			r = rN % 10;
			romanNumeral += getSubString(digit,r);
			digit--;
			rN = rN/10;
		}
		return romanNumeral;
	}


}
