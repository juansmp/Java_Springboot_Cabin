package co.edu.usergioarboleda.cabin.cabin.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cabin {
    private int id;
    private String name;
    private int categoryId;
    private int rooms;
    private String brand;

}
