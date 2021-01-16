public class entrada extends principal{
    public static void menu(){
        System.out.println("Digite a tabela do veículo\n1-Moto\n2-Carro\n3-Diária");
        String opt = ler.next();
        switch(opt){
            case "1":moto();break;
            case "2":System.out.println("1-Pequeno\2-Grande");
                opt = ler.next();
                if(opt!="1"||opt!="2"){
                    System.out.println("Opção inválida");
                }else{
                    carro(opt);
                }
            break;
            default:System.out.println("Opção inválida"); break;
        }
    }

    public static void moto(){

    }

    public static void carro(String opt){

    }
}
