package rpg;

public class ResultadoUso {
    public int dano;
    public int vidaPerdida;
    public boolean inimigoAtordoado;

    public ResultadoUso(int dano, int vidaPerdida, boolean inimigoAtordoado) {
        this.dano = dano;
        this.vidaPerdida = vidaPerdida;
        this.inimigoAtordoado = inimigoAtordoado;
        
    }
    public int getDano() {
    	return dano; }
    
    public int getVidaPerdida() { 
    	return vidaPerdida; }
    
    public boolean isInimigoAtordoado() { 
    	return inimigoAtordoado; }
    
   



}
    




