package rpg;

import java.util.Scanner;
import java.util.List;

public class MundoMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iniciar;
        int batalhar;
        int pular=0;
        int voar=0;
        int ZG=0;
        
        while (true) {
        System.out.println("A Jornada de Sandubinha");
        System.out.println("1 - Iniciar História");
        System.out.println("2 - Sair do Jogo");
        System.out.print("Escolha: ");
        iniciar = scan.nextInt();

        while (iniciar != 1 && iniciar != 2 ) {
            System.out.println("Opção inválida. Tente novamente.");
            System.out.print("Escolha: \n1 para Iniciar,\n2 para Sair: ");
            if (scan.hasNextInt()) {
                iniciar = scan.nextInt();
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scan.next(); //limpa a resposta 
            }
        }
        

        if (iniciar == 2) {
            System.out.println("Fim do Programa");
            break;
        }

       if(iniciar ==1) {
        Historia conto = new Historia();
        Historia timeout = new Historia();
        conto.introducao();
        conto.contextoAtual();
        conto.ritualEMissao();
        conto.florestaAtendimentus();
        MecanicaBatalha batalha = new MecanicaBatalha();
        
        
        
        Personagem heroi = new Personagem();
        heroi.setNome("Sandubinha");
        heroi.setEspécie("Guerreiro");
        heroi.setVida(5);//5
        System.out.println(heroi);
        heroi.setEquipamento(new Item());
        
         Personagem Monstrengo = new Personagem();
        Monstrengo.setNome("Monstrengo");
        Monstrengo.setEspécie("Monstro");
        Monstrengo.setVida(3);//3
        System.out.println(Monstrengo);
        
        
        
        
        
        //acontece a  funcao batalha \\ heroi \\ vilao \\qtdDados
        batalha.Batalha(heroi, Monstrengo, 1);
        
        
      
        
        	if(Monstrengo.getVida()==0) {
            System.out.println("Fim da batalha \u001B[1mVITÓRIA\u001B[0m de Sandubinha\n");
            timeout.dialogo(3000);
        	System.out.println("Processus Ministerii - Muito Obrigado, tome o Artefato (Guia de Atendimento) e vá para o proximo desafio\n ");
        	heroi.adicionaItem("Guia de Atendimento");
        	System.out.println("- Formato: Pergaminho");
        	System.out.println("- Benefício: Fortifica o personagem, sorteando 2 números de uma só vez a cada ataque.");
        	System.out.println("  O dano é a soma do número de vezes que o número secreto do inimigo apareceu nesses sorteios.");
        	System.out.println("- Consequência: Sem consequências.");

        	heroi.setEquipamento(heroi);
        	heroi.resetarVida(5);//5
        	heroi.vidaBonus();
        	heroi.mostrarItem();
        	
        }
        
        else if(heroi.getVida() == 0 ){
        	System.out.println("Fim da batalha \u001B[1mDERROTA\u001B[0m de Sandubinha\n");
        	System.out.println("Processus Ministerii - Oh ,não o mundo séra mais uma vez detruido por Glozium");
        	timeout.dialogo(3000);
        	System.out.println("O mundo foi destruido por Glozium, uma fatalidade terrivel... FIM DE JOGO");
        	if (timeout.jogarNovamente(scan)) {
        	    continue;
        	} else {
        		System.out.println("Jogo Encerrado");
        	    return;
        	}
        	
          }
        
         
         
        
        conto.cavernasFaturamentus();
      timeout.dialogo(3000);
        
        System.out.println(heroi);
        
        Personagem urso = new Personagem();
        urso.setNome("UrsoSangrento");
        urso.setEspécie("Monstro");
        urso.setVida(6);//6
        System.out.println(urso);;

      timeout.dialogo(3000);

        batalha.Batalha(heroi, urso,2);
        
        
        if(urso.getVida()==0) {
            System.out.println("Fim da batalha \u001B[1mVITÓRIA\u001B[0m de Sandubinha\n");
            timeout.dialogo(3000);
        	System.out.println("Ansião faturador - muito obrigado, mas tô ocupado demais para agradecimentos longos, tome o artefato sagrado e siga em frente.\n ");
        	System.out.println("Sandubinha ganha o artefato Faturamentus");
        	System.out.println("- Formato: Placa de pedra");
        	System.out.println("- Benefício: Sorteia 4 números de uma só vez a cada ataque.");
        	System.out.println("- Consequência: Se errar o número secreto, o próximo ataque do monstro causa +2 de dano.");

        	heroi.adicionaItem("Faturamentus");
        	heroi.setEquipamento(heroi);
        	heroi.resetarVida(7);//7
        	heroi.vidaBonus();
        	heroi.mostrarItem();
        	
        }
        
        else if(heroi.getVida() == 0 ){
        	System.out.println("Fim da batalha \u001B[1mDERROTA\u001B[0m de Sandubinha\n");
        	System.out.println("Ansião faturador - herói merda, nem para cumprir o trabalho dele, estamos perdidos");
        	timeout.dialogo(3000);
        	System.out.println("O mundo foi destruido por Glozium, uma fatalidade terrivel... FIM DE JOGO");
        	if (timeout.jogarNovamente(scan)) {
        	    continue;
        	} else {
        		System.out.println("Jogo Encerrado");
        	    return;
        	}
        	
          }
        
        
        
        
   
        conto.vilaTransmissao();
        heroi.adicionaItem("Estilingue Mágico");
        System.out.println("- Formato: Estilingue");
        System.out.println("- Benefício: Lança pedra teleguiada com 50% de chance.");
        System.out.println("  Sorteia +5 números para tentar acertar o número secreto.");
        System.out.println("  Se acertar, o inimigo fica atordoado e perde a rodada.");
        System.out.println("- Consequência:");
        System.out.println("  - Pode ser usado até 3 vezes por batalha sem penalidade.");
        System.out.println("  - Se errar 3 vezes, perde 1 de vida ao usar.");

        heroi.setEquipamento(heroi);
        
        System.out.println(heroi);
        
        Personagem dragao  = new Personagem();
        dragao.setNome("Dragão da Transmissão");
        dragao.setEspécie("Dragão");
        dragao.setVida(12);//12
        System.out.println(dragao);
        
        
        heroi.mostrarItem();
        
        
        	
        
        batalha.Batalha(heroi, dragao,3);
        
        if(dragao.getVida()==0) {
            System.out.println("Fim da batalha \u001B[1mVITÓRIA\u001B[0m de Sandubinha\n");
            timeout.dialogo(3000);
            System.out.println("\u001B[1mDragão:\u001B[0m - Muito obrigado, todo herói evitava essa batalha e seguia direto para a torre. Agora sou livre!");
	        System.out.println("\u001B[1mSandubinha:\u001B[0m - Evitava? E dá pra seguir sem lutar? Como assim?");
	        System.out.println("Sandubinha ganha o artefato \u001B[1mAzah Transmissão\u001B[0m!");
        	heroi.adicionaItem("Azah Transmissão");
        	System.out.println("- Formato: Capa");
        	System.out.println("- Benefício: Dá habilidade de voo (+10 números por rodada no ataque).");
        	System.out.println("  Ir de apé consome 3 de vida.");
        	System.out.println("- Consequência: Se errar o número secreto, o dano recebido será proporcional ao último número sorteado.");
        	System.out.println("  Fórmula: dano = vidaAtual - últimoNúmeroSorteado");

        	heroi.setEquipamento(heroi);
        	heroi.resetarVida(9);//9
        	heroi.vidaBonus();
        	heroi.mostrarItem();
        	
        }
        
        else if(heroi.getVida() == 0 ){
        	System.out.println("\u001B[1mDragão:\u001B[0m - Sinto muito herói, que sua alma seja livre...");
        	timeout.dialogo(3000);
	        System.out.println("\nTexto final: O mundo foi destruído por Glozium... Uma fatalidade terrível... Fim de jogo!");
	        if (timeout.jogarNovamente(scan)) {
        	    continue;
        	} else {
        		System.out.println("Jogo Encerrado");
        	    return;
        	}
        	
          }
          
        System.out.println("\nDeseja usar a Azah Transmissão para ir Voando até A Torre Contas A receber");
        timeout.dialogo(2500);
        System.out.println("O caminho e muito longo ate a torre voce sofrera 3 de dano se for andando");
        timeout.dialogo(2500);
        System.out.println("1 - Usar a Azah Trnsmissão");
        System.out.println("2 - Ir Andando");
        voar = scan.nextInt();
        if(voar==1) {
        	System.out.println(" ".repeat(48)+ "Apos uma Longa jornda Sandubinha Chega a \u001B[1mTorre de Contas a Receber\u001B[0m");
        	conto.torreContasAReceber();
        }else {
        	heroi.tomarDano(3);
        	System.out.println(" ".repeat(48)+"Apos uma Longa jornda Sandubinha Chega a \u001B[1mTorre de Contas a Receber\u001B[0m");
        	System.out.println("  - Você Tomou 3 de dano você tem "+heroi.getVida()+" de Vida");
        	conto.torreContasAReceber();
        }
        
          
        
        
        
        System.out.println("O caminho e muito longo ate a torre voce sofrera 3 de dano se for andando");
        timeout.dialogo(2500);
        System.out.println("1 - Usar a Azah Trnsmissão");
        System.out.println("2 - Ir Andando");
        voar = scan.nextInt();
        if(voar==1) {
        	System.out.println(" ".repeat(48)+ "Apos uma Longa jornda Sandubinha Chega a \u001B[1mTorre de Contas a Receber\u001B[0m");
        	conto.torreContasAReceber();
        }else {
        	heroi.tomarDano(3);
        	System.out.println(" ".repeat(48)+"Apos uma Longa jornda Sandubinha Chega a \u001B[1mTorre de Contas a Receber\u001B[0m");
        	System.out.println("  - Você Tomou 3 de dano você tem "+heroi.getVida()+" de Vida");
        	conto.torreContasAReceber();
        }
          
        
        conto.torreContasAReceber();
        
        System.out.println(heroi);
        
        Personagem EstatuaHeroi = new Personagem();
        EstatuaHeroi.setNome("Estatua do ultimo Heroi");
        EstatuaHeroi.setEspécie("Guerreiro Estatua");
        EstatuaHeroi.setVida(25);//25
        System.out.println(EstatuaHeroi);
        
        
        batalha.Batalha(heroi, EstatuaHeroi, 5);
        
        
        if(EstatuaHeroi.getVida()==0) {
            System.out.println("Fim da batalha \u001B[1mVITÓRIA\u001B[0m de Sandubinha\n");
            timeout.dialogo(3000);
            System.out.println("\u001B[1mSandubinha:\u001B[0m- É assustador olhar para essa estátua despedaçada e ver a forma do último herói...");
	        System.out.println("Sandubinha ganha o artefato: \u001B[4mColar da estátua sagrada\u001B[0m");
        	System.out.println(" Colar da Estátua Sagrada:");
        	System.out.println("- Formato: Colar");
        	System.out.println("- Benefício: Permite sortear +10 números em uma rodada.");
        	System.out.println("- Consequência: Perde 3 de vida sempre que o colar é usado em batalha.");

        	heroi.setEquipamento(heroi);
        	heroi.resetarVida(11);//11
        	heroi.vidaBonus();
        	heroi.mostrarItem();
        	
        }
        
        else if(heroi.getVida() == 0 ){
        	System.out.println("\u001B[1mEstátua do Último heroi:\u001B[0m ...");
        	timeout.dialogo(3000);
	        System.out.println("\nTexto final: O mundo foi destruído por Glozium... Uma fatalidade terrível... Fim de jogo!");
	        if (timeout.jogarNovamente(scan)) {
        	    continue;
        	} else {
        		System.out.println("Jogo Encerrado");
        	    return;
        	}
        	
          }
        
        
        Item verificador = new Item();
        System.out.println("deseja voltar aHospitalis e pedir aos ferreiros de Zerum Glozium");
        System.out.println("para forjar a Espada ZG antes de enfrentar Glozium.");
        System.out.println("   - Só é possível forjar a espada se ele tiver todos os itens das fases.");
        System.out.println("1 - SIM");
	    System.out.println("2 - NÃO");       
        ZG=scan.nextInt();
 

        if(ZG==1) {
        if (verificador.podeForjarEspadaZG(heroi)) {
            System.out.println("Você tem todos os itens lendários!");
            System.out.println("Forjando a Espada ZG...");
            heroi.adicionaItem("Espada ZG");
            System.out.println("Para evitar os andares, Sadubinha escala por fora e entra por uma janela do topo.");
        } else {
            System.out.println("Você ainda não possui todos os itens para forjar a Espada ZG.");
        }
        }
        
        Personagem glozium = new Personagem();
        glozium.setNome("Glozium");
        glozium.setEspécie("Mago Monstro");
        glozium.setVida(100);
        System.out.println(glozium);

	    System.out.println("Deseja escutar Glozium?");
	    System.out.println("1 - SIM");
	    System.out.println("2 - NÃO");
	     pular = scan.nextInt();
	    if (pular == 1) {
	        conto.dialogoGlozium();
	    }
	    batalha.Batalha(heroi, glozium, 10);
	    
	    if (glozium.getVida() == 0) {
	        System.out.println("Fim da batalha \u001B[1mVITÓRIA\u001B[0m de Sandubinha\n");

	        boolean usouEspadaZG = heroi.getEquipamento().listarItens().stream()
	                .anyMatch(item -> item.equalsIgnoreCase("Espada ZG"));

	        if (usouEspadaZG) {
	            System.out.println("\u001B[1mSandubinha:\u001B[0m Finalmente, Glozium está eliminado por completo, irei retornar à minha família.");
	            timeout.dialogo(3000);
	            System.out.println("Texto: O herói derrotou Glozium, o mundo agora poderá voltar a seus tempos de alegria. Muito obrigado, herói!");
	            timeout.dialogo(3000);
	            System.out.println("Texto: Fim de jogo!");
	        } else {
	            System.out.println("\u001B[1mGlozium:\u001B[0m você me derrotou com armas tão simples, impressionante, mas irei retornar no ano seguinte.");
	            timeout.dialogo(3000);
	            System.out.println("\u001B[1mSandubinha:\u001B[0m ...retornarei envergonhado para minha família, mas ao menos serei feliz");
	            timeout.dialogo(3000);
	            System.out.println("Texto: Sandubinha começa a se enrijecer como pedra...");
	            timeout.dialogo(3000);
	            System.out.println("\u001B[1mGlozium:\u001B[0m você me derrotou, mas suguei sua energia vital, você irá se transformar em minha estátua da entrada da torre hahaha");
	            timeout.dialogo(3000);
	            System.out.println("\u001B[1mSandubinha:\u001B[0m maldito!... Eu... nunc... ir... [virou pedra]");
	            timeout.dialogo(3000);
	            System.out.println("Texto: O herói derrotou Glozium ao custo de sua alma, o mundo seguirá normalmente por mais 1 ano... Fim de Jogo!");
	            timeout.dialogo(3000);
	        }

	        if (timeout.jogarNovamente(scan)) {
	            continue;
	        } else {
	            System.out.println("Jogo Encerrado");
	            return;
	        }

	    } else if (heroi.getVida() == 0) {
	        System.out.println("\u001B[1mGlozium:\u001B[0m Finalmente! um herói bosta que apenas aumentou meus poderes.");
	        timeout.dialogo(3000);
	        System.out.println("Texto: O mundo foi destruído por Glozium, uma fatalidade terrível... Fim de jogo!");

	        if (timeout.jogarNovamente(scan)) {
	            continue;
	        } else {
	            System.out.println("Jogo Encerrado");
	            return;
	        }
	    }
        
        
        
        }
       }// if==1
       
       
       
       
       
       
       
      }
        
        }
    

    

    
    

    