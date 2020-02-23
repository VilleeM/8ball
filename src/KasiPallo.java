/*
8Ball ohjelma, joka vastaa k‰ytt‰j‰n vaikeisiin kysymyksiin
*/
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class KasiPallo {
	
	private static final Random rand = new Random();
	private static final Scanner lukija = new Scanner (System.in);
			//vastaukset listassa
			public static String[] lista = {"It is certain", "It is decidedly so", "Without a doubt", "Yes definitely",
			"You may rely on it", "As I see it, yes", "Most likely", "Outlook good", "Yes", "Signs point to yes", "Reply hazy try again", "Ask again later", "Better not tell you now",     
			"Cannot predict now", "Concentrate and ask again", "Don't count on it", "My reply is no", "My sources say no", "Outlook not so good",        
		    "Very doubtful"};
/* 1. kysy k‰ytt‰j‰n nimi ja kirjoita se vieraslistaan
 * 2. kysy k‰ytt‰j‰lt‰ mit‰ tehd‰‰n: katso vieraslista, kysy kysymys, lopeta ohjelma.
 * KATSO VIERASLISTA: Tulosta vieraslistan sis‰ltˆ, kysy k‰ytt‰j‰lt‰ mit‰ tehd‰‰n seuraavaksi >>> palaa kohtaan 2
 * KYSY KYSYSMYS: k‰ytt‰j‰ kysyy kysymyksen arvotaan vastaus, kysy k‰ytt‰j‰lt‰ mit‰ tehd‰‰n seuraavaksi >>> palaa kohtaan 2
 * LOPETA OHJELMA: Ohjelma sulkeutuu
 */
 
	public static void main(String[] args) throws IOException {
		char kysymys = ' ';
		Scanner lukija2 = new Scanner(System.in);
		System.out.println("What's your name?");
		String nimi = lukija.nextLine();
		Vieraslista(nimi);
		while (true){
			System.out.print("'Q' to view the questbook \nDo you want to ask the 8ball a question? (Y/N):");
			kysymys = lukija2.next().charAt(0);
			if(kysymys=='y' || kysymys == 'Y') {
				Pallo();
				String question = Kysymys(nimi);
				Kysysmyslista(question, nimi);
				kysymys = ' ';
				System.out.println(arvoIndeksi(1));
			}else if (kysymys =='n' || kysymys == 'N'){
					System.out.println("I hope you step on a Lego!");
					break;
			}else if(kysymys == 'q' || kysymys == 'Q'){
					LueVieraslista();
			}else {
				System.out.println("I dont understand, try again:");
			}
		}
	}
	//arpoo vastauksen listasta
	public static String arvoIndeksi(int n) throws IOException {
		FileWriter kirjoittaja = new FileWriter ("Kyss‰rilista.txt", true);
			String vastaus = lista[rand.nextInt(lista.length)+0];
			kirjoittaja.write("Answer: "+vastaus);
			kirjoittaja.close();
			return vastaus;
	}
	//kysyy k‰ytt‰j‰lt‰ kymysyksen
	public static String Kysymys(String nimi) {
		System.out.println("Ask your question, "+nimi+".");
		return lukija.nextLine();
	}
	//kirjoittaa kysymyslista.txt tiedostoon kysymykset ja vastaukset
	public static void Kysysmyslista(String KL, String name) throws IOException {
		DateFormat aikaStamp = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
		Date aika = new Date();
		FileWriter kirjoittaja = new FileWriter ("Kyss‰rilista.txt", true);
		kirjoittaja.write(System.lineSeparator());
		kirjoittaja.write(aikaStamp.format(aika));
		kirjoittaja.write(System.lineSeparator());
		kirjoittaja.write("Asked by: "+name);
		kirjoittaja.write(System.lineSeparator());
		kirjoittaja.write("Question: "+KL);
		kirjoittaja.write(System.lineSeparator());
		kirjoittaja.close();
	}
	// p‰ivitt‰‰ vieraslista.txt:n
	public static void Vieraslista(String Vlista) throws IOException {
		FileWriter kirjoittaja = new FileWriter ("Vieraslista.txt", true);
		System.out.println("Whazzz up, " + Vlista+ "!");
		kirjoittaja.write(Vlista);
		kirjoittaja.write(System.lineSeparator());
		kirjoittaja.close();
		}
	public static void Pallo() {
		System.out.println(
				"    ,dP9CGG88@b,\r\n" + 
				"  ,lP  _   Y888@@b,\r\n" + 
				" dIi  (_)   G8888@b\r\n" + 
				"dCII  (_)   G8888@@b\r\n" + 
				"GCCIi     ,GG8888@@@\r\n" + 
				"GGCCCCCCCGGG88888@@@\r\n" + 
				"GGGGCCCGGGG88888@@@@...\r\n" + 
				"Y8GGGGGG8888888@@@@P.....\r\n" + 
				" Y88888888888@@@@@P......\r\n" + 
				" `Y8888888@@@@@@@P'......\r\n" + 
				"    `@@@@@@@@@P'.......\r\n" + 
				"        \"\"\"\"........");
		}
	//lukee vieraslista.txt:n
	public static void LueVieraslista() throws FileNotFoundException {
		final Scanner lukija = new Scanner(new File("Vieraslista.txt"));
		String rivi = " ";
		System.out.println("\nVieraslista:\n");
		while ( lukija.hasNext() ) {
			rivi = lukija.nextLine();
			System.out.println(rivi);
		}//while
		lukija.close();
		
	}
}
