package pard.dragon.genie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class WishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nickname;
    private String contents;
    private String type;

    public WishEntity(WishDto dto){
        this.nickname = dto.getNickname();
        this.contents = dto.getContents();
        this.type = dto.getType();
    }

}
