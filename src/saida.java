public class saida extends principal{
	public static void menu(){
		System.out.println("Digite a placa do veiculo");
		String placa = ler.next();
		if(ferramentas.verificaExistPlaca(placa)){
			saida(placa);
		}else{
			System.out.println("Veiculo não encontrado");
		}
	}
	
	public static void saida(String placa){
		int pos = ferramentas.procuraPlaca(placa);
		int horaentrada = ferramentas.passaMin(patio[pos][3]);
		int horasaida = ferramentas.passaMin(ferramentas.passaHora());
		patio[pos][4] = ferramentas.passaHora();
		int total = horasaida-horaentrada;
		System.out.println("Tempo de estadia:"+total+" minutos");
		if(total<=valorTol){
			System.out.println("Tempo dentro da tolerancia de "+valorTol+", nada a ser cobrado");
		}else{
			double a = total/60;
			double b = 0;
			switch(ferramentas.verificaTabela(placa)){
				case "moto": b = b*valorMoto; break;
				case "Carro Pequeno": b = b*valorCarroP; break;
				case "Carro Grande": b = b*valorCarroG; break;
				case "Diaria Moto": b = b*valorDiariaM; break;
				case "D Carro Pequeno": b = b*valorDiariaCP; break;
				case "D Carro Grande": b = b*valorDiariaCG; break;
			}
			System.out.println("A quantia a ser paga e de:"+b);
		}
		for(int i=0;i<5;i++){
			patio[pos][i] = null;
		}
	}
}