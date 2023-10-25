package DevAppRepTp2_Act2_2;

import java.io.Serializable;

// Classe représentant l'objet envoyé entre le client et le serveur
public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int op1;
    private int op2;
    private String operation;
    
    // Constructeur
    public Operation(int op1, int op2, String operation) {
        this.op1 = op1;
        this.op2 = op2;
        this.operation = operation;
    }
    
    // Getters
    public int getOp1() {
        return op1;
    }
    
    public int getOp2() {
        return op2;
    }
    
    public String getOperation() {
        return operation;
    }
}
