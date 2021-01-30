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

	//Converte de double para string
    public static double doubleToString(String a){
        a.replaceAll(",", ".");
        double valor = Double.parseDouble(a);
        return valor;
    }

	//Converte de String para int
    public static int stringToInt(String a){
        int valor = Integer.parseInt(a);
        return valor;
    }

	//Converte de int para string
    public static String intToString(int a){
        String result = Integer.toString(a);
        return result;
    }

	//Verifica o tamanho da placa e se já existe
    public static String verificaPlaca(){
        String placa = ler.next();
		placa=placa.toUpperCase();
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
	
	//Verifica se placa já está cadastrada
	public static boolean verificaExistPlaca(String placa){
		for(int i=0;i<cont;i++){
			if(placa.equals(patio[i][1])){
				return true;
			}
		}
		return false;
	}

	//Procura a placa no vetor, e informa a posição dela
	public static int procuraPlaca(String placa){
		for(int i=0;i<cont;i++){
			if(placa.equals(patio[i][1])){
				return i;
			}
		}
		return 0;
	}
	
	//Verifica e passa a tabela do veiculo
	public static String verificaTabela(String placa){
		for(int i=0;i<cont;i++){
			if(placa.equals(patio[i][1])){
				return patio[i][2];
			}
		}
		return " ";
	}

	//Transforma horas em minutos e envia
	public static int passaMin(String hora){
		hora = hora.replaceAll(":", "");
		String hs = ((hora.charAt(0))+""+(hora.charAt(1)));
		String ms = ((hora.charAt(2))+""+(hora.charAt(3)));
		int hi = stringToInt(hs) * 60;
		int mi = stringToInt(ms);
		return hi+mi;
	}

	//Opção do menu de exibir o patio
    public static void exibePatio(){
		System.out.println("Numero - Placa - Tabela - Entrada");
        for(int i=0;i<cont;i++){
			System.out.print((i+1)+" ");
            for(int b=1;b<4;b++){
                System.out.print(patio[i][b]+" ");
            }
            System.out.println("\n");
        }
    }
	
	//Apaga e Reinsere os veiculos no vetor quando um sai
	public static void reinsereVetor(int pos){
		for(int i=0;i<5;i++){
			patio[pos][i] = null;
		}
		for(int i=pos;i<cont;i++){
			for(int b=1;b<5;b++){
				patio[i][b]=patio[i+1][b];
			}
		}
		cont--;
	}
}
