
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class PosicionesEquipo {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
        String Equipos;
        int N_Equipos;
        int PartidoGanado = 0, PartidoPerdido = 0, Empate = 0, PuntosGanados = 0, PuntosEmpatados = 0, FechaJugada = 0;
        
        System.out.println("Ingrese la cantidad de equipos para el torneo clausura de la liga nacional de Guatemala : ");
        N_Equipos=sc.nextInt();
        String[] Equipo = new String[N_Equipos];
        String TablaPosicion[][] = new String[N_Equipos][5];
      
        for(int i =0; i<N_Equipos; i++){
            
            System.out.println("Ingrese nombre del equipo: "+ i);
            Equipos = sc.next();
            Equipo[i]=Equipos;
        }
        System.out.println("Ingrese las fechas jugadas del equipo: ");
        FechaJugada = sc.nextInt();
        
        for (int i =0; i<N_Equipos; i++){
            for(int j =0; j<FechaJugada; j++){
                System.out.println("Equipo "+ Equipo[i]);
                System.out.println("Fecha "+ (i + j));
                System.out.println("Escriba el resultado del partido(1 PartidoGanado, 2 PartidoPerdido, 3 Partido Empatado)");
                int resultado = sc.nextInt();
                
                switch (resultado){
                    case 1:
                       PartidoGanado = PartidoGanado +1;
                       PuntosGanados = PuntosGanados +3;
                       break;
                    case 2:
                       PartidoPerdido = PartidoPerdido +1;
                       break;
                    case 3:
                       Empate = Empate +1;
                       PuntosEmpatados = PuntosEmpatados +1;
                       break;
                }
            }
            
            TablaPosicion[i][0] = Equipo[i]; 
            TablaPosicion[i][1] = Integer.toString(PartidoGanado); 
            TablaPosicion[i][2] = Integer.toString(PartidoPerdido); 
            TablaPosicion[i][3] = Integer.toString(Empate); 
            TablaPosicion[i][4] = Integer.toString(PuntosGanados + PuntosEmpatados); 
            PartidoGanado = 0;
            PartidoPerdido = 0;
            Empate = 0;
            PuntosGanados = 0;
            PuntosEmpatados = 0;
        }
        
        for(int i =0; i<N_Equipos; i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<N_Equipos; k++){
                    for(int l=0; l<N_Equipos; l++){
                        if(Integer.parseInt(TablaPosicion[i][4]) > Integer.parseInt(TablaPosicion[k][4])){
                        
                        String pos = TablaPosicion[i][0];
                        TablaPosicion[i][0] = TablaPosicion[k][0];
                        TablaPosicion[k][0] = pos;
                        
                        pos = TablaPosicion[i][1];
                        TablaPosicion[i][1] = TablaPosicion[k][1];
                        TablaPosicion[k][1] = pos;
                        
                        pos = TablaPosicion[i][2];
                        TablaPosicion[i][2] = TablaPosicion[k][2];
                        TablaPosicion[k][2] = pos;
                        
                        pos = TablaPosicion[i][3];
                        TablaPosicion[i][3] = TablaPosicion[k][3];
                        TablaPosicion[k][3] = pos;
                        
                        pos = TablaPosicion[i][4];
                        TablaPosicion[i][4] = TablaPosicion[k][4];
                        TablaPosicion[k][4] = pos;
                    }
                    }
                }
            }
            
        }
        System.out.println("Ingrese la opción a visualizar");
        System.out.println("1. Presentar el registro de resultados de un equipo");
        System.out.println("2. Mostrar la tabla de posiciones clausura 2022");
        System.out.println("Por favor eliga una opción para continuar... ");
        int op = sc.nextInt();
        switch (op){
            case 1: 
                System.out.println("Ingrese el nombre del equipo para visualizar su historial");
                String EquipoActual = sc.next();
                
                for (int i =0; i< N_Equipos; i++){
                    for(int j=0; j<5; j++){
                        if(EquipoActual.equals(Equipo[i])){
                            System.out.printf("EQ\tG\tP\tE\tTP");
                            System.out.printf("%s\t", TablaPosicion[i][j]);
                        }
                    }
                }
                break;
                
            case 2:
                System.out.println("EQ\tG\tP\tE\tTP");
                 for (int i =0; i< N_Equipos; i++){
                    for(int j=0; j<5; j++){
                        System.out.printf("%s\t", TablaPosicion[i][j]);
                        }
                    System.out.printf("\n");
                    }
                 break;
        }
        
    } 
    
    
}
    