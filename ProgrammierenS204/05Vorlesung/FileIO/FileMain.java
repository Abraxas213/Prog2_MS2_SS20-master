package FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import datastructures.Contact;

public class FileMain {

	public static void main(String[] args) {
		File file = new File("Aufgabe1.txt");
		File file2 = new File("Aufgabe2.txt");
		if (file.exists() && file2.exists()) {
			System.out.println("die Datei existiert");
		} else {
			System.out.println("Die Datei wird angelegt");
			try {
				file.createNewFile();
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Das Programm lebt noch");
		}

		try (FileWriter fileWriter = new FileWriter(file, false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			bufferedWriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände - BufferedWriter");
			bufferedWriter.newLine();
			bufferedWriter.flush();

//			fileWriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände\r\n");
//			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String text = bufferedReader.readLine();
			System.out.println(text);
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
//			ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
//			oos.writeObject(new Ufo(10, 15, 1000, 1000, 3, "spriteName"));
//			oos.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//HA
		//Aufgabe 1
		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
			
				Contact neuerContact = new Contact(62232, "Hustenbaron");
				if (neuerContact instanceof Contact) {
					oos.writeObject(neuerContact);
				}

				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		//Aufgabe 2
		
		try (FileWriter fileWriter = new FileWriter(file2, false);
				PrintWriter printWriter = new PrintWriter(fileWriter)) {
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			printWriter.print(s);
			printWriter.flush();
			scanner.close();

//			fileWriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände\r\n");
//			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
