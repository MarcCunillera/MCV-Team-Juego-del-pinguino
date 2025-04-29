package Modelo;
import java.util.Random;
import java.util.ArrayList;
import Controlador.*;
public class Tablero {

<<<<<<< Updated upstream
	// Hem instanciat les variables
	private ArrayList<Casilla> tablero;
	private int turno;
	
	// Hem definit el constructor
	public Tablero(ArrayList<Casilla> tablero, int turno ) {
		this.tablero = new ArrayList<>(50);
		this.turno = 0;
	}
	
	// Geters y seters
	public ArrayList<Casilla> gettablero() {
		return tablero;
	}
    
    // ToString per mostra las casillas
=======
    public Tablero() {
        this.tablero = new ArrayList<>();
        this.GenerarTablero();
        this.turno = 0;
    }

    public ArrayList<Casilla> getTablero() { 
    	return tablero; 
    }

    @Override
>>>>>>> Stashed changes
    public String toString() {
        return "Casillas" + 50 ;
    }
	
    // Metodes de la classe Tablero
	public void GenerarTablero() {
<<<<<<< Updated upstream
		//generación de tablero
		for (int i = 1; i < 51; i++) {
			Casilla.asignarCasillas(i, tablero); //llamar al método para generar el tablero
		}
	}
	
	public void OrigenTablero(ArrayList<Casilla> tablero, ArrayList<Pinguino> ListaPinguinos) {
		//sirve para poder mover el jugador con el trineo o el agujero o el oso
		//PPinguino del cual es el turno
		Pinguino pingu = ListaPinguinos.get(turno);
		int posic = pingu.getPosicion();
		//Cogemos la casilla en la que se encuentra para poder extraer el d del tipo de casilla
		Casilla casillaAct = tablero.get(posic);
		int idTipo = casillaAct.getIDTipoCasilla();
		//boolean para saber si se puede sobornar al oso
		boolean soborno = false;
		
		switch (idTipo) {
		case 1: //oso
			if(!soborno) {
				pingu.setPosicion(0);
			} else {
				//sobornar
				
			}
			break;
		case 2: //agujero
			int agujAnt = 0;
			boolean encontradoA = false;
			//bucle para caer al agujero anterior
			for (int i = posic -1; i >= 0 && !encontradoA; i--) {
				if (tablero.get(i).getIDTipoCasilla() == 2) {
					encontradoA = true;
					agujAnt = i;
				}
			}
			//casos
			if(encontradoA) {
				System.out.println("El pingüino: " + pingu.getnombre() + " Ha caído al agujero y ha salid en la casilla nº " + agujAnt);
				pingu.setPosicion(agujAnt);
			}else {
				System.out.println("El pingüino: " + pingu.getnombre() + " Ha caído a un agujero sin salida, vuelve al inicio");
				pingu.setPosicion(0);
			}
			break;
		case 3: //trineo
			int trinPos = 0;
			boolean encontradoT = false;
			//bucle para avanzar al trineo siguiente
			for (int i = 0; i < tablero.size() && !encontradoT; i++) {
				if(tablero.get(i).getIDTipoCasilla() == 2) {
					encontradoT = true;
					trinPos = i;
				}
			}
			//casos
			if(encontradoT) {
				System.out.println("El pingüino: " + pingu.getnombre() + " Se ha subido al trineo y ha avanzado al siguiente en la casilla nº " + trinPos);
				pingu.setPosicion(trinPos);
			}else {
				System.out.println("El pingüino: " + pingu.getnombre() + " Se ha encontrado un trineo sin utilidad :(");
			}
			break;
		}
	}
	
	public void MoverPinguino(ArrayList<Pinguino> ListaPinguinos, int Dado) {
		//posición del jugador al tirar el dado
		
		Pinguino pingu = ListaPinguinos.get(turno); //obtener turno
		if(ListaPinguinos.isEmpty()) {
			System.out.println("No hay pinguinos");
		}else {
			
			//obtener resultado dado
			int resul = pingu.TirarDado(Dado);
			System.out.println(pingu.getnombre() + " Con ID: " + pingu.getID() + " Ha sacado un: " + resul);
			
			
			//avanzar turno
			turno = (turno + 1) % ListaPinguinos.size();
		}
		
	}
	
=======
        for (int i = 1; i <= 50; i++) {
            Casilla.asignarCasillas(i, tablero);
        }
    }
	
	//método en caso de que caiga en evento como trieno, oso u agujero
    public void OrigenTablero(ArrayList<Pinguino> ListaPinguinos) {
        Pinguino pingu = ListaPinguinos.get(turno);
        int posic = pingu.getPosicion();
        Casilla casillaAct = tablero.get(posic);
        int idTipo = casillaAct.getIDTipoCasilla();

        Eventos eventos = new Eventos(0, 0, 0, 0, 0); //para sobornar si hace falta
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
        }
    }
    
    //Método para mover al pingüino
    public void MoverPinguino(ArrayList<Pinguino> ListaPinguinos, int dadoSeleccionado) {
        if (ListaPinguinos.isEmpty()) {
            System.out.println("No hay pingüinos en la partida.");
            return;
        }

        Pinguino pingu = ListaPinguinos.get(turno);
        int resultadoDado = pingu.tirarDado(dadoSeleccionado);
        System.out.println(pingu.getNombre() + " con ID " + pingu.getID() + " ha sacado un " + resultadoDado);

        int nuevaPos = Math.min(pingu.getPosicion() + resultadoDado, tablero.size() - 1);
        pingu.setPosicion(nuevaPos);
        System.out.println(pingu.getNombre() + " avanzó a la casilla " + nuevaPos);

        this.OrigenTablero(ListaPinguinos);

        turno = (turno + 1) % ListaPinguinos.size();
    }
>>>>>>> Stashed changes
}
