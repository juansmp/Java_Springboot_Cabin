package co.edu.usergioarboleda.cabin.cabin.app.models.custom;

import java.io.Serializable;

import co.edu.usergioarboleda.cabin.cabin.app.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountClient implements Serializable {
    private static final long serialVersionUID = 8L;
    private long total;
    private Client client;

}
