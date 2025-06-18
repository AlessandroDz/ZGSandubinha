package rpg;

import java.util.Scanner;

public class Historia {

	public void introducao() {
		System.out.println(" ".repeat(50) +" A Jornada de Sandubinha");
	    System.out.println("Vindo de onde os olhos não conseguiam alcançar, com um som alto, passando pelas montanhas e vales, pelos rios e florestas.");
	    System.out.println("Todos no mundo puderam ouvir uma voz que parecia um estrondo, que dizia:");
	    dialogo(4000);
	    System.out.println("\n- Contemplem seu novo mestre, Glozium...");
	    dialogo(4000);
	   	System.out.println("- Demonstrativus potentiaaam!!");
	    dialogo(4000);
		System.out.println("\nO terror recaiu sobre as pessoas e o mundo foi tomado por uma neblina que provocou todo tipo de mazela.");
	  	System.out.println("Alguns morreram, outros tornaram-se monstros, animais sofreram mutações.");
	  	System.out.println("Mas após a dissolução dessa terrível onda mortífera, era possível ver em meio à neblina o que pareciam estátuas em pé, onde o som foi mais intenso...");
	
	}

	 public void contextoAtual() {
			 dialogo(4000);
		System.out.println("\n Agora...");
		System.out.println("A província de Hospitalis é conhecida por seus médicos mágicos poderosos, que foram capazes de erradicar uma doença terrível lançada pelo grande vilão Glozium.");
		System.out.println("\nInfelizmente, os hospitalines não conseguem lidar com todo o poder de Glozium sozinhos e, por isso, a província depende de guerreiros estrangeiros para ajudá-los a se defender.");
		System.out.println("A famosa Zerum Glozium é a principal Guilda do reino, seus ferreiros desenvolvem armas para os guerreiros capazes de travar embates contra as forças de Glozium.");
		System.out.println("Esses guerreiros escolhidos são chamados de Analytics di Glozium.");
	    }

	    public void ritualEMissao() {
	    	dialogo(4000);
		 System.out.println("\nPara reduzir os impactos do monstro imortal Glozium, que ressurge a cada ano, a província de Hospitalis realiza um grande ritual chamado Ciclum Receitatus Hospitalis.");
		 System.out.println("Esse ritual dura por um ano e reúne condições de destruir Glozium, reduzindo seu poder a zero.");
		 System.out.println("Mesmo que não seja destruído, ele é sempre enfraquecido e somente recobra seus poderes no próximo ano.");
		 System.out.println("\nPara que o ritual se concretize, o guerreiro escolhido deve partir em uma jornada visitando quatro locais para obter os itens necessários.");
		 System.out.println("E Sandubinha parte nessa jornada...");
	        
}
	    
	    public void florestaAtendimentus () {
	    	System.out.println(" ".repeat(45) +" O Inicio de uma Batalha Sangrenta"+"\n");
	    	dialogo(3500);
	    	System.out.println(" ".repeat(55)+ "\u001B[1mA Primeira Batalha\u001B[0m");
	    	dialogo(3500);
	     System.out.println("-Um lugar encantado a Floresta de Atendimentus , dizem que pessoas doentes ou com almas feridas podem ir a floresta para serem curadas");
	      dialogo(3000);
	     System.out.println("\n\u001B[1mSandubinha\u001B[0m - Então você é meu primeiro desafio nessa floresta encantada ?");
	     dialogo(3000);
	     System.out.println("\n\u001B[1mMonstro\u001B[0m - Bem vindo, vejo que você é um dos escolhidos para enfraquecer Glozium, meu nome e Processus  Ministerii,");
	     dialogo(3000);
	     System.out.println("\n\u001B[1mProcessus\u001B[0m - Sou o ser magico que atende as almas feridas, envio os informativos disso as cavernas de Faturamentus");
	   dialogo(3000);
	     System.out.println("\n\u001B[1mProcessus\u001B[0m - Você não irá lutar comigo, mas sim contra esse ser criado por Glozium chamado "+ "\u001B[1mMonstrengo.\u001B[0m");
	   dialogo(3000);
	     System.out.println("\n\u001B[1mProcessus\u001B[0m - Seres mágicos do meu tipo nao podem ser afetados por Glozium, mas tambem não podem lutar contra, ele me atrapalha me desconcentrando e provocando erros\n");
	   dialogo(3000);
	     System.out.println(" ".repeat(20)+ "\u001B[1mSurge entre as pernas do Grande Monstro um ser Humanoide, da altura de Sandubinha\u001B[0m"+"\n");
	     dialogo(2000);
	    System.out.println("\u001B[1mSandubinha\u001B[0m - Primeiro,não é enfraquecer, vou dar um fim total em Glozium... VENHA MONSTRO"+"\n");
	    
	    }
	    
	    
	    public void cavernasFaturamentus() {
	    	System.out.println(" ".repeat(55)+ "\u001B[1mCavernas de Faturamentus\u001B[0m");
	    	dialogo(3500);
	    	System.out.println("Existe sempre um preco a se pagar pela curo do corpo e da alma, após a floresta de atendimentus seu preco é calculado");
	    	System.out.println("de acordo com o tipo de contrato divino que você tem...");
	    	dialogo(3500);
	    	System.out.println("Percorrendo a caverna segurando uma tocha. Sandubinha escuta sons assustadore de grunhidos");
	    	dialogo(3000);
	    	System.out.println("\n\u001B[1mSandubinha\u001B[0ms - Que tipo de situação é essa ?");
	    	dialogo(3000);
	    	System.out.println(" ".repeat(50)+"\n\u001B[1mUm monstro em forma de urso surge e diz a Sandubinha\u001B[0ms:");
	    	dialogo(3000);
	    	System.out.println("\n\u001B[1mUrso Sangrento\u001B[0ms - Finalmente diversão, esses anciões só sabem ficar anotando essas coisas inúteis. Vamos lutar heroizinho.");
	    	dialogo(3000);
	    	System.out.println("\n\u001B[1mSandubinha\u001B[0m - Criatura desagradável, não me deu tempo nem de tomar uma água, então bora nessa!");
	    	
	    }
	    
	    public void vilaTransmissao() {
	        System.out.println(" ".repeat(55) + "\u001B[1mVila da Transmissão\u001B[0m");

	        System.out.println("Uma vila mágica que recebe cobranças vindas das cavernas de Faturamentus.");
	        System.out.println("Os moradores entregam as mensagens na torre...");
	      dialogo(3000);
	        System.out.println("\nSandubinha é bem recebido ao chegar na vila. Ele é convidado para um jantar ritualístico com comidas típicas.");
	      dialogo(3000);
	        System.out.println("Durante o jantar, os moradores contam que o monstro a ser enfrentado é um ser que voa.");
	        System.out.println("Para atacá-lo, Sandubinha terá que derrubar o monstro e usar sua espada.");
	      dialogo(3000);
	        System.out.println("\nOs moradores entregam a Sandubinha um item especial: \u001B[1mEstilingue Mágico\u001B[0m");
	      dialogo(3000);
	        System.out.println("\n".repeat(2) + "\u001B[1mUm monstro em forma de dragão surge voando e grita:\u001B[0m");
	      dialogo(1500);
	        System.out.println("\n\u001B[1mDragão da Transmissão:\u001B[0m - Você já tem sua arma... Já fui guardião dessas terras e transmitia as mensagens à torre.");
	      dialogo(1500);
	        System.out.println("Mas miléneos atrás, Glozium me tornou seu escravo, Sou obrigado a lutar com toda a minha fúria...");
	        System.out.println("Livre-me do sofrimento...");
	      dialogo(1500);
	        System.out.println("\n\u001B[1mSandubinha:\u001B[0m - Você também está preso a um destino que não escolheu, Vou te libertar!");
	      dialogo(1500);
	        System.out.println("\n\u001B[1mAto de Batalha:\u001B[0m Dragão da Transmissão - Vida: 12 | Números sorteados para dano: 3");
	      dialogo(1500);
	        System.out.println("\nEnquanto estiver no ar, o monstro não pode ser atacado pela espada...");
	        System.out.println("Use o estilingue antes de cada ataque!");
	      dialogo(1500);
	    }

	    public void torreContasAReceber() {

	        System.out.println("A terrível torre é onde seres mágicos recebem o pagamento por seu árduo trabalho.");
	      dialogo(1500);
	        System.out.println("Dizem que a ruína perto da torre era a cidade mais próxima do \"grito\",");
	      dialogo(1500);
	        System.out.println("terra natal dos \u001B[1mAnalyticsaes di Glosium\u001B[0m.");
	        System.out.println();
	      dialogo(3000);
;
	        System.out.println("Sandubinha chega ao primeiro andar da torre. Ele sente uma energia mágica mortífera vindo do topo.");
	      dialogo(3000);
	        System.out.println("Sem dúvidas, Glosium estava lá...");
	      dialogo(1500);
	        System.out.println("A parede se abre e sai dela o penúltimo monstro a ser enfrentado.");
	      dialogo(3000);
	        System.out.println("\u001B[3mSandubinha - Uma estátua na forma do último herói, por quê?\u001B[0m");
	      dialogo(3000);
	        System.out.println();

	        System.out.println("A batalha violenta ocorre...");
	        System.out.println();

	    }

	    
	    public void batalhaContraGlozium() {
	        System.out.println(" ".repeat(45) + "\u001B[1mBatalha contra Glozium (final)\u001B[0m");

	        System.out.println("Sandubinha sente que no topo da Torre de Contas a Receber reside Glozium,");
	      dialogo(1500);
	        System.out.println("uma entidade maligna e mestre dos \u001B[1mAnalyticsaes di Glosium\u001B[0m.");
	      dialogo(1500);
	        System.out.println("Para evitar os andares, Sandubinha escala por fora e entra por uma janela do topo...");
	      dialogo(1500);
	        System.out.println();

	        System.out.println("Sandubinha entra na sala do chefe e se depara com Glozium sentado no trono...");
	      dialogo(1500);
	        System.out.println("Uma presença arrepiante domina o ambiente.");
	      dialogo(1500);

	        System.out.println();}
	        
	        public void dialogoGlozium() {
	        System.out.println("\u001B[1mGlozium:\u001B[0m - Um rato invadiu meu recinto; talvez sirva de alimento para meus escravos");
	      dialogo(3000);
	        System.out.println("\u001B[1mSandubinha:\u001B[0m - Então você é Glozium? Não é mais aterrorizante que as criaturas apodrecidas que encontrei");
	      dialogo(3000);
	        System.out.println("\u001B[1mGlozium:\u001B[0m - ha ha ha ha! que petulante");
	      dialogo(2000);
	        System.out.println("\u001B[1mGlozium:\u001B[0m - Chegou a época, mas mandaram um pobre coitado; péssima ideia");
	        dialogo(3000);
	        System.out.println("\u001B[1mSandubinha:\u001B[0m - Vou te destruir, Glozium, e garantir sua aniquilação total e permanente");
	        dialogo(3000);
	        System.out.println("\u001B[1mGlozium:\u001B[0m - E o que um garoto com cabeça de hambúrguer pode fazer contra um monstro milenar?");
	        dialogo(3000);
	        System.out.println("  Que presenciou eventos tão singulares, que caminhou sobre vulcões e subjugou a humanidade?");
	        dialogo(3000);
	        System.out.println();

	        System.out.println("Sandubinha lança sua espada girando no ar que retorna à sua mão.");
	         dialogo(2000);
	        System.out.println("\u001B[1mSandubinha:\u001B[0m - Não subestime alguém com cabeça de hambúrguer.");
	         dialogo(2000);
	        System.out.println("Sou descendente dos Analyticsaes di Glosium. Te procurei por todos os cantos do inferno para te reduzir a Zero.");
	         dialogo(2000);
	        System.out.println("\u001B[1mGlozium:\u001B[0m - Interessante, aceito seu pedido de batalha.");
	         dialogo(2000);
	        System.out.println();

	    }

	    public void resultadoFinalBatalhaGlozium(boolean usouEspadaZG, boolean venceu) {
	        if (venceu) {
	            System.out.println("\u001B[1m VITÓRIA:\u001B[0m");

	            if (usouEspadaZG) {
	                System.out.println("\u001B[1mSandubinha:\u001B[0m - Finalmente, Glozium está eliminado por completo, irei retornar à minha família");
	                 dialogo(3000);
	                System.out.println("\u001B[1mTexto:\u001B[0m O herói derrotou Glozium, o mundo agora poderá voltar a seus tempos de alegria.");
	                dialogo(3000);
	                System.out.println("Muito obrigado, herói!");
	                 dialogo(1000);
	                System.out.println("\u001B[1mTexto:\u001B[0m Fim de jogo!");
	            } else {
	                System.out.println("\u001B[1mGlozium:\u001B[0m - Você me derrotou com armas tão simples, impressionante, mas irei retornar no ano seguinte");
	                 dialogo(3000);
	                System.out.println("\u001B[1mSandubinha:\u001B[0m - ...retornarei envergonhado para minha família, mas ao menos serei feliz");
	                  dialogo(3000);
	                System.out.println("\u001B[1mTexto:\u001B[0m Sandubinha começa a se enrijecer como pedra...");
	                dialogo(3000);
	                System.out.println("\u001B[1mGlozium:\u001B[0m - Você me derrotou, mas suguei sua energia vital. Você se tornará minha estátua na entrada da torre!");
	                 dialogo(3000);
	                System.out.println("\u001B[1mSandubinha:\u001B[0m - maldito!... Eu... nunc... ir...");
	                 dialogo(3000);
	                System.out.println("\u001B[1mTexto:\u001B[0m O herói derrotou Glozium ao custo de sua alma. O mundo seguirá normalmente por mais 1 ano...");
	                dialogo(3000);
	                System.out.println("Fim de Jogo!");
	            }

	        } else {
	            System.out.println("\u001B[1mGlozium:\u001B[0m - Finalmente! Um herói bosta que apenas aumentou meus poderes!");
	            dialogo(2000);
	            System.out.println("\u001B[1mTexto:\u001B[0m O mundo foi destruído por Glosium, uma fatalidade terrível...");
	            dialogo(2000);
	            System.out.println("Fim de jogo!");
	        }
	    }


	    
	    
	    
	    
	    
	    public boolean jogarNovamente(Scanner scan) {
	        System.out.println("Deseja Jogar Novamente?");
	        System.out.println("1 - SIM");
	        System.out.println("2 - NÃO");
	        int resposta = scan.nextInt();
	        return resposta == 1;
	    }
	    
	    public boolean jogarEscolher(int x) {
	        int resposta = x;
	        return resposta == x;
	    }
	    
	    
	  //metodo para os dialogos terem uma pausa
	    public void dialogo(int x) {
	    	 try {
			        Thread.sleep(x);  
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
	    }
	    
	    
	   
}
 