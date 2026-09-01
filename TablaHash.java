import java.util.ArrayList;

public class TablaHash{

    private ArrayList<Nodo>[] tabla;

    private class Nodo{

	private int llave;

	private String valor;

	private Nodo(int llave, String valor){
	    this.llave = llave;
	    this.valor = valor;
	}

	public int getLlave(){
	    return llave;
	}

	public String getValor(){
	    return valor;
	}

	@Override
	public String toString(){
	    return "(" + llave + ", " + valor.toString() + ")";
	}
    }

    public TablaHash(){
        tabla = new ArrayList[7];
    }

    private int hash(int l){
	return l % 7;
    }

    public void insertar(int key, String valor){
        int indice = hash(key);
	if (tabla[indice] == null) {
		tabla[indice] = new ArrayList<>();
	}
	for (Nodo nodo : tabla[indice]) {
	    if (nodo.getLlave() == key) {
		nodo.valor = valor;
		return;
	    }
	}
	tabla[indice].add(new Nodo(key, valor));
    }
	    
    public void buscar(int llave){
	Nodo b = null;
	int busca = hash(llave);
	if(tabla[busca] == null)
	    System.out.println("NOT_FOUND");
	else{
	    for(Nodo n: tabla[busca]){
		if(n.getLlave() == llave){
		    b = n;
		    break;
		}
	    }
	    if(b == null)
		System.out.println("NOT_FOUND");
	    else
		System.out.println(busca + " -> " + b.getValor());
	}
    }


    public void eliminar(int llave){
	int ind = hash(llave);
	Nodo b = null;
	if(tabla[ind] == null) {
	    return;
	} else {
	    for(Nodo n: tabla[ind]){
		if(n.getLlave() == llave){
		    tabla[ind].remove(n);
		    if(tabla[ind].isEmpty())
			tabla[ind] = null;
		    break;
		}
	    }
	}
    }


    @Override
    public String toString(){
	String s = "";
	for(int i = 0; i < 7; i++){
	    s += i + " -> ";
	    if(tabla[i] == null)
		s += "\n";
	    else
		s += tabla[i].toString() + "\n";
	}
	return s;
    }
}
