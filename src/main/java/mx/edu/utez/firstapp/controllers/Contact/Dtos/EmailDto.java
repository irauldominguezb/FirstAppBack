package mx.edu.utez.firstapp.controllers.Contact.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmailDto {
    private String fullname;
    private String email;
    private String comments;
}
