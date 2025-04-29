package Modelo;

import Controlador.*;
import Modelo.*;
import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> tablero;
    public int turno;

    public Tablero() {
        this.tablero = new ArrayList<>();
        this.GenerarTablero();
        this.turno = 0;
    }

    public ArrayList<Casilla> getTablero() { return tablero; }

    @Override
    public String toString() {
        return "Casillas del tablero: " + tablero.size();
    }

    public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public void GenerarTablero() {
        for (int i = 1; i <= 50; i++) {
            Casilla.asignarCasillas(i, tablero);
        }
    }
	
	//Método para gestionar las casillas especiales
    public void OrigenTablero(ArrayList<Pinguino> ListaPinguinos) {
        Pinguino pingu = ListaPinguinos.get(turno);
        int posic = pingu.getPosicion();
        Casilla casillaAct = tablero.get(posic);
        int idTipo = casillaAct.getIDTipoCasilla();

        Eventos eventos = new Eventos(0, 0, 0, 0, 0); // para sobornar si hace falta
        boolean soborno = false;

        switch (idTipo) {
            case 1: //Oso
                soborno = eventos.sobornarOso(pingu);
                if (!soborno) {
                    pingu.setPosicion(0);
                }
                break;
            case 2: //Agujero
                int agujAnt = 0;
                boolean encontradoA = false;
                for (int i = posic - 1; i >= 0 && !encontradoA; i--) {
                    if (tablero.get(i).getIDTipoCasilla() == 2) {
                        encontradoA = true;
                        agujAnt = i;
                    }
                }
                if (encontradoA) {
                    System.out.println(pingu.getNombre() + " cayó en un agujero y retrocedió a la casilla " + agujAnt);
                    pingu.setPosicion(agujAnt);
                } else {
                    System.out.println(pingu.getNombre() + " cayó en un agujero sin salida, vuelve al inicio");
                    pingu.setPosicion(0);
                }
                break;
            case 3: //Trineo
                int trinPos = 0;
                boolean encontradoT = false;
                for (int i = posic + 1; i < tablero.size() && !encontradoT; i++) {
                    if (tablero.get(i).getIDTipoCasilla() == 3) {
                        encontradoT = true;
                        trinPos = i;
                    }
                }
                if (encontradoT) {
                    System.out.println(pingu.getNombre() + " usó un trineo hasta la casilla " + trinPos);
                    pingu.setPosicion(trinPos);
                } else {
                    System.out.println(pingu.getNombre() + " encontró un trineo roto.");
                }
                break;
            case 4: //casilla interrogante
            	casillaAct.casillaInterrogante(pingu);
            	break;
        }
    }

    //método para mover al pinguino
    public void MoverPinguino(ArrayList<Pinguino> ListaPinguinos, int dadoSeleccionado) {
        if (ListaPinguinos.isEmpty()) {
            System.out.println("No hay pingüinos en la partida.");
            return;
        }

        Pinguino pingu = ListaPinguinos.get(turno);
        int resultadoDado = pingu.tirarDado(dadoSeleccionado);
        System.out.println(pingu.getNombre() + " con ID " + pingu.getID() + " ha sacado un " + resultadoDado);

        int nuevaPos = Math.min(pingu.getPosicion() + resultadoDado, tablero.size() - 1); //Seleccionar a que casilla ír
        pingu.setPosicion(nuevaPos);
        System.out.println(pingu.getNombre() + " avanzó a la casilla " + nuevaPos);
        
        
		this.OrigenTablero(ListaPinguinos); //llamar al método para comprovar eventos

        turno = (turno + 1) % ListaPinguinos.size();
    }
}
