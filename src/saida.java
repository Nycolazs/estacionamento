public class saida extends principal{
	public static void menu(){
		System.out.println("Digite a placa do veiculo");
		String placa = ler.next();
		if(ferramentas.verificaExistPlaca(placa)){
			System.out.println("bora");
		}else{
			System.out.println("embora");
		}
	}
}