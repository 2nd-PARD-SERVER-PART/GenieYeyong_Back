package pard.dragon.genie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishDto {
    private String nickname;
    private String contents;
    private String type;
}
