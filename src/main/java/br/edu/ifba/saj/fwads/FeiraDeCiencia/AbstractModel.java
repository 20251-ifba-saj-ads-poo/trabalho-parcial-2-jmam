package br.edu.ifba.saj.fwads.FeiraDeCiencia;
import java.time.LocalDateTime;

public class AbstractModel<UUID> {


    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private UUID id;  

    public UUID getID(){
        return id;
    }
}
