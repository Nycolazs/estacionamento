public class entrada extends principal{
    public static void menu(){
        System.out.println("Digite a tabela do veículo\n1-Moto\n2-Carro\n3-Diária");
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

    public static void moto(){
        System.out.println("Digite a placa da moto");
        String placa = ferramentas.verificaPlaca();
        String hora = ferramentas.passaHora();
        String tabela = "moto";
        cont++;
        insereVetor(cont, placa, tabela, hora);
    }

    public static void carro(String opt){

    }

    public static void diaria(String opt){
        
    }

    public static void insereVetor(int num, String placa, String tabela, String entrada){
        patio[num][0] = ferramentas.intToString(num);
        patio[num][1] = placa;
        patio[num][2] = tabela;
        patio[num][0] = entrada;
    }
}
