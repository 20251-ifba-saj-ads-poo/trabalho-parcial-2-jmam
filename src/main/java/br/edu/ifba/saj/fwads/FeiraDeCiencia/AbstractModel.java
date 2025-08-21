package br.edu.ifba.saj.fwads.FeiraDeCiencia;
import java.util.UUID;

public class AbstractModel<UUID> {

    private UUID id;
    
    public AbstractModel(UUID id){
        this.id=id;
    }

    public UUID getID(){
        return id;
    }
}
