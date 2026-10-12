package co.edu.uniquindio.quindioexpress;

import java.util.ArrayList;
import java.util.List;

public class QuindioExpress {
    List<Paquete> paquetes;



    private static QuindioExpress instancia;

    private QuindioExpress() {
        this.paquetes = new ArrayList<Paquete>();
    }



    public static QuindioExpress getInstancia() {
        if (instancia == null) {
            instancia = new QuindioExpress();
        }
        return instancia;
    }
}
