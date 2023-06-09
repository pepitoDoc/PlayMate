package edu.fpdual.web.service.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement
public class GameRaya {
    private String player1;
    private String player2;
    private String winner;
    private String date;
}
