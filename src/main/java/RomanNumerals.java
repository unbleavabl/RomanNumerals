import java.util.List;
import java.util.ArrayList;
class RomanNumeral{
	private int arabicNumeral;
	private String romanNumeral = "";
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


	public String getRomanNumeral() throws IllegalArgumentException{
		Integer aN = arabicNumeral;
		List<Integer> dAndRN = reverseNumber(aN);
		int digit = dAndRN.get(0).intValue();
		int rN = dAndRN.get(1).intValue();
		int r;
		while(rN>0){
			r = rN % 10;
			switch(digit){
				case 4 : for(int i = 0;i < r;i++){
					 	romanNumeral += "M";
					 }
					 break;
				case 3 : if(r == 4){
					 	romanNumeral += "CD";
						r -= 4;
					 }
					 else if (r == 9){
					 	romanNumeral += "CM";
						r -= 9;
					 }
					 else if(r > 4){
					 	romanNumeral += "D";
						r -= 5;
					 }
					 for(int i = 0;i < r;i++){
					 	romanNumeral += "C";
					 }
					 break;
				case 2 : if(r == 4){
					 	romanNumeral += "XL";
						r -= 4;
					 }
					 else if (r == 9){
					 	romanNumeral += "XC";
						r -= 9;
					 }
					 else if (r > 4){
					 	romanNumeral += "L";
					 	r -= 5;
					 }
					 for(int i = 0;i < r;i++){
					 	romanNumeral += "X";
					 }
					 break;
				case 1 : if(r == 4){
					 	romanNumeral += "IV";
						r -= 4;
					 }
					 else if(r == 9){
					 	romanNumeral += "IX";
						r -= 9;
					 }
					 else if (r > 4){
					 	romanNumeral += "V";
						r -= 5;
					 }
					 for (int i = 0; i < r;i++){
					 	romanNumeral += "I";
					 }
					 break;
				default : throw new IllegalArgumentException();
			}
			digit--;
			rN = rN/10;
		}
		return romanNumeral;
	}


}
