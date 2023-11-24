package pard.dragon.genie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pard.dragon.genie.dto.WishDto;

@Entity(name = "wish")
@NoArgsConstructor
@Getter
@Setter
public class WishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nickname;
    private String contents;
    private String type;
    private String password;

    public WishEntity(WishDto dto){
        this.nickname = dto.getNickname();
        this.contents = dto.getContents();
        this.type = dto.getType();
        this.password = dto.getPassword();
    }

}
