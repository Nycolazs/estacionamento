public class entrada extends principal{
	//Menu para entrada de veiculos
    public static void menu(){
        System.out.println("Digite a tabela do veículo\n1-Moto\n2-Carro\n3-Diaria");
        String opt = ler.next();
        switch(opt){
            case "1":moto();break;
            case "2":System.out.println("1-Pequeno\n2-Grande");
                opt = ler.next();
                if((opt.equals("1"))||(opt.equals("2"))){
                    carro(opt);
                }else{
                    System.out.println("Opção inválida");
                }
            break;
            case "3":System.out.println("Qual o veiculo:\n1-Moto\n2-Carro Pequeno\n3-Carro Grande");
                opt = ler.next();
                if((opt.equals("1"))||(opt.equals("2"))||(opt.equals("3"))){
                    diaria(opt);
                }else{
                    System.out.println("Opção inválida");
                }
            default:System.out.println("Opção inválida"); break;
        }
    }

	//Pega placa da moto, verifica e formata, e insere no vetor
    public static void moto(){
        System.out.println("Digite a placa da moto");
		String placa = ferramentas.verificaPlaca();
        repete:while(true){
			if(placa==null){
				System.out.println("Tente novamente");
				placa=ferramentas.verificaPlaca();
			}else{
				break repete;
			}
		}
        String tabela = "moto";
        insereVetor(cont, placa, tabela);
    }

	//Pega placa da moto, verifica e formata, e insere no vetor
    public static void carro(String opt){
		System.out.println("Digite a placa do carro");
        String placa = ferramentas.verificaPlaca();
        repete:while(true){
			if(placa==null){
				System.out.println("Tente novamente");
				placa=ferramentas.verificaPlaca();
			}else{
				break repete;
			}
		}
		String tabela = null;
		if(opt.equals("1")){
			tabela = "Carro Pequeno";
		}else{
			tabela = "Carro Grande";
		}
        insereVetor(cont, placa, tabela);
    }

	//Verifica diaria de cada veiculo
    public static void diaria(String opt){
		String tabela = null;
		String besta = null;
        if(opt.equals("1")){
			tabela = "Diaria Moto";
			besta = "a moto";
		}else if(opt.equals("2")){
			tabela = "D Carro Pequeno";
			besta = "o carro";
		}else{
			tabela = "D Carro Grande";
			besta = "o carro";
		}
		System.out.println("Digite a placa d"+besta);
		String placa = ferramentas.verificaPlaca();
        repete:while(true){
			if(placa==null){
				System.out.println("Tente novamente");
				placa=ferramentas.verificaPlaca();
			}else{
				break repete;
			}
		}
        insereVetor(cont, placa, tabela);
    }

	//Insere as informacoes passadas no vetor
    public static void insereVetor(int num, String placa, String tabela){
        patio[num][0] = tools.intToString(num+1);
        patio[num][1] = placa;
        patio[num][2] = tabela;
        patio[num][3] = ferramentas.passaHora();
		cont++;
    }
}
