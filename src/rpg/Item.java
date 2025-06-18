package rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Item {
    
    // Lista de nomes dos itens equipados
    private ArrayList<String> equipar = new ArrayList<>();


    //  Retorna a lista de itens equipados
    public ArrayList<String> getEquipar() {
        return equipar;
    }

    // Substitui a lista inteira de itens equipados
    public void setEquipar(ArrayList<String> equipar) {
        this.equipar = equipar;
    }

  
    public void adicionaItem(String item) {
        this.equipar.add(item);
    }


    // Exibe todos os itens atualmente equipados
    public void mostrarItem() {
        if (equipar == null || equipar.isEmpty()) {
            System.out.println("Nenhum item equipado.");
        } else {
            System.out.println("Itens equipados:");
            for (int i = 0; i < equipar.size(); i++) {
                System.out.println("- " + equipar.get(i));
            }
        }
    }

    // Retorna uma cópia da lista de itens equipados
    public ArrayList<String> listarItens() {
        return new ArrayList<>(equipar);
    }
    

    // Usa o item Guia de Atendimento 2 sorteios, cada acerto causa 1 de dano
    public static ResultadoUso usarGuiaDeAtendimento(int numeroSecreto, int vidaMaximaMonstro) {
        Random random = new Random();
        int dano = 0;
        System.out.println("Usando o Guia de Atendimento. Sorteando 2 números...");
        for (int i = 0; i < 2; i++) {
            int sorteado = random.nextInt(vidaMaximaMonstro) + 1;
            System.out.print(sorteado + " ");
            if (sorteado == numeroSecreto) dano++;
        }
        System.out.println("\nDano total causado: " + dano);
        return new ResultadoUso(dano, 0, false);
    }

    // Usa o item Faturamentus 4 sorteios
    public static ResultadoUso usarFaturamentus(int numeroSecreto, int vidaMaximaMonstro) {
        Random random = new Random();
        int dano = 0;
        boolean acertou = false;
        System.out.println("Usando o Faturamentus. Sorteando 4 números...");
        for (int i = 0; i < 4; i++) {
            int sorteado = random.nextInt(vidaMaximaMonstro) + 1;
            System.out.print(sorteado + " ");
            if (sorteado == numeroSecreto) {
                dano++;
                acertou = true;
            }
        }
        System.out.println();
        if (!acertou) {
            System.out.println("Você errou todos! O próximo ataque do vilão causará +2 de dano.");
        }
        System.out.println("Dano total causado: " + dano);
        return new ResultadoUso(dano, acertou ? 0 : -2, false);
    }

    // Estilingue Mágico várias tentativas, se acertar atordoa o inimigo
    public static ResultadoUso usarEstilingueMagico(int numeroSecreto, int vidaMaximaMonstro, int errosConsecutivos) {
        Random random = new Random();
        int tentativas = vidaMaximaMonstro / 2 + 5;
        boolean atordoou = false;

        System.out.println("Usando Estilingue Mágico. Tentando acertar entre " + tentativas + " tentativas...");
        for (int i = 0; i < tentativas; i++) {
            int sorteado = random.nextInt(vidaMaximaMonstro) + 1;
            System.out.print(sorteado + " ");
            if (sorteado == numeroSecreto) {
                atordoou = true;
                break;
            }
        }
        System.out.println();

        if (atordoou) {
            System.out.println("Você acertou! O vilão ficará atordoado e perderá a rodada.");
            return new ResultadoUso(0, 0, true);
        } else {
            int vidaPerdida = (errosConsecutivos + 1 >= 3) ? 1 : 0;
            if (vidaPerdida > 0) {
                System.out.println("Você errou pela terceira vez. Perdeu 1 de vida.");
            } else {
                System.out.println("Você errou. Ainda pode tentar mais vezes sem penalidade.");
            }
            return new ResultadoUso(0, vidaPerdida, false);
        }
    }

    //  Azah Transmissão 10 sorteios. Se não acertar, dano futuro calculado com base em último número sorteado
    public static ResultadoUso usarAzahTransmissao(int numeroSecreto, int vidaMaximaMonstro, int vidaAtual) {
        Random random = new Random();
        int[] sorteios = new int[10];
        int dano = 0;

        System.out.println("Usando Azah Transmissão. Sorteando 10 números...");
        for (int i = 0; i < 10; i++) {
            sorteios[i] = random.nextInt(vidaMaximaMonstro) + 1;
            System.out.print(sorteios[i] + " ");
            if (sorteios[i] == numeroSecreto) {
                dano++;
            }
        }
        System.out.println();

        if (dano == 0) {
            int ultimo = sorteios[9];
            int danoExtra = vidaAtual - ultimo;
            System.out.println("Nenhum acerto! Na próxima rodada, você receberá dano = vidaAtual - " + ultimo + " = " + danoExtra);
            return new ResultadoUso(0, danoExtra, false);
        } else {
            System.out.println("Dano total causado: " + dano);
            return new ResultadoUso(dano, 0, false);
        }
    }

    // Colar da Estátua Sagrada 10 sorteios, sempre perde 3 de vida
    public static ResultadoUso usarColarEstatuaSagrada(int numeroSecreto, int vidaMaximaMonstro) {
        Random random = new Random();
        int dano = 0;
        System.out.println("Usando o Colar da Estátua Sagrada. Sorteando 10 números...");
        for (int i = 0; i < 10; i++) {
            int sorteado = random.nextInt(vidaMaximaMonstro) + 1;
            System.out.print(sorteado + " ");
            if (sorteado == numeroSecreto) {
                dano++;
            }
        }
        System.out.println("\nDano total causado: " + dano + ". Custo: -3 de vida.");
        return new ResultadoUso(dano, 3, false);
    }

    // Espada ZG sorteia 40 vezes, cada acerto multiplica o dano
    public static ResultadoUso usarEspadaZG(int numeroSecreto, int vidaMaximaMonstro) {
        Random random = new Random();
        int vezes = 0;

        System.out.println("Usando a Espada ZG. Sorteando 40 números...");
        for (int i = 0; i < 40; i++) {
            int sorteado = random.nextInt(vidaMaximaMonstro) + 1;
            System.out.print(sorteado + " ");
            if (sorteado == numeroSecreto) {
                vezes++;
            }
        }
        int dano = vezes * numeroSecreto;
        System.out.println("\nDano total causado: " + vezes + " x " + numeroSecreto + " = " + dano);
        return new ResultadoUso(dano, 0, false);
    }
    
    public boolean podeForjarEspadaZG(Personagem heroi) {
        List<String> itensNecessarios = List.of(
            "Guia de Atendimento",
            "Faturamentus",
            "Estilingue Mágico",
            "Azah Transmissão",
            "Colar da estátua sagrada"
        );

        if (heroi.getEquipamento() == null) return false;

        List<String> itensDoHeroi = heroi.getEquipamento().listarItens();

        for (String item : itensNecessarios) {
            if (!itensDoHeroi.contains(item)) {
                return false;
            }
        }

        return true;
    }
}
