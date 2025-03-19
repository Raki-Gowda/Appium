package MobileAutomation.Appium;

public class Practice_App {

	public static void main(String[] args) {
		
		String a = "$170.97";
		String b = "";
		for(int x = 0;x<a.length();x++) {
			if(a.charAt(x) != '$') {
				b = b + a.charAt(x);
			}
		}
		System.out.println();
	}
}
