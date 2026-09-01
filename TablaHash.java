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

    private void insertar(){
    }

    private void buscar(){
    }

    private void eliminar(){
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
