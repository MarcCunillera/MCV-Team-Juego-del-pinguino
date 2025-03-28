package Modelo;

public class Inventario {
	private int IDinv;
	private int espacioInv;
	
	//constructor de la clase
	public Inventario(int IDinv, int espacioInv) {
		this.IDinv = IDinv;
		this.espacioInv = espacioInv;
	}
	
	//métodos get
	public int getIDinv() {
		return IDinv;
	}
	
	public int getespacioInv() {
		return espacioInv;
	}
	
	//métodos set
	public void setIDinv(int IDinv) {
		this.IDinv = IDinv;
	}
	
	public void setespacioInv(int espacioInv) {
		this.espacioInv = espacioInv;
	}
	
	//método toString
	public String toString() {
		return "Espacio del inventario: " + espacioInv;
	}
}
