package Application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entitie.ImportedProduct;
import entitie.Product;
import entitie.UsedProduct;

public class Principal {

	public static void main(String[] args) throws ParseException {
		Scanner leitura = new Scanner(System.in);
		int number;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.printf("Enter the number of products: ");
		number = leitura.nextInt();
		leitura.nextLine();

		List<Product> list = new ArrayList<>();
		for (int i = 1; i <= number; i++) {
			System.out.println("Porduct #"+i+" data:");
			System.out.print("Common, Used or imported (c/u/i)?");
			char opc = leitura.next().charAt(0);
			leitura.nextLine();
			System.out.print("Name: ");
			String nome = leitura.nextLine();
			System.out.print("Price: ");
			Double preco = leitura.nextDouble();
			leitura.nextLine();
			if (opc == 'i') {
				System.out.println("Customs fee: ");
				Double customs = leitura.nextDouble();
				leitura.nextLine();
				Product productIm = new ImportedProduct(nome, preco, customs);
				list.add(productIm);

			}
			else if (opc == 'c') {
				list.add(new Product(nome, preco));
			}
			else {
				System.out.printf("Manufacture date (DD/MM/YYYY)");
				Date manufactureDate = sdf.parse(leitura.next());
				list.add(new UsedProduct(nome, preco, manufactureDate));
			}
		}
		System.out.print("PRICE TAGS: ");
		for(Product lista:list) 
		{
			
			System.out.println(lista.princeTag());
		}

	}

}
