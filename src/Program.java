import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
	
		int caso;
		Scanner sc=new Scanner(System.in);
		System.out.println("escolha uma opção a seguir");
		System.out.println("1-ler arquivo de texto\n2-criar e escrever arquivo de texto\n3-criar pasta em algun diretório");
		caso=sc.nextInt();
		sc.nextLine();
		
		switch(caso) {
		
		case 1:	
		String path = "C:\\arq.txt";
		BufferedReader br = null;
		FileReader fr = null;
		try {
		fr = new FileReader(path);
		br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {
		System.out.println(line);
		line = br.readLine();
		}
		} catch (IOException e) {
		System.out.println("Error: " + e.getMessage());
		} finally {
		try {
		if (br != null)
		br.close();
		if (fr != null)
		fr.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
		break;
		
		case 2:
		
			String [] lines= new String[] {"PRIMEIRA LINHA","SEGUNDA LINHA","TERCEIRA LINHA"};
			String pathe = "C:\\arquivo.txt";
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathe,true))){
				for(String line : lines) {
					bw.write(line);
					bw.newLine();
					
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
						
			
		break;
		
		case 3:
			
			System.out.println("escolha a pasta de caminho para salvar o arquivo");
			String Path=sc.nextLine();
			
			File path1 =new File(Path);
			
			File [] folders= path1.listFiles(File::isDirectory);
			System.out.println("pastas");
			for(File folder : folders) {
				System.out.println(folder);
			}
			
			boolean sucesso= new File(Path+"Pasta_Aplicação").mkdir();
			System.out.println("Nova pasta criada"+sucesso);
			
		break;
		
		}
		
	}
	
	}
	

