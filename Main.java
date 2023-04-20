import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String  palavraChave =  "Motocicleta";
        String  letraUsadas = "";
        String  palavraAdivinhada = "";
        int Max_Tentativas = 10;


        for(int i = 0; i< palavraChave.length(); i++){
            palavraAdivinhada += "_";

            for(int tentativas = 0; ; tentativas++){
                if(tentativas == Max_Tentativas){
                    System.out.printf("Foram 10 tentativas... A palavra era  '%s'", palavraChave);
                    System.exit(0);
                }

                System.out.printf("Rodada %d. Até agora adivinhada: %s. Qual a sua próxima letra? ", tentativas,
                        palavraAdivinhada);

                char letraTentada = new Scanner(System.in ).next().charAt(0);
                if(letraUsadas.indexOf(letraTentada) >=0 ){
                    System.out.printf("Você já tentou a letra %c.%n", letraTentada);

                }else{

                    letraUsadas += letraTentada;

                    if(palavraChave.indexOf(letraTentada)>=0){
                        palavraAdivinhada = "";

                        for(int j = 0; j < palavraChave.length(); j++){
                            palavraAdivinhada += letraUsadas
                                    .indexOf(palavraChave.charAt(j)) >= 0 ? palavraChave.charAt(j) : "_";
                        }


                        if(palavraAdivinhada.contains("_")){
                            System.out.printf("Muito bom! %s existe na palavra. Ainda tem letras escondidas%n",
                                    letraTentada);

                        }else{
                            System.out.printf("Parabéns! A palavra adivinhada era '%s'%n", palavraAdivinhada);
                            System.exit(0);

                        }
                    }else{
                        System.out.printf("Infelizmente a letra %c não existe na palavra", letraTentada);
                    }
                }
            }
        }
    }
}