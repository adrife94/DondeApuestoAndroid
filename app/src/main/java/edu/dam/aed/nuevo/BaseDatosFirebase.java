package edu.dam.aed.nuevo;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BaseDatosFirebase {
    public static final String CHILD_FUTBOL = "futbol";
    public static final String CHILD_USUARIOS = "Usuarios";
    public static final String CHILD_APUESTAS = "Apuestas";
    private DatabaseReference dbreference;

    public BaseDatosFirebase() {this.dbreference = FirebaseDatabase.getInstance().getReference();
    }

    public DatabaseReference getDbreference() {
        return dbreference;
    }

    public void setDbreference(DatabaseReference dbreference) {
        this.dbreference = dbreference;
    }
}
