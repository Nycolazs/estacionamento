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

    public static int intToString(String a){
        int valor = Integer.parseInt(a);
        return valor;
    }
}
