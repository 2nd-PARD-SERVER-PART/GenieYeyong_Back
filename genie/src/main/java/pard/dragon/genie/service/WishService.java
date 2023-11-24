package pard.dragon.genie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pard.dragon.genie.dto.ResponseDto;
import pard.dragon.genie.dto.WishDto;
import pard.dragon.genie.entity.WishEntity;
import pard.dragon.genie.repository.WishRepository;

import java.util.List;

@Service
public class WishService {
    private final WishRepository wishRepository;

    @Autowired
    public WishService(WishRepository wishRepository) {
        this.wishRepository = wishRepository;
    }

    public ResponseDto<WishEntity> addWish(WishDto wishDto) { // Create item
        WishEntity wish = new WishEntity(wishDto);
        if(wish.getNickname().isEmpty())
            return ResponseDto.setFailed("닉네임이 비어있습니다.");
        if(wish.getContents().isEmpty())
            return ResponseDto.setFailed("소원 내용이 비어있습니다.");
        if(wish.getPassword().isEmpty())
            return ResponseDto.setFailed("비밀번호를 입력하세요.");
        wishRepository.save(wish);
        return ResponseDto.setSuccess("소원이 정상적으로 추가되었습니다", wish);
    }

    public ResponseDto<List<WishEntity>> findAll(){
        List<WishEntity> wishes;
        try {
            wishes = wishRepository.findAll();
            if(wishes.isEmpty())
                return ResponseDto.setFailed("소원이 비어있습니다."); //아무것도 없을 때
            int total = wishes.size();
            return ResponseDto.setSuccess("모든 학부의 소원 모아보기", wishes, total);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("DB 오류");
        }
    }

    public ResponseDto<List<WishEntity>> findOneWish(String wishesType){
        List<WishEntity> wishes;
        try {
            wishes = wishRepository.findByType(wishesType);
            if(wishes.isEmpty())
                return ResponseDto.setFailed("해당 학부의 소원이 비어있습니다."); //아무것도 없을 때
            int total = wishes.size();
            return ResponseDto.setSuccess(wishesType+"의 소원 출력", wishes, total);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("DB 오류");
        }
    }

    public ResponseDto<?> deleteWish(String password, Integer id) {
        try {
            if (wishRepository.findById(id).get().getPassword().equals(password)) {
                wishRepository.deleteById(id);
                return ResponseDto.setSuccess("소원이 삭제되었습니다.", null);

            } else {
                return ResponseDto.setFailed("비밀번호가 맞지 않음");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("DB 오류: " + e.getMessage());
        }
    }

    // 삭제를 누를 떄, 페이지에 대한 id가 맨 뒤에 endpoint로 붙고, request를 password로

}
