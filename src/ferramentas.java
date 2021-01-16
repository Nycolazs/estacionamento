import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ferramentas extends principal{
    private static LocalDateTime agora = LocalDateTime.now(); // data/hora atual

    public static String passaData(){
        // formatar a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(agora);
		return dataFormatada;
    }
	
	public static String passaHora(){
		// formatar a hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = formatterHora.format(agora);
		return horaFormatada;
	}

    //Metodo de criar texto, para usá-lo basta escreverTexto("nomeDoArquivo.txt","Texto");
    public static void escreverTexto(String pCaminhoArquivo, String pTextoAEscrever){
        try(
            FileWriter criadorDeArquivos = new FileWriter(pCaminhoArquivo, true);
            BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
            PrintWriter escritorDeArquivos = new PrintWriter(buffer);)
            {
            escritorDeArquivos.append(pTextoAEscrever);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static double doubleToString(String a){
        a.replaceAll(",", ".");
        double valor = Double.parseDouble(a);
        return valor;
    }

    public static int stringToInt(String a){
        int valor = Integer.parseInt(a);
        return valor;
    }

    public static String intToString(int a){
        String result = Integer.toString(a);
        return result;
    }

    public static String verificaPlaca(){
        String placa = ler.next();
        String result;
        repete: while(true){
            if(placa.length()>7){
                System.out.println("PLACA INVÁLIDA, DIGITE NOVAMENTE");
                placa = ler.next();
            }else{
                result = placa;
                break repete;
            }
        }
        return result;
    }

    public static void exibePatio(){
        for(int i=0;i<50;i++){
            for(int b=0;b<5;b++){
                System.out.print(patio[i][b]+" ");
            }
            System.out.println("\n");
        }
    }
}
