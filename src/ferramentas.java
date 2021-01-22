import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ferramentas extends principal{

    public static String passaData(){
		LocalDateTime agora = LocalDateTime.now(); // data e hora atual
        // formatar a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(agora);
		return dataFormatada;
    }
	
	public static String passaHora(){
		LocalDateTime agora = LocalDateTime.now(); // data e hora atual
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
            if(placa.length()!=7){
                System.out.println("Placa invalida, tente novamente");
                placa = ler.next();
			}else{
                if(verificaExistPlaca(placa)){
					System.out.println("Veiculo ja cadastrado");
					return null;
				}else{
					result = placa;
					break repete;
				}
            }
        }
        return result;
    }
	
	public static boolean verificaExistPlaca(String placa){
		for(int i=0;i<cont;i++){
			if(placa.equals(patio[i][1])){
				return true;
			}
		}
		return false;
	}

	public static int procuraPlaca(String placa){
		for(int i=0;i<cont;i++){
			if(placa.equals(patio[i][1])){
				return i;
			}
		}
		return 0;
	}
	
	public static String verificaTabela(String placa){
		for(int i=0;i<cont;i++){
			if(placa.equals(patio[i][1])){
				return patio[i][2];
			}
		}
		return " ";
	}

	public static int passaMin(String hora){
		hora = hora.replaceAll(":", "");
		String hs = ((hora.charAt(0))+""+(hora.charAt(1)));
		String ms = ((hora.charAt(2))+""+(hora.charAt(3)));
		int hi = stringToInt(hs) * 60;
		int mi = stringToInt(ms);
		return hi+mi;
	}

    public static void exibePatio(){
		System.out.println("Numero - Placa - Tabela - Entrada - Saida");
        for(int i=0;i<cont;i++){
            for(int b=0;b<5;b++){
                System.out.print(patio[i][b]+" ");
            }
            System.out.println("\n");
        }
    }
}
