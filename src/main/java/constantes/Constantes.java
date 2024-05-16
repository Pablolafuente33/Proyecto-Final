package constantes;

import EstructurasDeDatos.ListaSimple;

public class Constantes {

    private Constantes() {
        throw new IllegalStateException("Utility class");
    }

    public static final String IND_BASICO = "BASICO";

    public static final String IND_NORMAL = "NORMAL";

    public static final String IND_AVANZADO = "AVANZADO";

    public static final ListaSimple<String> PRIORIDAD_TIPOS_INDIVIDUOS = ListaSimple.of(Constantes.IND_BASICO,
            Constantes.IND_BASICO, Constantes.IND_AVANZADO);

    public static final String OPER_NACIMIENTO = "NACIMIENTO";

    public static final String OPER_REPRODUCCION = "REPRODUCCION";

    public static final String OPER_CLONACION = "CLONACION";

    public static final String OPER_MUERTE = "MUERTE";

    public static final String OPER_ITERACCION = "ITERACCION";

}