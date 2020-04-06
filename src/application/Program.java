package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		String path = "C:\\Users\\teoge\\eclipse-workspace\\exercicio-arquivos";
		String arquivoIn = "produtos.csv";
		String arquivoOut = "summary.csv";
		List<Product> listProduct = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path+"\\"+arquivoIn))){
			String line = br.readLine();
			while(line != null) {
				String[] arrayLine = line.split(",");
				Product product = new Product(arrayLine[0], Double.parseDouble(arrayLine[1]), Integer.parseInt(arrayLine[2]));
				listProduct.add(product);
				line = br.readLine();
			}
			
			new File(path + "\\out").mkdir();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(path+"\\out\\"+arquivoOut));
			for (Product product : listProduct) {
				line = product.getName() + ", " + (product.getPrice()*product.getQuantity());
				bw.write(line);
				bw.newLine();					
			}
			bw.close();
			
		}
		catch (IOException e) {
			System.out.println("Error "+e.getMessage());
		}
		catch (NumberFormatException e) {
			System.out.println("Error: Formato inválido ");
			e.printStackTrace();
		}

	}

}
