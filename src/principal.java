import java.util.Scanner;

public class principal{
	protected static Scanner ler = new Scanner(System.in);
	public static config config = new config();
	public static ferramentas tools = new ferramentas();
	public static String data = tools.passaData();
	public static entrada entrada = new entrada();
	protected static int valorTol; protected String nome;
	protected static double valorMoto; protected static double valorCarroP;
	protected static double valorCarroG; protected static double valorDiariaCG;
	protected static double valorDiariaM; protected static double valorDiariaCP;
	protected static String[][] patio = new String[50][5];//Numero,Placa,Tabela,Entradas,Saidas
	//Tabela 1-Moto, 2-Carro pequeno, 3-Carro grande, 4-Diária Moto, 5-Diária Carro
	
	//Main com menu principal
	public static void main(String[]a){
		config.primeiraVez();
		while(true){
			System.out.println("ESTACIONAMENTO\n1-Entrada\n2-Saida\n3-Configurar valores do zero");
			repete:while(true){
				String opt = ler.next();
				switch(opt){
					case "1": entrada.menu(); break repete;
					case "2": break repete;
					case "3": config.config(); break repete;
					default:System.out.println("Opção inválida");break;
				}
			}
		}
	}
}