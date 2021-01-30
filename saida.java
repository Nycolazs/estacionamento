public class saida extends principal{
	public static void menu(){
		System.out.println("Digite a placa do veiculo");
		String placa = ler.next();
		placa = placa.toUpperCase();
		if(ferramentas.verificaExistPlaca(placa)){
			switch(ferramentas.verificaTabela(placa)){
				case "moto": saida(placa); break;
				case "Carro Pequeno":saida(placa); break;
				case "Carro Grande":saida(placa); break;
				case "Diaria Moto":saidaDiaria(placa); break;
				case "D Carro Pequeno":saidaDiaria(placa); break;
				case "D Carro Grande":saidaDiaria(placa); break;
			}
		}else{
			System.out.println("Veiculo nao encontrado");
		}
	}
	
	public static void saidaDiaria(String placa){
		int pos = ferramentas.procuraPlaca(placa);
		double b = 0;
		switch(ferramentas.verificaTabela(placa)){
			case "Diaria Moto":b=valorDiariaM; break;
			case "D Carro Pequeno":b=valorDiariaCP; break;
			case "D Carro Grande":b=valorDiariaCG; break;
		}
		System.out.println("Valor a ser pago:"+b);
		ferramentas.reinsereVetor(pos);
	}
	
	public static void saida(String placa){
		int pos = ferramentas.procuraPlaca(placa);					     //Posicao do veiculo
		int horaentrada = ferramentas.passaMin(patio[pos][3]);			 //Hora de entrada
		int horasaida = ferramentas.passaMin(ferramentas.passaHora());   //Hora de saida
		patio[pos][4] = ferramentas.passaHora();						 //Insere a hora de saida no vetor
		int total = horasaida-horaentrada;								 //Tempo de estadia em minutos
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
			}
			System.out.println("A quantia a ser paga e de:"+b);
		}
		ferramentas.reinsereVetor(pos);
	}
}