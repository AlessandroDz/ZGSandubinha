package rpg;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class MecanicaBatalha extends Personagem {
	
	private int numeroDados;
	private int numeroSecretoHeroi;
	private int numeroSecretoVilao;
	private int errosEstilingue = 0;
	Historia conto = new Historia();

	public MecanicaBatalha(String nome, String espécie, int vida, Item equipamento, int numeroDados, int dano,
			int numeroSecretoHeroi, int numeroSecretoVilao) {
		super(nome, espécie, vida, equipamento);
		this.numeroDados = numeroDados;
		this.numeroSecretoHeroi = numeroSecretoHeroi;
		this.numeroSecretoVilao = numeroSecretoVilao;
	}


	public MecanicaBatalha() {}


	public int getSortearDados() {
		return numeroDados;
	}
	
	public void setSortearDados(int sortearDados) {
		this.numeroDados = sortearDados;
	}	
	
	public int getNumeroSecretoHeroi() {
		return numeroSecretoHeroi;
	}


	public void setNumeroSecretoHeroi(int numeroSecretoHeroi) {
		this.numeroSecretoHeroi = numeroSecretoHeroi;
	}


	public int getNumeroSecretoVilao() {
		return numeroSecretoVilao;
	}


	public void setNumeroSecretoVilao(int numeroSecretoVilao) {
		this.numeroSecretoVilao = numeroSecretoVilao;
	}


	 //Sorteia um numero aleatório entre 1 e a vida máxima fornecida
	public int sortearDado(int vidaMaxima) {
	    Random random = new Random();
	    return random.nextInt(vidaMaxima) + 1;  // Sorteia de 1 até vidaMaxima
	}

	//Rola uma quantidade de dados, retorna e imprime os valores sorteados
	public List<Integer> jogarDados(int quantidade, int vidaMaxima) {
	    List<Integer> resultados = new ArrayList<>();
	    System.out.print("Dados rolados: ");
	    for (int i = 0; i < quantidade; i++) {
	        int resultado = sortearDado(vidaMaxima);
	        resultados.add(resultado);
	        System.out.print(resultado + " ");
	    }
	    System.out.println();
	    return resultados;
	}

	
	public void aplicarDano(Personagem alvo, int dano) {
	        int vidaAtual = alvo.getVida();
	        int novaVida = Math.max(0, vidaAtual - dano); //  evitar vida negativa
	        alvo.setVida(novaVida);
	        System.out.println(alvo.getNome() + " recebeu " + dano + " de dano! Vida restante: " + novaVida);
	    }
	
	public boolean verificarItem(ArrayList<String> lista, String itemBuscado) {
	    return lista.contains(itemBuscado);
	}
	
	

	public boolean Batalha(Personagem heroi, Personagem vilao, int qtdDados) {
	    Scanner scan = new Scanner(System.in);
	    int batalhar;
	    int rodada = 0;
	    int errosEstilingue = 0;
	    Random random = new Random();
	    boolean usouEspadaZG = false; // variável para rastrear o uso da espada

	    while (heroi.getVida() > 0 && vilao.getVida() > 0) {
	        System.out.println("\n1 - Jogar os dados ");
	        System.out.println("2 - Escolher Item ");
	        System.out.println("3 - Desistir da missão ");
	        System.out.println("4 - Escolher Fase ");
	        System.out.println("5 - Lutar contra Gozium");
	        System.out.print("Escolha: ");

	        int numSecretoHeroi = random.nextInt(heroi.getVida()) + 1;
	        int numSecretoVilao = random.nextInt(vilao.getVida()) + 1;
	        setNumeroSecretoHeroi(numSecretoHeroi);
	        setNumeroSecretoVilao(numSecretoVilao);

	        if (scan.hasNextInt()) {
	            batalhar = scan.nextInt();

	            if (batalhar == 1) {
	                System.out.println("\nNúmero Secreto do Herói: " + numSecretoHeroi);
	                System.out.println("Número Secreto do Vilão: " + numSecretoVilao);

	                // Turno do herói
	                System.out.println("\n--- Turno do Herói ---");
	                List<Integer> dadosHeroi = jogarDados(qtdDados, vilao.getVida());
	                int danoHeroi = 0;
	                for (int num : dadosHeroi) {
	                    if (num == getNumeroSecretoVilao()) {
	                        danoHeroi += getNumeroSecretoVilao();
	                    }
	                }
	                if (danoHeroi > 0) {
	                    aplicarDano(vilao, danoHeroi);
	                } else {
	                    System.out.println("O herói não causou dano.");
	                }

	                if (vilao.getVida() <= 0) break;

	                // Turno do vilão
	                System.out.println("\n--- Turno do Vilão ---");
	                List<Integer> dadosVilao = jogarDados(qtdDados, vilao.getVida());
	                int danoVilao = 0;
	                for (int num : dadosVilao) {
	                    if (num == getNumeroSecretoHeroi()) {
	                        danoVilao += getNumeroSecretoHeroi();
	                    }
	                }
	                if (danoVilao > 0) {
	                    aplicarDano(heroi, danoVilao);
	                } else {
	                    System.out.println("O vilão não causou dano.");
	                }

	                rodada++;

	            } else if (batalhar == 2) {
	                if (heroi.getEquipamento() == null || heroi.getEquipamento().listarItens().isEmpty()) {
	                    System.out.println("Você não tem nenhum item no momento.");
	                    continue;
	                }

	                // Verifica se a Espada ZG foi usada
	                usouEspadaZG = usarItem(heroi, vilao, scan, errosEstilingue) || usouEspadaZG;

	            } else if (batalhar == 3) {
	                conto.jogarEscolher(1);

	            } else if (batalhar == 4) {
	                escolherFase(scan, heroi, vilao);
	                return usouEspadaZG;

	            } else if (batalhar == 5) {
	                lutarContraGlozium(scan, heroi, vilao);
	                return usouEspadaZG;

	            } else {
	                System.out.println("Opção inválida. Escolha 1 a 5.");
	            }

	        } else {
	            System.out.println("Entrada inválida. Digite um número.");
	            scan.next();
	        }
	    }

	    return usouEspadaZG; // Retorna se a espada foi usada durante a batalha
	}

	
	
	public boolean usarItem(Personagem heroi, Personagem vilao, Scanner scan, int errosEstilingueAtual) {
	    if (heroi.getEquipamento() == null || heroi.getEquipamento().listarItens().isEmpty()) {
	        System.out.println("Você não tem nenhum item no momento.");
	        return false;
	    }

	    List<String> itens = heroi.getEquipamento().listarItens();

	    System.out.println("Itens disponíveis:");
	    for (int i = 0; i < itens.size(); i++) {
	        System.out.println((i + 1) + " - " + itens.get(i));
	    }

	    System.out.print("Escolha um item pelo número: ");
	    int escolha = -1;

	    if (scan.hasNextInt()) {
	        escolha = scan.nextInt();
	        if (escolha >= 1 && escolha <= itens.size()) {
	            String itemEscolhido = itens.get(escolha - 1);
	            System.out.println("Você escolheu: " + itemEscolhido);

	            ResultadoUso resultado = null;
	            
	         // Executa o efeito do item escolhido
	            switch (itemEscolhido.toLowerCase()) {
	                case "guia de atendimento":
	                    resultado = Item.usarGuiaDeAtendimento(getNumeroSecretoVilao(), vilao.getVida());
	                    aplicarDano(vilao, resultado.getDano());
	                    break;

	                case "faturamentus":
	                    resultado = Item.usarFaturamentus(getNumeroSecretoVilao(), vilao.getVida());
	                    aplicarDano(vilao, resultado.getDano());
	                    if (resultado.getVidaPerdida() == -2) {
	                        System.out.println("O vilão causará +2 de dano no próximo turno!");
	                    }
	                    break;

	                case "estilingue mágico":
	                    resultado = Item.usarEstilingueMagico(getNumeroSecretoVilao(), vilao.getVida(), errosEstilingueAtual);
	                    if (resultado.isInimigoAtordoado()) {
	                        System.out.println("O vilão foi atordoado e perderá a rodada.");
	                        return false; // pula turno do vilão
	                    } else {
	                        errosEstilingueAtual++;
	                        if (resultado.getVidaPerdida() > 0) {
	                            heroi.setVida(heroi.getVida() - 1);
	                            System.out.println("Você perdeu 1 de vida. Vida atual: " + heroi.getVida());
	                        }
	                    }
	                    break;

	                case "azah transmissao":
	                    resultado = Item.usarAzahTransmissao(getNumeroSecretoVilao(), vilao.getVida(), heroi.getVida());
	                    aplicarDano(vilao, resultado.getDano());
	                    if (resultado.getVidaPerdida() > 0) {
	                        heroi.setVida(heroi.getVida() - resultado.getVidaPerdida());
	                        System.out.println("Você recebeu " + resultado.getVidaPerdida() + " de dano. Vida atual: " + heroi.getVida());
	                    }
	                    break;

	                case "colar da estatua sagrada":
	                    resultado = Item.usarColarEstatuaSagrada(getNumeroSecretoVilao(), vilao.getVida());
	                    aplicarDano(vilao, resultado.getDano());
	                    heroi.setVida(heroi.getVida() - resultado.getVidaPerdida());
	                    System.out.println("Você perdeu 3 de vida por usar o colar. Vida atual: " + heroi.getVida());
	                    break;

	                case "Espada ZG":
	                    resultado = Item.usarEspadaZG(getNumeroSecretoVilao(), vilao.getVida());
	                    aplicarDano(vilao, resultado.getDano());
	                    return true ; // espada ZG foi usada

	                default:
	                    System.out.println("Item não reconhecido.");
	                    break;
	            }

	        } else {
	            System.out.println("Número inválido. Escolha entre 1 e " + itens.size());
	        }
	    } else {
	        System.out.println("Entrada inválida. Digite um número.");
	        scan.next(); 
	    }

	    return false; //nenhum item relevante como a espada ZG foi usado
	}

	

	public void escolherFase(Scanner scan, Personagem heroi, Personagem vilao) {
	    System.out.println("Escolha uma fase:");
	    System.out.println("1 - Monstrengo");
	    System.out.println("2 - UrsoSangrento");
	    System.out.println("3 - Dragão da Transmissão");

	    int fase = scan.nextInt();
	    int voar =1;

	    switch (fase) {
	  //inicio da fase 1 Floresta de Atendimentus
	        case 1:
	        	conto.florestaAtendimentus();
	            vilao.setNome("Monstrengo");
	            vilao.setEspécie("Monstro");
	            vilao.setVida(3);
	            heroi.setVida(5);
	            heroi.setEquipamento(new Item());
	            Batalha(heroi, vilao, 1);

	            if (vilao.getVida() == 0) {
	                System.out.println("Fim da batalha \u001B[1mVITÓRIA\u001B[0m de Sandubinha\n");
	                System.out.println("Processus Ministerii - Muito Obrigado, tome o Artefato (Guia de Atendimento) e vá para o proximo desafio\n ");
	                heroi.adicionaItem("Guia de Atendimento");
	                heroi.setEquipamento(heroi);
	                heroi.resetarVida(5);
	                heroi.vidaBonus();
	                heroi.mostrarItem();
	            } else if (heroi.getVida() == 0) {
	                System.out.println("Fim da batalha \u001B[1mDERROTA\u001B[0m de Sandubinha\n");
	                System.out.println("Processus Ministerii - Oh ,não o mundo séra mais uma vez detruido por Glozium");
	                System.out.println("O mundo foi destruido por Glozium, uma fatalidade terrivel... FIM DE JOGO");
	                if (conto.jogarNovamente(scan)) {
	                    escolherFase(scan, heroi, vilao);
	                } else {
	                    System.out.println("Jogo Encerrado");
	                    return;
	                }
	            }
	            break;

	        case 2:// Início da fase 2 Cavernas de Faturamentus
	        	conto.cavernasFaturamentus();
	            heroi.resetarVida(5);
	            heroi.vidaBonus();
	            vilao.setNome("UrsoSangrento");
	            vilao.setEspécie("Monstro");
	            vilao.setVida(6);
	            Batalha(heroi, vilao, 2);
	            if(vilao.getVida()==0) {
	                System.out.println("Fim da batalha \u001B[1mVITÓRIA\u001B[0m de Sandubinha\n");
	                //timeout.dialogo(3000);
	            	System.out.println("Ansião faturador - muito obrigado, mas tô ocupado demais para agradecimentos longos, tome o artefato sagrado e siga em frente.\n ");
	            	System.out.println("Sandubinha ganha o artefato Faturamentus");
	            	heroi.adicionaItem("Faturamentus");
	            	heroi.setEquipamento(heroi);
	            	heroi.resetarVida(7);//7
	            	heroi.vidaBonus();
	            	heroi.mostrarItem();
	            	heroi.adicionaItem("Estilingue Mágico");
	                heroi.setEquipamento(heroi);
	            	
	            }
	            
	            else if(heroi.getVida() == 0 ){
	            	System.out.println("Fim da batalha \u001B[1mDERROTA\u001B[0m de Sandubinha\n");
	            	System.out.println("Ansião faturador - herói merda, nem para cumprir o trabalho dele, estamos perdidos");
	            	//timeout.dialogo(3000);
	            	System.out.println("O mundo foi destruido por Glozium, uma fatalidade terrivel... FIM DE JOGO");
	            	if (conto.jogarNovamente(scan)) {
	            		escolherFase(scan, heroi, vilao);
	            	} else {
	            		System.out.println("Jogo Encerrado");
	            	    return;
	            	}
	            	
	              }
	            break;

	        case 3:// inicio da fase 3 Vila da Transmissão
	        	conto.vilaTransmissao();
	            heroi.resetarVida(7);
	            heroi.vidaBonus();
	            vilao.setNome("Dragão da Transmissão");
	            vilao.setEspécie("Dragão");
	            vilao.setVida(12);
	            Batalha(heroi, vilao, 3);
	            if(vilao.getVida()==0) {
	                System.out.println("Fim da batalha \u001B[1mVITÓRIA\u001B[0m de Sandubinha\n");
	                //timeout.dialogo(3000);
	                System.out.println("\u001B[1mDragão:\u001B[0m - Muito obrigado, todo herói evitava essa batalha e seguia direto para a torre. Agora sou livre!");
	    	        System.out.println("\u001B[1mSandubinha:\u001B[0m - Evitava? E dá pra seguir sem lutar? Como assim?");
	    	        System.out.println("Sandubinha ganha o artefato \u001B[1mAzah Transmissão\u001B[0m!");
	            	heroi.adicionaItem("Azah Transmissão");
	            	heroi.setEquipamento(heroi);
	            	heroi.resetarVida(9);//9
	            	heroi.vidaBonus();
	            	heroi.mostrarItem();
	            	
	            }
	            
	            else if(heroi.getVida() == 0 ){
	            	System.out.println("\u001B[1mDragão:\u001B[0m - Sinto muito herói, que sua alma seja livre...");
	            	//timeout.dialogo(3000);
	    	        System.out.println("\nTexto final: O mundo foi destruído por Glozium... Uma fatalidade terrível... Fim de jogo!");
	    	        if (conto.jogarNovamente(scan)) {
	    	        	escolherFase(scan, heroi, vilao);
	            	} else {
	            		System.out.println("Jogo Encerrado");
	            	    return;
	            	}
	            	
	              }
	            System.out.println("\nDeseja usar a Azah Transmissão para ir Voando até A Torre Contas A receber");
	            conto.dialogo(2500);
	            System.out.println("O caminho e muito longo ate a torre voce sofrera 3 de dano se for andando");
	            conto.dialogo(2500);
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
	            	conto.resultadoFinalBatalhaGlozium(true,true);
	            	lutarContraGlozium(scan,heroi,vilao);
	            }
	            break;

	        default:
	            System.out.println("Fase inválida.");
	            return;
	    }

	    System.out.println("Lutando contra: " + vilao.getNome());
	}

	public void lutarContraGlozium(Scanner scan, Personagem heroi, Personagem vilao) {
	    heroi.resetarVida(9);
	    heroi.vidaBonus();
	    vilao.setNome("Glozium");
	    vilao.setEspécie("Mago Monstro");
	    vilao.setVida(100);

	    System.out.println(vilao);

	    System.out.println("Deseja escutar Glozium?");
	    System.out.println("1 - SIM");
	    System.out.println("2 - NÃO");
	    int pular = scan.nextInt();
	    if (pular == 1) {
	        Historia conto = new Historia();
	        conto.dialogoGlozium();
	    }
	    Batalha(heroi, vilao, 10);
	    
	    if (vilao.getVida() == 0) {
	        System.out.println("Fim da batalha \u001B[1mVITÓRIA\u001B[0m de Sandubinha\n");

	        boolean usouEspadaZG = heroi.getEquipamento().listarItens().stream()
	                .anyMatch(item -> item.equalsIgnoreCase("Espada ZG"));

	        if (usouEspadaZG) {
	            System.out.println("\u001B[1mSandubinha:\u001B[0m Finalmente, Glozium está eliminado por completo, irei retornar à minha família.");
	            System.out.println("Texto: O herói derrotou Glozium, o mundo agora poderá voltar a seus tempos de alegria. Muito obrigado, herói!");
	            System.out.println("Texto: Fim de jogo!");
	        } else {
	            System.out.println("\u001B[1mGlozium:\u001B[0m você me derrotou com armas tão simples, impressionante, mas irei retornar no ano seguinte.");
	            System.out.println("\u001B[1mSandubinha:\u001B[0m ...retornarei envergonhado para minha família, mas ao menos serei feliz");
	            System.out.println("Texto: Sandubinha começa a se enrijecer como pedra...");
	            System.out.println("\u001B[1mGlozium:\u001B[0m você me derrotou, mas suguei sua energia vital, você irá se transformar em minha estátua da entrada da torre hahaha");
	            System.out.println("\u001B[1mSandubinha:\u001B[0m maldito!... Eu... nunc... ir... [virou pedra]");
	            System.out.println("Texto: O herói derrotou Glozium ao custo de sua alma, o mundo seguirá normalmente por mais 1 ano... Fim de Jogo!");
	        }

	        if (conto.jogarNovamente(scan)) {
	        	escolherFase(scan, heroi, vilao);
	        } else {
	            System.out.println("Jogo Encerrado");
	            return;
	        }

	    } else if (heroi.getVida() == 0) {
	        System.out.println("\u001B[1mGlozium:\u001B[0m Finalmente! um herói bosta que apenas aumentou meus poderes.");
	        System.out.println("Texto: O mundo foi destruído por Glozium, uma fatalidade terrível... Fim de jogo!");

	        if (conto.jogarNovamente(scan)) {
	        	escolherFase(scan, heroi, vilao);
	        } else {
	            System.out.println("Jogo Encerrado");
	            return;
	        }
	    }

	    
	}
	
}
	

